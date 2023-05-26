package com.example.testproject;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TextArea out;
    @FXML
    private TextField input;

    @FXML
    public void Start() {
        WordNumeric numericToWord = new WordNumeric();
        numericToWord.numericText(input.getText());
        out.setText(numericToWord.getRes());
    }



}