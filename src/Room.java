public class Room {

    private int roomNumber;
    private String dateOfRent;
    private String dateOfRelease;
    private String roomView;
    private String comment;
    private boolean isFree;
    private byte numberOfBeds;
    private boolean hasBabyBed;

    public Room(int roomNumber, String dateOfRent, String dateOfRelease, String roomView, String comment, boolean isFree, byte numberOfBeds, boolean hasBabyBed) {
        this.roomNumber = roomNumber;
        this.dateOfRent = dateOfRent;
        this.dateOfRelease = dateOfRelease;
        this.roomView = roomView;
        this.comment = comment;
        this.isFree = isFree;
        this.numberOfBeds = numberOfBeds;
        this.hasBabyBed = hasBabyBed;
    }

    public Room(int roomNumber, String dateOfRent, String dateOfRelease, byte numberOfBeds) {
        this.roomNumber = roomNumber;
        this.dateOfRent = dateOfRent;
        this.dateOfRelease = dateOfRelease;
        this.numberOfBeds = numberOfBeds;
    }

    public Room() {
    }

    public void getDetails() {

    }
}
