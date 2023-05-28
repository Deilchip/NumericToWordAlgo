package com.example.testproject.extensions;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class CustomContextMenuTextField extends TextField {
    //настройка меню при нажатии правой кнопки мыши
    public CustomContextMenuTextField() {
        super();
        MenuItem cut = new MenuItem("Вырезать");
        cut.setOnAction(e -> this.cut());

        MenuItem copy = new MenuItem("Копировать");
        copy.setOnAction(e -> this.copy());

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().addAll(cut, copy);
        this.setContextMenu(contextMenu);
    }
}
