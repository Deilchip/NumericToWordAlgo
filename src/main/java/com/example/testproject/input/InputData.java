package com.example.testproject.input;


public class InputData implements Edit {
    @Override
    public boolean checkZero(String inputSequence) {
        return inputSequence.equals("0");
    }

    @Override
    public boolean checkMinus(String inputSequence) {
        return inputSequence.charAt(0) == '-';
    }

}
