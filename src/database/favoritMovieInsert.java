package database;

import DTO.movieDto;
import movieGUIFrame.MainGUIFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static movieGUIFrame.MainGUIFrame.duDate;
import static movieGUIFrame.MainGUIFrame.duGrade;

public class favoritMovieInsert {
    public favoritMovieInsert() throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 연결 URL
        String username = "JHJ3111";
        String password = "3111";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String sql = " INSERT INTO FAVORITE_MOVIE (name, grade) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, duDate); // 첫 번째 컬럼 값
            preparedStatement.setString(2, duGrade); // 두 번째 컬럼 값
            int rows = preparedStatement.executeUpdate();

            System.out.println("데이터 저장 성공");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터 저장 실패");
        }
    }

    public static void main(String[] args) throws SQLException {
        new favoritMovieInsert();
    }
}
