package database;

import DTO.movieDto;

import java.sql.*;

public class movieInsert {
    public movieInsert() throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 연결 URL
        String username = "JHJ3111";
        String password = "3111";
        movieDto d = new movieDto();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String sql = " INSERT INTO MOVIE (name, mdate, grade, review) VALUES (?, ? , ? , ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, d.mname); // 첫 번째 컬럼 값
            preparedStatement.setString(2, d.mdate); // 두 번째 컬럼 값
            preparedStatement.setString(3, d.mscore); // 두 번째 컬럼 값
            preparedStatement.setString(4, d.mreview); // 두 번째 컬럼 값
            int rows = preparedStatement.executeUpdate();

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
