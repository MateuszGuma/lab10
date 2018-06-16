package java_lab;

/**
 * Hello world!
 *
 */

public class App
{
    public static void main( String[] args )
    {

        try {
            String liczba = "";

            ///Testy
            System.out.println("Urnfield:");
            UrnfieldNumber u = new UrnfieldNumber();

            for (int i = 1; i <= 29; i++) {
                liczba = u.arabicToUrnfield(i);
                System.out.println(i + "\t =\t " + liczba);
                System.out.println(u.urnfieldToArabic(liczba) + "\n");
            }


            System.out.println("Roman:");// Romek?
            RomanNumber r = new RomanNumber();

            for (int i = 1; i <= 3000; i++) {
                liczba = r.arabicToRoman(i);
                System.out.println(i + "\t =\t " + liczba);
                System.out.println(r.romanToArabic(liczba) + "\n");
            }


            System.out.println(r.romanToArabic("CCA"));
        }
        catch (IllegalArgumentException e){
            System.out.println(e);

    }


    }// main



}
