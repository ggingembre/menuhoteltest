import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Created by guillaume on 4/26/17.
 */
public class Menu {

    private boolean exit = false;
    private BufferedReader br = null;

    private List<Hotel> allHotels;
    private Session session;
    private List<User> allUsers;

    public Menu(Session session, List<User> allUsers, List<Hotel> allHotels) {
        this.session = session;
        this.allUsers = allUsers;
        this.allHotels = allHotels;
    }

    private void printHeader(){
        System.out.println("*******************************");
        System.out.println("|      Welcome to our         |");
        System.out.println("|   Booking Application       |");
        System.out.println("*******************************");
    }

    /*
    access rights for all:
     */

    private void printGuestMainMenu(){
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Register");
            // (check login)
            // -- enter your username, check if username already exists
            // -- enter your password; no need to check password yet
        System.out.println("[2] Login"); // if logged in, show "logout"
            // Check login and pass
            //-- enter your name
            //-- enter your password
        System.out.println("[3] Search / book a room");
            /*
              -- [1] Search room by hotel and dates"; // for all
                ---- Please enter the hotel name
                ---- Please enter you check in date
                ---- Please enter your checkout date
                    We must show the list of rooms
                        ------ "Do you want to book a room?"
                        ------ if yes, "Please choose the room you want to book"
                        ------ get room number from user and call method bookroom with: Room + checkindate + checkoutdate
                            -------- "You have successfully booked your room" + print booking details (hotel, room, dates)
                            -------- return to "search room menu"
                        ------ if no: return to: search / book a room menu
              -- [2] Search room by city and dates"; // for all
                ---- Please enter the city
                ---- Please enter you check in date
                ---- Please enter your checkout date
                    We must show the list of rooms
                        ------ "Do you want to book a room?"
                        ------ if yes, "Please choose the room you want to book"
                        ------ get room number from user and call method bookroom with: Room + checkindate + checkoutdate
                            -------- "You have successfully booked your room" + print booking details (hotel, room, dates)
                            -------- return to "search room menu"
                        ------ if no: return to: search / book a room menu
              -- [3] Go back to main menu";
             */
        System.out.println("[4] Search a hotel");
        /*
        -- [1] Search hotel by name");
            ---- Please enter the hotel name
                    We must show the list of hotels
                    **** if time, add function to book room from here
        -- [2] Search hotel by city and dates");
                    We must show a list of hotels
                    **** if time, add function to book room from here
        -- [3] Go back to main menu");
         */
        System.out.println("[5] Admin menu"); // only admins (require sign-in); go to printAdminMainMenu
        /*
        -- [1] Choose database")
            ---- "Please choose the database you want to work with"
            ---- [1] XML
            ---- [2] Binary
            ---- confirm: "Are you sure you want to change database? If you do, we will restart the system"
        -- [2] Add a hotel"); // constructor with all fields: name, city,
            ---- "Please enter hotel name: "
            ---- "Please enter hotel city: "
            **** call constructor
            **** check for null exception: throw exception "We could not create this hotel"
            **** add this hotel to DAO
            ---- "Your hotel was created" + print hotel
            **** back to admin menu
        -- [3] Add a room"); // first find hotel, then constructor with all fields,
            ---- "Please enter the name of the hotel in which you want to add a room"
            **** search hotel by name
            ---- show list of hotels
            ---- "Please choose the number of the hotel in which you want to add a room"
            ---- "Please enter the number of guests"
            **** call constructor and create room
            **** check for null exception
            **** add room to DAO
            ---- "Your room was successfully created" + print room
            **** back to main admin menu
        -- [4] Update or delete a hotel"); // do like we do for users
            ---- "Please enter the name of the hotel you want to update or delete"
            **** search hotel by name
            ---- show list of hotels
            ---- "Please choose the number of the hotel you want to update or delete"
                ------ [1] update hotel
                    **** get hotel by ID
                    ---- "Please enter new hotel name"
                    **** set hotel name
                    ---- "Please enter new hotel city"
                    **** set hotel city
                ------ [2] delete hotel
                    **** get hotel by ID, find it and delete it in DAO
        -- [5] Update or delete a room");
            ---- "Please enter the name of the hotel of the room you want to update or delete"
            **** search hotel by hotel name
            ---- show list of hotels
            ---- "Please choose the number of the hotel of the room you want to update or delete"
            ---- print list of rooms of this hotel
            ---- "Please choose the number of the room you want to update or delete"
                ------ [1] update room
                    **** get room from list
                    ---- "Please enter new room parameters "
                    set method to set new parameters
                ------ [2] delete room
                    **** get room by ID, find it and delete it in DAO
        -- [6] Find and update a user"); // search user by userName
            ---- "Please enter the username of the user you want to update or delete"
                ------ [1] update user
                    **** "Please enter new password"
                    **** "Please enter new email"
                ------ [2] delete user
                    **** get user by username, find it and delete it in DAO
        [7] Back to main menu
         */


        System.out.println("[6] Exit");
    }

    private void printUserMainMenu() {
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Update your profile");
        System.out.println("[2] Logout");
        System.out.println("[3] Search / book a room");
        System.out.println("[4] Search a hotel");
        System.out.println("[5] Admin menu");
        System.out.println("[6] Exit");
    }

    /*if enough time:
    - allow user to change his information

     */

    private void printUserHotelMenu(){
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Search hotel by name");
        System.out.println("[2] Search hotel by city and dates");
        System.out.println("[3] Go back to main menu");
    }

    /*
     print hotel list
     then in book room from hotel list method: ask user to chose hotel number in the list, print rooms, and book 1
      */

    private void printUserHotelResultsMenu(){
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Book a room"); // for admin / users
        System.out.println("[2] Go back to hotel search");
        System.out.println("[3] Go back to main menu");
    }

    private void printUserRoomMenu(){
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Search room by hotel and dates"); // for all
        System.out.println("[2] Search room by city and dates"); // for all
        System.out.println("[3] Go back to main menu");
    }

    private void printUserRoomResultsMenu(){
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Book a room"); // for admin / users
        System.out.println("[2] Go back to room search");
        System.out.println("[3] Go back to main menu");
    }

    private void adminChooseDB(){
        System.out.println("Please make a selection");
        System.out.println("[1] Choose XML database");
        System.out.println("[2] Choose binary database"); // tell them that if they change DB, system will restart
    }

    private void printAdminMainMenu(){
        System.out.println("Please make a selection");
        System.out.println("[1] Choose database");
        System.out.println("[2] Add a hotel"); // constructor with all fields: name, city,
        System.out.println("[3] Add a room"); // first find hotel, then constructor with all fields,
        System.out.println("[4] Update or delete a hotel"); // do like we do for users
        System.out.println("[5] Update or delete a room");
        System.out.println("[6] Find and update a user"); // search user by userName
        System.out.println("[7] Back to main menu");
    }

    // find room: it will return a list
    // user should be able to choose one of the possibilities and do an action on it

    private void addRoom(){
        System.out.println("Please enter the hotel in which you want to add a room");
        //search hotel method; not void but Hotel. User search not void, but string; and admin search is Hotel.

    }

    private void searchUser(){
        System.out.println("Please enter the login of the user");
        //search user method; not void but User. User search not void, but string; and admin search is Hotel.
        // two points: update user, delete user. new menu with 3 points: update user, delete user, go back to admin menu
        // do not update / delete admins: so in search, if it is admin, then return: "you cannot update or delete admins"

    }


    public void runMenu(){

        printHeader();
        while(!exit){
            printGuestMainMenu();
            performActionGuestMainMenu(getMenuInput(1,6));
        }

    }

    private int getMenuInput(int min, int max){
        int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (choice < min || choice > max) {
            try {
                System.out.print("\nEnter your selection");
                choice = Integer.parseInt(br.readLine());
                if (choice < min || choice > max) throw new OutOfMenuRangeException();

            } catch (NumberFormatException | OutOfMenuRangeException | IOException e) {
                System.out.println("Invalid selection, please try again");
            }
        }
        return choice;
    }


    private void performActionGuestMainMenu(int choice){
        switch(choice){
            case 1:
                createUser();
                break;
            case 2:
                session = login(session, allUsers);
                if (session.isGuest()){
                    printGuestMainMenu();
                    performActionGuestMainMenu(getMenuInput(1,6));
                }else{
                    printUserMainMenu();
                    performActionUserMainMenu(getMenuInput(1,6));
                }
                break;
            case 3:
                printUserRoomMenu();
                performActionUserRoomMenu(getMenuInput(1,3));
                break;
            case 4:
                printUserHotelMenu();
                performActionUserHotelMenu(getMenuInput(1,3));
                break;
            case 5:
                // login
                printAdminMainMenu();
                //performActionAdminMainMenu();
            case 6:
                exit = true;
                System.out.println("Thank you for using our application");
                // default:
                //     System.out.println("An unknown error has occurred");
        }
    }

    private void performActionUserHotelMenu(int choice){
        SearchResults results;
        switch(choice){
            case 1:
                searchHotelByName(allHotels);
                break;
            case 2:
                results = searchHotelByCityDates(allHotels);
                printUserHotelResultsMenu();
                performActionUserHotelResultsMenu(results, getMenuInput(1,3));
                break;
            case 3:
                if (!session.isGuest()){
                    printUserMainMenu();
                    performActionUserMainMenu(getMenuInput(1,6));
                } else break;
                break;
           // default:
           //     System.out.println("An unknown error has occurred");
        }

    }

    private void performActionUserRoomMenu(int choice){
        SearchResults results;
        switch (choice){
            case 1:
                results = searchRoomHotelDate();
                printUserRoomResultsMenu();
                performActionUserRoomResultsMenu(results, getMenuInput(1,3));
                break;
            case 2:
                results = searchRoomCityDate();
                printUserRoomResultsMenu();
                performActionUserRoomResultsMenu(results, getMenuInput(1,3));
                break;
            case 3:
                if (!session.isGuest()){
                    printUserMainMenu();
                    performActionUserMainMenu(getMenuInput(1,6));
                } else break;
                break;
        }
    }

    private void performActionUserHotelResultsMenu(SearchResults results, int choice){
        switch (choice){
            case 1:
                bookRoom(results);
                break;
            case 2:
                printUserHotelMenu();
                performActionUserHotelMenu(getMenuInput(1,3));
                break;
            case 3:
                if (!session.isGuest()){
                printUserMainMenu();
                performActionUserMainMenu(getMenuInput(1,6));
            } else break;
        }
    }

    private void performActionUserRoomResultsMenu(SearchResults results, int choice){
        switch (choice){
            case 1:
                bookRoom(results);
                break;
            case 2:
                printUserRoomMenu();
                performActionUserRoomMenu(getMenuInput(1,3));
                break;
            case 3:
                if (!session.isGuest()){
                    printUserMainMenu();
                    performActionUserMainMenu(getMenuInput(1,6));
                } else break;
        }
    }

    private void performActionUserMainMenu(int choice) {
        switch (choice) {
            case 1:
                updateUser(session.getUser());
                printUserMainMenu();
                performActionUserMainMenu(getMenuInput(1,6));
                break;
            case 2:
                logout(session);
                printGuestMainMenu();
                performActionGuestMainMenu(getMenuInput(1,6));
                break;
            case 3:
                printUserRoomMenu();
                performActionUserRoomMenu(getMenuInput(1, 3));
                break;
            case 4:
                printUserHotelMenu();
                performActionUserHotelMenu(getMenuInput(1, 3));
                break;
            case 5:
                // login
                printAdminMainMenu();
                //performActionAdminMainMenu();
            case 6:
                exit = true;
                System.out.println("Thank you for using our application");
                // default:
                //     System.out.println("An unknown error has occurred");
        }
    }

    private void createUser(){

        User newUser;
        String firstName = "";
        String lastName = "";
        String userName = "";
        String address = "";
        String email = "";
        String password = "";
        String confirmpassword;
        String yn;

        Scanner scan = new Scanner(System.in);

        boolean ok = false;

        while (!ok){
            System.out.println("Please enter your email");
            email = scan.nextLine();
            System.out.println("Please enter your username");
            userName = scan.nextLine();
            System.out.println("Please enter your password");
            password = scan.nextLine();

            System.out.println("\nHere is a summary of your data:");
            System.out.println("First name: " + firstName);
            System.out.println("Last name: " + lastName);
            System.out.println("Address: " + address);
            System.out.println("Email: " + email);
            System.out.println("Username: " + userName);

            System.out.println("If this is correct, please enter Y, else press any key");
            yn = scan.nextLine();
            if (yn.equalsIgnoreCase("Y")) ok = true;
        }

        newUser = new User(email, userName, password);

        System.out.println(newUser);
        // here save this user to the database (and check if user already exists)

    }

    private void searchHotelByName(List<Hotel> allHotels){

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the hotel name");
        String hotelName = scan.nextLine();

        System.out.println(Utils.findHotelByHotelName(allHotels, hotelName));

    }

    private SearchResults searchHotelByCityDates(List<Hotel> allHotels){
        Scanner scan = new Scanner(System.in);
        List<Room> rooms;

        System.out.println("Please enter the city name");
        String cityName = scan.nextLine();
        LocalDate checkin = Utils.getCheckinDate();
        LocalDate checkout = Utils.getCheckoutDate(checkin);

        rooms = Utils.findRoomByCityDate(allHotels, cityName, checkin, checkout);
        Utils.printRoomResults(rooms, checkin, checkout, cityName);

        SearchResults results = new SearchResults(checkin, checkout, rooms);

        return results;

    }

    private SearchResults searchRoomHotelDate(){
        Scanner scan = new Scanner(System.in);
        List<Room> rooms;

        System.out.println("Please enter the hotel name");
        String hotelName = scan.nextLine();
        LocalDate checkin = Utils.getCheckinDate();
        LocalDate checkout = Utils.getCheckoutDate(checkin);

        rooms = Utils.findRoomByHotelDate(allHotels, hotelName, checkin, checkout);

        Utils.printRoomResults(rooms, checkin, checkout, hotelName);

        SearchResults results = new SearchResults(checkin, checkout, rooms);

        return results;

    }

    private SearchResults searchRoomCityDate() {
        Scanner scan = new Scanner(System.in);
        List<Room> rooms;

        System.out.println("Please enter the city name");
        String cityName = scan.nextLine();
        LocalDate checkin = Utils.getCheckinDate();
        LocalDate checkout = Utils.getCheckoutDate(checkin);

        rooms = Utils.findRoomByCityDate(allHotels, cityName, checkin, checkout);
        Utils.printRoomResults(rooms, checkin, checkout, cityName);

        SearchResults results = new SearchResults(checkin, checkout, rooms);

        return results;

    }

    private void bookRoom(SearchResults results){

        LocalDate checkin = results.getCheckin();
        LocalDate checkout = results.getCheckout();
        List<Room> rooms = results.getRooms();

        System.out.println("Here is the room array for room from " + checkin + " to " + checkout + ":");
        System.out.println(rooms);
        System.out.println("According to some logic, the room has been booked. Please check your email.");
    }

    private Session login (Session session, List<User> allUsers){
        String userName;
        String pass;
        User user;

        Scanner scan = new Scanner(System.in);

        if (!session.isGuest()) System.out.println("You already logged in as " + session.getUser().getUserName());

        if (session.isGuest()){
            // get login credentials from user
            System.out.println("Please enter your username");
            userName = scan.nextLine();
            System.out.println("Please enter your password");
            pass = scan.nextLine();

            // try to login
            user = Utils.loginAndPasswordVerification(allUsers, userName, pass);
            if (user == null) System.out.println("Wrong login credentials: please either register or try again");
            else{
                // update session info
                session.setUser(user);
                session.setGuest(false);

                if (user.isAdmin()) session.setAdmin(true);
            }
        }

        return session;
    }

    private Session logout(Session session){
        session.setUser(null);
        session.setGuest(true);
        session.setAdmin(false);

        return session;
    }

    private User updateUser(User user){
        String userName;
        String pass;
        String email;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your updated information");

        System.out.println("Please enter your new email");
        email = scan.nextLine();

        System.out.println("Please enter your new user name");
        userName = scan.nextLine();

        System.out.println("Please enter your new password");
        pass = scan.nextLine();

        user.setEmail(email);
        user.setUserName(userName);
        user.setPassword(pass);

        // procedure to save user to DB

        System.out.println("Your data has been successfully saved");

        return user;
    }

}