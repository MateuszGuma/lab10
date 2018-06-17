package java_lab;

import com.sun.tools.corba.se.idl.StringGen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;

public class InterfacePanel extends JPanel {
    private JButton b_arabicToRoman;
    private JButton b_romanToArabic;
    private JButton b_arabicToUrnfield;
    private JButton b_urnfieldToArabic;

    private JLabel l_arabic1;
    private JLabel l_arabic2;
    private JLabel l_urnfield;
    private JLabel l_roman;
    private JLabel l_history;

    private JTextField txt_arabic1;
    private JTextField txt_arabic2;
    private JTextField txt_urnfield;
    private JTextField txt_roman;

    private JTextArea txt_history;

    private Logic logic; // ====================================================================================== ważne! używam klasy Logic tutaj
    private List<String> history_list;

    InterfacePanel() {
        super();
        history_list = new ArrayList<String>();

        logic = new Logic();
        setLayout(null);

        //segment1
        l_arabic1 = new JLabel("Arabic Numbers");
        l_arabic1.setBounds(10, 10, 200, 20);
        add(l_arabic1);

        txt_arabic1 = new JTextField(15);
        txt_arabic1.setBounds(10, 33, 200, 30);
        add(txt_arabic1);

        b_arabicToUrnfield = new JButton("Convert to Urnfield");
        b_arabicToUrnfield.setBounds(30, 70, 160, 30);
        b_arabicToUrnfield.addMouseListener(new ActionListenerFactory.getMouseAdapter(1, txt_arabic1, txt_urnfield)); //nie działa coś
        add(b_arabicToUrnfield);

        //segment2
        l_urnfield = new JLabel("Urnfield Numerals");
        l_urnfield.setBounds(310, 10, 200, 20);
        add(l_urnfield);

        txt_urnfield = new JTextField(15);
        txt_urnfield.setBounds(310,35,200,30);
        add(txt_urnfield);

        b_urnfieldToArabic = new JButton("Convert to Arabic");
        b_urnfieldToArabic.setBounds(335, 70, 150, 30);
        add(b_urnfieldToArabic);

        //segment3
        l_arabic2 = new JLabel("Arabic Numbers");
        l_arabic2.setBounds(10, 125, 200, 20);
        add(l_arabic2);

        txt_arabic2 = new JTextField(15);
        txt_arabic2.setBounds(10, 150, 200, 30);
        add(txt_arabic2);

        b_arabicToRoman = new JButton("Convert to Roman");
        b_arabicToRoman.setBounds(30, 185, 160, 30);
        add(b_arabicToRoman);

        //segment4
        l_roman = new JLabel("Roman Numerals");
        l_roman.setBounds(310,125,200,20);
        add(l_roman);

        txt_roman = new JTextField(15);
        txt_roman.setBounds(310, 150, 200, 30);
        add(txt_roman);

        b_romanToArabic = new JButton("Convert to Arabic");
        b_romanToArabic.setBounds(335, 185, 160, 30);
        add(b_romanToArabic);

        l_history = new JLabel("Last 5 conversions");
        l_history.setBounds(10, 235, 200, 20);
        add(l_history);

        txt_history = new JTextArea(5, 20);
        txt_history.setBounds(10, 260, 500, 100);
        add(txt_history);

    }

    private void addHistory(String source, String result) {
        history_list.add(source + " --> " + result);
        if(history_list.size() > 5)
            history_list.remove(0);
    }

    private void displayHistory() {
        int elements;
        if(history_list.size() < 5) {
            elements = history_list.size();
        }
        else elements = 5;

        String historyText = "";
        for(int i = 0; i < elements; i++) {
            historyText += history_list.get(i) + System.lineSeparator();
        }
        txt_history.setText(historyText);
    }

/*
    public class ActionListenerFactory {
        MouseAdapter ActionListenerFactory(int operationNumber) {
        //public MouseAdapter getMouseAdapter(int operationNumber) {
            switch(operationNumber) {
                case 1:
                    return new fromArabicToUrnfieldHandler(txt_arabic1, txt_urnfield);
                    break;
                case 2:
                    return new fromUrnfieldToArabicHandler(txt_urnfield, txt_arabic1);
                    break;
                case 3:
                    return new fromArabicToRomanHandler(txt_arabic2, txt_roman);
                    break;
                case 4:
                    return new fromRomanToArabicHandler(txt_roman, txt_arabic2);
                default:
                    return null;
                    break;
            }
        }
    }
*/

    public class fromArabicToUrnfieldHandler extends MouseAdapter {
        private JTextField display;
        private JTextField source;

        fromArabicToUrnfieldHandler() { super(); }

        fromArabicToUrnfieldHandler(JTextField source, JTextField display) {
            this.display = display;
            this.source = source;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            String sourceText = source.getText();
            String resultText;
            if(!sourceText.isEmpty()) {
                resultText = logic.convert(1, sourceText);  // ================== powinien zawsze zwracać String odpowiedź lub tesc błedu, powinien tez sie komunikowac z zapisywaniem danych
                display.setText(resultText);
                addHistory(sourceText, resultText);
                displayHistory();
            }
        }
    }

    public class fromUrnfieldToArabicHandler extends MouseAdapter {
        private JTextField display;
        private JTextField source;

        fromUrnfieldToArabicHandler() { super(); }

        fromUrnfieldToArabicHandler(JTextField source, JTextField display) {
            this.display = display;
            this.source = source;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            String sourceText = source.getText();
            String displayText;
            if(!sourceText.isEmpty()) {
                displayText = logic.convert(2, sourceText);  // ================== powinien zawsze zwracać String odpowiedź lub tesc błedu, powinien tez sie komunikowac z zapisywaniem danych
                addHistory(sourceText, displayText);
                displayHistory();
            }
        }
    }

    public class fromArabicToRomanHandler extends MouseAdapter {
        private JTextField display;
        private JTextField source;

        fromArabicToRomanHandler() { super(); }

        fromArabicToRomanHandler(JTextField source, JTextField display) {
            this.display = display;
            this.source = source;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            String sourceText = source.getText();
            String resultText;
            if(!sourceText.isEmpty()) {
                resultText = logic.convert(3, sourceText);  // ================== powinien zawsze zwracać String odpowiedź lub tesc błedu, powinien tez sie komunikowac z zapisywaniem danych
                display.setText(resultText);
                addHistory(sourceText, resultText);
                displayHistory();
            }
        }
    }

    public class fromRomanToArabicHandler extends MouseAdapter {
        private JTextField display;
        private JTextField source;

        fromRomanToArabicHandler() { super(); }

        fromRomanToArabicHandler(JTextField source, JTextField display) {
            this.display = display;
            this.source = source;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            String sourceText = source.getText();
            String displayText;
            if(!sourceText.isEmpty()) {
                displayText = logic.convert(4, sourceText);  // ================== powinien zawsze zwracać String odpowiedź lub tesc błedu, powinien tez sie komunikowac z zapisywaniem danych
                addHistory(sourceText, displayText);
                displayHistory();
            }
        }
    }

}
