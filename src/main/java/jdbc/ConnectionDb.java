package jdbc;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionDb {

    public static Connection createConnection(String user, String pass) {
        MySqlConnectionModel connectionModel = new MySqlConnectionModel(user, pass, "localhost", 3306, "test_db");
        Connection conn = null;
        try {
            conn = MySqlConnector.getConnection(connectionModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
