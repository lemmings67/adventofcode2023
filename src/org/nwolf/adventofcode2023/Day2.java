package org.nwolf.adventofcode2023;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {
    
    final private static int max_red_cubes = 12;
    final private static int max_green_cubes = 13;
    final private static int max_blue_cubes = 14;

    private int gameid = 0;
    private Vector<GameSet> gamesets = new Vector<GameSet>();
    
    public Day2(String gamerecord) {

        Pattern pattern = Pattern.compile(
                "Game (\\d+):(.*)");

        Matcher matcher = pattern.matcher(gamerecord);

        if (matcher.find()) {
            this.gameid = Integer.parseInt(matcher.group(1));
            String gamesets = matcher.group(2);
            for (String gameset : gamesets.split(";")) {
                GameSet gs = new GameSet(gameset);
                this.gamesets.add(gs);
                System.out.println(gs);
            }

        } else {
            System.out.println("No match found for input " + gamerecord);
        }


    }

    public boolean isPossible() {
        
        for (GameSet gs : this.gamesets) {
            if (gs.getRedCubes() > max_red_cubes) return false;
            if (gs.getGreenCubes() > max_green_cubes) return false;
            if (gs.getBlueCubes() > max_blue_cubes) return false;
        }
        
        return true;
    }

    public int getPowerOfCubes() {
        int max_red_cubes = 0;
        int max_green_cubes = 0;
        int max_blue_cubes = 0;
        for (GameSet gs : this.gamesets) {
            if (gs.getRedCubes() > max_red_cubes) max_red_cubes = gs.getRedCubes();
            if (gs.getGreenCubes() > max_green_cubes) max_green_cubes = gs.getGreenCubes();
            if (gs.getBlueCubes() > max_blue_cubes) max_blue_cubes = gs.getBlueCubes();
        }
        return max_red_cubes * max_green_cubes * max_blue_cubes;
    }

    public static int computePart1(String filename) {
        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            int sum = 0;
            
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                Day2 d = new Day2(line);
                if (d.isPossible()) {
                    sum += d.getId();
                    System.out.println("Game " + d.getId() + " : Possible");
                }
                else {
                    System.out.println("Game " + d.getId() + " : Impossible !");
                }
            }
            
            fileReader.close();
            
            return sum;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static int computePart2(String filename) {
        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            int sum = 0;
            
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                Day2 d = new Day2(line);
                sum += d.getPowerOfCubes();                
            }
            
            fileReader.close();

            return sum;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }


    private int getId() {
        return this.gameid;
    }

    public static void main(String[] args) {
        int answer_part1 = computePart1("data/day2_input.txt");
        System.out.println("Part 1 : " + answer_part1);
        int answer_part2 = computePart2("data/day2_input.txt");
        System.out.println("Part 2 : " + answer_part2);
    }

}
