package org.nwolf.adventofcode2023;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* AventOfCode 2023 - Jour 7  
 * 
 * Cette classe gère une main de carte du jeu "Camel"
 * La force de chaque carte est la suivante (de la plus forte à la plus faible) :
 * A, K, Q, J, T, 9, 8, 7, 6, 5, 4, 3, or 2
 * 
 * Une main est trié, les combinaisons les plus fortes sont les suivantes (de la plus forte à la plus faible) :
 * 5 cartes identiques
 * 4 cartes identiques
 * 3 cartes identiques + 2 cartes identiques
 * 3 cartes identiques
 * 2 x 2 cartes identiques 
 * 1 x 2 cartes identiques
 * Aucune identiques 
 * 
 * Exemple : AAAA1 > AAA12 > AAA11
 * 
*/
public class Day7 implements Comparable<Day7> {

    // Enumération des valeurs de cartes et de leurs poids
    public enum Card {
        A(13), K(12), Q(11), J(10), T(9), _9(8), _8(7), _7(6), _6(5), _5(4), _4(3), _3(2), _2(1);

        private int weight;

        Card(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return this.weight;
        }

        public static Card valueOf(char c) {
            switch (c) {
                case 'A':
                    return A;
                case 'K':
                    return K;
                case 'Q':
                    return Q;
                case 'J':
                    return J;
                case 'T':
                    return T;
                case '9':
                    return _9;
                case '8':
                    return _8;
                case '7':
                    return _7;
                case '6':
                    return _6;
                case '5':
                    return _5;
                case '4':
                    return _4;
                case '3':
                    return _3;
                case '2':
                    return _2;
            }
            return null;
        }   
    }

    // Enumération des types de mains et de leurs poids
    public enum HandType {
        FIVE_OF_A_KIND(8), FOUR_OF_A_KIND(7), FULL_HOUSE(6), THREE_OF_A_KIND(5), TWO_PAIRS(4), ONE_PAIR(3), HIGHCARD(2);

        private int weight;

        HandType(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return this.weight;
        }
    }

    private int bid;
    private String hands;

    char first_kind = '?';
    char second_kind = '?';

    public static List<Day7> dataset = new ArrayList<Day7>();

    public Day7(String input) {
        // Décompose les deux parties la main (hand) et la mise (bid)
        String[] decompose = input.split(" ");
        this.hands = decompose[0];
        if (decompose.length > 1) this.bid = Integer.parseInt(decompose[1]);
    }

    @Override
    public int compareTo(Day7 o) {
        if (this.getHandType().getWeight() > o.getHandType().getWeight())
            return 1; 
        else if (this.getHandType().getWeight() == o.getHandType().getWeight()) {
            int i = 0;
            while (o.getHands().charAt(i) == this.getHands().charAt(i)) {
                i++;
            }
            if (Card.valueOf(this.getHands().charAt(i)).getWeight() > Card.valueOf(o.getHands().charAt(i)).getWeight())
                return 1;
            else if (Card.valueOf(this.getHands().charAt(i)).getWeight() == Card.valueOf(o.getHands().charAt(i)).getWeight())
                return 0;
            else
                return -1;
        } else
            return -1;  
    }

    public int getBid() {
        return bid;
    }

    public String getHands() {
        return hands;
    }

    public static void loadingInput(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Day7 day7 = new Day7(line);
                dataset.add(day7);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file: " + file.getName());
        }
    }

    public HandType getHandType() {
        // Détermine le type de main

        int first_count = 0;
        int second_count = 0;
        
        int first_digit = 0;
        while (first_count == 0 && first_digit < this.hands.length()) {
            for (int i = first_digit + 1; i < this.hands.length(); i++) {
                char c = this.hands.charAt(i);
                if (c == this.hands.charAt(first_digit)) {
                    this.first_kind = c;
                    first_count++;
                }
            }
            first_digit++;
        }

        if (first_count == 1 || first_count == 2) {
            first_digit = 1;
            // Search second kind
            while (second_count == 0 && first_digit < this.hands.length() - 1) {
                for (int i = first_digit + 1; i < this.hands.length(); i++) {
                    char c = this.hands.charAt(i);
                    if (c == this.hands.charAt(first_digit) && c != first_kind) {
                        second_kind = c;
                        second_count++;
                    }
                }
                first_digit++;
            }
        }
        switch (first_count) {
            case 4:
                return HandType.FIVE_OF_A_KIND;
            case 3:
                return HandType.FOUR_OF_A_KIND;
            case 2:
                if (second_kind != '?')
                    return HandType.FULL_HOUSE;
                else
                    return HandType.THREE_OF_A_KIND;
            case 1:
                if (second_kind != '?')
                    if (second_count == 2) return HandType.FULL_HOUSE;
                    else
                    return HandType.TWO_PAIRS;
                else
                    return HandType.ONE_PAIR;
        }

        return HandType.HIGHCARD;
    }

    public static long part1() {
        long result = 0;
        Collections.sort(dataset);
        for (int rank = 1; rank < dataset.size()+1; rank++) {
            System.out.println("Rank " + rank + " " + dataset.get(rank-1).getHands() + " " + dataset.get(rank-1).getBid() + " : " + dataset.get(rank-1).getHandType());
            result += dataset.get(rank-1).getBid()*rank;
        }
        return result;
    }

    public static long part2() {
        long result = 0;
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Day 7");
        Date start_date = new Date();
        loadingInput(new File("data/day7_input.txt"));
        // Day7 day7 = new Day7("32T3K 765");
        System.out.println("------");
        System.out.println("Part 1: " + part1());
        System.out.println("Part 2: " + part2());
        Date end_date = new Date();
        System.out.println("Execution time: " + (end_date.getTime() - start_date.getTime()) + " ms");
    }

}
