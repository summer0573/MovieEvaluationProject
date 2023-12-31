package movieGUIFrame;

import database.favoriteMovieSelect;
import database.movieSelect;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class favoriteGUIFrame extends JFrame {

    public static String duDate;

    public favoriteGUIFrame() {
        //Frame
        JFrame frame = new JFrame("나의 즐겨찾기 영화");
        frame.setSize(1000, 600);
        frame.setLocation(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton mainBtn = new JButton("메인 화면");
        mainBtn.setBounds(800, 480, 120, 50);

        JLabel title = new JLabel("즐겨찾기한 영화");
        title.setBounds(50, 60, 150, 50);

        mainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainGUIFrame();

            }
        });

        //JTable
        String[] columnNames={"영화이름", "평점"};

        //-------------------select----------------------------

        favoriteMovieSelect s = new favoriteMovieSelect();
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
        movieScrollPane.setBounds(50, 100, 300, 355);

        String[] tableData = new String[4];

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

                        for (int i = 0; i < movieTable.getColumnCount(); i++) {
                            tableData[i] = (String) movieTable.getValueAt(selectedRow, i);
                            System.out.println(tableData[i]);
                        }
                        System.out.println(); // 줄 바꿈
                    }
                }
                System.out.println("duDate : " + duDate);
            }
        });

        JLabel recomm = new JLabel("이런 영화는 어떠세요? : 추천 영화 목록");
        recomm.setBounds(400, 60, 300, 50);

        movieSelect ms = new movieSelect();
        Object[][] dataArray2 = ms.f_select();

        // 테이블 모델을 생성하고 isCellEditable을 재정의하여 특정 셀 수정 막기
        DefaultTableModel tableModel2 = new DefaultTableModel(dataArray2, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 원하는 조건에 따라 수정 가능 여부 결정
                return false; // 수정 불가능하도록 설정
            }
        };

        JTable movieTable2 = new JTable(tableModel2); //jtable에 tableModel 넣음
        JScrollPane movieScrollPane2 = new JScrollPane(movieTable2);
        movieScrollPane2.setBounds(400, 100, 300, 355);

        String[] tableData2 = new String[4];

        // 행 선택 이벤트 리스너 등록
        movieTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = movieTable2.getSelectedRow();
                    if (selectedRow != -1) {
                        // 선택된 행의 데이터 출력
//                        for (int i = 0; i < movieTable.getColumnCount(); i++) {
                        System.out.print(movieTable2.getValueAt(selectedRow, 0) + " ");
                        duDate = (String) movieTable2.getValueAt(selectedRow, 0);
//                        }

                        for (int i = 0; i < movieTable2.getColumnCount(); i++) {
                            tableData2[i] = (String) movieTable2.getValueAt(selectedRow, i);
                            System.out.println(tableData2[i]);
                        }
                        System.out.println(); // 줄 바꿈
                    }
                }
                System.out.println("duDate : " + duDate);
            }
        });

        frame.add(title);
        frame.add(recomm);
        frame.add(movieScrollPane);
        frame.add(movieScrollPane2);

        frame.add(mainBtn);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new favoriteGUIFrame();
    }
}
