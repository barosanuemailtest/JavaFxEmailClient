module JavaFxEmailClient {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    exports com.barosanu.controller;
    opens com.barosanu.controller;
    opens com.barosanu;

}