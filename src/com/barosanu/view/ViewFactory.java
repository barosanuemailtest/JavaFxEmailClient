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
    private ArrayList<Stage> activeStages;
    private boolean mainViewInitialized = false;

    public ViewFactory(ModelAccess modelAccess) {
        this.modelAccess = modelAccess;
        activeStages = new ArrayList<Stage>();
    }


    public void showLoginWindow() {
        Stage loginStage = new Stage();
        BaseController loginWindow = new LoginWindowController(this, modelAccess, "LoginWindow.fxml");
        loginStage.setScene(this.initializeScene(loginWindow));
        loginStage.show();
        activeStages.add(loginStage);
    }

    public void showMainWindow(){
        Stage mainStage = new Stage();
        BaseController mainWindow = new MainWindowController(this, modelAccess, "MainWindow.fxml");
        mainStage.setScene(this.initializeScene(mainWindow));
        mainStage.show();
        mainViewInitialized = true;
        activeStages.add(mainStage);
    }
    public void showOptionsWindow(){
        Stage optionsStage = new Stage();
        BaseController optionsController = new OptionsWindowController(this, modelAccess, "OptionsWindow.fxml");
        optionsStage.setScene(this.initializeScene(optionsController));
        optionsStage.show();
        activeStages.add(optionsStage);
    }

    public boolean isMainViewInitialized(){
        return this.mainViewInitialized;
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
