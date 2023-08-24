package database;

import DTO.movieDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class movieUpdate {
    public int update(String duDate) throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 연결 URL
        String username = "JHJ3111";
        String password = "3111";
        int rows=0;
        movieDto d = new movieDto();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String selectQuery = "update movie set name=?,mdate=?,grade=?,review=? where name=?";
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            statement.setString(1, d.mname);
            statement.setString(2, d.mdate);
            statement.setString(3, d.mscore);
            statement.setString(4, d.mreview);
            statement.setString(5, d.mname);

            System.out.println(duDate + "가 삭제되었습니다.");
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
