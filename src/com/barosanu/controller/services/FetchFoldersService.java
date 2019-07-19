package com.barosanu.controller.services;

import com.barosanu.model.EmailTreeItem;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;

public class FetchFoldersService extends Service<Void> {

    private Store store;
    private EmailTreeItem<String> foldersRoot;

    public FetchFoldersService(Store store, EmailTreeItem<String> foldersRoot) {
        this.store = store;
        this.foldersRoot = foldersRoot;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                fetchFolders();
                return null;
            }
        };
    }

    private void fetchFolders() throws MessagingException {
        Folder[] folders = store.getDefaultFolder().list();
        this.handleFolder(folders, foldersRoot);
    }

    private void handleFolder(Folder[] folders, EmailTreeItem parentTree) throws MessagingException {
        for (Folder folder : folders) {
            EmailTreeItem<String> emailTreeItem = new EmailTreeItem<String>(folder.getName());
            parentTree.getChildren().add(emailTreeItem);
            emailTreeItem.setExpanded(true);
            fetchMessagesOnFolder(emailTreeItem, folder);
            Folder[] subFolders = folder.list();
            handleFolder(subFolders, emailTreeItem);
        }
    }

    private void fetchMessagesOnFolder(EmailTreeItem<String> emailFolder, Folder folder) {
        Service fetchMessagesService = new Service() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected Object call(){
                        try {
                            if (folder.getType() != Folder.HOLDS_FOLDERS) {
                                folder.open(Folder.READ_WRITE);
                                int folderSize = folder.getMessageCount();
                                for (int i = folderSize; i > 0; i--) {
                                    Message currentMessage = folder.getMessage(i);
                                    emailFolder.addEmail(currentMessage);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                };
            }
        };
        fetchMessagesService.start();
    }
}
