import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    private SimpleDateFormat dateFormat;
    private IOManager ioManager;

    public DateUtils(SimpleDateFormat dateFormat, IOManager ioManager) {
        this.dateFormat = dateFormat;
        this.ioManager = ioManager;
    }

    public Date getDateFromString(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            ioManager.printMessage("Invalid date");
            return null;
        }
    }
}
