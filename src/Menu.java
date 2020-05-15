import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);
    Hotel hotel;

    public Menu(Hotel hotel) {
        this.hotel = hotel;

        initializeMenu();
    }

    public void initializeMenu() {
        System.out.println("======================================================");
        System.out.println("*            Hotel Management System                 *");
        System.out.println("======================================================");
        System.out.println("* 1. Reserve room                            *");
        System.out.println("* 2. Show empty rooms                         *");
        System.out.println("* 3. Remove all reservation for a room                      *");
        System.out.println("* 4. Reservation report                            *");
        System.out.println("* 5. Store program array data into a text file       *");
        System.out.println("* 6. Load program data back from the file            *");
        System.out.println("* 0. Quit Program                                    *");
        System.out.println("======================================================");

        do {
            System.out.println("Choose one of the options from above. (E.g: Type '4' to view all the rooms)");
            int option = input.nextInt();
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


        }
    }

    private void reservationReport() {
        System.out.println("Enter start date dd/MM/yyyy");
        String startDate = input.next();
        System.out.println("Enter end date dd/MM/yyyy");
        String endDate = input.next();

        try {
            Date start = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date end = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            hotel.getReservationReport(start, end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void removeAllReservationForARoom() {
        System.out.println("Enter room number");
        int roomNumber = input.nextInt();
        hotel.removeAllReservations(roomNumber);
    }

    private void showEmptyRooms() {
        System.out.println("Enter start date dd/MM/yyyy");
        String startDate = input.next();
        System.out.println("Enter end date dd/MM/yyyy");
        String endDate = input.next();

        try {
            Date start = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date end = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            ArrayList<Room> emptyRooms = hotel.getEmptyRooms(start, end);
            for (Room room : emptyRooms) {
                System.out.println("empty room " + room.roomNumber);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void reserve() {
        System.out.println("Enter room number");
        int roomNumber = input.nextInt();
        System.out.println("Enter start date dd/MM/yyyy");
        String startDate = input.next();
        System.out.println("Enter end date dd/MM/yyyy");
        String endDate = input.next();
        System.out.println("Enter your name");
        String guestName = input.next();

        try {
            Date start = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date end = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            boolean isSuccess = hotel.reserve(roomNumber, start, end, guestName);
            if (isSuccess) {
                System.out.println("Successful reservation");
            } else {
                System.out.println("The room is busy");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
