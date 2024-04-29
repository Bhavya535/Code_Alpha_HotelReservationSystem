public class Room {
    private int roomNumber;
    private String type;
    private double price;
    private Reservation reservation; // Represents the current reservation for this room

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.reservation = null; // Initially, the room has no reservation
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isReserved() {
        return reservation != null; // Check if the room is reserved
    }

    public Reservation getReservation() {
        return reservation; // Get the current reservation for this room
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation; // Set a reservation for this room
    }

    public void cancelReservation() {
        this.reservation = null; // Cancel the current reservation for this room
    }
}
