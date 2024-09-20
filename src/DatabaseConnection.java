import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Updated JDBC URL with `allowPublicKeyRetrieval=true`
    private static final String URL = "jdbc:mysql://localhost:3306/airline_management?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "darshff09";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
