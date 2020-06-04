package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton helloButton, goodbyeButton;
    private TypingListener typingListener;

    public Toolbar() {
        helloButton = new JButton("hello!");
        helloButton.addActionListener(this);

        goodbyeButton = new JButton("goodbye!");
        goodbyeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(helloButton);
        add(goodbyeButton);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton) actionEvent.getSource();
        if (clicked == helloButton) {
            if (typingListener != null) {
                typingListener.textTyped("hello button clicked\n");
            }
        } else if (clicked == goodbyeButton) {
            if (typingListener != null) {
                typingListener.textTyped("goodbye button clicked\n");
            }
        }
    }

    public TypingListener getTypingListener() {
        return typingListener;
    }

    public void setTypingListener(TypingListener typingListener) {
        this.typingListener = typingListener;
    }
}
