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
    public void deleteDigit(byte count) {
        while (count != 0) {
            numericView = numericView.divide(BigInteger.TEN);
            count--;
        }

    }
    public byte seeTens() {
        return numericView.divide(BigInteger.TEN).mod(BigInteger.TEN).byteValue();
    }

    public byte seeCurrentDigit() {
        return numericView.mod(BigInteger.TEN).byteValue();
    }


}
