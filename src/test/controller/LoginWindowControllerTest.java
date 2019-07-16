package test.controller;

import com.barosanu.EmailManager;
import com.barosanu.controller.LoginWindowController;
import com.barosanu.view.ViewFactory;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginWindowControllerTest {

    @Mock
    private ViewFactory viewFactoryMock;
    @Mock
    private EmailManager emailManagerMock;

    private TextField emailAddressField;

    private PasswordField passwordField;

    private Label errorLabel;

    private LoginWindowController loginWindowController;

    @BeforeEach
    public void setUp(){
        Platform.startup(() -> System.out.println("Toolkit initialized ..."));
        initMocks(this);
        emailAddressField = new TextField();
        passwordField = new PasswordField();
        errorLabel = new Label();

        loginWindowController = new LoginWindowController(
                viewFactoryMock,
                emailManagerMock,
                null,
                emailAddressField,
                passwordField,
                errorLabel
        );
    }

    @Test
    public void testFieldsValidation(){
        loginWindowController.loginAction();
        assertEquals(errorLabel.getText(),"Please fill email");
        emailAddressField.setText("some@address.com");
        loginWindowController.loginAction();
        assertEquals(errorLabel.getText(),"Please fill password");

    }

}
