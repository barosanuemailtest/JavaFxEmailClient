package com.barosanu.controller;

import com.barosanu.ModelAccess;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    @FXML
    private TreeView<String> folders;

    public MainWindowController(ViewFactory viewFactory, ModelAccess modelAccess, String fxmlName) {
        super(viewFactory, modelAccess, fxmlName);
    }

    @FXML
    void onOptionsClick() {
        this.viewFactory.showOptionsWindow();
    }

    @FXML
    void addAccountClick() {
        this.viewFactory.showLoginWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
