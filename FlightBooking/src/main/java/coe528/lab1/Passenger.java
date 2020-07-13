package coe528.lab1;

/*
 * Passenger class implementation.
 * @author Sam Bondi
 */
public abstract class Passenger {
    // Instance variables
    String name;
    int age;
    
    // Constructor                                                                                                                                                                                          
    public Passenger (String n, int a) {
        name = n;
        age = a;
    }
    
    // Getters
    /**
     * getName()
     * @return Name
     */
    public String getName(){
        return name;
    }
    /**
     * getAge()
     * @return Age
     */
    public int getAge(){
        return age;
    }
    
    // Setters
    /**
     * setName()
     * @param n name
     */
    public void setName(String n){
        name = n;
    }
    /**
     * setAge()
     * @param a age
     */
    public void setAge(int a){
        age = a;
    }
    
    /**
     * applyDiscount()
     * To be overwritten by subclasses, Member and NonMember, to apply a discount.
     * @param p original price
     * @return discountPrice;
     */
    public abstract double applyDiscount(double p);
}
