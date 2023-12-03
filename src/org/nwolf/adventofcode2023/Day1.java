// https://adventofcode.com - Day 1 

package org.nwolf.adventofcode2023;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {

    private String input;
    private int calibrationNumber;

    public Day1(String input) {
        this.input = input;

        Pattern pattern_begin = Pattern.compile(
                "(one|two|three|four|five|six|seven|eight|nine|\\d)");

        Pattern pattern_end = Pattern.compile(
                "^.*([0-9]|one|two|three|four|five|six|seven|eight|nine).*$");

        Matcher matcher_begin = pattern_begin.matcher(input);
        Matcher matcher_end = pattern_end.matcher(input);

        if (matcher_begin.find() && matcher_end.find()) {
            String firstNumber = matcher_begin.group(1);
            String secondNumber = matcher_end.group(1);
            this.calibrationNumber = Integer.parseInt(getNumberFromLitteral(firstNumber) + getNumberFromLitteral(secondNumber));
        } else {
            System.out.println("No match found for input " + input);
            String onlyNumberString = getNumberFromLitteral(input);

            this.calibrationNumber = Integer
                    .parseInt(onlyNumberString.charAt(0) + "" + onlyNumberString.charAt(onlyNumberString.length() - 1));
        }

    }

    public String getNumberFromLitteral(String litteral) {
        String onlyNumberString = litteral;
        onlyNumberString = onlyNumberString.replaceAll("one", "1");
        onlyNumberString = onlyNumberString.replaceAll("two", "2");
        onlyNumberString = onlyNumberString.replaceAll("three", "3");
        onlyNumberString = onlyNumberString.replaceAll("four", "4");
        onlyNumberString = onlyNumberString.replaceAll("five", "5");
        onlyNumberString = onlyNumberString.replaceAll("six", "6");
        onlyNumberString = onlyNumberString.replaceAll("seven", "7");
        onlyNumberString = onlyNumberString.replaceAll("eight", "8");
        onlyNumberString = onlyNumberString.replaceAll("nine", "9");
        onlyNumberString = onlyNumberString.replaceAll("[^0-9-]", "");

        return onlyNumberString;
    }


    public int getCalibrationNumber() {
        return calibrationNumber;
    }

    public static void main(String[] args) {
  
  
        // Open the file "Day1Input.txt" and read the contents into a String variable
        // called "input"
        File file = new File("data/day1_input.txt");
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        int sum = 0;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                Day1 day1 = new Day1(line);
                System.out.println("Calibration number for input " + line + " is " + day1.getCalibrationNumber());
                sum += day1.getCalibrationNumber();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Total : " + sum);

    }

    public static void tester(String input) {
        Day1 day1 = new Day1(input);
        System.out.println("Calibration number for input " + input + " is " + day1.getCalibrationNumber());
    }

}