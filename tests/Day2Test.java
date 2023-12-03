// Junit test for Day1 class 

package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.nwolf.adventofcode2023.Day2;

public class Day2Test {

    @Test
    public void test() {
        assertEquals(true, new Day2("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green").isPossible());
        assertEquals(true, new Day2("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue").isPossible());
        assertEquals(false, new Day2("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red").isPossible());
        assertEquals(false, new Day2("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red").isPossible());
        assertEquals(true, new Day2("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green").isPossible());
    }

}
