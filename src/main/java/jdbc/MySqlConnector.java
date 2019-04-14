package jdbc;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlConnector {
    static Connection getConnection(MySqlConnectionModel connectionModel) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        }
        return DriverManager.getConnection(connectionModel.getConnString(), connectionModel.getUsername(), connectionModel.getPassword());
    }

    public static void closeResources(AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
//                System.out.println(closeable.getClass().getName() + " closed !!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}