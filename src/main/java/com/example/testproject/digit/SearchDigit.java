package com.example.testproject.digit;

import com.example.testproject.constants.ConstantsNumber;

import java.util.ArrayList;

public class SearchDigit implements NumberAdder {
    //берёт соответсвующее цифре текстовое представление
    @Override
    public String findCommon(ArrayList<String> constant, byte digit) {
        return constant.get(digit);
    }

    //рассматривает единицы
    @Override
    public String findCommon(byte digit) {
        // проверка на склонение цифр: 1, 2
        if (digit != 0 && digit <= 2)
            return (ConstantsNumber.NUMBERS_DECLINATION.get(digit));
        // в остальных случаях
        else
            return (ConstantsNumber.NUMBERS_INDEX.get(digit));
    }
}
