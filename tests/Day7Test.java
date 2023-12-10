// Junit test for Day7 class 

package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.nwolf.adventofcode2023.Day7;
import java.io.File;
import java.util.List;

public class Day7Test {

    @Test
    public void testCards() {
        assertEquals(Day7.HandType.FULL_HOUSE, new Day7("AAABB").getHandType());
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
        assertEquals(Day7.HandType.FULL_HOUSE, new Day7("AABBB").getHandType());
        assertEquals(Day7.HandType.FULL_HOUSE, new Day7("BBAAA").getHandType());
        assertEquals(Day7.HandType.FULL_HOUSE, new Day7("ABABB").getHandType());
        assertEquals(Day7.HandType.FULL_HOUSE, new Day7("ABBAB").getHandType());
    }

    @Test
    public void part1() {
        List<Day7> dataset = Day7.loadingInput(new File("data/day7_testdata.txt"), false);
        assertEquals(6440, Day7.calculateTotalWinnings(dataset));
    }

    @Test
    public void part2() {
        List<Day7> dataset_v2 = Day7.loadingInput(new File("data/day7_testdata.txt"), true);
        assertEquals(5905, Day7.calculateTotalWinnings(dataset_v2));
    }

}
