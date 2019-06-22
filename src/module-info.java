module JavaFxEmailClient {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.mail;

    exports com.barosanu.controller;
    opens com.barosanu.controller;
    opens com.barosanu;

}