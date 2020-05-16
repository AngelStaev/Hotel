import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IOManager ioManager = new IOManager(new Scanner(System.in));
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        DateUtils dateUtils = new DateUtils(dateFormat, ioManager);
        Menu start = new Menu(new Hotel(), ioManager, dateUtils);
        start.initializeMenu();
    }
}
