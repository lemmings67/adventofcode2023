// Junit test for Day7 class 

package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.nwolf.adventofcode2023.Day7;
import java.io.File;

public class Day7Test {

    @Test
    public void testCards() {
        assertEquals(Day7.HandType.FIVE_OF_A_KIND, new Day7("AAAAA").getHandType());
        assertEquals(Day7.HandType.FOUR_OF_A_KIND, new Day7("AAAA1").getHandType());
        assertEquals(Day7.HandType.FOUR_OF_A_KIND, new Day7("AAA1A").getHandType());
        assertEquals(Day7.HandType.FOUR_OF_A_KIND, new Day7("AA1AA").getHandType());
        assertEquals(Day7.HandType.FOUR_OF_A_KIND, new Day7("A1AAA").getHandType());
        assertEquals(Day7.HandType.FOUR_OF_A_KIND, new Day7("1AAAA").getHandType());
        assertEquals(Day7.HandType.THREE_OF_A_KIND, new Day7("AAA12").getHandType());
        assertEquals(Day7.HandType.THREE_OF_A_KIND, new Day7("AA1A2").getHandType());
        assertEquals(Day7.HandType.THREE_OF_A_KIND, new Day7("A1AA2").getHandType());
        assertEquals(Day7.HandType.THREE_OF_A_KIND, new Day7("1AAA2").getHandType());
        assertEquals(Day7.HandType.TWO_PAIRS, new Day7("AABB1").getHandType());
        assertEquals(Day7.HandType.TWO_PAIRS, new Day7("ABAB1").getHandType());
        assertEquals(Day7.HandType.TWO_PAIRS, new Day7("1ABAB").getHandType());
        assertEquals(Day7.HandType.ONE_PAIR, new Day7("AA123").getHandType());
        assertEquals(Day7.HandType.ONE_PAIR, new Day7("A1A23").getHandType());
        assertEquals(Day7.HandType.ONE_PAIR, new Day7("1AA23").getHandType());
        assertEquals(Day7.HandType.HIGHCARD, new Day7("A1234").getHandType());
    }

    @Test
    public void part1() {
        Day7.loadingInput(new File("data/day7_testdata.txt"));
        assertEquals(6440, Day7.part1());
    }

    @Test
    public void part2() {
        // Day6 d = new Day6(new File("data/day6_testdata.txt"));
        // assertEquals(71503, d.part2());
    }

}
