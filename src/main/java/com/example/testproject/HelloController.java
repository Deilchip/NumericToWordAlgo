package com.example.testproject;

import com.example.testproject.extensions.CustomContextMenuTextField;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;


public class HelloController {

    @FXML
    private TextArea out;

    @FXML
    private Button buttonStart;
    @FXML
    private CustomContextMenuTextField input;

     public void initialize() {
         input.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
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
                            !newValue.matches(".*\\d;\\d.*") || // <-- Добавлено новое условие
                            Character.isDigit(newValue.charAt(newValue.length() - 2)))) {
                input.setText(newValue.substring(0, newValue.length() - 1));
            } else if (!newValue.matches("[0-9\\-;]*")) {
                input.setText(newValue.substring(0, newValue.length() - 1));
            }
        });
    }

    @FXML
    public void Start() throws Exception {
        WordNumeric numericToWord = new WordNumeric();
        numericToWord.inputEdit(String.valueOf(input.textProperty().getValue()));
        out.setText(numericToWord.getRes());
    }

}