package com.barosanu.controller.services;

import com.barosanu.model.EmailTreeItem;

import javax.mail.Store;

public class ServiceManager {

    public void submitFetchFoldersJob(Store store, EmailTreeItem<String> emailTreeItem){
        FetchFoldersService fetchFoldersService = new FetchFoldersService(store, emailTreeItem);
        fetchFoldersService.start();
    }
}
