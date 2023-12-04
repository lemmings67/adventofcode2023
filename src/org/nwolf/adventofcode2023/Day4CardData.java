package org.nwolf.adventofcode2023;

import java.util.Enumeration;
import java.util.Vector;

public class Day4CardData {

    int cardNumber;
    int [] numbers;
    int [] winningNumbers;

    private static Vector <Day4CardData> all = new Vector <Day4CardData> ();

    public Day4CardData(int cardNumber, int [] numbers, int [] winningNumbers) {
        this.cardNumber = cardNumber;
        this.numbers = numbers;
        this.winningNumbers = winningNumbers;
    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public int [] getNumbers() {
        return this.numbers;
    }

    public int [] getwinningNumbers() {
        return this.winningNumbers;
    }

    public static Vector<Day4CardData> getAll() {
        return (Vector<Day4CardData>) all.clone();
    }

    public static void add(Day4CardData d) {
        all.add(d);
    }
}