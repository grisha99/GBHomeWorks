package homeworkeight;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton {

    public ExitButton(){
        super("ВЫХОД");
        addActionListener(new ActionListener() {        // событие нажатия мышкой
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
