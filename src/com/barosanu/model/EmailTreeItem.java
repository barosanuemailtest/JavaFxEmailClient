package com.barosanu.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class EmailTreeItem<String> extends TreeItem<String> {

    private int unreadMessagesCount;
    private String name;
    private ObservableList<EmailMessage> data;

    public EmailTreeItem(String name){
        super(name);
        this.name = name;
        this.data = FXCollections.observableArrayList();
    }

}
