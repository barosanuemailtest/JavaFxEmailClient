package com.barosanu.controller.services;

import com.barosanu.model.EmailMessage;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.web.WebEngine;

import javax.mail.Message;
import javax.mail.MessagingException;

public class MessageRendererService extends Service<Void> {

    private EmailMessage emailMessage;
    private WebEngine webEngine;
    private StringBuffer stringBuffer;

    public  MessageRendererService(WebEngine webEngine){
        this.webEngine = webEngine;
        this.stringBuffer = new StringBuffer();
        this.setOnSucceeded( e -> displayMessage());
    }


    public void setEmailMessage(EmailMessage emailMessage) {
        this.emailMessage = emailMessage;
    }


    private void displayMessage() {
        webEngine.load(stringBuffer.toString());
    }


    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                loadMessage();
                return null;
            }
        };
    }

    private void loadMessage() throws MessagingException {
        stringBuffer.setLength(0);
        Message message = emailMessage.getMessage();
        System.out.println("Message type: " + message.getContentType());
    }
}
