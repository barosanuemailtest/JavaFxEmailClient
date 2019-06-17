package com.barosanu.controller;

import com.barosanu.ModelAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

    public LoginWindowController(ModelAccess modelAccess, String fxmlName) {
        super(modelAccess, fxmlName);
    }

    @FXML
    private TextField emailAddressField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void loginAction(ActionEvent event) {
        System.out.println(passwordField.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("LoginWindowController initialized");
    }
}
