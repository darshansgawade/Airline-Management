import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDetails {

    public void getBookingDetails(String flightNumber) {
        String query = "SELECT b.id AS booking_id,b.passenger_id, b.booking_date, " +
                "f.flight_number, f.departure, f.destination, f.arrival_time " +
                "FROM Bookings b " +
                "JOIN flights f ON b.flight_id = f.flight_number " +
                "WHERE f.flight_number = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, flightNumber);  // Set the flight number

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Booking ID: " + rs.getInt("booking_id"));
                System.out.println("Passenger ID: " + rs.getInt("passenger_id"));
//                System.out.println("Passenger Last Name: " + rs.getString("last_name"));
                System.out.println("Booking Date: " + rs.getDate("booking_date"));
                System.out.println("Flight Number: " + rs.getString("flight_number"));
                System.out.println("Departure: " + rs.getString("departure"));
                System.out.println("Destination: " + rs.getString("destination"));
                System.out.println("Flight Date: " + rs.getDate("arrival_time"));
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
