import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

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
    }

    public void chooseOptionFromMenu (int option) {
        System.out.println("Choose one of the options from above. (E.g: Type '4' to view all the rooms)");

        option = input.nextInt();
         switch (option) {




         }
    }
}
