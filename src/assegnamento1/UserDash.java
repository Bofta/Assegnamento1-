package assegnamento1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class with methods to display a user UI.

 */
public class UserDash extends Dash{

    /**
     * This constructor generates a dashboard from the user and the shop
     *
     * @param loggingIn
     * @param shop
     */
    public UserDash (User loggingIn, Shop shop){
        super(loggingIn, shop);
    }

    /**
     * This method prints the main menu
     */
    public void mainMenu(){
        Integer action = 0;
        do {
            System.out.println("Welcome to the shop \n0) Exit\n1) Search product by name\n2) Search product by year\n3) Print all products\n4) Request product");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                action = Integer.valueOf(reader.readLine());
            } catch (IOException exc) {
                System.out.println("IOEXception thrown. Exiting now.");
                return;
            }
            switch (action) {
                case 1:
                    this.searchProductByName();
                    break;
                case 2:
                    this.searchProductByYear();
                    break;
                case 3:
                    this.printAllProducts();
                    break;
                case 4:
                    this.requestProduct();
                    break;
            }
        } while (!action.equals(0));
    }

    /**
     * This method searches a product by its name
     */
    private void searchProductByName (){
        System.out.print("Insert name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        HashMap<Product, InventoryItem> foundProduct = this.shop.findProductsName(this.loggedIn, input);
        if (foundProduct == null) {
            System.out.println("Wine not found. Sorry.");
        } else {
            for(Map.Entry<Product, InventoryItem> productEntry: foundProduct.entrySet()) {
                System.out.println(productEntry.getKey().toString());
                System.out.println(productEntry.getValue().toString());
                System.out.println("Wanna buy it? Y/N:");
                try {
                    input = reader.readLine();
                } catch (IOException exc) {
                    System.out.println("IOEXception thrown. Exiting now.");
                    return;
                }
                if (input.equals("Y"))
                    this.orderWine(productEntry.getKey());
            }
        }
    }
    /**
     * This method searches a wine by its name
     */
    private void requestProduct (){
        System.out.print("Insert name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        this.shop.requestProduct(new User(this.loggedIn), input);
    }
    /**
     * This method orders a product
     *
     * @param product
     */
    private void orderProduct(Shop product){
        System.out.print("Year: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        Integer year = Integer.valueOf(input);
        System.out.print("How much: ");
        input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        Integer quantity = Integer.valueOf(input);
        new User(this.loggedIn).orderProduct(product, this.shop, year, quantity);
    }

    /**
     * This method searches a product by its code
     */
    private void searchProductByCode (){
        System.out.print("Insert product code : ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        ArrayList<Product> foundProductsArray = new ArrayList();
        HashMap<Product,InventoryItem> foundProducts = this.shop.findWinesYear(new User(this.loggedIn), Integer.valueOf(input));
        if (foundProducts == null) {
            System.out.println("Wine not found. Sorry.");
        } else {
            System.out.println("Found! ");
            for (Map.Entry<Shop,InventoryItem> foundProduct : foundProducts.entrySet()){
                System.out.println(foundProduct.getKey().toString());
                System.out.println(foundProduct.getValue().toString());
                foundProductsArray.add(foundProduct.getKey());
            }
            System.out.println("Wanna buy one? [#/N]: ");
            try {
                input = reader.readLine();
            } catch (IOException exc) {
                System.out.println("IOEXception thrown. Exiting now.");
                return;
            }
            if (input.equals("N"))
                return;
        }
        Integer orderingProduct = 0;
        try {
            orderingProduct = Integer.valueOf(input);
        } catch (NumberFormatException nfex){
            System.out.println("Non-numeric value inserted.");
            return;
        }
        this.orderProduct(foundProductsArray.get(orderingProduct));
    }
    /**
     * This method prints all the wines
     */
    public void printAllProducts() {
        System.out.println(this.shop.stringAllWines());
    }
}
