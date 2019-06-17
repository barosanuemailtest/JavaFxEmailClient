package com.barosanu.view;

import com.barosanu.ModelAccess;
import com.barosanu.controller.BaseController;
import com.barosanu.controller.LoginWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private ModelAccess modelAccess;
    private Stage stage;

    public ViewFactory(ModelAccess modelAccess) {
        this.modelAccess = modelAccess;
        this.stage = new Stage();
    }

    public void showLoginWindow() {
        BaseController LoginWindow = new LoginWindowController(modelAccess, "LoginWindow.fxml");

        stage.setScene(this.initializeScene(LoginWindow));
        stage.show();
    }

    private Scene initializeScene(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Scene scene = new Scene(parent);
        String DEFAULT_CSS = "default.css";
        scene.getStylesheets().add(getClass().getResource(DEFAULT_CSS).toExternalForm());

        return scene;
    }
}
