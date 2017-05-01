import java.util.ArrayList;
import java.util.List;

/**
 * Created by guillaume on 5/1/17.
 */
public class Hotel {

    private String hotelName;
    private List<Room> rooms;
    private String hotelCity;

    public Hotel(String hotelName, String hotelCity) {
        this.hotelName = hotelName;
        this.hotelCity = hotelCity;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelCity() {return hotelCity;}

    public List<Room> getHotelRooms() {return rooms;}

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hotel{");
        sb.append("hotelName='").append(hotelName).append('\'');
        sb.append("; rooms=").append(rooms.stream()
                .map(room -> " Room name: " + room.getName()
                        + ", Number of persons: " + room.getNumberOfPersons()
                        + ", Price: " + room.getPrice()).reduce("", String::concat));
        sb.append("; hotelCity='").append(hotelCity).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
