package java_lab;

/**
 * Application converts arabic number to urnfield numbers and to roman numbers
 *
 */

public class App {
    private static GUI graphical_interface;
    private static Logic data_computation;
    private static DataSaver saver;

    public static void main(String[] args) {

        graphical_interface = new GUI.GUIBuilder.build();

        /*
        try{
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
        */
    }// main



}
