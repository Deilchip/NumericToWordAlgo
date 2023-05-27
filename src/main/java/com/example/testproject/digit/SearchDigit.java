package com.example.testproject.digit;

import com.example.testproject.constants.ConstantsNumber;

import java.util.ArrayList;

public class SearchDigit implements NumberAdder {
    @Override
    public String findCommon(ArrayList<String> constant, byte digit) {
        return constant.get(digit);
    }

    @Override
    public String findCommon(byte digit) {
        if (digit != 0 && digit <= 2)
            return (ConstantsNumber.NUMBERS_DECLINATION.get(digit));
        else
            return (ConstantsNumber.NUMBERS_INDEX.get(digit));
    }
}
