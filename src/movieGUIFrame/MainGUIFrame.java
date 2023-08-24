package movieGUIFrame;

import DTO.movieDto;
import database.movieDelete;
import database.movieInsert;
import database.movieSelect;
import database.movieUpdate;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

    public static String duDate;

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

        JButton updateBtn = new JButton("수정");
        updateBtn.setBounds(540, 480, 100, 50);

        JButton deleteBtn = new JButton("삭제");
        deleteBtn.setBounds(650, 480, 100, 50);

        JButton imformationBtn = new JButton("관람정보");
        imformationBtn.setBounds(760, 480, 100, 50);

        JButton favoriteBtn = new JButton("즐겨찾기");
        favoriteBtn.setBounds(870, 480, 100, 50);

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

        movieSelect s = new movieSelect();
        Object[][] dataArray = s.select();

        // 테이블 모델을 생성하고 isCellEditable을 재정의하여 특정 셀 수정 막기
        DefaultTableModel tableModel = new DefaultTableModel(dataArray, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 원하는 조건에 따라 수정 가능 여부 결정
                return false; // 수정 불가능하도록 설정
            }
        };

        JTable movieTable = new JTable(tableModel); //jtable에 tableModel 넣음
        JScrollPane movieScrollPane = new JScrollPane(movieTable);
        movieScrollPane.setBounds(505, 100, 470, 355);

        // 행 선택 이벤트 리스너 등록
        movieTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = movieTable.getSelectedRow();
                    if (selectedRow != -1) {
                        // 선택된 행의 데이터 출력
//                        for (int i = 0; i < movieTable.getColumnCount(); i++) {
                            System.out.print(movieTable.getValueAt(selectedRow, 0) + " ");
                        duDate = (String) movieTable.getValueAt(selectedRow, 0);
//                        }
                        System.out.println(); // 줄 바꿈
                    }
                }
                System.out.println("duDate : " + duDate);
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(duDate == null){
                    JOptionPane.showMessageDialog(dframe, "삭제할 항목을 선택해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
                }
                movieDelete d = new movieDelete();
                try {
                    d.delete(duDate);
                    duDate = null;
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(duDate == null){
                    JOptionPane.showMessageDialog(dframe, "수정할 항목을 선택해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
                } else {
                    new updateGUIFrame();
                }
//                movieUpdate u = new movieUpdate();
//                try {
//                    u.update(duDate);
//                    duDate = null;
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
            }
        });

        //-----------------------------------------------

        selectMovie.add(select);
        selectMovie.add(updateBtn);
        selectMovie.add(deleteBtn);
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
