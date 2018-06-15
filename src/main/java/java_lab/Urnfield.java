package java_lab;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//Klasa konwertuje liczbe miedzy systemem arabskia a prastarym
public class Urnfield {

    //wydaje mi sie że pasuje znaleźć lepsze zabezpieczenie dla urnfieldToArabic
    private static List<String> num = new ArrayList<String>();
    static {
        for (int i = 1; i<= 29; i++)
            num.add(arabicToUrnfield(i));
    }



    public static String arabicToUrnfield(int number) {
        if (number >= 1 && number < 30) {
            TreeMap<Integer, String> map = new TreeMap<Integer, String>();
            map.put(5, "\\");
            map.put(1, "/");

            int l = map.floorKey(number); //Zwraca największy klucz mniejszy lub równy podanemu kluczowi
            if (number == l) {
                return map.get(number);
            }
            return arabicToUrnfield(number - l) + map.get(l);
        } else throw new IllegalArgumentException();
    }


    public static int urnfieldToArabic(String number) {

        if(num.contains(number)) {
            TreeMap<String, Integer> map = new TreeMap<String, Integer>();
            map.put("\\", 5);
            map.put("/", 1);

            String l = map.floorKey(number);
            if (number.equals(l)) {
                return map.get(number);
            }
            String nn = number.subSequence(1, number.length()).toString();
            return map.get(l) + urnfieldToArabic(nn);
        }else throw new IllegalArgumentException();
    }


}
