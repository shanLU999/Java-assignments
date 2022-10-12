
/**
 *
 * @author wlai
 */

import java.util.ArrayList;

/**
 *
 * @author wlai
 */
import java.util.Scanner;

public class VehicleHireApp {

    /**
     * main method
     */

    public static void main(String[] args) {
        // TODO code application logic here
        // Create the vehicle types
        VehicleType sedan = new VehicleType("SEDAN", "A standard sedan", 4);
        VehicleType limo6 = new VehicleType("LIMO6", "A six seater limo", 6);
        VehicleType limo8 = new VehicleType("LIMO8", "An eight seater limo", 8);
        // Create the vehicles
        ArrayList<Vehicle> vehicles = new ArrayList();
        vehicles.add(new Vehicle("Ed's Holden Caprice", "Silver", sedan, 2002));
        vehicles.add(new Vehicle("John's Mercedes C200", "Black", sedan, 2005));
        vehicles.add(new Vehicle("Guy's Volvo 244 DL", "Blue", sedan, 1976));
        vehicles.add(new Vehicle("Sasco's Ford Limo", "White", limo6, 2004));
        vehicles.add(new Vehicle("Peter's Ford Limo", "Red", limo6, 2003));
        vehicles.add(new Vehicle("Robert's Ford Limo", "White", limo8, 2002));
        System.out.println("\nList of vehicles in system:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle); //output format is based on Vechicle's toString()
        }

        Scanner sc = new Scanner(System.in);
        int option = 0;

        System.out.println("\nIt will display a list of vehicles based on the vehicle type you choose:");
        while (option != 4) {
            displayMenu();
            option = sc.nextInt();
            sc.nextLine(); //skip ‘\n’

            // switch statement that invokes the various methods of the class based on the option
            // selected by the user
            switch (option) {
                case 1: showVehicle(vehicles, "SEDAN"); break;
                case 2: showVehicle(vehicles, "LIMO6"); break;
                case 3: showVehicle(vehicles, "LIMO8"); break;
                case 4: System.exit(0);break;
                default:
                System.out.println();
                System.out.println("Please enter a valid option 1 to 4.");
            }

        } //end while
    }

    /**
     *  method for displaying a menu
     */
    public static void displayMenu() {
        System.out.println("1: SEDAN");
        System.out.println("2: LIMO6");
        System.out.println("3: LIMO8");
        System.out.println("4: Exit");
        System.out.print("Please select an option (1-4): ");
    }

    /**
     *  method for showing the list of vehicle with the same vehicle type
     */
    public static void showVehicle(ArrayList<Vehicle> vehicles, String typeCode) {
        System.out.println("List of vehicle of type " + typeCode +":");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().getCode().equals(typeCode)) {
                System.out.println(vehicle);
            }
        }
    }

}
