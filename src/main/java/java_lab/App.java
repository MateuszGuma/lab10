package java_lab;

import javax.swing.*;

/**
 * Application converts arabic number to urnfield numbers and to roman numbers
 *
 */

public class App extends JFrame {
    private static App gui;

    App() {
        super("lab10");
        InterfacePanel interfacePanel = new InterfacePanel();

        this.add(interfacePanel);
        this.setSize(535,435);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(this.getMinimumSize());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        if(gui == null)
            SwingUtilities.invokeLater(() -> gui = new App());

    }// main



}
