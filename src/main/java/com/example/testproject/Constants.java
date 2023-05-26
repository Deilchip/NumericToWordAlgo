package com.example.testproject;

import java.util.ArrayList;
import java.util.HashMap;

public class Constants{
    public static final String ZERO ="ноль";
    public static final String MINUS ="минус";
    public static final byte FIRST =0;
    public static final byte SECOND =1;

    public static final ArrayList<String> NUMBERS_INDEX = new ArrayList<>();
    static {

        NUMBERS_INDEX.add(0, "");
        NUMBERS_INDEX.add(1, "один ");
        NUMBERS_INDEX.add(2, "два ");
        NUMBERS_INDEX.add(3, "три ");
        NUMBERS_INDEX.add(4, "четыре ");
        NUMBERS_INDEX.add(5, "пять ");
        NUMBERS_INDEX.add(6, "шесть ");
        NUMBERS_INDEX.add(7, "семь ");
        NUMBERS_INDEX.add(8, "восемь ");
        NUMBERS_INDEX.add(9, "девять ");
    }

    public static final ArrayList<String> NUMBERS_DECLINATION = new ArrayList<>();
    static {
        NUMBERS_DECLINATION.add(0, "");
        NUMBERS_DECLINATION.add(1, "одна ");
        NUMBERS_DECLINATION.add(2, "две ");
    }



    public static final ArrayList<String> TEN_INDEX = new ArrayList<>();
    static {
        TEN_INDEX.add(0, "");
        TEN_INDEX.add(1, "десять ");
        TEN_INDEX.add(2, "двадцать ");
        TEN_INDEX.add(3, "тридцать ");
        TEN_INDEX.add(4, "сорок ");
        TEN_INDEX.add(5, "пятьдесят ");
        TEN_INDEX.add(6, "шестьдесят ");
        TEN_INDEX.add(7, "семьдесят ");
        TEN_INDEX.add(8, "восемьдесят ");
        TEN_INDEX.add(9, "девяносто ");
    }
    public static final ArrayList<String> UNIQUE_TENS = new ArrayList<>();
    static {
        UNIQUE_TENS.add(0,"");
        UNIQUE_TENS.add(1,"одиннадцать ");
        UNIQUE_TENS.add(2,"двенадцать ");
        UNIQUE_TENS.add(3,"тринадцать ");
        UNIQUE_TENS.add(4,"четырнадцать ");
        UNIQUE_TENS.add(5,"пятнадцать ");
        UNIQUE_TENS.add(6,"шестнадцать ");
        UNIQUE_TENS.add(7,"семнадцать ");
        UNIQUE_TENS.add(8,"восемнадцать ");
        UNIQUE_TENS.add(9,"девятнадцать ");

    }
    public static final ArrayList<String> HUNDRED_INDEX = new ArrayList<>();
    static {
        HUNDRED_INDEX.add(0, "");
        HUNDRED_INDEX.add(1, "сто ");
        HUNDRED_INDEX.add(2, "двести ");
        HUNDRED_INDEX.add(3, "триста ");
        HUNDRED_INDEX.add(4, "четыреста ");
        HUNDRED_INDEX.add(5, "пятьсот ");
        HUNDRED_INDEX.add(6, "шестьсот ");
        HUNDRED_INDEX.add(7, "семьсот ");
        HUNDRED_INDEX.add(8, "восемьсот ");
        HUNDRED_INDEX.add(9, "девятьсот ");
    }
    public static final ArrayList<String> LARGE_INDEX = new ArrayList<>();
    static {
        LARGE_INDEX.add(0, "");
        LARGE_INDEX.add(1, "тысяч");
        LARGE_INDEX.add(2, "миллион");
        LARGE_INDEX.add(3, "миллиард");
        LARGE_INDEX.add(4, "триллион");
        LARGE_INDEX.add(5, "квадраллион");
        LARGE_INDEX.add(6, "квинтиллион");
        LARGE_INDEX.add(7, "секстиллион");
        LARGE_INDEX.add(8, "септиллион");
        LARGE_INDEX.add(9, "октиллион");
        LARGE_INDEX.add(10, "нониллион");
        LARGE_INDEX.add(11, "дециллион");
    }

}
