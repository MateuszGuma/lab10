package java_lab;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public class ActionListenerFactory {
    //jeszcze nie działa

    public static MouseAdapter getMouseAdapter(int operationNumber, JTextField source, JTextField destination) {
        switch(operationNumber) {
            case 1:
                return new InterfacePanel.fromArabicToUrnfieldHandler(source, destination);

            case 2:
                return new InterfacePanel.fromUrnfieldToArabicHandler(source, destination);

            case 3:
                return new InterfacePanel.fromArabicToRomanHandler(source, destination);

            case 4:
                return new InterfacePanel.fromRomanToArabicHandler(source, destination);
            default:
                return null;

        }
    }
}
