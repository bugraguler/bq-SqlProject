import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, String>> getListOfMapFromResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<Map<String, String>> tableData = new ArrayList<>();
        Map<String, String> row = new LinkedHashMap<>();
        //with while loop we go through the rows one by one
        while (resultSet.next()) {
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                //with for loop we go through all the columns one by one
                String columnName = resultSetMetaData.getColumnLabel(i);
                String columValue = resultSet.getString(columnName);
                row.put(columnName, columValue);
            }
            tableData.add(row);
        }
        return tableData;
    }

}
