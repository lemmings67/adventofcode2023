package org.nwolf.adventofcode2023;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day5 {

    long[] seeds;

    Day5Map seed_to_soil_map;
    Day5Map soil_to_fertilizer;
    Day5Map fertilizer_to_water;
    Day5Map water_to_light;
    Day5Map light_to_temperature;
    Day5Map temperature_to_humidity;
    Day5Map humidity_to_location;

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
                } else if (line.matches("seed-to-soil.*")) {
                    seed_to_soil_map = new Day5Map("seed-to-soil map");
                    while (((line = bufferedReader.readLine()) != null) && !line.matches("")) {
                        seed_to_soil_map.addLine(line);
                    }
                } else if (line.matches("soil-to-fertilizer.*")) {
                    soil_to_fertilizer = new Day5Map("soil-to-fertilizer");
                    while (((line = bufferedReader.readLine()) != null) && !line.matches("")) {
                        soil_to_fertilizer.addLine(line);
                    }
                } else if (line.matches("fertilizer-to-water.*")) {
                    fertilizer_to_water = new Day5Map("fertilizer-to-water");
                    while (((line = bufferedReader.readLine()) != null) && !line.matches("")) {
                        fertilizer_to_water.addLine(line);
                    }
                } else if (line.matches("water-to-light.*")) {
                    water_to_light = new Day5Map("water-to-light");
                    while (((line = bufferedReader.readLine()) != null) && !line.matches("")) {
                        water_to_light.addLine(line);
                    }
                } else if (line.matches("light-to-temperature.*")) {
                    light_to_temperature = new Day5Map("light-to-temperature");
                    while (((line = bufferedReader.readLine()) != null) && !line.matches("")) {
                        light_to_temperature.addLine(line);
                    }
                } else if (line.matches("temperature-to-humidity.*")) {
                    temperature_to_humidity = new Day5Map("temperature-to-humidity");
                    while (((line = bufferedReader.readLine()) != null) && !line.matches("")) {
                        temperature_to_humidity.addLine(line);
                    }
                } else if (line.matches("humidity-to-location.*")) {
                    humidity_to_location = new Day5Map("humidity-to-location");
                    while (((line = bufferedReader.readLine()) != null) && !line.matches("")) {
                        humidity_to_location.addLine(line);
                    }
                }

            }

            fileReader.close();
        } catch (

        IOException e) {
            e.printStackTrace();
        }

    }

    public long getSmallestDestination() {
        long smallest_destination = -1;
        for (long seed : seeds) {
            long soil = seed_to_soil_map.getDestination(seed);
            long fertilizer = soil_to_fertilizer.getDestination(soil);
            long water = fertilizer_to_water.getDestination(fertilizer);
            long light = water_to_light.getDestination(water);
            long temperature = light_to_temperature.getDestination(light);
            long humidity = temperature_to_humidity.getDestination(temperature);
            long destination = humidity_to_location.getDestination(humidity);
            if (smallest_destination == -1 || destination < smallest_destination) {
                smallest_destination = destination;
            }
        }
        return smallest_destination;
    }

    public static void main(String[] args) {
        Day5 test = new Day5(new File("data/day5_testdata.txt"));    
        System.out.println("Smallest destination: " + test.getSmallestDestination());

        Day5 input_dataset = new Day5(new File("data/day5_input.txt"));
        System.out.println("Smallest destination: " + input_dataset.getSmallestDestination());

    }

}
