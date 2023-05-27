package com.example.testproject.input;

import com.example.testproject.constants.ConstantsError;
import com.example.testproject.constants.ConstantsNumber;

import java.math.BigInteger;

public class InputData implements Edit {
    @Override
    public boolean checkZero(String inputSequence) {
        return inputSequence.equals("0");
    }

    @Override
    public boolean checkMinus(String inputSequence) {
        if (inputSequence.charAt(0) == '-') {
            return true;
        }
        return false;
    }

}
