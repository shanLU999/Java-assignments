import java.util.Scanner;
import java.util.ArrayList;
/** * Purpose:Project 1 – Parking Spot System: Application class including the main() method and handling all inputs and outputs.
* @author      SHAN LU <103528518> 
* @version     JDK 1.8  
* @date        Created on 11 September 2021                 
*/
public class Application{

/** *
 * Call displayMenu method and make option
 *
*/
    public static void main() {
        int option = 0;
        Scanner sc = new Scanner(System.in);
        while (option != 7) {
            displayMenu();
            option = sc.nextInt();
            sc.nextLine(); //skip ‘\n’
            
            if (option == 1) {                
                CarPark.addParkingSlot();//call addParkingSlot method from CarPark cass
            }else if (option == 2) {
                CarPark.removeSlot();//call removeSlot method from CarPark cass
            }else if (option == 3) {
                CarPark.showList();//call showList method from CarPark cass
            }else if (option == 4) {
                CarPark.parkNewCar();//call parkNewCar method from CarPark cass
            }else if (option == 5) {
                CarPark.findCar();//call findCar method from CarPark cass
            }else if (option == 6) {
                CarPark.removeCar();//call removeCar method from CarPark cass
            }else if (option == 7) {
                System.exit(0);break;
            }

        }
    }

/** *
 * A method to out print the menu
 *
*/
    public static void displayMenu(){
        System.out.println("Please select one of the following options:");
        System.out.println("1. Add a car slot.");
        System.out.println("2. Delete a parking slot by slot ID (only if not occupied).");
        System.out.println("3. List all slots.");
        System.out.println("4. Park a car into a slot.");
        System.out.println("5. Find a car by registration number.");
        System.out.println("6. Remove a car by registration number");
        System.out.println("7. Exit");
    }

}

