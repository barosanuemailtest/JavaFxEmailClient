package com.barosanu.controller.services;

import com.barosanu.model.EmailTreeItem;

import javax.mail.Folder;
import javax.mail.Store;
import java.util.List;

public class ServiceManager {

    public void submitFetchFoldersJob(Store store, EmailTreeItem<String> emailTreeItem, List<Folder> folderList){
        FetchFoldersService fetchFoldersService = new FetchFoldersService(store, emailTreeItem, folderList);
        fetchFoldersService.start();
    }
}
