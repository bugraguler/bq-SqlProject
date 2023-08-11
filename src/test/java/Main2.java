import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        //DBUrl Database String
        //databases always provided with IP s
        //3306 usually port for
        String dbURl = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        Connection connection = DriverManager.getConnection(dbURl, username, password);
        Statement statement = connection.createStatement();
        String query = "select * from person;";
        ResultSet resultSet = statement.executeQuery(query);
        //ResultSetMetaData is an Interface to get some kind of information from a table
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.print(resultSetMetaData.getColumnLabel(i) + " ");
        }
        System.out.println();
        while (resultSet.next()) {
            //with while loop we go through the rows one by one
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                //with for loop we go through all the columns one by one
                String columnName = resultSetMetaData.getColumnLabel(i);
                String columValue = resultSet.getString(columnName);
                System.out.print(columValue+" ");
            }
            System.out.println();
        }
    }
}