package assegnamento1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
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
                    System.out.println("Function to ship products");
                case 2:
                    this.addProduct();
                    break;
                case 3:
                    this.printRequests();
                    break;
                case 4:
                    this.printShop();
                    break;
            }
        } while (!action.equals(0));
    }

    /**
     * UI to ship the ordered products.
     *
     */


    /**
     * UI to add a new product
     *
     */
    private void addProduct() {
        System.out.println("Is the item already in our database? [Y/N]");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        if (input.equals("Y")){
            this.refillWarehouse();
        } else if (input.equals("N")) {
            this.addNewProduct();
        }else {
            System.out.println("Wrong input.");
            return;
        }
    }

    /**
     * UI to add products quantities.
     *
     */
    private void refillWarehouse (){
        System.out.print("Insert name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        HashMap<Product,InventoryItem> foundProduct = this.shop.findProductsName(this.loggedIn, input);
        if (foundProduct == null) {
            System.out.println("Wine not found. Sorry.");
        } else {
            for(Map.Entry<Product, InventoryItem> productEntry: foundProduct.entrySet()) {
                System.out.println(productEntry.getKey().toString());
                System.out.println("Wanna refill it? Y/N:");
                try {
                    input = reader.readLine();
                } catch (IOException exc) {
                    System.out.println("IOEXception thrown. Exiting now.");
                    return;
                }
                if (input.equals("N"))
                    continue;


                System.out.println("What code_Product are we refilling? ");
                try {
                    input = reader.readLine();
                } catch (IOException exc) {
                    System.out.println("IOEXception thrown. Exiting now.");
                    return;
                }
                Integer code_Product;
                try{
                    code_Product = Integer.valueOf(input);
                } catch (NumberFormatException nfex) {
                    System.out.println("Wrong value inserted.");
                    return;
                }
                System.out.println("How much? ");
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

            }

        }
    }

    /**
     * UI to add a non-existent product.
     *
     */
    private void addNewProduct () {
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

        System.out.println("Insert product: ");
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        String vine = input;

        System.out.println("Insert notes: ");
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        String notes = input;

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

    }

    /**
     * UI that prints all the requests made by users.
     *
     */
    private void printRequests () {
        for (Request request: this.shop.getRequestedProducts()){
            System.out.println("Request:\n" + request.getProductName()+"\nBy: "+request.getRequester().getUsername()+"\n");
        }
    }

    /**
     * UI that prints all the saved data.
     */
    private void printShop() {
        System.out.println(this.shop.getShopData(this.loggedIn));
    }
}
