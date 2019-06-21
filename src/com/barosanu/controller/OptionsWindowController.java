package com.barosanu.controller;

import com.barosanu.ModelAccess;
import com.barosanu.view.ColorTheme;
import com.barosanu.view.FontSize;
import com.barosanu.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {

    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<ColorTheme> themePicker;

    @FXML
    void applyBtnAction() {
        modelAccess.setTheme(themePicker.getValue());
        modelAccess.setFontSize(FontSize.values()[(int)(fontSizePicker.getValue())]);
    }

    @FXML
    void cancelBtnAction() {
        //TODO: better way to close stage
        Stage stage = (Stage) fontSizePicker.getScene().getWindow();
        stage.close();
    }

    public OptionsWindowController(ViewFactory viewFactory, ModelAccess modelAccess, String fxmlName) {
        super(viewFactory, modelAccess, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(ColorTheme.DEFAULT);

        setUpSlider();


    }

    private void setUpSlider() {
        fontSizePicker.setMin(0);
        fontSizePicker.setMax(FontSize.values().length - 1);
        fontSizePicker.setValue(modelAccess.getFontSize().ordinal());
        fontSizePicker.setMinorTickCount(0);
        fontSizePicker.setMajorTickUnit(1);
        fontSizePicker.setBlockIncrement(1);
        fontSizePicker.setSnapToTicks(true);
        fontSizePicker.setShowTickMarks(true);
        fontSizePicker.setShowTickLabels(true);
        fontSizePicker.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int i = aDouble.intValue();
                return FontSize.values()[i].toString();
            }
            @Override
            public Double fromString(String s) {
                return null;
            }
        });
        fontSizePicker.valueProperty().addListener((obs, oldVal, newVal) ->
                fontSizePicker.setValue(newVal.intValue()));

    }
}
