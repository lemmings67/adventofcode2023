// Junit test for Day1 class 

package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.nwolf.adventofcode2023.Day5;
import java.io.File;

public class Day5Test {

    @Test
    public void test() {
        Day5 d = new Day5(new File("data/day5_testdata.txt"));
        assertEquals(35, d.getSmallestDestination());
    }
}
