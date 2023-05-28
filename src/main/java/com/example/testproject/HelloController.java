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
        //отключение вставки в текстовую строку
        input.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.isControlDown() && event.getCode().toString().equals("V")
                    || event.isMetaDown() && event.getCode().toString().equals("V")) {event.consume();}});
        // запрет на ввод в текстовое поле что-то кроме разрешенных символов ";" "-" и цифр 0-9
        input.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String character = event.getCharacter();
            boolean isDigit = character.matches("[0-9]");
            boolean isSymbol = character.equals("-") || character.equals(";");
            if (!isDigit && !isSymbol) {
                event.consume();
            }
        });
        // отключение кнопки старта, если текстовое поле пустое
        input.textProperty().addListener((observable, oldValue, newValue) ->
                buttonStart.setDisable(input.getText().isEmpty()));
    }

    // метод запускающий алгоритм преобразования
    @FXML
    public void Start() throws Exception {
        WordNumeric numericToWord = new WordNumeric();
        numericToWord.inputEdit(String.valueOf(input.textProperty().getValue()));
        out.setText(numericToWord.getRes());
    }

}