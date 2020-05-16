import java.util.*;

public class Hotel {

    List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(i, 1 + i / 3));
        }
    }

    public boolean reserve(int roomNumber, Date start, Date end, String guestName, String specialWish) {
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(end);
        return rooms.get(roomNumber).addReservation(startDate, endDate, guestName, specialWish);
    }

    public ArrayList<Room> getEmptyRooms(Date start, Date end) {
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

    public void removeAllReservations(int roomNumber) {
        rooms.get(roomNumber).removeReservations();
    }

    public Map<Integer, Integer> getReservationReport(Date start, Date end) {
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(end);

        Map<Integer, Integer> roomsBusyDays = new HashMap<>();
        for (Room room : rooms) {
            int busyDays = room.getBusyDays(startDate, endDate);
            roomsBusyDays.put(room.roomNumber, busyDays);
        }

        return roomsBusyDays;
    }

    public Room getRoom(Date start, Date end, int bedNumber) {
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(end);
        for (Room room : rooms) {
            boolean available = room.isAvailable(startDate, endDate, bedNumber);
            if (available) {
                return room;
            }
        }

        return null;
    }

}
