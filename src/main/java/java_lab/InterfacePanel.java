package java_lab;

import javax.swing.*;

public class InterfacePanel extends JPanel {
    private JButton b_arabicToRoman;
    private JButton b_romanToArabic;
    private JButton b_arabicToUrnfield;
    private JButton b_urnfieldToArabic;

    private JLabel l_arabic1;
    private JLabel l_arabic2;
    private JLabel l_urnfield;
    private JLabel l_roman;

    private JTextField txt_arabic1;
    private JTextField txt_arabic2;
    private JTextField txt_urnfield;
    private JTextField txt_roman;

    private JTextArea history;

    InterfacePanel() {
        super();
        //todo etykiety, przyciski, pola tekstowe
        setLayout(null);

        //segment1
        l_arabic1 = new JLabel("Arabic Numbers");
        l_arabic1.setBounds(5, 5, 200, 20);
        add(l_arabic1);

        txt_arabic1 = new JTextField(15);
        txt_arabic1.setBounds(5, 30, 200, 30);
        add(txt_arabic1);

        b_arabicToUrnfield = new JButton("Convert to Urnfield");
        b_arabicToUrnfield.setBounds(25, 65, 160, 30);
        add(b_arabicToUrnfield);

        //segment2
        l_urnfield = new JLabel("Urnfield Numerals");
        l_urnfield.setBounds(305, 5, 200, 20);
        add(l_urnfield);

        txt_urnfield = new JTextField(15);
        txt_urnfield.setBounds(305,30,200,30);
        add(txt_urnfield);

        b_urnfieldToArabic = new JButton("Convert to Arabic");
        b_urnfieldToArabic.setBounds(330, 65, 150, 30);
        add(b_urnfieldToArabic);

        //segment3
        l_arabic2 = new JLabel("Arabic Numbers");
        l_arabic2.setBounds(5, 120, 200, 20);
        add(l_arabic2);

        txt_arabic2 = new JTextField(15);
        txt_arabic2.setBounds(5, 145, 200, 30);
        add(txt_arabic2);

        b_arabicToRoman = new JButton("Convert to Roman");
        b_arabicToRoman.setBounds(25, 180, 160, 30);
        add(b_arabicToRoman);

        //segment4
        l_roman = new JLabel("Roman Numerals");
        l_roman.setBounds(305,120,200,20);
        add(l_roman);

        txt_roman = new JTextField(15);
        txt_roman.setBounds(305, 145, 200, 30);
        add(txt_roman);

        b_romanToArabic = new JButton("Convert to Arabic");
        b_romanToArabic.setBounds(330, 180, 160, 30);
        add(b_romanToArabic);

        history = new JTextArea(5, 20);
        history.setBounds(5, 230, 500, 100);
        add(history);

    }
}
