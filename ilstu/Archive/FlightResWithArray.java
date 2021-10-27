/*
 * Filename: FlightReservation.java
 * Last modified on October 20, 2021 
 * 
 * Course: IT 168
 */
package ilstu;

import java.util.Scanner;

/**
 * This is a program to display flight information and reserve seats on flights.
 * 
 * @author Stephanie Scott
 */

public class FlightResWithArray {
    private static Scanner scanner = new Scanner(System.in);
    private static Flight[] flights = new Flight[4];
    private static String userInput;
    private static String userInputFlightNum;
    private static String userInputResSeats;
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
            reserveFlights();
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

    private static void reserveFlights() {
        boolean prompting = true;
        while (prompting) {
            prompting = promptFlightNum();
        }

        prompting = true;
        while (prompting) {
            prompting = promptReserveSeatNum();
        }

        reserveSeats();
    }

    private static boolean validateFlightNum() {
        return getFlightByFlightNum() != null;
    }

    private static boolean validateSeats() {
        boolean inputIsAnInt = true;
        for (int i = 0; i < userInputResSeats.length(); i++) {
            if ((int) userInputResSeats.charAt(i) >= 48 && (int) userInputResSeats.charAt(i) <= 57) {
                continue;
            }
            inputIsAnInt = false;
        }

        boolean numCheck = false;
        if (inputIsAnInt) {
            numCheck = Integer.parseInt(userInputResSeats) > 0;
            if (!numCheck) {
                log("Error: number of seats must be greater than 0.");
            }
        } else {
            log("Error: invalid input.");
        }

        return inputIsAnInt && numCheck;
    }

    private static void reserveSeats() {
        Flight flight = getFlightByFlightNum();
        if (flight.reserveSeats(Integer.parseInt(userInputResSeats))) {
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
        userInput = scanner.nextLine();
        userInput = userInput.toUpperCase();
    }

    private static boolean promptFlightNum() {
        System.out.print("On which flight?  ");
        userInputFlightNum = scanner.nextLine();
        boolean invalid = !validateFlightNum();
        if (invalid) {
            log("\nError: no matching flight found.\n");
        }
        return invalid;
    }

    private static boolean promptReserveSeatNum() {
        System.out.print("How many seats would you like to reserve?  ");
        userInputResSeats = scanner.nextLine();

        return !validateSeats();
    }

    private static void quit() {
        log("You entered Q. Exiting program. Goodbye!");
        programRunning = false;
        scanner.close();
    }

    private static void log(String msg) {
        System.out.println(msg);
    }
}
