import java.util.Map;
import java.util.Scanner;

public class IOManager {

    private Scanner scanner;

    public IOManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMenu() {
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
    }

    public int readOption() {
        System.out.println("Choose one of the options from above. (E.g: Type '4' to view all the rooms)");
        return readNextInt();
    }

    private int readNextInt() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
    }

    public int readRoomNumber() {
        System.out.println("Enter room number");
        return readNextInt();
    }

    public String readStartDate() {
        return readDate("Enter a valid start date dd/MM/yyyy");
    }

    public String readEndDate() {
        return readDate("Enter a valid end date dd/MM/yyyy");
    }

    private String readDate(String message) {
        String input = null;
        while (input == null || input.equals("")) {
            System.out.println(message);
            input = scanner.nextLine();
        }

        return input;
    }

    public String readGuestName() {
        System.out.println("Enter your name");
        return scanner.nextLine();
    }

    public String readGuestPreferences() {
        System.out.println("Do you want baby bed,breakfast or sea view");
        return scanner.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int readBedsNumber() {
        System.out.println("How many beds do you need?");
        return readNextInt();
    }

    public void printRoomBusyDays(Map<Integer, Integer> roomBusyDays) {
        for (Integer room : roomBusyDays.values()) {
            System.out.println("Room " + room + " busy days " + roomBusyDays.get(room));
        }
    }

}
