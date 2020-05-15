import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        System.out.println("* 1. Display Empty rooms                             *");
        System.out.println("* 2. Add customer to room                            *");
        System.out.println("* 3. Delete customer from room                       *");
        System.out.println("* 4. View all the rooms                              *");
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

    public void chooseOptionFromMenu (int option) {
         switch (option) {
             case 1 : {
                 reserve();
                break;
            }



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
            Date start =new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date end =new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
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
