import CRUD.Login;
import jdbc.ConnectionDb;

import java.sql.Connection;
import java.sql.SQLException;

public class TestMain {
    public static void main(String[] args) throws SQLException{
        Connection conn = ConnectionDb.createConnection(args[0], args[1]);
        Login.mainTestLogIn(conn);
    }
}