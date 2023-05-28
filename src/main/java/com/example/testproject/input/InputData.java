package com.example.testproject.input;


public class InputData implements Edit {

    // проверка входного числа на наличие минуса
    @Override
    public boolean checkMinus(String inputSequence) {
        return inputSequence.charAt(0) == '-';
    }

}
