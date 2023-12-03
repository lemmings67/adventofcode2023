// Junit test for Day1 class 

package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.nwolf.adventofcode2023.Day1;

public class Day1Test {

    @Test
    public void test() {
        assertEquals(12, new Day1("1abc2").getCalibrationNumber());
        assertEquals(38, new Day1("pqr3stu8vwx").getCalibrationNumber());
        assertEquals(15, new Day1("a1b2c3d4e5f").getCalibrationNumber());
        assertEquals(77, new Day1("treb7uchet").getCalibrationNumber());
        assertEquals(29, new Day1("two1nine").getCalibrationNumber());
        assertEquals(83, new Day1("eightwothree").getCalibrationNumber());
        assertEquals(13, new Day1("abcone2threexyz").getCalibrationNumber());
        assertEquals(24, new Day1("xtwone3four").getCalibrationNumber());
        assertEquals(42, new Day1("4nineeightseven2").getCalibrationNumber());
        assertEquals(14, new Day1("zoneight234").getCalibrationNumber());
        assertEquals(76, new Day1("7pqrstsixteen").getCalibrationNumber());
        assertEquals(48, new Day1("xlbbxrhkt4dqdcbkddoneoneightjb").getCalibrationNumber());
        assertEquals(22, new Day1("vhcmrbxlttwo2").getCalibrationNumber());
        assertEquals(77, new Day1("xmnbbnlmnk7flhcqrl").getCalibrationNumber());
        assertEquals(99, new Day1("tpjpbnl9gcbhtv").getCalibrationNumber());
        assertEquals(15, new Day1("1z5cjc").getCalibrationNumber());
        assertEquals(89, new Day1("meight65csmkfourpmcv79").getCalibrationNumber());
        assertEquals(61, new Day1("f6four1f").getCalibrationNumber());
        assertEquals(11, new Day1("one95zhnineseven1").getCalibrationNumber());
        assertEquals(42, new Day1("4hmxmkvzmpzb2").getCalibrationNumber());
        assertEquals(52, new Day1("5eight2").getCalibrationNumber());
        assertEquals(31, new Day1("3tmfhdnjtr1b").getCalibrationNumber());
        assertEquals(65, new Day1("6tvpsbbqr92five").getCalibrationNumber());
        assertEquals(22, new Day1("prlhtzthtwo3mjrblrtrsfoneeight4fourtwo").getCalibrationNumber());
        assertEquals(85, new Day1("841jhhfkhppprnine5").getCalibrationNumber());
    }

}
