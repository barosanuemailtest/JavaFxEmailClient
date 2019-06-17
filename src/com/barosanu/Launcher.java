package com.barosanu;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ProgramState programState = new ProgramState();
        programState.init();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
