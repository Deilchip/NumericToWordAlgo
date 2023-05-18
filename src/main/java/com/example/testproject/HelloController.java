package com.example.testproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.HashMap;
import java.util.Scanner;

public class HelloController {
    private StringBuilder res = new StringBuilder();
    private byte i = 0;
    private static final HashMap<Integer, String> VALUE = new HashMap<>();

    static {
        VALUE.put(1, "один");
        VALUE.put(2, "два");
        VALUE.put(3, "три");
        VALUE.put(4, "четыре");
        VALUE.put(5, "пять");
        VALUE.put(6, "шесть");
        VALUE.put(7, "семь");
        VALUE.put(8, "восемь");
        VALUE.put(9, "девять");
    }

    private static final HashMap<Integer, String> HUNDRED = new HashMap<>();

    static {
        HUNDRED.put(1, "сто");
        HUNDRED.put(2, "двести");
        HUNDRED.put(3, "триста");
        HUNDRED.put(4, "четыреста");
        HUNDRED.put(5, "пятьсот");
        HUNDRED.put(6, "шестьсот");
        HUNDRED.put(7, "семьсот");
        HUNDRED.put(8, "восемьсот");
        HUNDRED.put(9, "девятьсот");
    }

    private static final HashMap<Integer, String> SUFFIX = new HashMap<>();

    static {
        SUFFIX.put(1, "тысяча");
        SUFFIX.put(2, "миллион");
        SUFFIX.put(3, "миллиард");
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        i = 0;
        res = new StringBuilder();
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        long num = in.nextInt();
        welcomeText.setText(numericToText(num).toString());
    }

    public StringBuilder numericToText(long num) {
        if (num == 0 && i == 0) {
            res.append("ноль");
            return res;
        }
        if (num == 0)
            return res;
        byte unit = (byte) (num % 10);
        i += 1;
        if ((i - 1) % 3 == 0 && i > 3) {
            SUFFIX.forEach((key, value) -> {
                if (key == i / 3) {
                    res.insert(0, " ").insert(0, value);
                }
            });
        }
        if (i % 3 == 0) {
            HUNDRED.forEach((key, value) -> {
                if (key == unit) {
                    res.insert(0, " ").insert(0, value);
                }
            });
            return numericToText(num / 10);
        }
        VALUE.forEach((key, value) -> {
            if (key == unit) {
                res.insert(0, " ").insert(0, value);
            }
        });
        return numericToText(num / 10);
    }
}