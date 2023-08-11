import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //connection string usually provided by DBA
        String dbURl = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        //jdbc java api that contains all the interface and classes
        //mysql this is the name of the database that we will be working with
        //3.239.253.255 Ip of the database where we have the database
        //3306 port on which the database is active
        //syntaxhrm_mysql name of the database or schema
        String username = "syntax_hrm";
        String password = "syntaxhrm123";
        //will be used to track and give different access levels
        Connection connection = DriverManager.getConnection(dbURl, username, password);
        Statement statement = connection.createStatement();
        String query = "select * from employee";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String empid = resultSet.getString("empid");
            String salary = resultSet.getString("salary");
            String grade = resultSet.getString("grade");
            String department = resultSet.getString("department");
            System.out.println(empid + " " + salary + " " + grade + " " + " " + department);
        }
    }
}
