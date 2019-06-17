package com.barosanu.controller;

import com.barosanu.ModelAccess;
import com.barosanu.model.EmailAccount;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private Label errorLabel;

    @FXML
    void loginAction() {
        if(fieldsAreValid()){
            errorLabel.setText("Logging in ...");
            EmailAccount emailAccount = new EmailAccount(
                    emailAddressField.getText(),
                    passwordField.getText()
            );
            System.out.println("asdf initialized");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("LoginWindowController initialized");
    }

    private boolean fieldsAreValid(){
        if(emailAddressField.getText().isEmpty()){
            errorLabel.setText("Please fill email");
            return false;
        }
        if(passwordField.getText().isEmpty()){
            errorLabel.setText("Please fill password");
            return false;
        }
        return true;
    }
}
