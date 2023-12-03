package org.nwolf.adventofcode2023;

public class Day3Symbol {
    
        int x;
        int y;
        String value;

        public Day3Symbol(int x, int y, String value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public String getValue() {
            return this.value;
        }
}
