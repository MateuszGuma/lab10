package java_lab;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap; //TreeMap<K,V>

//Klasa konwertuje liczbe miedzy systemem arabskia a prastarym
public class UrnfieldNumber {

    //wydaje mi sie że pasuje znaleźć lepsze zabezpieczenie dla urnfieldToArabic
//    private static List<String> num = new ArrayList<String>();
//    static {
//        for (int i = 1; i<= 29; i++)
//            num.add(arabicToUrnfield(i));
//    }



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
        } else throw new IllegalArgumentException("arabicToUrnfield: " + number );
    }


    public static int urnfieldToArabic(UrnfieldWrapper number) {

        //if(num.contains(number.stringValue())) {
            TreeMap<String, Integer> map = new TreeMap<String, Integer>();
            map.put("\\", 5);
            map.put("/", 1);

            String l = map.floorKey(number.stringValue());
            if (number.stringValue().equals(l)) {
                return map.get(number.stringValue());
            }
            String num = number.stringValue().subSequence(1, number.stringValue().length()).toString();
            return map.get(l) + urnfieldToArabic(new UrnfieldWrapper(num));
        //}else throw new IllegalArgumentException("urnfieldToArabic: " + number.stringValue() );
    }
}
