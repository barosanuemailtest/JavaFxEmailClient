package com.barosanu.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailTreeItem<String> extends TreeItem<String> {

    private int unreadMessagesCount;
    private String name;
    private ObservableList<EmailMessage> emails;

    public EmailTreeItem(String name){
        super(name);
        this.name = name;
        this.emails = FXCollections.observableArrayList();
    }

    public void addEmail(Message message) throws MessagingException {
        boolean messageIsRead = message.getFlags().contains(Flags.Flag.SEEN);
        EmailMessage emailMessage = new EmailMessage(
                message.getSubject(),
                message.getFrom()[0].toString(),
                message.getRecipients(MimeMessage.RecipientType.TO)[0].toString(),
                message.getSize(),
                message.getSentDate(),
                messageIsRead,
                message
        );

        emails.add(emailMessage);
        System.out.println("Added message: " + emailMessage.toString());
        if(!messageIsRead){
            incrementUnreadMessagesCount();
        }
    }

    private void incrementUnreadMessagesCount(){
        unreadMessagesCount++;
        updateName();
    }

    private void updateName(){
        if(unreadMessagesCount > 0) {
            this.setValue((String) (name + "(" + unreadMessagesCount + ")"));
        } else {
            this.setValue(name);
        }
    }
}
