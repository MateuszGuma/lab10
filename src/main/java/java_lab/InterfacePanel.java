package java_lab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        //b_arabicToUrnfield.addActionListener(new InsertAction(txt_arabic1,txt_urnfield));

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
        //b_urnfieldToArabic.addActionListener(new InsertAction(txt_urnfield, txt_arabic1));
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
        //b_arabicToRoman.addActionListener(new InsertAction(txt_arabic2, txt_roman));
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
        //b_romanToArabic.addActionListener(new InsertAction(txt_roman, txt_arabic2 ));


        add(b_romanToArabic);

        history = new JTextArea(5, 20);
        history.setBounds(5, 230, 500, 100);
        add(history);




        //addActionListener
        b_arabicToUrnfield.addActionListener(new InsertAction(txt_arabic1,txt_urnfield));
        b_urnfieldToArabic.addActionListener(new InsertAction( txt_urnfield, txt_arabic1));
        b_arabicToRoman.addActionListener(new InsertAction(txt_arabic2, txt_roman));
        b_romanToArabic.addActionListener(new InsertAction(txt_roman, txt_arabic2 ));

        //Logic l =new Logic();
        Logic.Convert a = Logic.Convert.fromArabicToRoman;

//        b_romanToArabic.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                RomanNumber rom =  new RomanNumber();
//                try {
//                    int result = rom.romanToArabic(txt_roman.getText());
//                    txt_arabic2.setText(String.valueOf(result));
//                }catch (IllegalArgumentException ee){
//                    txt_roman.setText("IllegalArgument");
//                }
//
//            });


        Logic l = new Logic();
        System.out.println(l.convert(Logic.Convert.fromArabicToRoman, "10"));
        System.out.println(l.convert(Logic.Convert.fromArabicToUrnfield, "10"));
        System.out.println(l.convert(Logic.Convert.fromRomanToArabic, "MMCC"));
        System.out.println(l.convert(Logic.Convert.fromUrnfieldToArabic, "//\\"));


    }





    class InsertAction implements ActionListener {
        ActionEvent  action;
        //Object source;
        JTextField display;
        JTextField display_res;
        String s1;
        String s2;



        //InsertAction(Object   source, JTextField display,  JTextField display_res){
        InsertAction( JTextField display,  JTextField display_res){
            this.display =  display;
            this.display_res =  display_res;




        }


        @Override
        public void actionPerformed(ActionEvent e)  {
            Object   source = e.getSource();

            if(source == b_romanToArabic){
                RomanNumber rom =  new RomanNumber();
                try {
                    int result = rom.romanToArabic(display.getText());
                    display_res.setText(String.valueOf(result));
                }catch (IllegalArgumentException ee){
                    display.setText("IllegalArgument");
                }

            }

            else if(source == b_arabicToRoman){
                RomanNumber rom =  new RomanNumber();
                try {
                    String result = rom.arabicToRoman(Integer.parseInt(display.getText()));
                    display_res.setText(result);
                }catch (IllegalArgumentException ee){
                    display.setText("IllegalArgument");
                }

            }


            else if(source == b_arabicToUrnfield){
                UrnfieldNumber rom =  new UrnfieldNumber();
                try {
                    String result = rom.arabicToUrnfield(Integer.parseInt(display.getText()));
                    display_res.setText(result);
                }catch (IllegalArgumentException ee){
                    display.setText("IllegalArgument");
                }

            }


            else if(source == b_urnfieldToArabic){
                UrnfieldNumber rom =  new UrnfieldNumber();
                try {
                    int result = rom.urnfieldToArabic(display.getText());
                    display_res.setText(String.valueOf(result));
                }catch (IllegalArgumentException ee){
                    display.setText("IllegalArgument");
                }

            }

        }
    }




}
