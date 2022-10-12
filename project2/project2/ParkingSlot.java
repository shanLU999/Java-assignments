/** * Purpose:Project 2 – Parking Spot System: ParkingSlot Class set up slots variables.
* @author      SHAN LU <103528518> 
* @version     JDK 1.8  
* @date        Created on 11 September 2021                 
*/

public class ParkingSlot {

    private String id;
    private boolean staffMember = false;
    private Car car;
/** *
 * Creates new instances of parking slot
 *
*/
    public ParkingSlot(String newId, boolean staffMember, Car car) {
       this.id = newId;
       this.staffMember = staffMember;
       this.car =null;
    }
    
/** *
 * set id
 *
*/
    public void setId(String id) {
        this.id = id;
    }

/** *
 * Return id
 *
*/
    
    public String getId(){
        return id;
    }
    
/** *
 * retrun boolean value to present if it is a staff slot
 *
*/
    public boolean isStaffMember(){
        return staffMember;
    }

/** *
 * retrun boolean value to present if the slot is occupied
 *
*/
    public boolean isOccupied() {
        return car != null;
    }
    
/** *
 * set car
 *
*/
    public void parkCar(Car car) {
        this.car = car;
    }

/** *
 * when remove car set car to null
 *
*/
    public void removeCar() {
        this.car = null;
    }
    
/** *
 * Return car
 *
*/    public Car getCar(){
        return car;
    }
    
/** *
 * Return the string to display slots
 *
*/    public String toString(){
        String staffName = "";
        if(staffMember){
            staffName = "Staff Parking Slot";
        }else{
            staffName = "Visitor Parking Slot";
        }
        return id + "  " + staffName + "  " + car;
    }
    
    
}