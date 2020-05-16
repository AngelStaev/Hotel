import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Hotel hotel;
    private IOManager ioManager;
    private DateUtils dateUtils;

    public Menu(Hotel hotel, IOManager ioManager, DateUtils dateUtils) {
        this.hotel = hotel;
        this.ioManager = ioManager;
        this.dateUtils = dateUtils;
    }

    public void initializeMenu() {
        do {
            ioManager.printMenu();
            int option = ioManager.readOption();
            if (option == -1) {
                continue;
            } else if (option == 0) {
                break;
            }

            chooseOptionFromMenu(option);
        } while (true);
    }

    public void chooseOptionFromMenu(int option) {
        switch (option) {
            case 1: {
                reserve();
                break;
            }
            case 2: {
                showEmptyRooms();
                break;
            }
            case 3: {
                removeAllReservationForARoom();
                break;
            }
            case 4: {
                reservationReport();
                break;
            }
            case 5: {
                bedsNumber();
                break;
            }


        }
    }

    private void bedsNumber() {
        String startDate = ioManager.readStartDate();
        String endDate = ioManager.readEndDate();
        int beds = ioManager.readBedsNumber();

        Date start = dateUtils.getDateFromString(startDate);
        Date end = dateUtils.getDateFromString(endDate);
        Room room = hotel.getRoom(start, end, beds);
        if (room == null) {
            ioManager.printMessage("Sorry, no available room");
        } else {
            ioManager.printMessage("You can book room " + room.roomNumber);
        }
    }

    private void reservationReport() {
        String startDate = ioManager.readStartDate();
        String endDate = ioManager.readEndDate();

        Date start = dateUtils.getDateFromString(startDate);
        Date end = dateUtils.getDateFromString(endDate);

        Map<Integer, Integer> reservationReport = hotel.getReservationReport(start, end);
        ioManager.printRoomBusyDays(reservationReport);
    }

    private void removeAllReservationForARoom() {
        int roomNumber = ioManager.readRoomNumber();
        hotel.removeAllReservations(roomNumber);
    }

    private void showEmptyRooms() {
        String startDate = ioManager.readStartDate();
        String endDate = ioManager.readEndDate();

        Date start = dateUtils.getDateFromString(startDate);
        Date end = dateUtils.getDateFromString(endDate);
        ArrayList<Room> emptyRooms = hotel.getEmptyRooms(start, end);
        for (Room room : emptyRooms) {
            ioManager.printMessage("empty room " + room.roomNumber);
        }
    }

    public void reserve() {
        int roomNumber = ioManager.readRoomNumber();
//        input.nextLine();
        String startDate = ioManager.readStartDate();
        String endDate = ioManager.readEndDate();
        String guestName = ioManager.readGuestName();
        String specialWish = ioManager.readGuestPreferences();

        Date start = dateUtils.getDateFromString(startDate);
        Date end = dateUtils.getDateFromString(endDate);
        boolean isSuccess = hotel.reserve(roomNumber, start, end, guestName, specialWish);
        if (isSuccess) {
            ioManager.printMessage("Successful reservation");
        } else {
            ioManager.printMessage("The room is busy");
        }
    }
}
