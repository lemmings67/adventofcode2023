package org.nwolf.adventofcode2023;

public class Day4CardData {

    // Card number (unique)
    private int cardNumber;
    // Numbers on this card
    private int[] numbers;
    // Winning numbers for this card
    private int[] winningNumbers;
    // Count the number of instances of the card
    private int instances = 0;

    private int point;

    public Day4CardData(int cardNumber, int[] numbers, int[] winningNumbers) {
        this.cardNumber = cardNumber;
        this.numbers = numbers;
        this.winningNumbers = winningNumbers;
        this.instances = 1;
    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public int[] getNumbers() {
        return this.numbers;
    }

    public int[] getwinningNumbers() {
        return this.winningNumbers;
    }

    public void addInstance(int copy) {
        this.instances+=copy;
    }

    public int getPoints() {
        int point = 0;
        for (int num : this.getNumbers()) {
            for (int win : this.getwinningNumbers()) {
                if (num == win) {
                    point++;
                }
            }
        }
        this.point = point;
        return point;
    }

    public double getPower() {
        double power = 0;
        if (point > 0)
            power = Math.pow(2, point - 1);
        return power;
    }

    public int getInstances() {
        return this.instances;
    }

}