package org.nwolf.adventofcode2023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameSet {

    private int red_cubes = 0;
    private int green_cubes = 0;
    private int blue_cubes = 0;

    public GameSet(String gameset) {

        Pattern pattern = Pattern.compile(
                "(\\d+) (red|green|blue)");

        Matcher matcher = pattern.matcher(gameset);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group(1));
            String color = matcher.group(2);

            if (color.equals("red")) {
                this.red_cubes = number;
            } else if (color.equals("green")) {
                this.green_cubes = number;
            } else if (color.equals("blue")) {
                this.blue_cubes = number;
            }
        }

    }

    public int getRedCubes() {
        return this.red_cubes;
    }

    public int getGreenCubes() {
        return this.green_cubes;
    }

    public int getBlueCubes() {
        return this.blue_cubes;
    }

    public int getTotalCubes() {
        return this.red_cubes + this.green_cubes + this.blue_cubes;
    }

    public int getScore() {
        return this.red_cubes * 3 + this.green_cubes * 2 + this.blue_cubes;
    }

    public String toString() {
        return "GameSet: " + this.red_cubes + " red, " + this.green_cubes + " green, " + this.blue_cubes + " blue";
    }
}