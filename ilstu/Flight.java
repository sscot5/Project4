
/*
 * Filename: Flight.java Last modified on October 12, 2021
 * 
 * Course: IT 168 Class Section: 1
 */
package ilstu;

/**
 * This is a simple flight class
 * 
 * @author Stephanie Scott
 */

public class Flight {
    // instance variable
    private String flightNum; // A flight “number” that is two uppercase letters followed by 3 or 4 digits
    private int aiportCode; // The 3-letter airport code where the flight originates
    private String destAirport; // The 3-letter code for the destination airport
    private String aircraft; // An aircraft type that is a string of characters
    private int maxNumSeats; // The maximum number of seats available on this flight
    private int numSeatsReserved; // The number of seats currently reserved

    private static final String ac1 = "A350";
    private static final String ac2 = "767";
    private static final String ac3 = "ERJ-145";
    private static final int ac1Capacity = 325;
    private static final int ac2Capacity = 216;
    private static final int ac3Capacity = 50;

    // The Flight class must have a constructor that receives the flight number,
    // origin airport, destination airport and aircraft type. It should initialize
    // those four instance variables and set the number of seats currently reserved
    // to zero.

    /**
     * Constructor Method
     * 
     * @param
     */
    public Flight(String flightNum, int airportCode, String destAirport, String aircraft) {

    }

    // calcMaximumSeats method. The calcMaximumSeats method will initialize the
    // maximum number of seats available based on the aircraft type.

    // The Flight class must have the following public methods.
    // A toString method that returns a String with the flight number, origin
    // airport, destination airport, and number of seats available (format shown in
    // the sample output below).
    // A getSeatsAvailable method that returns the difference between the maximum
    // number of seats and the number of seats currently reserved.

    // A reserve method that receives an int parameter representing the number of
    // seats to reserve. If the number of seats to reserve is less than or equal to
    // the number of seats available, the method should increase the number of seats
    // currently reserved by the appropriate number and return true. If not, the
    // method should return false and leave the number of seats unchanged.

    // The Flight class must have the following private method.
    // A calcMaximumSeats method that sets the flight’s maximum number of seats
    // instance variable based on the aircraft type. The maximum number of seats for
    // different aircraft types are shown in the following table. If the String
    // parameter does not match a valid aircraft type, the maximum number of seats
    // should be set to zero.

}