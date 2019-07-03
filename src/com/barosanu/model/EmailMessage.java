package com.barosanu.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.mail.Message;
import java.util.Date;

public class EmailMessage {

    private SimpleStringProperty sender;
    private SimpleStringProperty subject;
    private SimpleStringProperty recipient;
    private SimpleObjectProperty<FormatableInteger> size;
    private SimpleObjectProperty<Date> date;

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isRead() {
        return isRead;
    }

    private boolean isRead;
    private Message message;

    public EmailMessage(String sender, String subject, String recipient, int size, Date date, boolean isRead, Message message) {
        this.sender = new SimpleStringProperty(sender);
        this.subject = new SimpleStringProperty(subject);
        this.recipient = new SimpleStringProperty(recipient);
        this.size = new SimpleObjectProperty<FormatableInteger>(new FormatableInteger(size));
        this.date = new SimpleObjectProperty<Date>(date);
        this.isRead = isRead;
        this.message = message;
    }

    public String getSender(){
        return sender.get();
    }
    public String getSubject(){
        return subject.get();
    }
    public String getRecipient(){
        return recipient.get();
    }
    public FormatableInteger getSize(){
        return size.get();
    }
    public Date getDate(){
        return date.get();
    }
    public Message getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "EmailMessage{" +
                "sender=" + sender +
                ", subject=" + subject +
                ", recipient=" + recipient +
                ", size=" + size +
                ", date=" + date +
             //   ", message=" + message +
                '}';
    }
}
