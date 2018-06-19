package java_lab;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;


public class InterfacePanel extends JPanel {
    private JButton b_arabicToRoman;
    private JButton b_romanToArabic;
    private JButton b_arabicToUrnfield;
    private JButton b_urnfieldToArabic;

    private JButton b_clearInput;
    private JButton b_clearHistory;

    private JLabel l_arabic1;
    private JLabel l_arabic2;
    private JLabel l_urnfield;
    private JLabel l_roman;
    private JLabel l_history;

    private JTextField txt_arabic1;
    private JTextField txt_arabic2;
    private JTextField txt_urnfield;
    private JTextField txt_roman;

    private static JTextArea txt_history;

    private static Logic logic;
    private static List<String> history_list;

    InterfacePanel() {
        super();
        history_list = new ArrayList<String>();

        txt_arabic1 = new JTextField(15);
        txt_urnfield = new JTextField(15);
        txt_arabic2 = new JTextField(15);
        txt_roman = new JTextField(15);

        logic = new Logic();
        setLayout(null);

        //segment1
        l_arabic1 = new JLabel("Arabic Numbers");
        l_arabic1.setBounds(10, 10, 200, 20);
        add(l_arabic1);

        txt_arabic1.setBounds(10, 33, 200, 30);
        add(txt_arabic1);

        b_arabicToUrnfield = new JButton("Convert to Urnfield");
        b_arabicToUrnfield.setBounds(30, 70, 160, 30);
        b_arabicToUrnfield.addMouseListener(ActionListenerFactory.getMouseAdapter(1, txt_arabic1, txt_urnfield));
        add(b_arabicToUrnfield);

        //segment2
        l_urnfield = new JLabel("Urnfield Numerals");
        l_urnfield.setBounds(310, 10, 200, 20);
        add(l_urnfield);

        txt_urnfield.setBounds(310,35,200,30);
        add(txt_urnfield);

        b_urnfieldToArabic = new JButton("Convert to Arabic");
        b_urnfieldToArabic.setBounds(335, 70, 150, 30);
        b_urnfieldToArabic.addMouseListener(ActionListenerFactory.getMouseAdapter(2, txt_urnfield, txt_arabic1));
        add(b_urnfieldToArabic);

        //segment3
        l_arabic2 = new JLabel("Arabic Numbers");
        l_arabic2.setBounds(10, 125, 200, 20);
        add(l_arabic2);

        txt_arabic2.setBounds(10, 150, 200, 30);
        add(txt_arabic2);

        b_arabicToRoman = new JButton("Convert to Roman");
        b_arabicToRoman.setBounds(30, 185, 160, 30);
        b_arabicToRoman.addMouseListener(ActionListenerFactory.getMouseAdapter(3, txt_arabic2, txt_roman));
        add(b_arabicToRoman);

        //segment4
        l_roman = new JLabel("Roman Numerals");
        l_roman.setBounds(310,125,200,20);
        add(l_roman);

        txt_roman.setBounds(310, 150, 200, 30);
        add(txt_roman);

        b_romanToArabic = new JButton("Convert to Arabic");
        b_romanToArabic.setBounds(335, 185, 160, 30);
        b_romanToArabic.addMouseListener(ActionListenerFactory.getMouseAdapter(4, txt_roman, txt_arabic2));
        add(b_romanToArabic);

        b_clearInput = new JButton("Clear Input Areas");
        b_clearInput.setBounds(10, 230, 230, 20);
        b_clearInput.addMouseListener(new ClearInput());
        add(b_clearInput);

        b_clearHistory = new JButton("Clear History Area");
        b_clearHistory.setBounds(280, 230, 230, 20);
        b_clearHistory.addMouseListener(new ClearHistory());
        add(b_clearHistory);

        l_history = new JLabel("Last 5 conversions");
        l_history.setBounds(10, 260, 200, 20);
        add(l_history);

        txt_history = new JTextArea(5, 20);
        txt_history.setBounds(10, 285, 500, 100);
        add(txt_history);


    }
  
  
    private static void addHistory(String source, String result) {
        history_list.add(source + " --> " + result);
        if(history_list.size() > 5)
            history_list.remove(0);
    }

    private static void displayHistory() {
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


    public static class fromArabicToUrnfieldHandler extends MouseAdapter {
        private JTextField display;
        private JTextField source;

        fromArabicToUrnfieldHandler(JTextField source, JTextField display) {
            this.display = display;
            this.source = source;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            String sourceText = source.getText();
            String resultText;
            if(!sourceText.isEmpty()) {
                resultText = logic.convert(Logic.Convert.fromArabicToUrnfield, sourceText);
                display.setText(resultText);
                addHistory(sourceText, resultText);
                displayHistory();
            }
        }
    }

    public static class fromUrnfieldToArabicHandler extends MouseAdapter {
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
            String resultText;
            if(!sourceText.isEmpty()) {
                resultText = logic.convert(Logic.Convert.fromUrnfieldToArabic, sourceText);
                display.setText(resultText);
                addHistory(sourceText, resultText);
                displayHistory();
            }
        }
    }

    public static class fromArabicToRomanHandler extends MouseAdapter {
        private JTextField display;
        private JTextField source;

        fromArabicToRomanHandler(JTextField source, JTextField display) {
            this.display = display;
            this.source = source;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            String sourceText = source.getText();
            String resultText;
            if(!sourceText.isEmpty()) {
                resultText = logic.convert(Logic.Convert.fromArabicToRoman, sourceText);
                display.setText(resultText);
                addHistory(sourceText, resultText);
                displayHistory();
            }
        }
    }

    public static class fromRomanToArabicHandler extends MouseAdapter {
        private JTextField display;
        private JTextField source;

        fromRomanToArabicHandler(JTextField source, JTextField display) {
            this.display = display;
            this.source = source;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            String sourceText = source.getText();
            String resultText;
            if(!sourceText.isEmpty()) {
                resultText = logic.convert(Logic.Convert.fromRomanToArabic, sourceText);
                display.setText(resultText);
                addHistory(sourceText, resultText);
                displayHistory();
            }
        }
    }

    public class ClearInput extends MouseAdapter {
        ClearInput() {
            super();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            txt_arabic1.setText("");
            txt_arabic2.setText("");
            txt_urnfield.setText("");
            txt_roman.setText("");
        }
    }

    public class ClearHistory extends MouseAdapter {
        ClearHistory() {
            super();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            history_list.clear();
            displayHistory();
        }
    }
}
