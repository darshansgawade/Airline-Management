import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightManager flightManager = new FlightManager();
        PassengerManager passengerManager = new PassengerManager();
        BookingManager bookingManager = new BookingManager();
        BookingDetails bookingdetails = new BookingDetails();

        while (true) {
            System.out.println("1. Add Flight");
            System.out.println("2. List Flights");
            System.out.println("3. Add Passenger");
            System.out.println("4. List Passengers");
            System.out.println("5. Book Flight");
            System.out.println("6. Booked Flight Details");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Flight Number: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Departure: ");
                    String departure = scanner.nextLine();
                    System.out.print("Destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Departure Time (YYYY-MM-DD HH:MM:SS): ");
                    String departureTime = scanner.nextLine();
                    System.out.print("Arrival Time (YYYY-MM-DD HH:MM:SS): ");
                    String arrivalTime = scanner.nextLine();
                    flightManager.addFlight(flightNumber, departure, destination, departureTime, arrivalTime);
                    break;
                case 2:
                    flightManager.listFlights();
                    break;
                case 3:
                    System.out.print("First Name: ");
                    String first_name = scanner.nextLine();
                    System.out.print("Last name: ");
                    String last_name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    passengerManager.addPassenger(first_name, last_name, email);
                    break;
                case 4:
                    passengerManager.listPassengers();
                    break;
                case 5:
                    System.out.print("Flight ID: ");
                    int flightId = scanner.nextInt();
                    System.out.print("Passenger ID: ");
                    int passengerId = scanner.nextInt();
                    bookingManager.bookFlight(flightId, passengerId);
                    break;
                case 6:
                    System.out.print("Flight ID: ");
                    int flightno = scanner.nextInt();
                    bookingdetails.getBookingDetails(String.valueOf(flightno));
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
