import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerManager {

    // private String first_name;

    public void addPassenger(String first_name, String last_name, String email) {
        String query = "INSERT INTO passengers (first_name, last_name, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // String first_name;
            stmt.setString(1, first_name);
            // String last_name;
            stmt.setString(2, last_name);
            stmt.setString(3, email);

            stmt.executeUpdate();
            System.out.println("Passenger added successfully!");
            System.out.println("--------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listPassengers() {
        String query = "SELECT * FROM passengers";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Passenger ID: " + rs.getInt("id"));
                System.out.println("First Name: " + rs.getString("first_name"));
                System.out.println("Last Name: " + rs.getString("last_name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
