package java_lab;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class UrnfieldNumberTest {
    /**
     * Tests for UrnfieldNumbers
     */

    private String urnfieldNumber;
    private int arabicNumber;

    public UrnfieldNumberTest(String uN, int aN) {
        this.urnfieldNumber = uN;
        this.arabicNumber = aN;
    }

    @Parameterized.Parameters
    public static List<Object[]> urnfieldNumbersToTest() {
        return Arrays.asList(new Object[][]{
                //string escape used here
                {"/", 1},
                {"///", 3},
                {"\\", 5},
                {"//\\", 7},
                {"//\\\\", 12}, //prints //\\
                {"////\\\\\\", 19},
                {"///\\\\\\\\", 23}
        });
    }

    @Test
    public void testNumberToUrnfieldConversion() {
        assertEquals(urnfieldNumber, UrnfieldNumber.arabicToUrnfield(arabicNumber));
    }

    @Test
    public void testUrnfieldToNumberConversion() {
        assertEquals(arabicNumber, UrnfieldNumber.urnfieldToArabic(new UrnfieldWrapper(urnfieldNumber)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfRange() {
        assertEquals("///\\\\\\\\\\\\\\", UrnfieldNumber.arabicToUrnfield(38));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalForm() {
        assertEquals(12, UrnfieldNumber.urnfieldToArabic(new UrnfieldWrapper("\\\\//")));
    }

}
