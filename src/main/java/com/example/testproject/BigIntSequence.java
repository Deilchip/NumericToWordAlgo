package com.example.testproject;

import java.math.BigInteger;

public class BigIntSequence {
    BigInteger numericView;
    byte nextNumber;
    public BigIntSequence(String sequence) throws Exception {
        try {
             numericView = new BigInteger(sequence);
        }
        catch (Exception e){
            throw new Exception();
        }
    }
    public byte getNextNumber(){
        nextNumber = numericView.mod(BigInteger.TEN).byteValue();
        numericView = numericView.divide(BigInteger.TEN);
        return nextNumber;
    }
    public byte seeNextNumber(){
        return numericView.mod(BigInteger.TEN).byteValue();
    }

}
