package com.example.testproject;

import com.example.testproject.constants.ConstantsError;
import com.example.testproject.constants.ConstantsNumber;
import com.example.testproject.constants.ConstantsSuffix;
import com.example.testproject.digit.NumberAdder;
import com.example.testproject.digit.SearchDigit;
import com.example.testproject.extensions.CustomBigInt;
import com.example.testproject.input.Edit;
import com.example.testproject.input.InputData;
import com.example.testproject.sufix.Common;
import com.example.testproject.sufix.SuffixAdder;
import com.example.testproject.sufix.Thousand;

import java.math.BigInteger;
import java.util.ArrayList;

public class WordNumeric {
    //для записи результата
    private StringBuilder res = new StringBuilder();
    //для подсчета разряда после просмотра каждых 3 цифр
    private int summaryDigit = 0;
    //индекс для проверки отрицательного значения
    private int indexMinus = 0;
    //индекс для отслеживания 3 пустых разрядов для избежания записи неправильного наименования 10 в n-ой степени
    private byte indexZeroCount = 0;
    private SuffixAdder suffixAdder;
    private NumberAdder numberAdder;
    private Edit edit;

    //геттер для вывода
    public String getRes() {
        return res.toString().trim();
    }

    public void setSuffixAdder(SuffixAdder suffixAdder) {
        this.suffixAdder = suffixAdder;
    }

    public void setNumberAdder(NumberAdder numberAdder) {
        this.numberAdder = numberAdder;
    }

    public void setEdit(Edit edit) {
        this.edit = edit;
    }


    /* метод принимает в себя поочередно целочисленные значения типа CustomBigInt
     * за каждый проход цикла метод рассматривает 3 разряда, сначала проверяет наличие уникальных десяток
     * находит он их по следующему разряду (десятки), если он равен 1 и текущий разряд(единицы) равен любой цифре кроме 0
     * типа "одиннадцать,двенадцать" и т.д.
     * если текущий разряд (единицы) - ноль, то рассматривает из справочника названия для разряда десяток
     * после проверок удаляет два разряда (единицы, десятки) за ненадобностью их дальнейшего использования
     * проверяет следующую цифру на разряд сотен и вписывает значение
     * т.к. метод рассматривает по 3 разряда, то в конце присутствует инкремент для переменной summaryDigit
     * также по метод обнуляет переменную indexZeroCount по той же причине, т.к. все нужные разряды были просмотрены
     */
    private void countOrder(CustomBigInt sequence) {
        while (!sequence.checkValue()) {
            addSuffix(sequence.seeCurrentDigit(), sequence.seeTens());
            if (sequence.seeTens() == 1 &&
                    sequence.seeCurrentDigit() != 0)
                searchNumber(ConstantsNumber.UNIQUE_TENS, sequence.seeCurrentDigit());
            else if (sequence.seeTens() != 0) {
                searchNumber(ConstantsNumber.NUMBERS_INDEX, sequence.seeCurrentDigit());
                searchNumber(ConstantsNumber.TEN_INDEX, sequence.seeTens());
            } else
                searchNumber(ConstantsNumber.NUMBERS_INDEX, sequence.seeCurrentDigit());
            sequence.deleteDigit((byte) 2);
            searchNumber(ConstantsNumber.HUNDRED_INDEX, sequence.seeCurrentDigit());
            sequence.deleteDigit((byte) 1);
            summaryDigit++;
            indexZeroCount = 0;
        }

    }

    private void addSuffix(byte digit, byte ten) {
        if (checkZeros(digit))
            return;
        if (summaryDigit > 1) {
            setSuffixAdder(new Common());
            addTextToRes(suffixAdder.processSuffix(digit, ten));
        } else if (summaryDigit == 1) {
            setSuffixAdder(new Thousand());
            addTextToRes(suffixAdder.processSuffix(digit, ten));
        }
        addTextToRes(ConstantsNumber.LARGE_INDEX.get(summaryDigit));
    }

    private boolean checkZeros(byte number) {
        if (indexZeroCount == 3) {
            indexZeroCount = 0;
            return true;
        } else if (number == 0) {
            indexZeroCount++;
        }
        return false;
    }

    private void addTextToRes(String constant) {
        res.insert(0, constant);
    }


    private void searchNumber(ArrayList<String> constant, byte sequence) {
        setNumberAdder(new SearchDigit());
        if (summaryDigit == 1 && constant == ConstantsNumber.NUMBERS_INDEX) {
            addTextToRes(numberAdder.findCommon(sequence));
        } else {
            addTextToRes(numberAdder.findCommon(constant, sequence));
        }
    }


    public void inputEdit(String numSequence) throws Exception {
        res.setLength(0);
        String[] number = numSequence.split(";");
        setEdit(new InputData());
        for (int i = number.length - 1; i >= 0; i--) {
            if (edit.checkZero(numSequence)) {
                addTextToRes(ConstantsNumber.ZERO);
                continue;
            } else if (edit.checkMinus(numSequence)) {
                indexMinus = 1;
                number[i] = number[i].replaceFirst("-", "");
            }
            if (checkFormat(number[i])) {
                countOrder(new CustomBigInt(number[i]));
                if (indexMinus == 1)
                    addTextToRes(ConstantsSuffix.MINUS);
                addTextToRes(ConstantsSuffix.NEXT_LINE);
            }
            setZeroIndexes();
        }
    }
    public boolean checkFormat(String inputSequence) {
        if (((double) inputSequence.length() / 3) > ConstantsNumber.LARGE_INDEX.size()) {
            res.append(ConstantsError.ERROR_SIZE);
            System.out.println(inputSequence + " - " + ConstantsError.ERROR_SIZE);
            return false;
        }
        if (inputSequence.length() == 0) {
            res.append(ConstantsError.ERROR_NULL);
            System.out.println(ConstantsError.ERROR_NULL);
            return false;
        }
        try {
            BigInteger integer = new BigInteger(inputSequence);
        } catch (NumberFormatException e) {
            res.append(ConstantsError.ERROR_TYPE);
            System.out.println(inputSequence + " - " + ConstantsError.ERROR_TYPE);
            return false;
        }
        return true;
    }
    private void setZeroIndexes() {
        summaryDigit = 0;
        indexMinus = 0;
    }
}
