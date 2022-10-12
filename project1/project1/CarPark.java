import java.util.ArrayList;
import java.util.Scanner;

 

/** * Purpose:Project 1 – Parking Spot System: CarPark: Maintain a list of available parking slots.
* @author      SHAN LU <103528518> 
* @version     JDK 1.8  
* @date        Created on 11 September 2021                 
*/






public class CarPark {
    private static ArrayList<ParkingSlot> slots =new ArrayList<ParkingSlot>();       

   
/** *
 * Add parking slot method to add slot into system.
*/    

    public static void addParkingSlot() {
        String psID; //initial new variables
        boolean isStaff = false;
        Car car = null;
        Scanner sc = new Scanner(System.in);
            do{
                
                System.out.println("Please enter a parking slot ID which starts with a capital letter, followed by a two-digit number e.g. \"D01\"");
                psID = sc.nextLine();                    
            }while(!psID.matches("[A-Z][0-9]{2}"));//only if input mathches the format will the codes continue                    
                
            System.out.println("Is the slot added for a staff member(Y for yes, N for no)?");
            if(sc.nextLine().toUpperCase().charAt(0) == 'Y'){
                isStaff = true;//it is a staff slot
            }else if (sc.nextLine().toUpperCase().charAt(0) == 'N'){
                isStaff = false;//itis a visitor slot
            }
        
        ParkingSlot newslot = new ParkingSlot(psID, isStaff,car);
        slots.add(newslot);//add the new slot to the array
    }
    
/** *
 * remove parking slot method to remove slot is the slot exist and is not occupied.
*/
    public static void removeSlot(){
        String psID;//new variables
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Please enter a parking slot ID.");
            psID = sc.nextLine();                    
        }while(!psID.matches("[A-Z][0-9]{2}"));//only if input mathches the format will the codes continue
            
        for(int i = 0; i < slots.size(); i++){
            ParkingSlot slot = slots.get(i);//define every elements in the array
            String id = slot.getId();//get the slot ID from ParkingSlot class
            if(id.equals(psID)) {
                if(slot.isOccupied() == true) {//if the slot is occupied the slot cannot be delete
                    System.out.println("Slot cannot be deleted because is occupied");
                }
                else {
                    slots.remove(i);//remove the slot from array
                    System.out.println("You have successfully removed the slot.");
                }
            }
        }
        
    }
    
/** *
 * showList()method to list out all the slots int the system
*/
    public static void showList(){//show all the elements in the array
        for(int i = 0; i < slots.size(); i++){
            ParkingSlot ps = slots.get(i);//define every elements in the array
            System.out.println(ps.toString());//out print evry slot details by the method in ParkingSlot class
        }
    }
    
/** *
 * Park a car into a slot:A parking slot cannot be deleted if there is a car being parked there
 *Visitor car can only be parked in a visitor slot and staff car can only be parked in a staff slot
*/
    public static void parkNewCar(){
        Scanner sc = new Scanner(System.in);
        String registrationNumber;   //initial variables will be used 
        String owner;
        
        
        
        do {
            System.out.println("Please enter your register number.");
            registrationNumber = sc.nextLine();
        }while(!registrationNumber.matches("[A-Z][0-9]{4}"));//only if input mathches the format will the codes continue
        
       
        
        System.out.println("Please enter the name of the car owner.");
        owner = sc.nextLine();
        
        
        
        Car car = new Car(registrationNumber,owner);//initial the car from Car class
        
        System.out.println("Is the car owner a staff member or a visitor? Type in \"S\" as staff member, \"V\" as visitor.");
        String identity = sc.nextLine();boolean b = false;//set the boolean will be used in following steps
        if(identity.toUpperCase().charAt(0) == 'S'){
        b=true;}//prepared for check if the boolean from ParkingSlot class mathces this boolean value
        
        for(int i = 0; i < slots.size(); i++){// print out all the empty slot 
                ParkingSlot ps = slots.get(i);//define every elements in the array
                if(!ps.isOccupied()&&ps.isStaffMember()==b)//slot empty && input boolean equals staffMember boolean in ParkingSlot class
                System.out.println(ps.toString());//print out all the slot matches the isStaffMember
            }
        
        System.out.println("Please select a slot that you would like to park in.");
        
        String slotID = sc.nextLine();
        
        if(!haslot(slotID)){//if slot not exist 
            System.out.println("The slot does not exist in the system.");
        }

        for(int i = 0; i < slots.size(); i++){//the car will be park into the slot given
                ParkingSlot ps = slots.get(i);
                if(ps.getId().equals(slotID)&&!ps.isStaffMember()==b){
                    System.out.println("Visitor car can only be parked in a visitor slot and staff car can only be parked in a staff slot.");
                    break;//break out if the car type doesn't match the slot type
                }else if(ps.getId().equals(slotID)&&ps.isStaffMember()==b&&ps.isOccupied()){
                    System.out.println("The slot is already occupied.");
                    break;//break out if the slot is occupied
                    
                }else if(ps.getCar() != null&&ps.getCar().getRegistrationNumber().equals(registrationNumber)){
                    System.out.println("The car cannot be parked as a car can only be parked in one slot.");
                    break;//nreak out if the registration ID already exist
                }else if(ps.getId().equals(slotID)&&ps.isStaffMember()==b&&!ps.isOccupied()){
                    ps.parkCar(car);//successfully chage the car status in slots array
                    System.out.println("You have successfully parked a car.");
                    break;
                }
            }
        }
    
/** *
 * Find the owner and slot ID of a car which has been parked
 *
*/
    public static void findCar(){
        Scanner sc = new Scanner(System.in);
        String registrationNumber;   //initial variable
                
        do {
            System.out.println("Please enter the register number of the car.");
            registrationNumber = sc.nextLine();
        }while(!registrationNumber.matches("[A-Z][0-9]{4}"));//stop user here if the input does not matches the format
        
        for(int i =0; i < slots.size(); i++){
            ParkingSlot ps = slots.get(i);//define the elements of the slot array
            if (ps.getCar().getRegistrationNumber().equals(registrationNumber))
            {
                String psID = ps.getId();//assign the value slot ID from ParkingSlot class 
                String owner = ps.getCar().getOwner();//assign the owner from Car class
                
                System.out.println("The car with register number of " + registrationNumber + " is parked on the lot: " + psID + ", and the owner of the car is: " + owner);
                
            }else if(!ps.getCar().getRegistrationNumber().equals(registrationNumber)){
                System.out.println("The car does not exist in the system.");//if the registration number does not exist alert user
            }
        }
    }

/** *
 * Remove car from slot.
 *
*/
    public static void removeCar(){
        Scanner sc = new Scanner(System.in);
        String registrationNumber;//initial variables
        
        do {
            System.out.println("Please enter the register number of the car.");
            registrationNumber = sc.nextLine();
        }while(!registrationNumber.matches("[A-Z][0-9]{4}"));//keep user here if the input does not match format
        
        for(int i =0; i < slots.size(); i++){
            ParkingSlot ps = slots.get(i);//define element in slot array
            if (ps.getCar().getRegistrationNumber().equals(registrationNumber))
            {
                ps.removeCar();//call remove method from ParkingSlot class
                System.out.println("You have successfully removed the car.");
                break;
            }else if(!ps.getCar().getRegistrationNumber().equals(registrationNumber)){
                System.out.println("The car does not exist in the system.");//alert user if the registraion number not exist
            }
        }
    }
    
/** *
 * Return a boolean value is the slot exist in the system
 *
*/
    public static boolean haslot(String slotId){
        
        for(int i =0; i < slots.size(); i++){
            ParkingSlot ps = slots.get(i); //define the element i slot
            if (ps.getId().equals(slotId)){
            return true;//retrun true if the slot exist
            }
        }
        return false;
    } 
}