import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by guillaume on 5/1/17.
 */
public class Utils {

    public static List<Hotel> findHotelByHotelName(List<Hotel> allHotels, String hotelName) throws NoSuchElementException {
            return allHotels.stream()
                    .filter((Hotel hotel) -> hotel.getHotelName().equalsIgnoreCase(hotelName))
                    .collect(Collectors.toList());

    }

    public static List<Hotel> findHotelByCityDate(List<Hotel> allHotels, String cityName, LocalDate checkin, LocalDate checkout) throws NoSuchElementException {

        List<Room> rooms = findRoomByCityDate(allHotels, cityName, checkin, checkout);

        // create array of hotels with available rooms from the room array
        List<Hotel> hotelDuplicates = new ArrayList<>();
        for (Room room : rooms) {
            hotelDuplicates.add(room.getHotel());
        }

        // removing duplicates
        Set<Hotel> hotelsNoD = new HashSet<>();
        hotelsNoD.addAll(hotelDuplicates);

        List<Hotel> hotelsByCityByDate = new ArrayList<>();
        hotelsByCityByDate.addAll(hotelsNoD);

        // issue: when printing results, it also prints rooms that are not available... maybe better to return a
        // room map, with only available rooms, grouped by hotel?
        return hotelsByCityByDate;
    }

    public static boolean isBooked (Room room, LocalDate checkin, LocalDate checkout){
        boolean isBooked = false;
        List<Reservation> bookings;

        bookings = room.getBookings();
        if (bookings == null) {isBooked = false;} else {
            for (Reservation booking : bookings){
                // if checkin or checkout dates are during an existing stay
                if ((booking.getDateOfArrival().isBefore(checkin) &&
                        (booking.getDateOfDeparture().isAfter(checkin)))
                        || (booking.getDateOfArrival().isBefore(checkout) &&
                        (booking.getDateOfDeparture().isAfter(checkout)))) isBooked = true;

                // if checkin or checkout dates are the same as an existing stay
                if ((booking.getDateOfArrival().isEqual(checkin))
                        || (booking.getDateOfArrival().isEqual(checkout))) isBooked = true;

                // if checkin before and checkout after checkin and checkout of existing stay
                if ((checkin.isBefore(booking.getDateOfArrival()))
                        && (checkout.isAfter(booking.getDateOfArrival()))) isBooked = true;
            }
        }

        return isBooked;
    }

    public static List<Room> findRoomByHotelDate(List<Hotel> allHotels, String hotelName, LocalDate checkin, LocalDate checkout) throws NoSuchElementException {

        List<Hotel> myHotels;
        List<Room> rooms = new ArrayList<>();

        myHotels = allHotels.stream()
                .filter((Hotel hotel) -> hotel.getHotelName().equalsIgnoreCase(hotelName))
                .collect(Collectors.toList());

        // create room array with all rooms in the city
        for (Hotel hotel : myHotels) {
            rooms.addAll(hotel.getHotelRooms());
        }

        // delete room if it is booked during requested period
        rooms.removeIf(room -> isBooked(room,checkin, checkout));

        //System.out.println("Here are the rooms available during your stay:");
        //System.out.println(rooms);

        return rooms;
    }

    public static List<Room> findRoomByCityDate(List<Hotel> allHotels, String cityName, LocalDate checkin, LocalDate checkout) throws NoSuchElementException {

        List<Hotel> cityHotels;
        List<Room> rooms = new ArrayList<>();

        cityHotels = allHotels.stream()
                .filter((Hotel hotel) -> hotel.getHotelCity().equalsIgnoreCase(cityName))
                .collect(Collectors.toList());

        // create room array with all rooms in the city
        for (Hotel hotel : cityHotels) {
            rooms.addAll(hotel.getHotelRooms());
        }

        // delete room if it is booked during requested period
        rooms.removeIf(room -> isBooked(room,checkin, checkout));

        return rooms;
    }

    public static LocalDate readDateFromConsole(){
        LocalDate date1 = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        while(true){
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                date1 = LocalDate.parse(br.readLine(),formatter); //throw IOException
                break;
            } catch (Exception e){
                System.out.println("Please enter the right date format: d/MM/yyyy");
                continue;
            }
        }

        return date1;
    }

    public static LocalDate getCheckinDate(){
        LocalDate checkin;

        while(true){
            try{
                System.out.println("Please enter your desired check-in date");
                checkin = readDateFromConsole();
                if (checkin.isBefore(LocalDate.now())) throw new CheckinDateException();
                break;
            }catch (CheckinDateException e){
                System.out.println("The check-in date cannot be in the past. Please enter a correct date");
                continue;
            }
        }
        return checkin;
    }

    public static LocalDate getCheckoutDate(LocalDate checkin){
        LocalDate checkout;
        LocalDate maxcheckout;

        maxcheckout = checkin.plusDays(30);

        while(true){
            try{
                System.out.println("Please enter your desired check-out date");
                checkout = readDateFromConsole();
                if (checkout.isBefore(checkin) || checkout.isAfter(maxcheckout) || checkout.isEqual(checkin))
                    throw new CheckinDateException();
                break;
            }catch (CheckinDateException e){
                System.out.println("The check-out must be after your check in date, and cannot be more than 30 days" +
                        " after your check-in date. \nYour check-in date is: " + checkin + " and your maximum check-out" +
                        "date is: " + maxcheckout + ". Please enter a correct date");
                continue;
            }
        }
        return checkout;
    }

}