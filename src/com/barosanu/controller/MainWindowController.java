package com.barosanu.controller;

import com.barosanu.ModelAccess;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;

public class MainWindowController extends BaseController{

    public MainWindowController(ViewFactory viewFactory, ModelAccess modelAccess, String fxmlName) {
        super(viewFactory, modelAccess, fxmlName);
    }

    @FXML
    void onOptionsClick() {
        this.viewFactory.showOptionsWindow();
    }
}
