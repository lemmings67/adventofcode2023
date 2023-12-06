// Junit test for Day1 class 

package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.nwolf.adventofcode2023.Day6;
import java.io.File;

public class Day6Test {

    @Test
    public void part1() {
        Day6 d = new Day6(new File("data/day6_testdata.txt"));
        assertEquals(288, d.part1());
    }

    @Test
    public void part2() {
        Day6 d = new Day6(new File("data/day6_testdata.txt"));
        assertEquals(71503, d.part2());
    }

}
