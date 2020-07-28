package homeworkeight;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkButton extends JButton {
    public OkButton() {
        super("OK");
        addActionListener(new ActionListener() {        // событие нажатия мышкой
            public void actionPerformed(ActionEvent e) {
                System.out.println("Нажата кнопка " + getText());
            }
        });

    }
}
