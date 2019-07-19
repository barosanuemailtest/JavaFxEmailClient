package com.barosanu;

import com.barosanu.controller.services.ServiceManager;
import com.barosanu.model.EmailAccount;
import com.barosanu.model.EmailMessage;
import com.barosanu.model.EmailTreeItem;
import com.barosanu.view.ColorTheme;
import com.barosanu.view.FontSize;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;


public class EmailManager {

    private ServiceManager serviceManager;

    public EmailManager(){
        this(new ServiceManager());
    }
    public EmailManager(ServiceManager serviceManager){
        this.serviceManager = serviceManager;
    }

    //Themes handling:
    public ColorTheme getTheme() {
        return theme;
    }

    public void setTheme(ColorTheme theme) {
        this.theme = theme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    private ColorTheme theme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    //Folders handling:
    private EmailTreeItem<String> foldersRoot= new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    private List<Folder> folderList = new ArrayList<Folder>();

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> emailTreeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        emailTreeItem.setExpanded(true);
        foldersRoot.getChildren().add(emailTreeItem);
        serviceManager.submitFetchFoldersJob(emailAccount.getStore(), emailTreeItem, folderList);
    }

    // Selection model handling:
    private EmailTreeItem<String> selectedFolder;

    public EmailTreeItem<String> getSelectedFolder() {
        return selectedFolder;
    }

    public void setSelectedFolder(EmailTreeItem<String> selectedFolder) {
        this.selectedFolder = selectedFolder;
    }

    private EmailMessage selectedMessage;

    public EmailMessage getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(EmailMessage selectedMessage) {
        this.selectedMessage = selectedMessage;
    }

    //Messages interaction:
    public void deleteSelectedMessage() {
        try {
            selectedMessage.getMessage().setFlag(Flags.Flag.DELETED, true);
            boolean messageWasDeleted = selectedFolder.getEmails().remove(selectedMessage);
            System.out.println("messageWasDeleted: " + messageWasDeleted);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void setRead() {
        try {
            selectedMessage.setRead(true);
            selectedMessage.getMessage().setFlag(Flags.Flag.SEEN, true);
            selectedFolder.decrementUnreadMessagesCount();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void setUnRead() {
        try {
            selectedMessage.setRead(false);
            selectedMessage.getMessage().setFlag(Flags.Flag.SEEN, false);
            selectedFolder.incrementUnreadMessagesCount();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
