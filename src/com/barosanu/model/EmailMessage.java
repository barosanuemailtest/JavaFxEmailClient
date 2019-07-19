package com.barosanu.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.mail.Message;
import java.util.Date;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailMessage that = (EmailMessage) o;
        return isRead == that.isRead &&
                Objects.equals(sender, that.sender) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(recipient, that.recipient) &&
                Objects.equals(size, that.size) &&
                Objects.equals(date, that.date) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, subject, recipient, size, date, isRead, message);
    }
}
