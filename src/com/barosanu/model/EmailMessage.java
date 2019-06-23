package com.barosanu.model;

import javafx.beans.property.SimpleStringProperty;

public class EmailMessage {

    private SimpleStringProperty sender;
    private SimpleStringProperty subject;

    public EmailMessage(String Subject, String Sender){
        this.subject = new SimpleStringProperty(Subject);
        this.sender = new SimpleStringProperty(Sender);    }

    public String getSender(){
        return sender.get();
    }

    public String getSubject(){
        return subject.get();
    }

    @Override
    public String toString(){
        return "Message Subject: " + getSubject() + " sender: " + getSender();
    }
}
