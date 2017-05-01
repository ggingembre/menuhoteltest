import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Created by guillaume on 4/26/17.
 */
public class Main {

    public static void main(String[] args) {

        // create hotels

        Hotel hyatt = new Hotel("Hyatt", "Kiev");
        Hotel hilton = new Hotel("Hilton", "Kiev");
        Hotel vintage = new Hotel("Vintage", "Lvov");
        Hotel rynok = new Hotel("Rynok", "Lvov");

        // create rooms
        Room hyattRoom1 = new Room("1", "Hyatt Queen", 2, 300, hyatt);
        Room hyattRoom2 = new Room("2", "Hyatt King", 4, 500, hyatt);

        List<Room> hyattRooms = new ArrayList<>();
        hyattRooms.add(hyattRoom1);
        hyattRooms.add(hyattRoom2);
        hyatt.setRooms(hyattRooms);

        Room hiltonRoom1 = new Room("3", "Hilton Queen", 2, 400, hilton);
        Room hiltonRoom2 = new Room("4", "Hilton King", 4, 600, hilton);

        List<Room> hiltonRooms = new ArrayList<>();
        hiltonRooms.add(hiltonRoom1);
        hiltonRooms.add(hiltonRoom2);
        hilton.setRooms(hiltonRooms);

        Room vintageRoom1 = new Room("5", "Vintage Queen", 2, 200, vintage);
        Room vintageRoom2 = new Room("6", "Vintage King", 4, 400, vintage);

        List<Room> vintageRooms = new ArrayList<>();
        vintageRooms.add(vintageRoom1);
        vintageRooms.add(vintageRoom2);
        vintage.setRooms(vintageRooms);

        Room rynokRoom1 = new Room("7", "Female Dorm", 20, 10, rynok);
        Room rynokRoom2 = new Room("8", "Male Dorm", 20, 10, rynok);

        List<Room> rynokRooms = new ArrayList<>();
        rynokRooms.add(rynokRoom1);
        rynokRooms.add(rynokRoom2);
        rynok.setRooms(rynokRooms);

        // create users
        User guillaume = new User ("ggingembre@gmail.com", "ggingembre", "test");
        User charles = new User ("cgalant@gmail.com", "cgalant", "test");
        User elena = new User ("elena@gmail.com", "elena", "test");

        // create reservations
        LocalDate checkin1 = LocalDate.of(2017, Month.MAY, 12);
        LocalDate checkout1 = LocalDate.of(2017, Month.MAY, 14);

        LocalDate checkin2 = LocalDate.of(2017, Month.MAY, 2);
        LocalDate checkout2 = LocalDate.of(2017, Month.MAY, 4);

        LocalDate checkin3 = LocalDate.of(2017, Month.JUNE, 12);
        LocalDate checkout3 = LocalDate.of(2017, Month.JUNE, 14);

        LocalDate checkin4 = LocalDate.of(2017, Month.JUNE, 2);
        LocalDate checkout4 = LocalDate.of(2017, Month.JUNE, 4);

        Reservation r1 = new Reservation(guillaume,hyattRoom1,checkin1, checkout1);
        Reservation r2 = new Reservation(charles, hiltonRoom2, checkin2, checkout2);
        Reservation r3 = new Reservation (elena, vintageRoom1, checkin3, checkout3);
        Reservation r4 = new Reservation(elena, hyattRoom2, checkin1, checkout1);

        // updating the reservation lists of the rooms

        List<Reservation> hyatt1book = new ArrayList<>();
        hyatt1book.add(r1);
        hyattRoom1.setBookings(hyatt1book);

        //List<Reservation> hyatt2book = new ArrayList<>();
        //hyatt2book.add(r4);
        //hyattRoom2.setBookings(hyatt2book);

        List<Reservation> hilton2book = new ArrayList<>();
        hilton2book.add(r2);
        hiltonRoom1.setBookings(hilton2book);

        List<Reservation> vintage1book = new ArrayList<>();
        vintage1book.add(r3);
        vintageRoom1.setBookings(vintage1book);

        // look for hotels by city

        List<Hotel> allHotels = new ArrayList<>();
        allHotels.add(hyatt);
        allHotels.add(hilton);
        allHotels.add(vintage);
        allHotels.add(rynok);

        System.out.println("By hotel name:");
        System.out.println(Utils.findHotelByHotelName(allHotels, "Hyatt"));

        // look for hotels by city and date

        //System.out.println("By city name:");
        System.out.println(Utils.findHotelByCityDate(allHotels, "Kiev", checkin1, checkout1));

        LocalDate checkin = Utils.getCheckinDate();
        LocalDate checkout = Utils.getCheckoutDate(checkin);

        System.out.println("You have entered the following checkin date: " + checkin);
        System.out.println("You have entered the following checkout date: " + checkout);

        //Menu menu = new Menu();
        //menu.runMenu();
    }
}
