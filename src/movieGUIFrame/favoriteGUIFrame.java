package movieGUIFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class favoriteGUIFrame extends JFrame {
    public favoriteGUIFrame() {
        //Frame
        JFrame frame = new JFrame("나의 즐겨찾기 영화");
        frame.setSize(1000, 600);
        frame.setLocation(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton mainBtn = new JButton("메인 화면");
        mainBtn.setBounds(800, 480, 120, 50);

        mainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainGUIFrame();

            }
        });

        frame.add(mainBtn);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new favoriteGUIFrame();
    }
}
