import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Room {

    int roomNumber;
    List<Reservation> reservations;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.reservations = new ArrayList<>();
    }

    public boolean addReservation(Calendar start,Calendar end, String name){
        boolean available = isAvailable(start, end);
        if (available) {
            Reservation reservation = new Reservation(start, end, name);
            reservations.add(reservation);
        }

        return available;
    }

    public boolean isAvailable(Calendar start,Calendar end) {
        boolean canNotReserve = false;
        for (Reservation reservation: reservations) {
            canNotReserve =
                    (reservation.getEnd().after(start) && reservation.getStart().before(start)) ||
                            (reservation.getStart().before(end) && reservation.getEnd().after(start));
            if (canNotReserve) {
                break;
            }
        }

        return !canNotReserve;
    }

}
