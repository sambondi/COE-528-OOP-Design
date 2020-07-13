package coe528.lab1;

/*
 * Flight ticket class implementation.
 * @author Sam Bondi
 */
public class Ticket {
    // Instance variables
    public static int number = 0;
    public double price;
    public Passenger p;
    public Flight flight;
    
    public Ticket(Passenger pass, Flight f, double pr){
        price = pr;
        flight = f;
        p = pass;
        number++;
    }
    
    // Getters
    /**
     * getPrice()
     * @return price
     */
    public double getPrice(){
        return price;
    }
    /**
     * getPassenger()
     * @return p
     */
    public Passenger getPassenger(){
        return p;
    }
    /**
     * getFlight()
     * @return flight
     */
    public Flight getFlight(){
        return flight;
    }
    /**
     * getTicketNumber()
     * @return number
     */
    public int getTicketNumber(){
        return number;
    }
    
    
    // Setters
    /**
     * setPrice()
     * @param pr price
     */
    public void setPrice(double pr) {
        price = pr;
    }
    /**
     * setPassenger()
     * @param pass passenger object
     */
    public void setPassenger(Passenger pass) {
        p = pass;
    }
    /**
     * setFlight()
     * @param fl flight object
     */
    public void setFlight(Flight fl) {
        flight = fl;
    }
    /**
     * setTicketNumber()
     * @param ticketNumber flight ticket number
     */
    public void setTicketNumber(int ticketNumber){
        number = ticketNumber;
    }
    
    /**
     * Override toString() method.
     * @return String representation of ticket object.
     */
    @Override
    public String toString(){
        return String.format( p.getName() + ", Flight " + flight.getFlightNumber() + ", " + flight.getOrigin() + " to " + flight.getDestination() + ", " + flight.getDepartureTime() + " original price: " + flight.getOriginalPrice() + ", ticket price: " + price);
    }
}
