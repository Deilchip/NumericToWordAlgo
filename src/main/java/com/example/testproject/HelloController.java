package com.example.testproject;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.KeyEvent;

public class HelloController {

    @FXML
    private TextArea out;

    @FXML
    private Button buttonStart;
    @FXML
    private TextField input;

     public void initialize() {
         input.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
             // Windows: Ctrl+V; MacOS: Cmd+V
             if (event.isControlDown() && event.getCode().toString().equals("V")
                     || event.isMetaDown() && event.getCode().toString().equals("V")) {
                 event.consume();
             }
         });

        input.textProperty().addListener((observable, oldValue, newValue) -> {
            buttonStart.setDisable(input.getText().isEmpty());
            if (newValue.isEmpty()) {
                return;
            }
            if (newValue.length() == 1 && newValue.charAt(0) == '-') {

            } else if (newValue.length() > 1 && newValue.charAt(newValue.length() - 1) == '-' &&
                    (newValue.charAt(newValue.length() - 2) == '-' ||
                            !newValue.matches(".*;\\-.*") ||
                            Character.isDigit(newValue.charAt(newValue.length() - 2)))) {
                input.setText(newValue.substring(0, newValue.length() - 1));
            } else if (!newValue.matches("[0-9\\-;]*")) {
                input.setText(newValue.substring(0, newValue.length() - 1));
            }
        });
    }





    @FXML
    public void Start() {
        out.setText(input.getText());
        WordNumeric numericToWord = new WordNumeric();
        numericToWord.numericText(String.valueOf(input.textProperty()));
        //  out.setText(numericToWord.getRes());
    }


}