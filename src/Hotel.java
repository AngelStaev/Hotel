import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Hotel {

    List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(i));
        }
    }

    public boolean reserve(int roomNumber, Date start, Date end, String guestName) {
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(end);
        return rooms.get(roomNumber).addReservation(startDate, endDate, guestName);
    }
    public ArrayList<Room> getEmptyRooms(Date start, Date end){
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(end);

        ArrayList<Room> emptyRooms = new ArrayList<>();
        for (Room room : rooms) {
            boolean available = room.isAvailable(startDate, endDate);
            if (available) {
                emptyRooms.add(room);
            }
        }

        return emptyRooms;
    }
}
