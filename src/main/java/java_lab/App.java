package java_lab;

import javax.swing.*;

/**
 * Application converts arabic number to urnfield numbers and to roman numbers
 *
 */

public class App extends JFrame {
    private static App gui;
    //private static GUI graphical_interface;
    private static Logic data_computation;
    private static DataSaver saver;

    App() {
        super("lab10");
        InterfacePanel interfacePanel = new InterfacePanel();

        this.add(interfacePanel);
        this.setSize(535,410);
        this.setLocationRelativeTo(null); //wysrodkowanie
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(this.getMinimumSize());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        if(gui == null)
            SwingUtilities.invokeLater(() -> gui = new App());


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
