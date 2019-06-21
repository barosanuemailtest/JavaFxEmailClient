package com.barosanu.controller;

import com.barosanu.ModelAccess;
import com.barosanu.view.ColorTheme;
import com.barosanu.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {

    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<ColorTheme> themePicker;

    public OptionsWindowController(ViewFactory viewFactory, ModelAccess modelAccess, String fxmlName) {
        super(viewFactory, modelAccess, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(ColorTheme.DEFAULT);

    }
}
