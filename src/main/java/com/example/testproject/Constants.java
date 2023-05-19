package com.example.testproject;

import java.util.ArrayList;
import java.util.HashMap;

public class Constants{
    public static final HashMap<Integer, String> NUMBERS_INDEX = new HashMap<>();
    static {
        NUMBERS_INDEX.put(1, "один ");
        NUMBERS_INDEX.put(2, "два ");
        NUMBERS_INDEX.put(3, "три ");
        NUMBERS_INDEX.put(4, "четыре ");
        NUMBERS_INDEX.put(5, "пять ");
        NUMBERS_INDEX.put(6, "шесть ");
        NUMBERS_INDEX.put(7, "семь ");
        NUMBERS_INDEX.put(8, "восемь ");
        NUMBERS_INDEX.put(9, "девять ");
    }

    public static final HashMap<Integer, String> NUMBERS_DECLINATION = new HashMap<>();
    static {
        NUMBERS_DECLINATION.put(1, "одна ");
        NUMBERS_DECLINATION.put(2, "две ");
    }



    public static final HashMap<Integer, String> TEN_INDEX = new HashMap<>();
    static {
        TEN_INDEX.put(1, "десять ");
        TEN_INDEX.put(2, "двадцать ");
        TEN_INDEX.put(3, "тридцать ");
        TEN_INDEX.put(4, "сорок ");
        TEN_INDEX.put(5, "пятьдесят ");
        TEN_INDEX.put(6, "шестьдесят ");
        TEN_INDEX.put(7, "семьдесят ");
        TEN_INDEX.put(8, "восемьдесят ");
        TEN_INDEX.put(9, "девяносто ");
    }
    public static final HashMap<Integer, String> UNIQUE_TENS = new HashMap<>();
    static {
        UNIQUE_TENS.put(1,"одиннадцать ");
        UNIQUE_TENS.put(2,"двенадцать ");
        UNIQUE_TENS.put(3,"тринадцать ");
        UNIQUE_TENS.put(4,"четырнадцать ");
        UNIQUE_TENS.put(5,"пятнадцать ");
        UNIQUE_TENS.put(6,"шестнадцать ");
        UNIQUE_TENS.put(7,"семнадцать ");
        UNIQUE_TENS.put(8,"восемнадцать ");
        UNIQUE_TENS.put(9,"девятнадцать ");

    }
    public static final HashMap<Integer, String> HUNDRED_INDEX = new HashMap<>();
    static {
        HUNDRED_INDEX.put(1, "сто ");
        HUNDRED_INDEX.put(2, "двести ");
        HUNDRED_INDEX.put(3, "триста ");
        HUNDRED_INDEX.put(4, "четыреста ");
        HUNDRED_INDEX.put(5, "пятьсот ");
        HUNDRED_INDEX.put(6, "шестьсот ");
        HUNDRED_INDEX.put(7, "семьсот ");
        HUNDRED_INDEX.put(8, "восемьсот ");
        HUNDRED_INDEX.put(9, "девятьсот ");
    }

    public static final HashMap<Integer, String> LARGE_ONE_INDEX = new HashMap<>();
    static {
        LARGE_ONE_INDEX.put(1, "тысяча ");
        LARGE_ONE_INDEX.put(2, "миллион ");
    }

    public static final HashMap<Integer, String> LARGE_TWO_INDEX = new HashMap<>();
    static {
        LARGE_TWO_INDEX.put(1, "тысяч ");
        LARGE_TWO_INDEX.put(2, "миллионов ");
    }

    public static final HashMap<Integer, String> LARGE_THREE_INDEX = new HashMap<>();
    static {
        LARGE_THREE_INDEX.put(1, "тысячи ");
        LARGE_THREE_INDEX.put(2, "миллиона ");
    }

}
