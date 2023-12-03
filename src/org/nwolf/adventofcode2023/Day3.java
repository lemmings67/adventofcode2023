package org.nwolf.adventofcode2023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import java.util.Vector;

public class Day3 {

    Vector<Day3SerialNo> serialnos = new Vector<Day3SerialNo>();
    Vector<Day3Symbol> symbols = new Vector<Day3Symbol>();

    ArrayList<String> d = new ArrayList<String>();

    public Day3(String [] data) {
        for (String line: data) {
            d.add(line);
        }
        analyseData();

    }

    public Day3(String filename) {

        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                d.add(line);
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        analyseData();

    }

    private void analyseData() {
        int y = 0;
        for (String line : this.d) {
            int x = 0;

            // Decode numbers into an array with line number and column number
            Pattern pattern_numbers = Pattern.compile("([0-9]+)");
            Matcher matcher_numbers = pattern_numbers.matcher(line);

            while (matcher_numbers.find()) {
                String value = matcher_numbers.group(1);
                x = line.indexOf(value, x);
                Day3SerialNo sn = new Day3SerialNo(x, y, Integer.parseInt(value));
                serialnos.add(sn);
                x++;
                // System.out.println(line + " row : " + x + " cur : " + value);
            }

            x = 0;

            // Decode symbols into an array with line number and column number
            Pattern pattern_symbol = Pattern.compile("([\\W])");
            Matcher matcher_symbol = pattern_symbol.matcher(line);

            while (matcher_symbol.find()) {
                String value = matcher_symbol.group(1);
                x = line.indexOf(value, x);
                if (x != -1 && value.equals(".") == false) {
                    Day3Symbol sn = new Day3Symbol(x, y, value);
                    symbols.add(sn);
                    System.out.println("Line " + y + " Column " + x + " : " + value);
                    x++;
                }
            }

            y++;
        }
    }

    public int sumSNNumbers() {
        int sum = 0;
        for (Day3SerialNo sn : this.serialnos) {
            boolean isValide = isValide(sn);
            if (isValide) {
                System.out.println(d.get(sn.getY()) + " row : " + sn.getY() + " cur : " + sn.getValue());
                // System.out.println(sn.getValue());
                sum += sn.getValue();
            }
        }
        System.out.println("Sum: " + sum);

        return sum;
    }

    public int sumGearsRatio() {
        int sum = 0;
        for (Day3Symbol s : this.symbols) {
            if (s.getValue().equals("*")) {
                // Search a SerialNo at the left and right of the symbol
                Day3SerialNo first = null, second = null;
                for (Day3SerialNo sn : this.serialnos) {
                    if (isNear(s, sn)) {
                        if (first == null) {
                            first = sn;
                        } else {
                            second = sn;
                        }
                    }
                }
                if (first != null && second != null) {
                    sum += first.getValue() * second.getValue();
                }
            }
        }
        System.out.println("Sum: " + sum);

        return sum;
    }

    private boolean isNear(Day3Symbol sy, Day3SerialNo sn) {
        // Search on top or bottom
        if (sn.getY() + 1 == sy.getY() || sn.getY() -1 == sy.getY()) {
                if (sy.getX() == sn.getMaxX() + 1 || sy.getX() == sn.getMinX() - 1)
                    return true;
                if (sn.getMinX() <= sy.getX() && sn.getMaxX() >= sy.getX())
                    return true;
        }
        // Search at left or right
        if (sn.getY() == sy.getY()) {
            if (sy.getX() == sn.getMaxX() + 1 || sy.getX() == sn.getMinX() - 1) return true;
        }
        return false;
    }

    private boolean isValide(Day3SerialNo sn) {
        for (Day3Symbol sy : this.symbols) {
            if (isNear(sy, sn)) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        //Day3 day3 = new Day3();
        //day3.sumValueNumbers(); 
        Day3 day3 = new Day3("data/day3_input.txt");
        day3.sumSNNumbers();
        day3.sumGearsRatio();

    }

}
