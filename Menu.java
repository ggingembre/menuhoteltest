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

    private void printUserMainMenu(){
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Register");
        System.out.println("[2] Login");
        System.out.println("[3] Search a hotel");
        System.out.println("[4] Book a room");
        System.out.println("[5] Exit");
    }

    private void printUserHotelMenu(){
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Search hotel by name");
        System.out.println("[2] Search hotel by city and dates");
        System.out.println("[3] Go back to main menu");
    }

    private void printUserHotelResultsMenu(){
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Book a room");
        System.out.println("[2] Go back to hotel search");
        System.out.println("[3] Go back to main menu");
    }

    private void printUserRoomMenu(){
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Search room by hotel and dates");
        System.out.println("[2] Search room by city and dates");
        System.out.println("[3] Go back to main menu");
    }

    private void printUserRoomResultsMenu(){
        System.out.println("\nPlease make a selection");
        System.out.println("[1] Book a room");
        System.out.println("[2] Go back to room search");
        System.out.println("[3] Go back to main menu");
    }

    private void printAdminMainMenu(){
        System.out.println("Please make a selection");
        System.out.println("[1] Login");
        System.out.println("[2] Add a hotel");
        System.out.println("[3] Update or delete a hotel");
        System.out.println("[4] Update or delete a room");
        System.out.println("[5] Exit");
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
