package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class searchData {
    public Object[][] select() {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 연결 URL
        String username = "JHJ3111";
        String password = "3111";

        List<Object[]> data = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String selectQuery = "SELECT name, TO_CHAR(TO_DATE(mdate, 'YYYY-MM-DD'), 'YY-MM-DD') mmdate, grade, review " +
                    "FROM MOVIE where = ?";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) { //date 리스트에 데이터베이스 테이블 값 넣기
                String name = resultSet.getString("name");
                String mdate = resultSet.getString("mmdate");
                String grade = resultSet.getString("grade");
                String review = resultSet.getString("review");

                Object[] row = {name, mdate, grade, review};
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 데이터를 2차원 배열로 변환
        Object[][] dataArray = new Object[data.size()][];
        data.toArray(dataArray);

//        // 데이터 출력 (테스트용)
//        for (Object[] row : dataArray) {
//            for (Object value : row) {
//                System.out.print(value + "\t");
//            }
//            System.out.println();
//        }

        return dataArray;
    }
    public static void main(String[] args) throws SQLException {
        new searchData();
    }
}