package database;

import java.sql.*;

public class selectGroup {
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 연결 URL
    String username = "HR";
    String password = "5678";

    public String maxGroup() {
        int max = 0;
        String nameText = "";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, grade FROM movie WHERE grade = (SELECT MAX(grade) FROM movie)");
                ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        nameText = resultSet.getString(1);
                        max = resultSet.getInt(2); // 첫 번째 컬럼 값 가져오기
                    }
                    System.out.println(nameText + "          " + max);
                return nameText + " : " + max + "점";
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String minGroup(){
        int min = 0;
        String nameText = "";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, grade FROM movie WHERE grade = (SELECT MIN(grade) FROM movie)");
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    nameText = resultSet.getString(1);
                    min = resultSet.getInt(2); // 첫 번째 컬럼 값 가져오기
                }
                System.out.println(nameText + "          " + min);
                return nameText + " : " + min + "점";
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

    public double sumGroup(){
        double sum = 0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(grade) FROM movie");
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sum = resultSet.getDouble(1); // 첫 번째 컬럼 값 가져오기
                }
                System.out.println(sum);
                return sum;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}