package com.example.testproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.*;

public class HelloController {
    private StringBuilder res = new StringBuilder();
    private byte index = 0;
    private int summaryDigit = 0;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        res = new StringBuilder();
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        long num = in.nextInt();
        welcomeText.setText(countOrder(numericText(num)).toString());
    }

    private StringBuilder countOrder(ArrayList<Byte> sequence) {
        if (sequence.size() > 3)
            summaryDigit = sequence.size() / 3;
        while (sequence.size() % 3 != 0) {
            sequence.add(0, (byte) 0);
        }
        int i = 0;
        while (i != sequence.size()) {
            if (index == 0) {
                searchHundreds(sequence.get(i));
                i++;
            }
            if (index == 1) {
                if (sequence.get(i) == 1 && sequence.get(i + 1) != 0) {
                    searchUniqueTens(sequence.get(i + 1));
                    i += 2;
                } else {
                    searchTens(sequence.get(i));
                    i++;
                    searchNumber(sequence.get(i));
                    i++;
                }

            }
        }
        return res;
    }

    private void searchNumber(Byte sequence) {
        Constants.NUMBERS_INDEX.forEach((key, value) -> {
            if (key == (int) sequence)
                if (summaryDigit <= 0)
                    res.append(value);
               else if (key == 1)
                    if (summaryDigit == 1)
                        res.append(Constants.NUMBERS_DECLINATION.get(1)).append(Constants.LARGE_ONE_INDEX.get(summaryDigit));
                    else res.append(value).append(Constants.LARGE_ONE_INDEX.get(summaryDigit));
                else if (key <= 4) {
                    if (key == 2 && summaryDigit == 1)
                        res.append(Constants.NUMBERS_DECLINATION.get(2)).append(Constants.LARGE_THREE_INDEX.get(summaryDigit));
                    else res.append(value).append(Constants.LARGE_THREE_INDEX.get(summaryDigit));
                } else if (key <= 9) {
                    res.append(value).append(Constants.LARGE_TWO_INDEX.get(summaryDigit));
                }
        });
        summaryDigit -= 1;
    }

    private void searchTens(Byte sequence) {
        Constants.TEN_INDEX.forEach((key, value) -> {
            if (key == (int) sequence)
                res.append(value);
        });
        index-=1;
    }

    private void searchUniqueTens(Byte sequenceNumber) {
        Constants.UNIQUE_TENS.forEach((key, value) -> {
            if (key == (int) sequenceNumber) {
                if(summaryDigit!=0)
                res.append(value).append(Constants.LARGE_TWO_INDEX.get(summaryDigit));
                else res.append(value);
            }
        });
        summaryDigit-=1;
        index -= 1;
    }
    private void searchHundreds(Byte sequence) {
        Constants.HUNDRED_INDEX.forEach((key, value) -> {
            if (key == (int) sequence)
                res.append(value);
        });
        index++;
    }

    private ArrayList<Byte> numericText(long num) {
        if (num < 0) {
            num *= -1;
            res.insert(0, "минус ");
        }
        ArrayList<Byte> result = new ArrayList<>();
        while (num != 0) {
            result.add((byte) (num % 10));
            num /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}