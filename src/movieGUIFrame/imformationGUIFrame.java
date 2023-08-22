package movieGUIFrame;

import database.selectGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class imformationGUIFrame {

    public imformationGUIFrame (){
    JFrame frame = new JFrame("나의 영화 정보");
        frame.setSize(1000, 600);
        frame.setLocation(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton mainBtn = new JButton("메인 화면");
        mainBtn.setBounds(800, 480, 120, 50);

        Font font = new Font("SansSerif", Font.PLAIN, 30);

        selectGroup sg = new selectGroup();

        int max = sg.maxGroup();
        int min = sg.minGroup();
        double avg = sg.avgGroup();

        JLabel minGrade = new JLabel("점수가 가장 높은 영화 : " + max);
        JLabel maxGrade = new JLabel("점수가 가장 낮은 영화 : " + min);
        JLabel avgGrade = new JLabel("영화 점수 총 평균 : " + avg);
        minGrade.setBounds(25, 40, 350, 50);
        maxGrade.setBounds(25, 100, 350, 50);
        avgGrade.setBounds(25, 160, 350, 50);
        minGrade.setFont(font);
        maxGrade.setFont(font);
        avgGrade.setFont(font);

        mainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainGUIFrame();

            }
        });

        frame.add(minGrade);
        frame.add(maxGrade);
        frame.add(avgGrade);
        frame.add(mainBtn);

        frame.setVisible(true);
}

    public static void main(String[] args) {
        new imformationGUIFrame();
    }
}
