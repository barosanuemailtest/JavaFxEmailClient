module JavaFxEmailClient {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires java.mail;
    requires activation;

    //test:
    requires org.junit.jupiter.api;
    requires mockito.all;

    exports com.barosanu.controller;
    opens com.barosanu.controller;
    opens com.barosanu.model;
    opens com.barosanu;

}