/** * Purpose:Project 1 – Parking Spot System: Car class: set up car variables
* @author      SHAN LU <103528518> 
* @version     JDK 1.8  
* @date        Created on 11 September 2021                 
*/

public class Car {

    private String registrationNumber;   
    private String owner;
/** *
 * Initialize instance variables
 *
*/
    public Car(String newregistrationNumber, String newOwner) {
        
        this.registrationNumber = newregistrationNumber;
        this.owner = newOwner;
    }

/** *
 * set registration number
 *
*/
    public void setRegistrationNumber(String registrationNumber)  {
        this.registrationNumber = registrationNumber;
    }

/** *
 * return registration number
 *
*/    
    public String getRegistrationNumber()  {
        return registrationNumber;
    }

/** *
 * set owner
 *
*/ 
    public void setOwner(String owner)  {
        this.owner = owner;
    }

/** *
 * return owner
 *
*/     
    public String getOwner() {
        return owner;
    }

/** *
 * display registration number in slot
 *
*/     public String toString() {
        return registrationNumber;
    }
}