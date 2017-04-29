import java.util.Scanner;

/**
 * Created by guillaume on 4/26/17.
 */
public class Menu {

    boolean exit = false;

    private void printHeader(){
        System.out.println("*******************************");
        System.out.println("|      Welcome to our         |");
        System.out.println("|   Booking Application       |");
        System.out.println("*******************************");
    }

    /*
    access rights for all:
     */

    private void printUserMainMenu(){
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
        System.out.println("[1] Search room by hotel and dates"); // forr all
        //--searching room
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
            printUserMainMenu();
            performActionUserMainMenu(getMenuInput(1,5));
        }

    }

    private int getMenuInput(int min, int max){
        int choice = 0;
        Scanner scan = new Scanner(System.in);

        while (choice < min || choice > max){
            try{
                System.out.print("\nEnter your selection");
              choice = Integer.parseInt(scan.nextLine());
              if (choice < min || choice > max) throw new OutOfMenuRangeException();

            } catch (NumberFormatException | OutOfMenuRangeException e){
                System.out.println("Invalid selection, please try again");
            }
        }
        return choice;
    }


    private void performActionUserMainMenu(int choice){
        switch(choice){
            case 1:
                createUser();
                break;
            case 2:
                //login
                break;
            case 3:
                printUserHotelMenu();
                performActionUserHotelMenu(getMenuInput(1,3));
                break;
            case 4:
                printUserRoomMenu();
                performActionUserRoomMenu(getMenuInput(1,3));
                break;
            case 5:
                exit = true;
                System.out.println("Thank you for using our application");
           // default:
           //     System.out.println("An unknown error has occurred");
        }
    }

    private void performActionUserHotelMenu(int choice){
        switch(choice){
            case 1:
                searchHotelByName();
                break;
            case 2:
                searchHotelByCityDates();
                break;
            case 3:
                break;
           // default:
           //     System.out.println("An unknown error has occurred");
        }

    }

    private void performActionUserRoomMenu(int choice){
        switch (choice){
            case 1:
                searchRoomHotelDate();
                break;
            case 2:
                searchRoomCityDate();
                break;
            case 3:
                break;
        }
    }

    private void performActionUserHotelResultsMenu(int choice){
        switch (choice){
            case 1:
                bookRoom();
                break;
            case 2:
                printUserHotelMenu();
                performActionUserHotelMenu(getMenuInput(1,3));
                break;
            case 3:
                break;
        }
    }

    private void performActionUserRoomResultsMenu(int choice){
        switch (choice){
            case 1:
                bookRoom();
                break;
            case 2:
                printUserRoomMenu();
                performActionUserRoomMenu(getMenuInput(1,3));
                break;
            case 3:
                break;
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
            System.out.println("Please enter your first name");
            firstName = scan.nextLine();
            System.out.println("Please enter your last name");
            lastName = scan.nextLine();
            System.out.println("Please enter your address");
            address = scan.nextLine();
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

        newUser = new User(firstName, lastName, address, email, userName, password);

        System.out.println(newUser);
        // here save this user to the database (and check if user already exists)

    }

    private void searchHotelByName(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the hotel name");
        String hotelName = scan.nextLine();

        // here call controller function to search for hotel with hotelName

        System.out.println("Here is your hotel information: ");

        printUserHotelResultsMenu();
        performActionUserHotelResultsMenu(getMenuInput(1,3));
    }

    private void searchHotelByCityDates(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the city name");
        String cityName = scan.nextLine();
        System.out.println("Please enter your check-in date");
        String checkin = scan.nextLine();
        System.out.println("Please enter your check-out date");
        String checkout = scan.nextLine();

        // we need a logic to check the dates (format, and logic: checkin before checkout, and checkout not
        // more than 30 days after checkin

        // here call controller function to search for hotels in given cities and available at these dates

        System.out.println("Here is a list of hotels with rooms available when you will be in " + cityName +
        " from " + checkin + " to " + checkout);

        // here it would be nice to have a function so that user can enter hotel number and book room.
        // it should be done easily with an array that would be passed to the hotelresultsmenu.

        printUserHotelResultsMenu();
        performActionUserHotelResultsMenu(getMenuInput(1,3));

    }

    private void searchRoomHotelDate(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the hotel name");
        String hotelName = scan.nextLine();
        System.out.println("Please enter your check-in date");
        String checkin = scan.nextLine();
        System.out.println("Please enter your check-out date");
        String checkout = scan.nextLine();

        // we need a logic to check the dates (format, and logic: checkin before checkout, and checkout not
        // more than 30 days after checkin
        // here perform the search using controller

        System.out.println("Here is a list of rooms that are available in " + hotelName +
        " from " + checkin + " to " + checkout);

        // here again, a function to book one room in the list using an array

        printUserRoomResultsMenu();
        performActionUserRoomResultsMenu(getMenuInput(1,3));
    }

    private void searchRoomCityDate() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the city name");
        String cityName = scan.nextLine();
        System.out.println("Please enter your check-in date");
        String checkin = scan.nextLine();
        System.out.println("Please enter your check-out date");
        String checkout = scan.nextLine();

        // we need a logic to check the dates (format, and logic: checkin before checkout, and checkout not
        // more than 30 days after checkin
        // here call controller function to search for hotels in given cities and available at these dates

        System.out.println("Here is a list of rooms available when you will be in " + cityName + " from " + checkin
        + " to " + checkout);

        // here again, a function to book one room in the list using an array

        printUserRoomResultsMenu();
        performActionUserRoomResultsMenu(getMenuInput(1,3));

    }

    private void bookRoom(){

        System.out.println("According to some logic, the room has been booked. Please check your email.");

    }
}
