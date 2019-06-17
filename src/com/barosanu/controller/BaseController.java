package com.barosanu.controller;

import com.barosanu.ModelAccess;

public abstract class BaseController {

    private ModelAccess modelAccess;
    private String fxmlName;

    public BaseController(ModelAccess modelAccess, String fxmlName) {
        this.modelAccess = modelAccess;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName(){
        return  this.fxmlName;
    }
}
