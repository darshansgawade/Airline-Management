import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightManager {
    public void addFlight(String flightNumber, String departure, String destination, String departureTime,
                          String arrivalTime) {
        String query = "INSERT INTO flights (flight_number, departure, destination, departure_time, arrival_time) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, flightNumber);
            stmt.setString(2, departure);
            stmt.setString(3, destination);
            stmt.setString(4, departureTime);
            stmt.setString(5, arrivalTime);

            stmt.executeUpdate();
            System.out.println("Flight added successfully!");
            System.out.println("--------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listFlights() {
        String query = "SELECT * FROM flights";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Flight ID: " + rs.getInt("id"));
                System.out.println("Flight Number: " + rs.getString("flight_number"));
                System.out.println("Departure: " + rs.getString("departure"));
                System.out.println("Destination: " + rs.getString("destination"));
                System.out.println("Departure Time: " + rs.getString("departure_time"));
                System.out.println("Arrival Time: " + rs.getString("arrival_time"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
