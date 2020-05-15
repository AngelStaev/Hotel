import java.time.Duration;
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

    public boolean addReservation(Calendar start, Calendar end, String name) {
        boolean available = isAvailable(start, end);
        if (available) {
            Reservation reservation = new Reservation(start, end, name);
            reservations.add(reservation);
        }

        return available;
    }

    public boolean isAvailable(Calendar start, Calendar end) {
        boolean canNotReserve = false;
        for (Reservation reservation : reservations) {
            canNotReserve =
                    (reservation.getEnd().after(start) && reservation.getStart().before(start)) ||
                            (reservation.getStart().before(end) && reservation.getEnd().after(start));
            if (canNotReserve) {
                break;
            }
        }

        return !canNotReserve;
    }

    public void removeReservations() {
        this.reservations = new ArrayList<>();
    }

    public int getBusyDays(Calendar start, Calendar end) {
        //TODO bug when reservation start == period start
        //and reservation end is equal or bidder than the end period
        int busyDays = 0;
        for (Reservation reservation : reservations) {
            if (reservation.getStart().before(start)
                    && reservation.getEnd().after(start)) {//reservation start before start, reservetion end after start
                busyDays += Duration.between(start.toInstant(), reservation.getEnd().toInstant()).toDays();
            } else if (reservation.getStart().after(start) &&
                    reservation.getEnd().before(end)) {//res start after start, res end before end
                busyDays += Duration.between(reservation.getStart().toInstant(), reservation.getEnd().toInstant()).toDays();
            } else if (reservation.getStart().before(end) &&
                    reservation.getEnd().after(end)) {// res start before end res end after end
               busyDays += Duration.between(reservation.getStart().toInstant(), end.toInstant()).toDays();
            } else if (reservation.getStart().before(start) &&
                    reservation.getEnd().after(end)) {// res start before start, res end after end
                busyDays += Duration.between(start.toInstant(), end.toInstant()).toDays();
            }
        }

        return busyDays;
    }
}
