package java_lab;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class RomanNumberTest {
    /**
     * Tests for RomanNumbers
     */

    private String romanNumber;
    private int arabicNumber;

    public RomanNumberTest(String rN, int aN) {
        this.romanNumber = rN;
        this.arabicNumber = aN;
    }

    @Parameterized.Parameters
    public static List<Object[]> romanNumbersToTest() {
        return Arrays.asList(new Object[][] {
                {"I", 1},
                {"III", 3},
                {"LXXXVI", 86},
                {"XCIV", 94},
                {"CXIII", 113},
                {"DCCXXXIX", 739},
                {"MMCMXCIX", 2999}
        });
    }

    @Test
    public void testNumberToRomanConversion() {
        assertEquals(romanNumber, RomanNumber.arabicToRoman(arabicNumber));
    }

    @Test
    public void testRomanToNumberConversion() {
        assertEquals(arabicNumber, RomanNumber.romanToArabic(romanNumber));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfRange() {
        assertEquals("MMMDLXVIII", RomanNumber.arabicToRoman(3568));
    }

}
