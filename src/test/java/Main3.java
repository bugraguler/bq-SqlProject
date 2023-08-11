import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) throws SQLException {
        String dbURl = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        Connection connection = DriverManager.getConnection(dbURl, username, password);
        Statement statement = connection.createStatement();
        String query = "select * from person;";
        ResultSet resultSet = statement.executeQuery(query);
        //ResultSetMetaData is an Interface to get some kind of information from a table
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        List<Map<String, String>> tableData = new ArrayList<>();

        while (resultSet.next()) {

            Map<String, String> row = new LinkedHashMap<>();

            //with while loop we go through the rows one by one
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                //with for loop we go through all the columns one by one
                String columnName = resultSetMetaData.getColumnLabel(i);
                String columValue = resultSet.getString(columnName);
                row.put(columnName, columValue);
            }
            tableData.add(row);
        }
        System.out.println(tableData);
    }
}
