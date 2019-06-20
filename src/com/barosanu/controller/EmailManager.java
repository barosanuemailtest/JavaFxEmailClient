package com.barosanu.controller;

import com.barosanu.ModelAccess;
import com.barosanu.model.EmailAccount;

public class EmailManager {

    public ModelAccess modelAccess;

    public EmailManager(ModelAccess modelAccess) {
        this.modelAccess = modelAccess;
    }

    public EmailLoginResult login(EmailAccount emailAccount){
        return EmailLoginResult.FAILED_BY_CREDENTIALS;
    }


}
