package jdbc;//import lombok.Builder;
//import lombok.NoArgsConstructor;

public class MySqlConnectionModel {
    private final String username;
    private final String password;
    private final String host;
    private final Integer port;
    private final String dbScheme;
    private final String connString;


    MySqlConnectionModel(String username, String password, String host, Integer port, String dbScheme) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
        this.dbScheme = dbScheme;
        //jdbc:mysql://localhost:3306/test_db
        connString = "jdbc:mysql://"+host+":"+port+"/"+dbScheme;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getDbScheme() {
        return dbScheme;
    }

    String getConnString() {
        return connString;
    }
}
