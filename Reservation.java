import java.time.LocalDate;

/**
 * Created by guillaume on 5/1/17.
 */
public class Reservation {
    private User user;
    private Room room;
    private LocalDate dateOfArrival;
    private LocalDate dateOfDeparture;

    public Reservation(User user, Room room, LocalDate dateOfArrival, LocalDate dateOfDeparture) {
        this.user = user;
        this.room = room;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }
}
