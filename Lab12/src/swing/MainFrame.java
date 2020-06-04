package swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private Toolbar toolbar;

    public MainFrame() throws HeadlessException {
        super("hello world");
        setLayout(new BorderLayout());
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textPanel = new TextPanel();
        add(textPanel, BorderLayout.CENTER);

        toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);

        toolbar.setTypingListener(text -> textPanel.appendText(text));

        setVisible(true);
    }
}
