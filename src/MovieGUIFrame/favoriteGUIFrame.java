package MovieGUIFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class favoriteGUIFrame extends JFrame {
    public favoriteGUIFrame() {
        //Frame
        JFrame frame = new JFrame("나의 즐겨찾기 영화");
        frame.setSize(1000, 600);
        frame.setLocation(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
