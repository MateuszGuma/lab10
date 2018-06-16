package java_lab;

import java.util.TreeMap; //TreeMap<K,V>

public class RomanNumber {

    private final static TreeMap<Integer, String> roman_numerals = new TreeMap<Integer, String>();

    static {
        roman_numerals.put(1000, "M");
        roman_numerals.put(900, "CM");
        roman_numerals.put(500, "D");
        roman_numerals.put(400, "CD");
        roman_numerals.put(100, "C");
        roman_numerals.put(90, "XC");
        roman_numerals.put(50, "L");
        roman_numerals.put(40, "XL");
        roman_numerals.put(10, "X");
        roman_numerals.put(9, "IX");
        roman_numerals.put(5, "V");
        roman_numerals.put(4, "IV");
        roman_numerals.put(1, "I");
    }

    private final static TreeMap<String, Integer> arabic_numerals = new TreeMap<String, Integer>();

    static {
        arabic_numerals.put("M", 1000);
        arabic_numerals.put("CM", 900);
        arabic_numerals.put("D", 500);
        arabic_numerals.put("CD", 400);
        arabic_numerals.put("C", 100);
        arabic_numerals.put("XC", 90);
        arabic_numerals.put("L", 50);
        arabic_numerals.put("XL", 40);
        arabic_numerals.put("X", 10);
        arabic_numerals.put("IX", 9);
        arabic_numerals.put("V", 5);
        arabic_numerals.put("IV", 4);
        arabic_numerals.put("I", 1);
    }


    public static String arabicToRoman(int number) {
        if (number >= 1 && number <= 3000) {


            int l = roman_numerals.floorKey(number); //Zwraca największy klucz mniejszy lub równy podanemu kluczowi
            if (number == l) {
                return roman_numerals.get(number);
            }
            return roman_numerals.get(l) + arabicToRoman(number - l);
        } else throw new IllegalArgumentException("arabicToRoman: " + number );
    }


    public static int romanToArabic(String number) {
        int res = 0;
        for (int i = 0; i < number.length(); i++) {
            String k1 = Character.toString(number.charAt(i));

            if(!arabic_numerals.containsKey(k1))
                throw new IllegalArgumentException("romanToArabic: " + number);

            int s1 = arabic_numerals.get(k1);
            if (i + 1 < number.length()) {
                String k2 = Character.toString(number.charAt(i+1));

                if(!arabic_numerals.containsKey(k2))
                    throw new IllegalArgumentException("romanToArabic: "  + number);

                int s2 = arabic_numerals.get(k2);

                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    ++i;
                }

            } else {
                res = res + s1;
                i++;
            }
        }
        return res;
    }

}