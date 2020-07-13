package coe528.lab1;

/*
 * Implementaion of NonMember class.
 * Represents a flyer who is not a frequent flyer.
 * @author Sam Bondi
 */
public class NonMember extends Passenger{

    public NonMember(String n, int a) {
        super(n, a);
    }

    /**
     * applyDiscount()
     * Overriding abstract class, Passenger's, applyDiscount method.
     * @param p original price
     * @return discountPrice;
     */
    @Override
    public double applyDiscount(double p) {
        double discountPrice;
        if (this.age > 65) {
            System.out.println(this.name + " meets the age requirement of > 65. A 10% discount applied.");
            discountPrice = p - (p * 0.1);
            return discountPrice;
        }else{
            System.out.println(this.name + " does not meet the age requirement of > 65. No discount applied.");
            discountPrice = p;
            return discountPrice;
        }
    }
    
}
