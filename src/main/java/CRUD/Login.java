package CRUD;
        import jdbc.MySqlConnector;
        import java.sql.*;
        import java.util.Scanner;

public class Login {
    public static void mainTestLogIn(Connection conn) throws SQLException {
        for (int i = 0; i < 3; i++) {
            ResultSet rsPassAndName = userLoginInput(conn);
            if (checkAuth(rsPassAndName)) {
                break;
            }
        }
        MySqlConnector.closeResources(conn);
    }

    private static ResultSet userLoginInput(Connection conn) throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Password: ");
        String password = sc.next();
        ResultSet set = getResultSet(conn, name, password);
        return set;
        }

    private static ResultSet getResultSet(Connection conn, String name, String password) throws SQLException{
        PreparedStatement checkNameAndPassword = conn.prepareStatement("SELECT * FROM Actors WHERE name= ? and password= ? ");
        checkNameAndPassword.setString(1, name);
        checkNameAndPassword.setString(2, password);
        checkNameAndPassword.execute();
        return checkNameAndPassword.getResultSet();
    }

    private static boolean checkAuth(ResultSet rsPassAndName) throws SQLException {
        boolean PassAndName= false;
        if (rsPassAndName.next()) {
            System.out.print("User");
            System.out.println(rsPassAndName.getString("name"));
            PassAndName= true;
        } else {
            System.out.println("Wrong selection");
        }
        return PassAndName;
    }

}


