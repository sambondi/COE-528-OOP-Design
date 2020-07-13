package coe528.lab1;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/*
 * Flight class implementation.
 * Each object of this class represents a unique flight.
 * @author Sam Bondi
 */
public class Flight {
    // Instance variables
    public int flightNumber;
    public int capacity;
    public int numberOfSeatsLeft;
    public double originalPrice;
    public String origin;
    public String destination;
    public String departureTime;
    
    /**
     * Flight class default constructor
     */
    public Flight() {}
    
    /**
     * Flight class constructor
     * @param num Flight number
     * @param cap Flight capacity
     * @param price Original flight price
     * @param start Flight origin
     * @param dest Flight destination
     * @param depart Flight departure time
     */
    public Flight(int num, int cap, double price, String start, String dest, String depart) {
        flightNumber = num;
        capacity = cap;
        numberOfSeatsLeft = capacity;
        originalPrice = price;
        departureTime = depart;
        boolean equalityCheck;
        
        try {
            origin = start;
            destination = dest;
            if ( origin.equals(destination) ) {
                //System.out.println("[Illegal Argument Exception] Origin cannot equal destination.\n" + e);
                throw new IllegalArgumentException("Origin cannot equal destination.\n");
            }
        }catch (IllegalArgumentException e){
            System.out.println("[IllegalArgumentException] Origin cannot equal destination.");
            System.out.println("\tIssue initializing flight: " + flightNumber);
        }
    }
    
    // Getters
    /**
     * getFlightNumebr()
     * @return flightNumber
     */
    public int getFlightNumber(){
        return flightNumber;
    }
    /**
     * getCapacity()
     * @return capacity
     */
    public int getCapacity(){
        return capacity;
    }
    /**
     * getNumberOfSeatsLeft()
     * @return numberOfSeatsLeft
     */
    public int getNumberOfSeatsLeft(){
        return numberOfSeatsLeft;
    }
    /**
     * getOriginalPrice()
     * @return originalPrice
     */
    public double getOriginalPrice(){
        return originalPrice;
    }
    /**
     * getOrigin()
     * @return origin
     */
    public String getOrigin(){
        return origin;
    }
    /**
     * getDestination()
     * @return destination
     */
    public String getDestination(){
        return destination;
    }
    /**
     * getDepartureTime()
     * @return departureTime
     */
    public String getDepartureTime(){
        return departureTime;
    }
    
    // Setters
    /**
     * setFlightNumebr()
     * @param num Flight number
     */
    public void setFlightNumber(int num){
        flightNumber = num;
    }
    /**
     * getCapacity()
     * @param cap Flight capacity
     */
    public void setCapacity(int cap){
        capacity = cap;
    }
    /**
     * getNumberOfSeatsLeft()
     * @param seatsLeft Number of seats left on flight
     */
    public void setNumberOfSeatsLeft(int seatsLeft){
        numberOfSeatsLeft = seatsLeft;
    }
    /**
     * getOriginalPrice()
     * @param price Flight price
     */
    public void setOriginalPrice(double price){
        originalPrice = price;
    }
    /**
     * getOrigin()
     * @param start Flight origin
     */
    public void setOrigin(String start){
        origin = start;
    }
    /**
     * getDestination()
     * @param dest Flight destination
     */
    public void setDestination(String dest){
        destination = dest;
    }
    /**
     * getDepartureTime()
     * @param depart Flight departure time
     */
    public void setDepartureTime(String depart){
        departureTime = depart;
    }
    
    /**
     * bookASeat() - Decrements numberOfSeats
     * @return TRUE if numberOfSeatsLeft greater than zero, else FALSE.
     */
    public boolean bookASeat(){
        if (numberOfSeatsLeft > 0) {
            numberOfSeatsLeft--;
            return TRUE;
        }else{
            return FALSE;
        }
    }
    
    /**
     * Override toString() method.
     * @return String representation of Flight object.
     */
    @Override
    public String toString(){
        return String.format("Flight " + flightNumber + ", " + origin + " to " + destination + ", " + departureTime + ", " + "original price: " + originalPrice);
    }
    
}
