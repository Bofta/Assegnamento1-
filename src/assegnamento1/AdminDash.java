package assegnamento1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Montasser Ben Rejeb - Omar Stringhini
 * Class with methods to display an admin UI.
 */
public class AdminDash extends Dash{

    /**
     * Constructor for the dashboard. Logs a user in.
     *
     * @param loggingIn the user
     * @param shop 		the shop we're working on
     */
    public AdminDash(Employee loggingIn, Shop shop){
        super(loggingIn, shop);
    }

    /**
     * Prints the main menu and calls the right functions
     *
     */
    public void mainMenu(){
        Integer action = null;
        do {
            System.out.println("Welcome back to work.\n0) Exit\n1) Ship orders\n2) Add product\n3) Check requests\n4) Print all data\n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                action = Integer.valueOf(reader.readLine());
            } catch (IOException exc) {
                System.out.println("IOEXception thrown. Exiting now.");
                return;
            }
            switch (action) {
                case 1:
                    this.shipProduct();
                case 2:
                    this.addNewProduct();
                    break;
                case 3:
                    System.out.println("3rd option");
                    break;
                case 4:
                    this.shop.stringAllProducts();
                    break;
            }
        } while (!action.equals(0));
    }

    /**
     * UI to ship the ordered products.
     *
     */
    private void shipProduct(){
        System.out.println("Shipping Products!");
        new Employee(this.loggedIn).shipOrders(this.shop);
        System.out.println("Finished shipping orders.");
    }


        private void addNewProduct() {
            System.out.print("Insert name: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = "";
            try {
                input = reader.readLine();
            } catch (IOException exc) {
                System.out.println("IOEXception thrown. Exiting now.");
                return;
            }
            String name = input;

            System.out.println("Insert producer: ");
            try {
                input = reader.readLine();
            } catch (IOException exc) {
                System.out.println("IOEXception thrown. Exiting now.");
                return;
            }
            String producer = input;

            System.out.println("Insert quantity: ");
            try {
                input = reader.readLine();
            } catch (IOException exc) {
                System.out.println("IOEXception thrown. Exiting now.");
                return;
            }
            Integer quantity;
            try{
                quantity = Integer.valueOf(input);
            } catch (NumberFormatException nfex) {
                System.out.println("Wrong value inserted.");
                return;
            }
            System.out.println("Insert price: ");
            try {
                input = reader.readLine();
            } catch (IOException exc) {
                System.out.println("IOEXception thrown. Exiting now.");
                return;
            }
            double price;
            try{
                price = Integer.valueOf(input);
            } catch (NumberFormatException nfex) {
                System.out.println("Wrong value inserted.");
                return;
            }

            System.out.println("Insert code: ");
            try {
                input = reader.readLine();
            } catch (IOException exc) {
                System.out.println("IOEXception thrown. Exiting now.");
                return;
            }
            Integer code;
            try{
                code = Integer.valueOf(input);
            } catch (NumberFormatException nfex) {
                System.out.println("Wrong value inserted.");
                return;
            }

            this.shop.addProduct(new Employee(this.loggedIn),name, quantity);
        }






}
