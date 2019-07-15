package test.controller;

import com.barosanu.EmailManager;
import com.barosanu.controller.LoginWindowController;
import com.barosanu.view.ViewFactory;
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
    @Mock
    private TextField emailAddressField;

    @InjectMocks
    private LoginWindowController m;

}
