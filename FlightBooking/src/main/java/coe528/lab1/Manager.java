package coe528.lab1;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;

/*
 * @Description Manager class implementation.
 * Manages the flight of a specific airline.
 * Maintains an array of flights and an aray of issued tickets.
 * @author Sam Bondi
 */
public class Manager {
    
    // Creating arrays for flights and issued tickets.
    ArrayList<Flight> ArrayOfFlights = new ArrayList<>();
    ArrayList<Ticket> ArrayOfIssuedTickets = new ArrayList<>();
    
    // Default constructor.
    public Manager () {}
    
    /**
     * createFlights()
     * Populates the ArrayOfFlights.
     */
    public void createFlights() {
        System.out.println("Manager method: createFlights() was called.");
        System.out.println("Attempting to populate ArrayOfFlights with flights.");
        
        Flight flight0 = new Flight(1000, 50, 150.00, "Toronto", "Montreal", 
                                    "07/11/2020 8:49pm");
        Flight flight1 = new Flight(1001, 50, 700.00, "Toronto", "Paris",
                                    "07/14/2020 10:00am");
        Flight flight2 = new Flight(1002, 50, 850.00, "Toronto", "Milan",
                                    "07/22/2020 8:00am");
        Flight flight3 = new Flight(1003, 25, 800.00, "Toronto", "Milan",
                                    "07/22/2020 9:00pm");
        Flight flight4 = new Flight(1004, 25, 50.00, "Toronto", "Toronto",
                                    "07/11/2020 6:00pm");
        Flight flight5 = new Flight(1005, 0, 1000.0, "Toronto", "Napoli",
                                    "07/20/2020 1:11pm");
        
        // Populate the array of flights.
        ArrayOfFlights.add(flight0);
        ArrayOfFlights.add(flight1);
        ArrayOfFlights.add(flight2);
        ArrayOfFlights.add(flight3);
        ArrayOfFlights.add(flight5);
    }
    
    /**
     * displayAvailableFlights()
     * @param origin Flight origin
     * @param destination Flight destination
     */
    public void displayAvailableFlights(String origin, String destination) {
        String start = origin;
        String dest = destination;
        int availableFlightsFoundFlag = 0;
        
        System.out.println("\nManager method: displayAvailableFlights() was called.");
        System.out.println("Attempting to find available flights from " + start + " to " + dest);
        
        for ( Flight flight : ArrayOfFlights ) {
            if ( start.equalsIgnoreCase(flight.getOrigin()) && dest.equalsIgnoreCase(flight.getDestination()) && flight.numberOfSeatsLeft > 0 ) {
                String flightDescription = flight.toString();
                System.out.println(flightDescription);
                availableFlightsFoundFlag = 1;
            }
        }
        
        if ( availableFlightsFoundFlag == 0 ) {
            System.out.println("Could not find available flights from " + start + " to " + dest);
        }
    }
    
    /**
     * getFlight()
     * @param num Flight Number
     * @return flight object
     */
    public Flight getFlight(int num) {
        int flightFoundFlag = 0;
        int flightNumberToSearch = num;
        Flight flightFound = new Flight();
        
        System.out.println("\nManager method: getFlight() was called.");
        System.out.println("Attempting to find flight with flight number: " + flightNumberToSearch);
        
        for ( Flight flight : ArrayOfFlights ) {
            if ( flightNumberToSearch == flight.getFlightNumber() ) { 
                flightFoundFlag = 1;
                flightFound = flight;
                break;
            }else{
                flightFoundFlag = 0;
            }
        }
        
        if ( flightFoundFlag == 1 ) {
            System.out.println("Found a flight with flight number: " + flightNumberToSearch);
            return flightFound;
        }else if ( flightFoundFlag == 0 ) {
            System.out.println("Could not find flight with flight number: " + flightNumberToSearch);
            return null;
        }
        
        return null;
    }
    
    /**
     * bookSeat()
     * @param num Flight number
     * @param p Passenger object
     */
    public void bookSeat(int num, Passenger p) {
        System.out.println("\nManager method: bookSeat() was called.");
        System.out.println("Verifying existence of flight: " + num);
        
        // Get flight object using getFlight() method.
        Flight flight = getFlight(num);
        
        if ( flight != null ) {
            
            boolean bookingSuccess;
            System.out.println("Attempting to book a set on flight: " + num);
            bookingSuccess = flight.bookASeat();
            
            if ( bookingSuccess == TRUE ) {
                System.out.println(p.getName() + " has successfully booked a seat on flight: " + num);
                System.out.println("Attempting to apply appropriate discounts.");
                
                if ( p.getClass() == Member.class ) {
                    
                    System.out.println(p.getName() + " has been a member for " + ((Member)p).yearsOfMembership + " years");
                    
                    // Retrieve the discounted price.
                    double newPrice = ((Member)p).applyDiscount(flight.getOriginalPrice());
                    System.out.println("Original flight price: " + flight.getOriginalPrice());
                    System.out.println("New price after discount: " + newPrice);
                    
                    // Capacity information.
                    System.out.println("Original flight capacity: " + flight.getCapacity());
                    System.out.println("New flight capacity: " + flight.numberOfSeatsLeft);
                    
                    // Create a flight ticket with the appropriate price.
                    Ticket ticket = new Ticket(p, flight, newPrice);
                    System.out.println("Ticket Number: " + ticket.getTicketNumber());
                    System.out.println(ticket.toString());
                
                }else if ( p.getClass() == NonMember.class ) {
                    
                    System.out.println(p.getName() + " is a Non-Member. Attempting to apply senior's discount.");
                    
                    // Retrieve the discounted price.
                    double newPrice = ((NonMember)p).applyDiscount(flight.getOriginalPrice());
                    System.out.println("Original flight price: " + flight.getOriginalPrice());
                    System.out.println("New price after discount: " + newPrice);
                    
                    // Capacity information.
                    System.out.println("Flight capacity: " + flight.getCapacity());
                    System.out.println("New flight capacity: " + flight.numberOfSeatsLeft);
                    
                    // Create a flight ticket with the appropriate price.
                    Ticket ticket = new Ticket(p, flight, newPrice);
                    System.out.println("Ticket Number: " + ticket.getTicketNumber());
                    System.out.println(ticket.toString());
                
                }
            }else if ( bookingSuccess == FALSE ) {
            
                System.out.println("Booking was not successful. Flight: " + num + " is at full capacity.");
            
            }
        }else if ( flight == null ) {
            System.out.println("Booking was unsuccessful.");
        }
    }
    
    public static void main(String[] args) {
        
        // Create the airline manager for Bondi Airlines.
        Manager BondiAirlinesManager = new Manager();
        
        // Populate the flights array for Bondi Airlines.
        BondiAirlinesManager.createFlights();
        
        // Check to see if flights from Toronto to Milan are available.
        BondiAirlinesManager.displayAvailableFlights("Toronto", "Milan");
        
        // Check to see if flights from Toronto to Sicily are avalable.
        BondiAirlinesManager.displayAvailableFlights("Toronto", "Sicily");
        
        // Return flight object with flight number 1000.
        Flight flight1000 = BondiAirlinesManager.getFlight(1000);
        System.out.println(flight1000.toString());
        
        // Attempt to return a flight object with a flight number that does not exist.
        Flight flight1943 = BondiAirlinesManager.getFlight(1943);
        //System.out.println(flight1943.toString());
        // This will throw a NullPointerException because the flight does not exist, returns null.
        
        // Polymorphism and inheritence play a large role here.
        // Create a member passenger with 6 years of membership.
        Passenger p0 = new Member("Sam", 22, 6);
        BondiAirlinesManager.bookSeat(1003, p0);
        
        // Create a member passenger with 2 years of membership.
        Passenger p1 = new Member("Joseph", 53, 2);
        BondiAirlinesManager.bookSeat(1000, p1);
        
        // Create a non-member passenger.
        Passenger p2 = new NonMember("Alana", 22);
        BondiAirlinesManager.bookSeat(1003, p2);
        
        // Create a non-member senior passenger.
        Passenger p3 = new NonMember("Rosa", 82);
        BondiAirlinesManager.bookSeat(1001, p3);
        
        // Create a non-member passenger.
        Passenger p4 = new NonMember("Maria", 52);
        // Attempt to book a seat on a flight with 0 seats.
        BondiAirlinesManager.bookSeat(1005, p4);
    }
}
