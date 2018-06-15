package java_lab;

/**
 * Hello world!
 *
 */

public class App
{
    public static void main( String[] args )
    {

        ///Testy
        Urnfield u = new Urnfield();
        String liczba = "";

        System.out.println( "toUrnfield2:");
        for (int i = 1; i<= 29; i++) {

            liczba = u.arabicToUrnfield(i);
            System.out.println(i+"\t =\t "+ liczba );
            System.out.println( u.urnfieldToArabic(liczba));
        }


    }// main



}
