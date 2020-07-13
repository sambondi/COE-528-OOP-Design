package coe528.lab1;

/*
 * Member class implementation.
 * Represents a frequest flyer member.
 * @author Sam Bondi
 */
public class Member extends Passenger {
    // Instance variables
    public int yearsOfMembership;

    // Constructor - Passenger
    public Member(String n, int a, int yom) {
        super(n, a);
        yearsOfMembership = yom;
    }
    
    /**
     * applyDiscount()
     * Overriding abstract class, Passenger's, applyDiscount method.
     * @param p original price
     * @return discountPrice
     */
    @Override
    public double applyDiscount(double p) {
        double discountPrice;
        if (yearsOfMembership > 5) {
            discountPrice = p - (p * 0.5);
            return discountPrice;
        }else if(yearsOfMembership > 1 && yearsOfMembership <= 5) {
            discountPrice = p - (p * 0.1);
            return discountPrice;
        }else{
            System.out.println("Not eligible for discount.");
            discountPrice = p;
            return discountPrice;
        }
    }
}