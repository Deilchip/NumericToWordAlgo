package com.example.testproject.extensions;

import java.math.BigInteger;

public class CustomBigInt {
    BigInteger numericView;

    public CustomBigInt(String sequence) throws Exception {
        try {
            numericView = new BigInteger(sequence);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public boolean checkValue() {
        return numericView.equals(BigInteger.valueOf(0));
    }
    //удалить несколько последних цифр числа
    public void deleteDigit(byte count) {
        while (count != 0) {
            numericView = numericView.divide(BigInteger.TEN);
            count--;
        }
    }

    public boolean checkZeros() {
        return numericView.mod(BigInteger.valueOf(1000)).intValue() == 0;
    }

    //посмотреть и удалить последнюю цифру числа
    public byte seeTens() {
        return numericView.divide(BigInteger.TEN).mod(BigInteger.TEN).byteValue();
    }

    //посмотреть последнюю цифру числа
    public byte seeCurrentDigit() {
        return numericView.mod(BigInteger.TEN).byteValue();
    }
}
