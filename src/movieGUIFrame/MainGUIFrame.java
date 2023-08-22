package movieGUIFrame;

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
        JLabel MovieDate = new JLabel("<html><body><center>관람 날짜" +
                "<br>(yymmdd)</center></body></html>");
        JLabel MovieScore = new JLabel("<html><body><center>영화 평점" +
                "<br>(1 ~ 5)</center></body></html>");
        JLabel MovieComment = new JLabel("영화에 대한 감상을 남겨주세요!");
        MovieTitle.setBounds(25, 40, 80, 50);
        MovieDate.setBounds(25, 100, 80, 50);
        MovieScore.setBounds(25, 160, 80, 50);
        MovieComment.setBounds(25, 210, 500, 50);

        //jfield
        JTextField title = new JTextField(50);
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

        JButton imformationBtn = new JButton("나의 영화 정보");
        imformationBtn.setBounds(670, 480, 120, 50);

        JButton favoriteBtn = new JButton("나의 즐겨찾기");
        favoriteBtn.setBounds(805, 480, 120, 50);

        insertMovie.add(MovieTitle);
        insertMovie.add(MovieDate);
        insertMovie.add(MovieScore);
        insertMovie.add(MovieComment);
        insertMovie.add(insertBtn); //등록버튼
        insertMovie.add(title);
        insertMovie.add(date);
        insertMovie.add(score);
        insertMovie.add(comment);

        selectMovie.add(select);
        selectMovie.add(searchBtn);
        selectMovie.add(imformationBtn);
        selectMovie.add(favoriteBtn);

        frame.add(insertMovie);
        frame.add(selectMovie);

        frame.setVisible(true);

        JFrame dframe = new JFrame("Dialog"); //다이얼로그 프레임
        dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dframe.setSize(300, 200);

        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mttext = title.getText(); //title jfeild를 텍스트로 바꿈
                String dtext = date.getText(); //date jfeild를 텍스트로 바꿈
                String stext = score.getText(); //score jfeild를 텍스트로 바꿈
                String ctext = comment.getText(); //comment jfeild를 텍스트로 바꿈

                System.out.println(mttext + "     " + dtext + "     " + stext + "     " + ctext);

                if(mttext.isEmpty()){
                    JOptionPane.showMessageDialog(dframe, "영화 제목을 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
                }else if(dtext.isEmpty()){
                    JOptionPane.showMessageDialog(dframe, "관람 날짜를 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
                }else if(stext.isEmpty()){
                    JOptionPane.showMessageDialog(dframe, "평가 점수(n/5)를 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
                }else if(ctext.isEmpty()){
                    JOptionPane.showMessageDialog(dframe, "한줄 감상문을 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        favoriteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new favoriteGUIFrame();

            }
        });

        imformationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new imformationGUIFrame();

            }
        });
    }

    //run 했을때 실행순서가 시작되는 main 메소드
    public static void main(String[] args) {
        new MainGUIFrame();
    }
}
