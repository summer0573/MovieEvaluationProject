package movieGUIFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateGUIFrame extends JFrame {

    public updateGUIFrame() {
        //Frame
        JFrame frame = new JFrame("수정하기");
        frame.setSize(500, 300);
        frame.setLocation(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton backBtn = new JButton("돌아가기");
        backBtn.setBounds(60, 260, 30, 20);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

            }
        });

        frame.add(backBtn);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new updateGUIFrame();
    }
}
