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
    }

    public void initializeMenu() {
        System.out.println("======================================================");
        System.out.println("*            Hotel Management System                 *");
        System.out.println("======================================================");
        System.out.println("* 1. Reserve room                            *");
        System.out.println("* 2. Show empty rooms                         *");
        System.out.println("* 3. Remove all reservation for a room                      *");
        System.out.println("* 4. Reservation report                            *");
        System.out.println("* 5. Choose room with number of beds     *");
        System.out.println("* 0. Quit Program                                    *");
        System.out.println("======================================================");

        do {
            System.out.println("Choose one of the options from above. (E.g: Type '4' to view all the rooms)");
            int option = input.nextInt();
            if (option == 0) {
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
        System.out.println("Enter start date dd/MM/yyyy");
        String startDate = input.next();
        System.out.println("Enter end date dd/MM/yyyy");
        String endDate = input.next();
        System.out.println("How many beds do you need?");
        int beds = input.nextInt();

        try {
            Date start = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date end = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            Room room = hotel.getRoom(start, end, beds);
            if (room == null) {
                System.out.println("Sorry, no available room");
            } else {
                System.out.println("You can book room " + room.roomNumber);
            }
        } catch (ParseException e) {
            e.printStackTrace();
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
        System.out.println("Do you want baby bed,breakfast or sea view");
        String specialWish = input.next();

        try {
            Date start = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date end = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            boolean isSuccess = hotel.reserve(roomNumber, start, end, guestName, specialWish);
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
