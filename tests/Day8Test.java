// Junit test for Day7 class 

package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.nwolf.adventofcode2023.Day8;
import java.util.HashMap;

public class Day8Test {

    @Test
    public void part1() {
        HashMap<String, Day8> dataset = Day8.loadingInput("data/day8_test1.txt");
        assertEquals(2, Day8.part1(dataset));
        HashMap<String, Day8> dataset2 = Day8.loadingInput("data/day8_test2.txt");
        assertEquals(6, Day8.part1(dataset2));
    }

    @Test
    public void part2() {
        HashMap<String, Day8> dataset = Day8.loadingInput("data/day8_test3.txt");
        assertEquals(6, Day8.part2(dataset));
    }

}
