/**
 * @author Montasser Rajeb - Omar Stringhini
 */

package assegnamento1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
     * @author Montasser Ben Rejeb - Omar Stringhini
     * User is a simple user that can buy products from the shop.
     */
    public class User extends Person{

        /**
         * This constructor generates an empty user
         */
        public User () {
        }
        /**
         * This constructor generates a user from its username and password
         *
         * @param username
         * @param password
         *
         */
        public User (String username, String password ) {
            super(username, password);
        }
        /**
         * This constructor generates a user from a generic person
         *
         * @param user
         */
        public User(Person user){
            super(user.getUsername(), user.getPassword());
        }

        /**
         * This method notifies the user of a newly arrived product. In real life, it could send an email.
         */
        public void notifyProductAdded () {
            System.out.println("Il prodotto  richiesto da "+ this.getUsername() + " e' stato aggiunto.");
                return;
        }

        /**
         * This method orders a Product from the Shop.
         *
         * @param wantedProduct
         * @param shop
         * @param Code
         * @param quantity
         */
        public void orderProduct (final Product wantedProduct, final Shop shop, final Integer Code, final Integer quantity){
            shop.orderProduct(this, wantedProduct, Code , quantity);
        }
        /**
         * This method returns the user's orders
         *
         * @param  shop
         * @return the orders
         */
        public ArrayList<Order> getMyOrders (final Shop shop) {
            return shop.getOrdersForUser(this);
        }


        /**
         * This method adds a product to the list of request
         *
         * @param requestedProduct
         * @param shop
         */
        public void requestProduct (String requestedProduct, Shop shop) {
            shop.requestProduct(this, requestedProduct);
            return;
        }



        public void searchProduct (String research){
            HashMap<Product,InventoryItem> products = new HashMap<Product,InventoryItem>();
            Iterator<Product> it = products.keySet().iterator();
            while(it.hasNext()) {
                System.out.println(it.next());
            }


        }
    }



