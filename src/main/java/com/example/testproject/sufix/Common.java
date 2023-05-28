package com.example.testproject.sufix;

import com.example.testproject.constants.ConstantsSuffix;

public class Common implements SuffixAdder{
    // выбор склонения для суффикса в случае, если степень десятки не эквивалентна тысячам
    @Override
    public String processSuffix(byte digit, byte ten) {
        if (digit == 1 && ten != 1)
            return ConstantsSuffix.SUFFIX_SPACE;
        else if (digit <= 4 && digit != 0 && (ten > 1 || ten == 0))
            return ConstantsSuffix.SUFFIX_A;
        else return ConstantsSuffix.SUFFIX_OV;

    }
}
