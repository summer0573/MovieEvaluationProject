package database;

import java.sql.*;

public class selectGroup {
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 연결 URL
    String username = "HR";
    String password = "5678";

    public int maxGroup() {
        int max = 0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(grade) FROM movie");
                ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        max = resultSet.getInt(1); // 첫 번째 컬럼 값 가져오기
                    }
                    System.out.println(max);
                return max;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int minGroup(){
        int min = 0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT MIN(grade) FROM movie");
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    min = resultSet.getInt(1); // 첫 번째 컬럼 값 가져오기
                }
                System.out.println(min);
                return min;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public double avgGroup(){
        double avg = 0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT AVG(grade) FROM movie");
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    avg = resultSet.getDouble(1); // 첫 번째 컬럼 값 가져오기
                }
                System.out.println(avg);
                return avg;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}