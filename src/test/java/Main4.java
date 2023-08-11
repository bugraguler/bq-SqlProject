import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main4 {
    public static void main(String[] args) {
        String dbURl = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(dbURl, username, password);
            statement = connection.createStatement();
            String query = "select * from person;";
            resultSet = statement.executeQuery(query);
            List<Map<String, String>> tableData = new ArrayList<>();
            tableData = DBUtils.getListOfMapFromResultSet(resultSet);
            System.out.println(tableData);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connection);
            DBUtils.closeStatement(statement);
            DBUtils.closeResultSet(resultSet);
        }
    }


}
