package com.barosanu.controller;

import com.barosanu.ModelAccess;
import com.barosanu.controller.services.LoginService;
import com.barosanu.model.EmailAccount;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

    public LoginWindowController(ViewFactory viewFactory,ModelAccess modelAccess, String fxmlName) {
        super(viewFactory, modelAccess, fxmlName);
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
            LoginService loginService = new LoginService(modelAccess, emailAccount);
            loginService.start();
            loginService.setOnSucceeded(e->{
                EmailLoginResult result = loginService.getValue();
                switch (result) {
                    case SUCCESS:
                        if(!this.viewFactory.isMainViewInitialized()){
                            this.viewFactory.showMainWindow();
                        }
                        Stage stage = (Stage) emailAddressField.getScene().getWindow();
                        this.viewFactory.closeStage(stage);
                        break;
                    case FAILED_BY_CREDENTIALS:
                        errorLabel.setText("Invalid credentials!");
                        break;
                    case FAILED_BY_NETWORK:
                        errorLabel.setText("Unexpected error!");
                        break;
                }
            });
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emailAddressField.setText("barosanu2489@gmail.com");
        passwordField.setText("9222193ABEDJg");
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
