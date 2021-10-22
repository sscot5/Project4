/*
* Filename: FlightReservation.java Last modified on October 12, 2021
* 
* Course: IT 168 Class Section: 1
*/
package ilstu;

import java.util.Scanner;

/**
 * This is a program to display flight information and reserve seats on flights.
 * 
 * @author Stephanie Scott
 */
public class FlightReservation1 {
    public static void main(String[] args) {
        Flight flight1 = new Flight("AA179", "ORD", "DFW", "A350");
        Flight flight2 = new Flight("AA3820", "BMI", "ORD", "ERJ-145");
        Flight flight3 = new Flight("DL2789", "BMI", "ATL", "ERJ-145");
        Flight flight4 = new Flight("DL298", "ORD", "IAD", "767");
        flight2.reserveSeats(48);
        flight3.reserveSeats(40);
        boolean choosingInput = true;
        Scanner scanner = new Scanner(System.in);
        while (choosingInput) {
            System.out.print(
                    "\nWelcome to BloNo Reservations.\nPlease choose one of the following:\nF – list all available flights\nM – make a flight reservation\nQ – quit\nEnter your choice: ");
            String input = scanner.nextLine();
            input = input.toUpperCase();
            if (input.equals("Q")) {
                choosingInput = false;
                continue;
            } else if (input.equals("F")) {
                // list all available flights
                if (flight1.getSeatsAvailable() > 0) {
                    System.out.println(flight1);
                }
                if (flight2.getSeatsAvailable() > 0) {
                    System.out.println(flight2);
                }
                if (flight3.getSeatsAvailable() > 0) {
                    System.out.println(flight3);
                }
                if (flight4.getSeatsAvailable() > 0) {
                    System.out.println(flight4);
                }
                if (flight1.getSeatsAvailable() == 0 && flight2.getSeatsAvailable() == 0
                        && flight3.getSeatsAvailable() == 0 && flight4.getSeatsAvailable() == 0) {
                    System.out.println("Sorry. There are no seats available on any flights.");
                }
            } else if (input.equals("M")) {
                // make flight reservation
                System.out.print("On which flight?  ");
                String flight = scanner.nextLine();
                int availSeats;
                int reserveSeats;

                if (flight.equals(flight1.getFlightNum())) {
                    availSeats = flight1.getSeatsAvailable();
                    System.out.print("How many seats would you like to reserve?  ");
                    reserveSeats = scanner.nextInt();
                    scanner.nextLine();
                    if (availSeats >= reserveSeats) {
                        System.out.println("Reservation successful.");
                    } else {
                        System.out.println("Sorry, there are not enough seats available on that flight.");
                    }

                } else if (flight.equals(flight2.getFlightNum())) {
                    availSeats = flight2.getSeatsAvailable();
                    System.out.print("How many seats would you like to reserve?  ");
                    reserveSeats = scanner.nextInt();
                    scanner.nextLine();
                    if (availSeats >= reserveSeats) {
                        System.out.println("Reservation successful.");
                    } else {
                        System.out.println("Sorry, there are not enough seats available on that flight.");
                    }

                } else if (flight.equals(flight3.getFlightNum())) {
                    availSeats = flight3.getSeatsAvailable();
                    System.out.print("How many seats would you like to reserve?  ");
                    reserveSeats = scanner.nextInt();
                    scanner.nextLine();
                    if (availSeats >= reserveSeats) {
                        System.out.println("Reservation successful.");
                    } else {
                        System.out.println("Sorry, there are not enough seats available on that flight.");
                    }

                } else if (flight.equals(flight4.getFlightNum())) {
                    availSeats = flight4.getSeatsAvailable();
                    System.out.print("How many seats would you like to reserve?  ");
                    reserveSeats = scanner.nextInt();
                    scanner.nextLine();
                    if (availSeats >= reserveSeats) {
                        System.out.println("Reservation successful.");
                    } else {
                        System.out.println("Sorry, there are not enough seats available on that flight.");
                    }

                } else {
                    System.out.println("Sorry, no matching flight was found.");
                    continue;
                }
            } else {
                // invalid input reread.
                System.out.println(input + " is invalid.");
                continue;
            }
        }
        scanner.close();
        System.out.println("You entered Q. Exiting program. Goodbye!");
    }
}