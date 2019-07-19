package com.barosanu.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.mail.Folder;
import java.util.Iterator;
import java.util.List;

public class FolderUpdaterService extends Service {

    private List<Folder> foldersList;

    public FolderUpdaterService(List<Folder> foldersList) {
        this.foldersList = foldersList;
    }

    @Override
    protected Task createTask() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (; ; )
                    try {
                        Thread.sleep(3000);
                        for (Iterator<Folder> iterator = foldersList.iterator(); iterator.hasNext();) {
                            Folder folder = iterator.next();
                            if (folder.getType() != Folder.HOLDS_FOLDERS && folder.isOpen()) {
                                folder.getMessageCount();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        };
    }
}

