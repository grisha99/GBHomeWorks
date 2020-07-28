package homeworkeight;

import javax.swing.*;
import java.awt.*;

public class CustomButtonPanel extends JPanel{
    public CustomButtonPanel() {
        super(new FlowLayout(FlowLayout.RIGHT)); // панель с равномерным расположением и выравниванием в право
        JPanel buttPanel = new JPanel(new GridLayout(1,2,5,0)); // панель для кнопок (для двух)
        JButton exitBtn = new ExitButton();
        JButton okBtn = new OkButton();
        buttPanel.add(okBtn);
        buttPanel.add(exitBtn);
        add(buttPanel); // добавляем панель с кнопками
    }
}
