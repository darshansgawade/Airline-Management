import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingManager {

    public void bookFlight(int flightId, int passengerId) {
        String query = "INSERT INTO bookings (flight_id, passenger_id,booking_date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, flightId);
            stmt.setInt(2, passengerId);
            Date booking_date = new Date(System.currentTimeMillis());  // Current date
            stmt.setDate(3, booking_date);

            stmt.executeUpdate();
            System.out.println("Booking successful!");
            System.out.println("--------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
