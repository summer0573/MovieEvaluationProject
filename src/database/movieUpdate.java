package database;

import DTO.movieDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static DTO.movieDto.*;

public class movieUpdate {
    public int update(String duDate) throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 연결 URL
        String username = "JHJ3111";
        String password = "3111";
        int rows=0;

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String selectQuery = "update movie set name=?,mdate=?,grade=?,review=? where name=?";
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            statement.setString(1, umname);
            statement.setString(2, umdate);
            statement.setString(3, umscore);
            statement.setString(4, umreview);
            statement.setString(5, duDate);

            System.out.println(duDate + "가 수정되었습니다.");
            rows=statement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("[에러]deletelunchmanage() 메소드의 SQL 오류 = "+se.getMessage());
        }
        return rows;
    }

    public static void main(String[] args) throws SQLException {
        new movieDelete();
    }
}
