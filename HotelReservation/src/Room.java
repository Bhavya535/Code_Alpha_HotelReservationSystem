public class Room {
    private int roomNumber;
    private String type;
    private double price;
    private Reservation reservation; 

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.reservation = null; 
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
        return reservation != null; 
    }

    public Reservation getReservation() {
        return reservation; 
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation; 
    }

    public void cancelReservation() {
        this.reservation = null; 
    }
}
