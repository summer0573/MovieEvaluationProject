package movieGUIFrame;

import DTO.movieDto;
import database.movieInsert;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainGUIFrame extends JFrame {
    ImageIcon img = new ImageIcon("src/img/Search_icon.png");
    movieDto d = new movieDto(); //dto getset

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

        insertMovie.add(MovieTitle);
        insertMovie.add(MovieDate);
        insertMovie.add(MovieScore);
        insertMovie.add(MovieComment);
        insertMovie.add(insertBtn); //등록버튼
        insertMovie.add(title);
        insertMovie.add(date);
        insertMovie.add(score);
        insertMovie.add(comment);

        frame.add(insertMovie);

        JFrame dframe = new JFrame("Dialog"); //다이얼로그 프레임
        dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dframe.setSize(300, 200);


        //----------------------------selectpanel V

        JTextField select = new JTextField();
        select.setBounds(553, 40, 330, 50);

        Image imgage = img.getImage();
        // 창의 사이즈인 500,500에 맞춰서 이미지를 변경
        Image changeImg = imgage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImg);

        JButton searchBtn = new JButton(changeIcon); //검색버튼
        searchBtn.setBounds(880, 40, 50, 50);

        JButton imformationBtn = new JButton("나의 영화 정보");
        imformationBtn.setBounds(670, 480, 120, 50);

        JButton favoriteBtn = new JButton("나의 즐겨찾기");
        favoriteBtn.setBounds(805, 480, 120, 50);

        //-----------------------------------------------

        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mttext = title.getText(); //title jfeild를 텍스트로 바꿈
                String dtext = date.getText(); //date jfeild를 텍스트로 바꿈
                String stext = score.getText(); //score jfeild를 텍스트로 바꿈
                String ctext = comment.getText(); //comment jfeild를 텍스트로 바꿈

                System.out.println(mttext + "     " + dtext + "     " + stext + "     " + ctext);

                d.mname = mttext;
                d.mdate = dtext;
                d.mscore = stext;
                d.mreview = ctext;

                System.out.println(d.mname + "     " + d.mdate + "     " + d.mscore + "     " + d.mreview);

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

                try {
                    movieInsert mi = new movieInsert();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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

        //JTable
        String[] columnNames={"영화이름","관람날짜","평점","리뷰"};

        //-------------------select----------------------------

        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 연결 URL
        String username = "HR";
        String password = "5678";

        List<Object[]> data = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String selectQuery = "SELECT * FROM MOVIE";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String mdate = resultSet.getString("mdate");
                String grade = resultSet.getString("grade");
                String review = resultSet.getString("review");

                Object[] row = {name, mdate, grade, review};
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 데이터를 2차원 배열로 변환
        Object[][] dataArray = new Object[data.size()][];
        data.toArray(dataArray);

//        // 데이터 출력 (테스트용)
//        for (Object[] row : dataArray) {
//            for (Object value : row) {
//                System.out.print(value + "\t");
//            }
//            System.out.println();
//        }

        // 테이블 모델을 생성하고 isCellEditable을 재정의하여 특정 셀 수정 막기
        DefaultTableModel tableModel = new DefaultTableModel(dataArray, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 원하는 조건에 따라 수정 가능 여부 결정
                return false; // 수정 불가능하도록 설정
            }
        };

        //-----------------------------------------------

        JTable movieTable = new JTable(tableModel);
        JScrollPane movieScrollPane = new JScrollPane(movieTable);
        movieScrollPane.setBounds(505, 100, 470, 355);

        selectMovie.add(select);
        selectMovie.add(searchBtn);
        selectMovie.add(imformationBtn);
        selectMovie.add(favoriteBtn);
        selectMovie.add(movieScrollPane);

        frame.add(selectMovie);

        frame.setVisible(true);
    }

    //run 했을때 실행순서가 시작되는 main 메소드
    public static void main(String[] args) {
        new MainGUIFrame();
    }
}
