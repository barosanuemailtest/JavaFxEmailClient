package com.barosanu.controller.services;

import com.barosanu.ModelAccess;
import com.barosanu.controller.EmailLoginResult;
import com.barosanu.model.EmailAccount;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import javax.mail.Message;

public class LoginService extends Service<EmailLoginResult> {

    private ModelAccess modelAccess;
    private EmailAccount emailAccount;

    public LoginService(ModelAccess modelAccess, EmailAccount emailAccount) {
        this.emailAccount = emailAccount;
        this.modelAccess = modelAccess;
    }

    @Override
    protected Task<EmailLoginResult> createTask() {
        Message zz;
        return new Task<EmailLoginResult>() {
            @Override
            protected EmailLoginResult call() throws Exception {
                Thread.sleep(1000);
                return login();
            }
        };
    }

    private EmailLoginResult login(){
        return  EmailLoginResult.SUCCESS;
    }
}
