// Junit test for Day1 class 

package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.nwolf.adventofcode2023.Day3;

public class Day3Test {

    @Test
    public void part1() {
        Day3 d = new Day3(new String[] {
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."
        });
        assertEquals(4361, d.sumSNNumbers());
    }

    @Test
    public void part2() {
        Day3 d = new Day3(new String[] {
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."
        });
        assertEquals(467835, d.sumGearsRatio());
    }
}
