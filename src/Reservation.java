import java.util.Calendar;

public class Reservation {

    private Calendar start;
    private Calendar end;
    private String guestName;

    public Reservation(Calendar start, Calendar end, String guestName) {
        this.start = start;
        this.end = end;
        this.guestName = guestName;
    }

    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
}
