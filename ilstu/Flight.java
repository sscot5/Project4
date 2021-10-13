
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
    private String airportCode; // The 3-letter airport code where the flight originates
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

    /**
     * Constructor Method
     * 
     * @param flightNum   -- the flight number
     * @param airportCode -- the origin airport
     * @param destAirport -- destination airport
     * @param aircraft    -- aircraft type
     * 
     *                    function: constructor that receives the flight number,
     *                    origin airport, destination airport, and aircraft type. It
     *                    also sets the number of seats currently reserved to zero.
     */
    public Flight(String flightNum, String airportCode, String destAirport, String aircraft) {
        this.flightNum = flightNum;
        this.airportCode = airportCode;
        this.destAirport = destAirport;
        this.aircraft = aircraft;
        numSeatsReserved = 0;
        calcMaximumSeats(aircraft);
    }

    /**
     * Overridden toString method
     * 
     * @return a string containing the flight number, originating airport code,
     *         destination airport code, and the number of seats avialable
     */
    @Override
    public String toString() {
        return flightNum + "\t" + airportCode + "\t" + destAirport + "\t" + getSeatsAvailable() + " seats available";
    }

    /**
     * Getter for the number of seats available
     * 
     * @return the difference between the maximum number of seats and the number of
     *         seats currently reserved
     */
    public int getSeatsAvailable() {
        return maxNumSeats - numSeatsReserved;
    }

    /**
     * Getter for the flight number
     *
     * @return flight number
     */
    public String getFlightNum() {
        return flightNum;
    }

    // /**
    // * Reserve seats method
    // *
    // * @param reserveSeats -- the number of seats needed to be reserved
    // *
    // * @return true if the number of seats are available and reserved or false if
    // * the number of seats are unavailable
    // */
    // public boolean reserveSeats(int reserveSeats) {
    // if (getSeatsAvailable() < reserveSeats) {
    // numSeatsReserved = reserveSeats;
    // return true;
    // }
    // return false;
    // }
    public int reserveSeats(int reserveSeats) {
        if (getSeatsAvailable() >= reserveSeats) {
            numSeatsReserved = reserveSeats;
        }
        return maxNumSeats - numSeatsReserved;
    }

    /**
     * Calculates the number of seats available based on the aircraft
     * 
     * @param aircraft
     */
    private void calcMaximumSeats(String aircraft) {
        if (aircraft.equals(ac1)) {
            maxNumSeats = ac1Capacity;
        } else if (aircraft.equals(ac2)) {
            maxNumSeats = ac2Capacity;
        } else if (aircraft.equals(ac3)) {
            maxNumSeats = ac3Capacity;
        } else {
            maxNumSeats = 0;
        }

    }
}