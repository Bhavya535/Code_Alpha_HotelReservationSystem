import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Hotel Reservation System!");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAvailableRooms(hotel);
                    break;
                case 2:
                    makeReservation(hotel, scanner);
                    break;
                case 3:
                    viewBookingDetails(hotel, scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void displayAvailableRooms(Hotel hotel) {
        System.out.println("\nAvailable Rooms:");
        List<Room> availableRooms = hotel.getAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (Room room : availableRooms) {
                System.out.println(room.getRoomNumber() + " - " + room.getType() + " - $" + room.getPrice());
            }
        }
    }

    private static void makeReservation(Hotel hotel, Scanner scanner) {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();

        boolean booked = hotel.bookRoom(roomNumber, checkInDate, checkOutDate, guestName);
        if (booked) {
            System.out.println("Room booked successfully!");
            double totalPrice = hotel.calculateTotalPrice(roomNumber, checkInDate, checkOutDate);

            System.out.print("Enter payment amount: ");
            double amountPaid = scanner.nextDouble();
            scanner.nextLine(); 

            if (amountPaid >= totalPrice) {
                System.out.print("Enter payment method (e.g., credit card, cash): ");
                String paymentMethod = scanner.nextLine();

                Payment payment = new Payment(totalPrice, paymentMethod);
                payment.processPayment();

                System.out.println("Payment successful!");
            } else {
                System.out.println("Insufficient payment amount. Booking canceled.");
                hotel.cancelBooking(roomNumber);
            }
        } else {
            System.out.println("Room is not available or does not exist.");
        }
    }

    private static void viewBookingDetails(Hotel hotel, Scanner scanner) {
        System.out.print("Enter room number to view booking details: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); 

        Room room = hotel.findRoomByNumber(roomNumber);
        if (room != null && room.isReserved()) {
            Reservation reservation = room.getReservation();
            System.out.println("\nBooking Details for Room " + room.getRoomNumber() + ":");
            System.out.println("Guest Name: " + reservation.getGuestName());
            System.out.println("Check-in Date: " + reservation.getCheckInDate());
            System.out.println("Check-out Date: " + reservation.getCheckOutDate());
            System.out.println("Total Price: $" + reservation.getTotalPrice());
        } else {
            System.out.println("Booking details not found for room number: " + roomNumber);
        }
    }
}
