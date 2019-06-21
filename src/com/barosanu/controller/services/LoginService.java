package com.barosanu.controller.services;

import com.barosanu.ModelAccess;
import com.barosanu.controller.EmailLoginResult;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class LoginService extends Service<EmailLoginResult> {

    private ModelAccess modelAccess;

    public LoginService(ModelAccess modelAccess) {
        this.modelAccess = modelAccess;
    }

    @Override
    protected Task<EmailLoginResult> createTask() {
        return new Task<EmailLoginResult>() {
            @Override
            protected EmailLoginResult call() throws Exception {
                Thread.sleep(3000);
                return EmailLoginResult.SUCCESS;
            }
        };
    }
}
