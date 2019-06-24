package com.barosanu.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class EmailMessage {

    private SimpleStringProperty sender;
    private SimpleStringProperty subject;
    private SimpleStringProperty recipient;
    private SimpleObjectProperty<FormatableInteger> size;
    private SimpleObjectProperty<Date> date;
    private Message message;

    public EmailMessage(String Subject, String Sender){
        this.subject = new SimpleStringProperty(Subject);
        this.sender = new SimpleStringProperty(Sender);    }

    public EmailMessage(Message message) throws MessagingException {
        this.subject = new SimpleStringProperty(message.getSubject());
        this.sender = new SimpleStringProperty(message.getFrom()[0].toString());
        this.recipient = new SimpleStringProperty(message.getRecipients(MimeMessage.RecipientType.TO)[0].toString());
        this.size = new SimpleObjectProperty<FormatableInteger>(new FormatableInteger(message.getSize()));
        this.date = new SimpleObjectProperty<Date>(message.getSentDate());
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
