package com.example.testproject;

import java.math.BigInteger;
import java.util.ArrayList;

public class WordNumeric {
    private StringBuilder res = new StringBuilder();
    private int summaryDigit = 0;
    private int indexMinus = 0;
    private byte indexZeroCount = 0;
    public String getRes() {
        return res.toString().trim();
    }
    private StringBuilder countOrder(BigInteger sequence) {
        while (!sequence.equals(BigInteger.valueOf(0))) {
            addSuffix(sequence.mod(BigInteger.valueOf(1000)).intValue());
            if (sequence.divide(BigInteger.TEN).mod(BigInteger.TEN).byteValue() == 1 &&
                    sequence.mod(BigInteger.TEN).byteValue() != 0)
                searchNumber(Constants.UNIQUE_TENS, sequence.mod(BigInteger.TEN).byteValue());
            else if (sequence.divide(BigInteger.TEN).mod(BigInteger.TEN).byteValue() != 0) {
                searchNumber(sequence.mod(BigInteger.TEN).byteValue());
                searchNumber(Constants.TEN_INDEX, sequence.divide(BigInteger.TEN).mod(BigInteger.TEN).byteValue());
            } else
                searchNumber(sequence.mod(BigInteger.TEN).byteValue());
            sequence = sequence.divide(BigInteger.TEN).divide(BigInteger.TEN);
            searchNumber(Constants.HUNDRED_INDEX, sequence.mod(BigInteger.TEN).byteValue());
            sequence = sequence.divide(BigInteger.TEN);
            summaryDigit++;
        }
        return res.insert(0, "\n");
    }
    private void addSuffix(int sequence) {
        if (sequence == 0)
            return;
        int checkTens = (sequence / 10) % 10;
        sequence %= 10;
        if (summaryDigit == 1) {
            if (sequence == 1 && checkTens != 1)
                res.insert(0, "а ");
            else if (sequence <= 4 && sequence != 0 && (checkTens > 1 || checkTens == 0))
                res.insert(0, "и ");
            else res.insert(0, " ");
        } else if (summaryDigit != 0) {
            if (sequence == 1 && checkTens != 1)
                res.insert(0, " ");
            else if (sequence <= 4 && sequence != 0 && (checkTens > 1 || checkTens == 0))
                res.insert(0, "а ");
            else res.insert(0, "ов ");
        }
        res.insert(0, Constants.LARGE_INDEX.get(summaryDigit));
    }
    private void searchNumber(byte sequence) {
        if (summaryDigit == 1 && sequence <= 2 && sequence != 0) {
            res.insert(0, Constants.NUMBERS_DECLINATION.get(sequence));
        } else {
            res.insert(0, Constants.NUMBERS_INDEX.get(sequence));
        }
    }
    private void searchNumber(ArrayList<String> map, byte sequence) {
        res.insert(0, map.get(sequence));
    }

    public void numericText(String num) {
        res.setLength(0);
        String[] allNumbers = num.split(";");
        for (int i = allNumbers.length - 1; i >= 0; i--) {
            allNumbers[i].replaceAll("[^\\d]","");
            if (allNumbers[i].charAt(0) == '-') {
                indexMinus++;
                allNumbers[i] = allNumbers[i].substring(1);
            }
            if (allNumbers[i].equals("0")) {
                res.append(Constants.ZERO);
                continue;
            }
            try {
                countOrder(new BigInteger(allNumbers[i]));
                if (indexMinus != 0) {
                    res.insert(1, "минус ");
                    indexMinus = 0;
                }
                summaryDigit = 0;
            } catch (Exception e) {
                res.append("введено некорректное число\n");
            }
        }
    }
}
