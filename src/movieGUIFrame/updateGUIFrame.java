package movieGUIFrame;

import DTO.movieDto;
import database.movieUpdate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static DTO.movieDto.*;

public class updateGUIFrame extends JFrame {
    movieDto d = new movieDto(); //dto getset

    public void updateFrame(String duDate, String[] tableData) {
        //Frame
        JFrame frame = new JFrame("수정하기");
        frame.setSize(495, 480);
        frame.setLocation(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        //jlabel
        JLabel MovieTitle = new JLabel("영화 제목");
        JLabel MovieDate = new JLabel("<html><body><center>관람 날짜" +
                "<br>(yymmdd)</center></body></html>");
        JLabel MovieScore = new JLabel("<html><body><center>영화 평점" +
                "<br>(1 ~ 5)</center></body></html>");
        JLabel MovieComment = new JLabel("영화에 대한 감상을 남겨주세요!");
        MovieTitle.setBounds(10, 5, 80, 50);
        MovieDate.setBounds(10, 65, 80, 50);
        MovieScore.setBounds(10, 125, 80, 50);
        MovieComment.setBounds(10, 165, 500, 50);

        //jfield
        JTextField title = new JTextField(tableData[0],50);
        JTextField date = new JTextField(tableData[1]);
        JTextField score = new JTextField(tableData[2]);
        JTextArea comment = new JTextArea(tableData[3]);
        comment.setLineWrap(true);
        title.setBounds(75, 10, 380, 40);
        date.setBounds(75, 70, 380, 40);
        score.setBounds(75, 130, 380, 40);
        comment.setBounds(25, 210, 427, 180);

        JButton updateBtn = new JButton("수정하기");
        updateBtn.setBounds(200, 400, 120, 30);

        JButton backBtn = new JButton("돌아가기");
        backBtn.setBounds(333, 400, 120, 30);

        JFrame dframe = new JFrame("Dialog"); //다이얼로그 프레임
        dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dframe.setSize(300, 200);


        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mttext = title.getText(); //title jfeild를 텍스트로 바꿈
                String dtext = date.getText(); //date jfeild를 텍스트로 바꿈
                String stext = score.getText(); //score jfeild를 텍스트로 바꿈
                String ctext = comment.getText(); //comment jfeild를 텍스트로 바꿈

                System.out.println(mttext + "     " + dtext + "     " + stext + "     " + ctext);

                umname = mttext;
                umdate = dtext;
                umscore = stext;
                umreview = ctext;

                System.out.println(umname + "     " + umdate + "     " + umscore + "     " + umreview);

                if(mttext.isEmpty()){
                    JOptionPane.showMessageDialog(dframe, "영화 제목을 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
                }else if(dtext.isEmpty()){
                    JOptionPane.showMessageDialog(dframe, "관람 날짜를 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
                }else if(stext.isEmpty()){
                    JOptionPane.showMessageDialog(dframe, "평가 점수(n/5)를 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
                }else if(ctext.isEmpty()){
                    JOptionPane.showMessageDialog(dframe, "한줄 감상문을 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
                }

                title.setText(""); // Clear the text field
                date.setText(""); // Clear the text field
                score.setText(""); // Clear the text field
                comment.setText(""); // Clear the text field

                movieUpdate mu = new movieUpdate();
                try {
                    mu.update(duDate);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(false);
            }
        });


        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

            }
        });


        frame.add(MovieTitle);
        frame.add(MovieDate);
        frame.add(MovieScore);
        frame.add(MovieComment);
        frame.add(title);
        frame.add(date);
        frame.add(score);
        frame.add(comment);
        frame.add(updateBtn);
        frame.add(backBtn);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new updateGUIFrame();
    }
}
