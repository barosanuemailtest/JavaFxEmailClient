package com.barosanu.view;

import com.barosanu.ModelAccess;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewFactory {



    private ModelAccess modelAccess;
    private Stage stage;

    public ViewFactory(ModelAccess modelAccess) {
        this.modelAccess = modelAccess;
        this.stage = new Stage();
    }

    public void showloginWindow(){
        Parent root = new GridPane();
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }
}
