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
    private final StringBuilder res = new StringBuilder();
    //для подсчета разряда после просмотра каждых 3 цифр
    private int summaryDigit = 0;
    //индекс для проверки отрицательного значения
    private int indexMinus = 0;
    //индекс для отслеживания 3 пустых разрядов для избежания записи неправильного наименования 10 в n-ой степени
    private SuffixAdder suffixAdder;
    private NumberAdder numberAdder;
    private Edit edit;

    //геттер для вывода
    public String getRes() {
        return res.toString().replaceFirst("\n", "");
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


    // метод перевода целочисленного представления в текстовом виде
    private void countOrder(CustomBigInt sequence) {
        while (!sequence.checkValue()) {
            // проверка 3 разрядов на наличие нулей, если все 3 разряда = 0 тогда удаляем их и добавляем 1 к summaryDigit
            if (sequence.checkZeros()) {
                sequence.deleteDigit((byte) 3);
                summaryDigit++;
                continue;
            }
            // вызов метода для добавления суфикса
            addSuffix(sequence.seeCurrentDigit(), sequence.seeTens());
            /* просмотр последующего(десятки) и текущего(единицы) разряда, если текущий не равен 0 и последующий
             * равен 1, тогда отправляем только текущий разряд в поиск цифры для нахождения уникальных десяток
             * типа: одиннадцать, тринадцать и т.д.
             */
            if (sequence.seeTens() == 1 &&
                    sequence.seeCurrentDigit() != 0)
                searchNumber(ConstantsNumber.UNIQUE_TENS, sequence.seeCurrentDigit());
           /* просмотр последующего(десятки) разряда, если он не ноль, тогда просто находим индекс совпадающий
            * с текстовым представлением разряда
            */
            else if (sequence.seeTens() != 0) {
                searchNumber(ConstantsNumber.NUMBERS_INDEX, sequence.seeCurrentDigit());
                searchNumber(ConstantsNumber.TEN_INDEX, sequence.seeTens());
            }
            // нахождение совпадения значения разряда единиц с текстовым представлением
            else
                searchNumber(ConstantsNumber.NUMBERS_INDEX, sequence.seeCurrentDigit());
            // удаление двух разрядов, т.к. выше были рассмотрены разряды единиц и десяток
            sequence.deleteDigit((byte) 2);
            // нахождение совпадения значения разряда сотен с текстовым представлением
            searchNumber(ConstantsNumber.HUNDRED_INDEX, sequence.seeCurrentDigit());
            // удаление третьего разряда (сотен)
            sequence.deleteDigit((byte) 1);
            // инкрементация индекса для отслеживания нужного текстового представления степени 10 (тысячи,миллионы и т.д)
            summaryDigit++;
        }
    }

    //метод для добавления к текстовому представлению степени 10 правильного суффикса (миллион(а/ов/ )
    private void addSuffix(byte digit, byte ten) {
        /* общая проверка, у всех текстовых представлений выше тысячи суффиксы и построение одинаково
         * (миллион(а/ов ), миллиард(а/ов ), триллион(а/ов/ ) и т.д.
         */
        if (summaryDigit > 1) {
            setSuffixAdder(new Common());
            addTextToRes(suffixAdder.processSuffix(digit, ten));
        }
        // проверка на текстовое представление для тысяч, т.к. у нех построение уникально
        else if (summaryDigit == 1) {
            setSuffixAdder(new Thousand());
            addTextToRes(suffixAdder.processSuffix(digit, ten));
        }
        // добавление самого текстового представления степени 10
        addTextToRes(ConstantsNumber.LARGE_INDEX.get(summaryDigit));
    }

    // добавление какого-либо текстового представления
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
            if (!checkFormat(number[i])) {
                addTextToRes(ConstantsSuffix.NEXT_LINE);
                continue;
            } else if (edit.checkMinus(number[i])) {
                indexMinus = 1;
                number[i] = number[i].replaceFirst("-", "");
            }
            if (indexMinus == 1) {
                countOrder(new CustomBigInt(number[i].replaceFirst("-", "")));
                addTextToRes(ConstantsSuffix.MINUS);
            } else
                countOrder(new CustomBigInt(number[i]));
            addTextToRes(ConstantsSuffix.NEXT_LINE);
            setZeroIndexes();
        }
    }

    @SuppressWarnings("unused")
    public boolean checkFormat(String inputSequence) {
        if (inputSequence.length() == 0) {
            addTextToRes(ConstantsError.ERROR_NULL);
            System.out.println(ConstantsError.ERROR_NULL);
            return false;
        }
        if (((double) inputSequence.length() / 3) > ConstantsNumber.LARGE_INDEX.size()) {
            addTextToRes(ConstantsError.ERROR_SIZE);
            System.out.println(inputSequence + " - " + ConstantsError.ERROR_SIZE);
            return false;
        }
        try {
            BigInteger number = new BigInteger(inputSequence);
            if (number.equals(BigInteger.valueOf(0))) {
                addTextToRes(ConstantsNumber.ZERO);
                return false;
            }
        } catch (NumberFormatException e) {
            addTextToRes(ConstantsError.ERROR_TYPE);
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
