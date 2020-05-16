import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateUtilsTests {

    private SimpleDateFormat dateFormat;
    private DateUtils dateUtils;

    @Before
    public void setup() {
        IOManager ioManager = new IOManager(new Scanner(System.in));
        dateFormat = new SimpleDateFormat(DateUtils.DATE_FORMAT);

        dateUtils = new DateUtils(dateFormat, ioManager);
    }

    @Test
    public void testDateFromString_ShouldReturnDate() {
        String date = "15/05/2020";

        Date dateFromString = dateUtils.getDateFromString(date);

        Assert.assertEquals("Dates are not the same", dateFormat.format(dateFromString), date);
    }

    @Test
    public void testDateFromString_ShouldReturnNull_WithLetters() {
        String date = "sadasdasdasd";

        Date dateFromString = dateUtils.getDateFromString(date);

        Assert.assertNull("Result date should be null", dateFromString);
    }

    @Test(expected = NullPointerException.class)
    public void testDateFromString_ShouldReturnThrow_WithNullParameter() {
        Date dateFromString = dateUtils.getDateFromString(null);
    }

    @Test(expected = NullPointerException.class)
    public void testDateFromString_ShouldReturnThrow_WithInvalidDate() {
        String date = "05/2020";

        Date dateFromString = dateUtils.getDateFromString(date);
    }

    @Test
    public void testDateFromString_ShouldReturnDate_WithDifferentDateFormat() {
        String date = "15/05/2020 12:30:24";

        Date dateFromString = dateUtils.getDateFromString(date);

        Assert.assertNotEquals("Dates are not the same", dateFormat.format(dateFromString), date);
    }
}
