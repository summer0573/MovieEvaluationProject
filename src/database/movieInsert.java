package database;

import java.sql.*;

public class movieInsert {
    public movieInsert() throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 연결 URL
        String username = "JHJ3111";
        String password = "3111";

        String name = "바비"; //영화이름
        int mdate = 230815; //날짜
        int grade = 3; //점수
        String review = "핑크핑크한 영화였다. 마고로비 진짜 매력있게 생김"; //리뷰
        
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("데이터 저장 성공");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터 저장 실패");
        }
    }


    public static void main(String[] args) throws SQLException {
        new movieInsert();
    }
}
