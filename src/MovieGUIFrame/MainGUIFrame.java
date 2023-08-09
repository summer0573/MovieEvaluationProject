package MovieGUIFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUIFrame extends JFrame {

    ImageIcon img = new ImageIcon("src/img/Search_icon.png");

    public MainGUIFrame() {
        //Frame
        JFrame frame = new JFrame("나의 영화 리뷰");
        frame.setSize(1000, 600);
        frame.setLocation(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel
        JPanel insertMovie = new JPanel(); //영화 리뷰 데이터 insert 내용이 들어갈 패널
        JPanel selectMovie = new JPanel(); //데이터 목록이 select 될 패널
        insertMovie.setLayout(null);
        selectMovie.setLayout(null);
        insertMovie.setBounds(0,0,500,600);
        selectMovie.setBounds(500,0,500,600);
        insertMovie.setBackground(Color.PINK);
        selectMovie.setBackground(Color.LIGHT_GRAY);

        //jlabel
        JLabel MovieTitle = new JLabel("영화 제목");
        JLabel MovieDate = new JLabel("상영 날짜");
        JLabel MovieScore = new JLabel("<html><body><center>영화 평점" +
                "<br>(1 ~ 5)</center></body></html>");
        JLabel MovieComment = new JLabel("영화에 대한 감상을 남겨주세요!");
        MovieTitle.setBounds(25, 40, 80, 50);
        MovieDate.setBounds(25, 100, 80, 50);
        MovieScore.setBounds(25, 160, 80, 50);
        MovieComment.setBounds(25, 210, 500, 50);

        //jfield
        JTextField title = new JTextField();
        JTextField date = new JTextField();
        JTextField score = new JTextField();
        JTextArea comment = new JTextArea();
        comment.setLineWrap(true);
        title.setBounds(95, 40, 380, 50);
        date.setBounds(95, 100, 380, 50);
        score.setBounds(95, 160, 380, 50);
        comment.setBounds(25, 250, 450, 200);

        JButton insertBtn = new JButton("등록");
        insertBtn.setBounds(375, 480, 100, 50);

        JTextField select = new JTextField();
        select.setBounds(553, 40, 330, 50);

        Image imgage = img.getImage();
        // 창의 사이즈인 500,500에 맞춰서 이미지를 변경
        Image changeImg = imgage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImg);

        JButton searchBtn = new JButton(changeIcon);
        searchBtn.setBounds(880, 40, 50, 50);

        JButton favoriteBtn = new JButton("나의 즐겨찾기");
        favoriteBtn.setBounds(805, 480, 120, 50);

        insertMovie.add(MovieTitle);
        insertMovie.add(MovieDate);
        insertMovie.add(MovieScore);
        insertMovie.add(MovieComment);
        insertMovie.add(insertBtn);
        insertMovie.add(title);
        insertMovie.add(date);
        insertMovie.add(score);
        insertMovie.add(comment);

        selectMovie.add(select);
        selectMovie.add(searchBtn);
        selectMovie.add(favoriteBtn);

        frame.add(insertMovie);
        frame.add(selectMovie);

        frame.setVisible(true);

        favoriteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new favoriteGUIFrame();

            }
        });
    }

    //run 했을때 실행순서가 시작되는 main 메소드
    public static void main(String[] args) {
        new MainGUIFrame();
    }
}
