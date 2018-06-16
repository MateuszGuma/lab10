package java_lab;

import javax.swing.*;

public class GUI {
    private JFrame window;
    private JPanel interfacePanel;

    private GUI(GUIBuilder builder) {
        this.window = builder.window;
        this.interfacePanel = builder.interfacePanel;
    }

    public class GUIBuilder {
        private JFrame window;
        private JPanel interfacePanel;

        public GUIBuilder() {

        }

    }
}
