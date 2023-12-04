package org.nwolf.adventofcode2023;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.nwolf.adventofcode2023.Day4CardData;

public class Day4 {

    public Day4(String[] data) {
        for (String line : data) {
            analyse(line);
        }
    }

    public Day4(String filename) {
        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                analyse(line);
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void analyse(String line) {
        Pattern p = Pattern.compile("Card +(\\d+): +([ 0-9]+) \\| ([ 0-9]+)");
        Matcher m = p.matcher(line);
        if (m.find()) {
            int cardNumber = Integer.parseInt(m.group(1));
            String[] numbers_str = m.group(2).trim().split(" +");
            String[] winningNumbers_str = m.group(3).trim().split(" +");
            int[] numbers = new int[numbers_str.length];
            int[] winningNumbers = new int[winningNumbers_str.length];
            for (int i = 0; i < numbers_str.length; i++) {
                numbers[i] = Integer.parseInt(numbers_str[i]);
            }
            for (int i = 0; i < winningNumbers_str.length; i++) {
                winningNumbers[i] = Integer.parseInt(winningNumbers_str[i]);
            }
            Day4CardData d = new Day4CardData(cardNumber, numbers, winningNumbers);
            Day4CardData.add(d);
        }
    }

    public int sumWinningNumbersPower() {
        int sum = 0;
        for (Day4CardData d : Day4CardData.getAll()) {
            int point = 0;
            for (int num : d.getNumbers()) {
                for (int win : d.getwinningNumbers()) {
                    if (num == win) {
                        point++;
                    }
                }
            }
            double power = 0;
            if (point > 0)
                power = Math.pow(2, point - 1);
            System.out.println("Card " + d.getCardNumber() + " point: " + point + " power: " + power);
            sum += power;
        }
        return sum;
    }

    public static void main(String[] args) {
        Day4 d = new Day4("data/day4_input.txt");
        System.out.println("Result : " + d.sumWinningNumbersPower());
    }

}