package com.barosanu.controller;

import com.barosanu.EmailManager;
import com.barosanu.view.ViewFactory;

public abstract class BaseController {

    protected ViewFactory viewFactory;
    protected EmailManager emailManager;
    private String fxmlName;


    public BaseController(ViewFactory viewFactory, EmailManager emailManager, String fxmlName) {
        this.viewFactory = viewFactory;
        this.emailManager = emailManager;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName(){
        return  this.fxmlName;
    }
}
