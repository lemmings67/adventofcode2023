package org.nwolf.adventofcode2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8 {

    static String directions = "";

    String source_node;
    String destination_left_node;
    String destination_right_node;

    public Day8(String source_node, String destination_left_node, String destination_right_node) {
        this.source_node = source_node;
        this.destination_left_node = destination_left_node;
        this.destination_right_node = destination_right_node;
    }

    public static HashMap<String, Day8> loadingInput(String file) {
        // Chargement du fichier
        HashMap<String, Day8> dataset = new HashMap<String, Day8>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty() == false) {
                    Pattern pattern = Pattern.compile("(\\w+) = \\((\\w+), (\\w+)\\)");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        Day8 day8 = new Day8(matcher.group(1), matcher.group(2), matcher.group(3));
                        dataset.put(day8.source_node, day8);
                    }

                    if (line.matches("[LR]+")) {
                        directions = line;
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file: " + file);
        }

        return dataset;
    }

    public static int part1(HashMap<String, Day8> dataset_v1) {
        int steps = 0;
        char current_direction = 'R';

        // On commence par le noeud AAA
        String next_node = "AAA";
        // On continue tant qu'on n'est pas arrivé au noeud ZZZ
        while (next_node.equals("ZZZ") == false) {
            Day8 current_node = dataset_v1.get(next_node);
            // Répéter la direction autant de fois que nécessaire, si on arrive a la fin de
            // la chaine, on recommence (avec le modulo)
            current_direction = directions.charAt(steps % directions.length());

            if (current_direction == 'L') {
                next_node = current_node.destination_left_node;
            } else {
                next_node = current_node.destination_right_node;
            }
            System.out.println(
                    "Step " + steps + " " + current_node.source_node + ' ' + current_direction + " -> " + next_node);

            steps++;
        }

        return steps;
    }

    public static int part2(HashMap<String, Day8> dataset) {
        int steps = 0;
        char current_direction = 'R';

        boolean all_nodes = true;

        // Find all source node ending with A
        List<String> next_nodes = new ArrayList<String>();
        for (String key : dataset.keySet()) {
            if (key.endsWith("A")) {
                next_nodes.add(key);
            }
        }

        // On continue tant que l'ensemble des noeuds de départ ne sont pas arrivés à
        // ZZZ
        while (all_nodes) {
            // Répéter la direction autant de fois que nécessaire, si on arrive a la fin de
            // la chaine, on recommence (avec le modulo)
            current_direction = directions.charAt(steps % directions.length());

            // Clone next_nodes to current_nodes
            List<String> current_nodes = new ArrayList<String>(next_nodes);

            for (int i = 0; i < current_nodes.size(); i++) {
                Day8 current_node = dataset.get(current_nodes.get(i));

                if (current_direction == 'L') {
                    next_nodes.set(i, current_node.destination_left_node);
                } else {
                    next_nodes.set(i, current_node.destination_right_node);
                }

                /*System.out.println("Step " + steps + " " + current_node.source_node + ' ' + current_direction
                        + " -> " + next_nodes.get(i));*/

            }

            // Si l'ensembles noeuds se termine par un Z on a fini
            all_nodes = false;
            for (String node : next_nodes) {
                if (node.endsWith("Z") == false) {
                    all_nodes = true;
                }
            }

            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println("Day 8");
        HashMap<String, Day8> dataset = loadingInput("data/day8_input.txt");
        Date start_date = new Date();
        // System.out.println("Part 1: " + part1(dataset) + " steps");
        System.out.println("Part 2: " + part2(dataset) + " steps");
        Date end_date = new Date();
        System.out.println("Execution time: " + (end_date.getTime() - start_date.getTime()) + " ms");
    }

}
