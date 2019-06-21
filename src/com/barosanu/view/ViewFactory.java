package com.barosanu.view;

import com.barosanu.ModelAccess;
import com.barosanu.controller.BaseController;
import com.barosanu.controller.LoginWindowController;
import com.barosanu.controller.MainWindowController;
import com.barosanu.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private ModelAccess modelAccess;
    private Stage stage;
    private ArrayList<Stage> activeStages;

    public ViewFactory(ModelAccess modelAccess) {
        this.modelAccess = modelAccess;
        this.stage = new Stage();
        activeStages = new ArrayList<Stage>();
        activeStages.add(stage);
    }


    public void showLoginWindow() {
        BaseController loginWindow = new LoginWindowController(this, modelAccess, "LoginWindow.fxml");
        stage.setScene(this.initializeScene(loginWindow));
        stage.show();
    }

    public void showMainWindow(){
        BaseController mainWindow = new MainWindowController(this, modelAccess, "MainWindow.fxml");
        stage.setScene(this.initializeScene(mainWindow));
        stage.show();
    }
    public void showOptionsWindow(){
        Stage optionsStage = new Stage();
        BaseController optionsController = new OptionsWindowController(this, modelAccess, "OptionsWindow.fxml");
        optionsStage.setScene(this.initializeScene(optionsController));
        optionsStage.show();
        activeStages.add(optionsStage);
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
        applyCurrentStylesToScene(scene);
        return scene;
    }

    public void closeStage(Stage stageToClose) {
        activeStages.remove(stageToClose);
        stageToClose.close();
    }

    public void updateStyles(){
        for(Stage stage2:activeStages) {
            Scene scene2 = stage2.getScene();
            applyCurrentStylesToScene(scene2);
        }
    }

    private void applyCurrentStylesToScene(Scene scene){
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(modelAccess.getTheme())).toExternalForm());
        scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(modelAccess.getFontSize())).toExternalForm());
    }
}
