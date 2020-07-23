package homeworkeight;

import javax.swing.*;
import java.awt.*;

public class SimpleWindow extends JFrame {

    public SimpleWindow(String title) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        setBounds(100, 100, 500, 500);
        setMinimumSize(new Dimension(300, 200));    //минимальный размер окна
        Container container = getContentPane(); // получаем расположение на форме
        container.add(new CustomButtonPanel(), BorderLayout.SOUTH); // ставим на форму панель с выравнивание внизу
        setVisible(true);
    }
}
