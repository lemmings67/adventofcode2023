package org.nwolf.adventofcode2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;



public class Day10 {

    /* Les directions sont en x, y */
    enum Direction {
        UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

        private int x;
        private int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }

    char[][] maps;
    private int starting_x;
    private int starting_y;

    public Day10(String file) {

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Vector<String> lines = new Vector<String>();

            // Compte le nombre de ligne dans le fichier
            int nb_lines = 0;
            int nb_columns = 0;
            // Chargement du fichier
            String l;
            while ((l = bufferedReader.readLine()) != null) {
                lines.add(l);
                nb_lines++;
                nb_columns = l.length();
            }
            
            // Création du tableau
            maps = new char[nb_columns][nb_lines];

            int y = 0;
            for (String line: lines) {
                for (int x = 0; x < line.length(); x++) {
                    char current_char = line.charAt(x);
                    if (current_char == 'S') {
                        starting_x = x;
                        starting_y = y;
                    }
                    maps[x][y] = current_char;
                }
                y++;
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file: " + file);
        }
    }

    public static int part1(Day10 dataset) {
        int steps = 0;
        return steps;
    }

    public static int part2(Day10 dataset) {
        int steps = 0;
        return steps;
    }

    public static void main(String[] args) {
        System.out.println("Day 10");
        Day10 dataset = new Day10("data/day10_test1.txt");
        Date start_date = new Date();
        System.out.println("Part 1: " + part1(dataset) + " steps");
        System.out.println("Part 2: " + part2(dataset) + " steps");
        Date end_date = new Date();
        System.out.println("Execution time: " + (end_date.getTime() - start_date.getTime()) + " ms");
    }

}
