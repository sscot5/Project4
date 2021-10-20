package ilstu;

import java.util.Scanner;

public class FlightRes {
    private static Scanner scanner = new Scanner(System.in);
    private static Flight[] flights = new Flight[4];
    private static String userInput;
    private static String userInputFlightNum;
    private static int userInputResSeats;
    private static boolean programRunning = true;

    public static void main(String[] args) {
        log("Welcome to BloNo Reservations.");
        setupData();
        while (programRunning) {
            runProgram();
        }
    }

    private static void setupData() {
        flights[0] = new Flight("AA179", "ORD", "DFW", "A350");
        flights[1] = new Flight("AA3820", "BMI", "ORD", "ERJ-145");
        flights[2] = new Flight("DL2789", "BMI", "ATL", "ERJ-145");
        flights[3] = new Flight("DL298", "ORD", "IAD", "767");
        flights[1].reserveSeats(48);
        flights[2].reserveSeats(40);
    }

    private static void runProgram() {
        promptUser();

        switch (userInput) {
        case "F":
            listFlights();
            break;
        case "M":
            boolean prompting = true;
            while (prompting) {
                promptFlightNum();
                promptReserveSeatNum();
                prompting = !validateInput();
            }
            reserveSeats();
            break;
        case "Q":
            quit();
            break;
        default:
            log(userInput + " is not valid input.");
        }
    }

    private static void listFlights() {
        for (Flight flight : flights) {
            if (flight.getSeatsAvailable() > 0) {
                System.out.println(flight);
            }
        }
    }

    // TODO: needs to reask with a error statement
    private static boolean validateInput() {
        boolean validFlight = getFlightByFlightNum() != null;
        boolean validResSeats = userInputResSeats > 0;
        return validFlight && validResSeats;
    }

    private static void reserveSeats() {
        Flight flight = getFlightByFlightNum();
        if (flight.reserveSeats(userInputResSeats)) {
            log("Reservation successful.");
        } else {
            log("Sorry, there are not enough seats available on that flight.");
        }
    }

    private static Flight getFlightByFlightNum() {
        for (Flight flight : flights) {
            if (flight.getFlightNum().equals(userInputFlightNum)) {
                return flight;
            }
        }
        return null;
    }

    private static void promptUser() {
        log("\nPlease choose one of the following: ");
        log("F - list all available flights");
        log("M - make a flight reservation");
        log("Q - quit");
        System.out.print("Enter your choice: ");

        // Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        userInput = userInput.toUpperCase();
        // scanner.close();
    }

    private static void promptFlightNum() {
        // Scanner scanner = new Scanner(System.in);
        System.out.print("On which flight?  ");
        userInputFlightNum = scanner.nextLine();
        // scanner.close();
    }

    private static void promptReserveSeatNum() {
        System.out.print("How many seats would you like to reserve?  ");
        // Scanner scanner = new Scanner(System.in);
        userInputResSeats = scanner.nextInt();
        // scanner.close();
    }

    private static void quit() {
        log("You entered Q. Exiting program. Goodbye!");
        programRunning = false;
    }

    private static void log(String msg) {
        System.out.println(msg);
    }
}
