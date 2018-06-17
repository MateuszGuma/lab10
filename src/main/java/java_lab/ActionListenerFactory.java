package java_lab;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public class ActionListenerFactory {
    //jeszcze nie działa

    public static MouseAdapter getMouseAdapter(int operationNumber, JTextField source, JTextField destination) {
        switch(operationNumber) {
            case 1:
                return new InterfacePanel.fromArabicToUrnfieldHandler(source, destination);
            break;
            case 2:
                return new InterfacePanel.fromUrnfieldToArabicHandler(source, destination);
            break;
            case 3:
                return new InterfacePanel.fromArabicToRomanHandler(source, destination);
            break;
            case 4:
                return new InterfacePanel.fromRomanToArabicHandler(source, destination);
            default:
                return null;
            break;
        }
    }
}
