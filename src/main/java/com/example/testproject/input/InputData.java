package com.example.testproject.input;


public class InputData implements Edit {
    // проверка входного числа на ноль
    @Override
    public boolean checkZero(String inputSequence) {
        return inputSequence.equals("0");
    }

    // проверка входного числа на наличие минуса
    @Override
    public boolean checkMinus(String inputSequence) {
        return inputSequence.charAt(0) == '-';
    }

}
