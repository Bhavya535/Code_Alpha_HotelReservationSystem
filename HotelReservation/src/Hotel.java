import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;

    public Hotel() {
        this.rooms = initializeRooms(); 
    }

    private List<Room> initializeRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Double", 150.0));
        rooms.add(new Room(103, "Suite", 200.0));
        return rooms;
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isReserved()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public boolean bookRoom(int roomNumber, LocalDate checkInDate, LocalDate checkOutDate, String guestName) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null && !room.isReserved()) {
            double totalPrice = calculateTotalPrice(room.getPrice(), checkInDate, checkOutDate);
            Reservation reservation = new Reservation(checkInDate, checkOutDate, guestName, totalPrice);
            room.setReservation(reservation);
            return true; 
        }
        return false; 
    }

    public void cancelBooking(int roomNumber) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null && room.isReserved()) {
            room.cancelReservation();
            System.out.println("Booking canceled for room " + roomNumber);
        } else {
            System.out.println("No active booking found for room " + roomNumber);
        }
    }

    public Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null; 
    }

    public double calculateTotalPrice(double roomPrice, LocalDate checkInDate, LocalDate checkOutDate) {
        long numDays = checkInDate.until(checkOutDate).getDays();
        return roomPrice * numDays;
    }

}
