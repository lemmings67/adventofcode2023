package org.nwolf.adventofcode2023;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day5 {

    long[] seeds;

    Day5Map seed_to_soil_map;
    Day5Map soil_to_fertilizer;

    public Day5(String seed) {
        String[] seedArray = seed.split(" ");
        seeds = new long[seedArray.length - 1];
        for (int i = 1; i < seedArray.length; i++) {
            seeds[i - 1] = Long.parseLong(seedArray[i]);
        }
        System.out.println("Ok");
    }

    public Day5(File file) {

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
           
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.matches("seeds.+")) {
                    String[] seedArray = line.split(" ");
                    seeds = new long[seedArray.length - 1];
                    for (int i = 1; i < seedArray.length; i++) {
                        seeds[i - 1] = Long.parseLong(seedArray[i]);
                    }
                    
                    seed_to_soil_map = new Day5Map("seed-to-soil map");

                    soil_to_fertilizer = new Day5Map("soil-to-fertilizer");
                    



                }
            }

            fileReader.close();
        } catch (

        IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Day5 day5 = new Day5(new File("data/day5_testdata.txt"));

        long smallest_destination = -1;
        for (long seed : day5.seeds) {
            System.out.println(seed);
            long soil = day5.seed_to_soil_map.getDestination(seed);
            long fertilizer = day5.soil_to_fertilizer.getDestination(soil);
            long destination = 1;
            if (smallest_destination == -1 || destination < smallest_destination) {
                smallest_destination = destination;
            }
        }
        System.out.println("Smallest destination: " + smallest_destination);
        
    }

}
