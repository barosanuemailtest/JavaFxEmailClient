package com.barosanu.controller;

import com.barosanu.ModelAccess;
import com.barosanu.view.ViewFactory;

public abstract class BaseController {

    protected ViewFactory viewFactory;
    protected ModelAccess modelAccess;
    private String fxmlName;


    public BaseController(ViewFactory viewFactory, ModelAccess modelAccess, String fxmlName) {
        this.viewFactory = viewFactory;
        this.modelAccess = modelAccess;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName(){
        return  this.fxmlName;
    }
}
