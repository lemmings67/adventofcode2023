package org.nwolf.adventofcode2023;

public class Day3SerialNo {
    
        int x;
        int y;
        int value;
        int size;

        public Day3SerialNo(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.size = ("" + value).length();
        }

        public int getMinX() {
            return this.x;
        }

        public int getMaxX() {
            return this.x + this.size-1;
        }

        public int getY() {
            return this.y;
        }

        public int getValue() {
            return this.value;
        }

        public int getSize() {
            return this.size;
        }

}
