package MovieGUIFrame;

import javax.swing.*;
import java.awt.*;

public class MainGUIFrame extends JFrame {
    public MainGUIFrame() {
        //Frame 설정
        JFrame frame = new JFrame();
        frame.setTitle("나의 영화 리뷰");
        frame.setSize(1000, 600);
        frame.setLocation(350, 200);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        //panel 설정
        JPanel insertMovie = new JPanel(); //영화 리뷰 데이터 insert 내용이 들어갈 패널
        JPanel selectMovie = new JPanel(); //데이터 목록이 select 될 패널
        insertMovie.setBackground(Color.PINK);
        selectMovie.setBackground(Color.LIGHT_GRAY);

        insertMovie.setBounds(0,0,500,600);
        selectMovie.setBounds(500,0,500,600);

        //insertMovie 안 내용
        JLabel MovieTitle = new JLabel("영화 제목");
        JLabel MovieDate = new JLabel("상영 날짜");
        JLabel MovieScore = new JLabel("영화 평점(1 ~ 5)");

        insertMovie.add(MovieTitle);

        frame.add(insertMovie);
        frame.add(selectMovie);

    }

    //run 했을때 실행순서가 시작되는 main 메소드
    public static void main(String[] args) {
        new MainGUIFrame();
    }
}
