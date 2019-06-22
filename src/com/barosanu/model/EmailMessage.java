package com.barosanu.model;

import javafx.beans.property.SimpleStringProperty;

public class EmailMessage {

    private SimpleStringProperty sender;
    private SimpleStringProperty subject;

    public String getSender(){
        return sender.get();
    }
    public String getSubject(){
        return subject.get();
    }

    public EmailMessage(String Subject, String Sender){
        this.subject = new SimpleStringProperty(Subject);
        this.sender = new SimpleStringProperty(Sender);    }
}
