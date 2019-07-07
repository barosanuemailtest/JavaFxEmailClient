package test.view;

import com.barosanu.EmailManager;
import com.barosanu.controller.BaseController;
import com.barosanu.controller.LoginWindowController;
import com.barosanu.view.ViewFactory;
import com.barosanu.view.ViewInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ViewInitializerTest {

    @Mock
    private EmailManager emailManagerMock;
    @Mock
    private ViewFactory viewFactoryMock;

    private ViewInitializer viewInitializer;

    @BeforeEach
    public void setUp(){
        viewInitializer = new ViewInitializer(emailManagerMock);
    }

    @Test()
    public void testInitializeStage(){
        BaseController loginWindowController = new LoginWindowController(
                viewFactoryMock,
                emailManagerMock,
                "somePath.fxml"
        );
        assertThrows(IllegalStateException.class, ()-> {
            viewInitializer.initializeStage(loginWindowController);
        });


    }
}
