package database;

import java.sql.*;

public class selectGroup {
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 연결 URL
    String username = "HR";
    String password = "5678";
    public int maxGroup() {
        int max;
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String selectQuery = "select max(grade) from movie;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            max = resultSet.getInt("grade");
            System.out.println(max);
            return max;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int minGroup(){
        int min;
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String selectQuery = "select min(grade) from movie;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            min = resultSet.getInt("grade");
            System.out.println(min);
            return min;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int avgGroup(){
        int avg;
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String selectQuery = "select avg(grade) from movie;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            avg = resultSet.getInt("grade");
            System.out.println(avg);
            return avg;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
