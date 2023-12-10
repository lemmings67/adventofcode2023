package org.nwolf.adventofcode2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;

public class Day10 {

    char[][] maps;

    public Day10(String file) {
      // Chargement du fichier
        String line;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Compte le nombre de ligne dans le fichier
            int nb_lines = 0;
            int nb_columns = 0;
            while ((line = bufferedReader.readLine()) != null) {
                nb_lines++;
                nb_columns = line.length();
            }
            
            // Création du tableau
            maps = new char[nb_columns][nb_lines];

            bufferedReader.reset();

            nb_lines = 0;
            while ((line = bufferedReader.readLine()) != null) {
                for (int x = 0; x < line.length(); x++) {
                    maps[x][nb_lines] = line.charAt(x);
                }
                nb_lines++;
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file: " + file);
        }
    }

    public static int part1(HashMap<String, Day8> dataset) {
        int steps = 0;
        return steps;
    }

    public static int part2(HashMap<String, Day8> dataset) {
        int steps = 0;
        return steps;
    }

    public static void main(String[] args) {
        System.out.println("Day 10");
        HashMap<String, Day8> dataset = loadingInput("data/day8_input.txt");
        Date start_date = new Date();
        System.out.println("Part 1: " + part1(dataset) + " steps");
        System.out.println("Part 2: " + part2(dataset) + " steps");
        Date end_date = new Date();
        System.out.println("Execution time: " + (end_date.getTime() - start_date.getTime()) + " ms");
    }

}
