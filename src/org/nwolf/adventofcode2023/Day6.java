package org.nwolf.adventofcode2023;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

public class Day6 {

    int times[];
    int distances[];
    int race_winning_combination[];

    // Hold boat button 6 for 1 ms
    final int max_distance_for_holding_1s = 6;

    public Day6(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Loading "Times" table from file
                if (line.matches("Time:.*")) {
                    String[] times_str = line.split(" +");
                    this.times = new int[times_str.length - 1];
                    for (int i = 1; i < times_str.length; i++) {
                        this.times[i - 1] = Integer.parseInt(times_str[i]);
                    }
                }
                // Loading "Distances" table from file
                if (line.matches("Distance:.*")) {
                    String[] distances_str = line.split(" +");
                    this.distances = new int[distances_str.length - 1];
                    for (int i = 1; i < distances_str.length; i++) {
                        this.distances[i - 1] = Integer.parseInt(distances_str[i]);
                    }
                }
            }
            race_winning_combination = new int[this.distances.length];
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }

    public boolean isWinningCombination(long holding_time, long distance, long max_time) {
        long speed = holding_time;
        long remaining_time = max_time - holding_time;

        long distance_reached = speed * remaining_time;

        if (distance_reached > distance)
            return true;

        return false;
    }

    public int part1() {
        for (int i = 0; i < this.distances.length; i++) {
            race_winning_combination[i] = 0;
            int distance = this.distances[i];
            int max_time = this.times[i];
            for (int holding_time = 1; holding_time < max_time; holding_time++) {
                if (isWinningCombination(holding_time, distance, max_time))
                    race_winning_combination[i] += 1;
            }
            System.out.println("Race " + i + " : " + race_winning_combination[i]);

        }

        int winning_combination = race_winning_combination[0];
        for (int i = 1; i < this.distances.length; i++) {
            winning_combination = winning_combination * race_winning_combination[i];
        }

        return winning_combination;
    }

    public long part2() {
        String distance_str="";
        String max_time_str="";
        for (int i = 0; i < this.distances.length; i++) {
            distance_str += this.distances[i];
            max_time_str += this.times[i];
        }
        long distance = Long.parseLong(distance_str);
        long max_time = Long.parseLong(max_time_str);
    
        long race_winning_combination = 0;
        for (int holding_time = 1; holding_time < max_time; holding_time++) {
                if (isWinningCombination(holding_time, distance, max_time)) race_winning_combination += 1;
        }

        return race_winning_combination;
    }

    public static void main(String[] args) {
        System.out.println("Day 6");
        Date start_date = new Date();
        Day6 day6 = new Day6(new File("data/day6_input.txt"));
        System.out.println("Part 1: " + day6.part1());
        System.out.println("Part 2: " + day6.part2());
        Date end_date = new Date();
        System.out.println("Execution time: " + (end_date.getTime() - start_date.getTime()) + " ms");
    }

}
