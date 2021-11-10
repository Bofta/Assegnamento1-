/**
 * @author Montasser Ben Rejeb - Omar Stringhini
 */


package assegnamento1;

import java.util.*;

public class Shop {

    public String name;
    public HashMap<String, Integer> products;
    public ArrayList<Employee> employees;
    public ArrayList<User> users;
    public ArrayList<Order> orders;
    public ArrayList<Request> requestedProducts;

    public Shop(String s) {
        this.name = s;
        this.products = new HashMap<String, Integer>();
        this.employees = new ArrayList<Employee>();
        this.users = new ArrayList<User>();
        this.orders= new ArrayList<Order>();
        this.requestedProducts= new ArrayList<Request>();

    }

    public Shop(final HashMap<Product, InventoryItem> products, final ArrayList<Employee> employees, final ArrayList<User> users){
        this.products = new HashMap<String, Integer>();
        this.employees = new ArrayList<Employee>(employees);
        this.users = new ArrayList<User> (users);
        this.orders= new ArrayList<Order>();
        this.requestedProducts= new ArrayList<Request>();
    }

    public Shop() {

    }


    /**
     * This method gets the Shop's name
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method sets the Shop's name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets the Shop's products
     *
     * @return the products
     */
    public HashMap<String, Integer> getProducts(){
        return this.products;
    }

    /**
     * This method sets the Shop's products
     *
     * @param products
     */
    public void setProducts(HashMap<Product,InventoryItem> products) {
        this.products = new HashMap<String, Integer>();
    }

    /**
     * This method gets the Shop's employees
     *
     * @return the employees
     */
    public ArrayList<Employee> getemployees(){
        return this.employees;
    }

    /**
     * This method sets the Shop's employees
     *
     * @param employees
     */
    public void setemployees(ArrayList<Employee> employees) {
        Collections.copy(this.employees, employees);
    }

    /**
     * This method gets the Shop's members
     *
     * @return the members
     */
    public ArrayList<User> getUsers(){
        return this.users;
    }

    /**
     * This method sets the Shop's requested products
     *
     * @param requestedProducts
     */
    public void setRequestedProducts(ArrayList<Request> requestedProducts) {
        Collections.copy(this.requestedProducts, requestedProducts);
    }

    /**
     * This method gets the Shop's requested products
     *
     * @return the requests
     */
    public ArrayList<Request> getRequestedProducts(){
        return this.requestedProducts;
    }
    /**
     * This method sets the Shop's users
     *
     * @param members
     */
    public void setMembers(ArrayList<User> members) {
        Collections.copy(this.users, members);
    }

    /**
     * This method gets the Shop's orders
     *
     * @return the orders
     */
    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void orderProduct (User orderer, Product wantedProduct, Integer Code, Integer quantity){
        this.orders.add(new Order(orderer, wantedProduct, Code, quantity, false));
    }





    public boolean isRegistered(String username, String password) {
        for(Person temp : this.users) {
            if(temp.getUsername().equals(username) && temp.getPassword().equals(password)) {
                return true;
            }
        }
        for(Person temp : this.employees) {
            if(temp.getUsername().equals(username) && temp.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public Person login (String username, String password){
        // First, we check if the person is a normal user (more frequent)
        for (User user: this.users) {
            if (username.equals(user.getUsername())) {
                if (user.checkLogin(password)){
                    return user;
                }
            }
        }
        // If not, let's check if it's a employee
        for (Employee employee: this.employees) {
            if (username.equals(employee.getUsername())) {
                if (employee.checkLogin(password)){
                    return employee;
                }
            }
        }
        return null;
    }

    public void requestProduct(User requester, String toRequest) {
        this.requestedProducts.add(new Request(requester, toRequest));
    }

    /**
     * This method ships the ordered products
     *
     * @param authorizer
     */

    public void shipProducts (Employee authorizer) {
        for (Order tempOrder: this.orders){
                if (!tempOrder.isShipped())
                {
                    tempOrder.setShipped(true);
                    System.out.println("Succesfully shipped product: " + tempOrder.getOrderedProduct().getName());
                }

                else {
                    System.out.println("Error with order: "+ tempOrder.getOrderedProduct().getName()+"; Refill the warehouse first.");
                }
        }
    }

    /**
     * This method adds multiple products
     *
     * @param authorizer
     * @param name_Product
     * @param quantity
     */
    public void addProduct(Employee authorizer, String name_Product, Integer quantity) {
        //guardo se authorizer è un seller
        if(!this.employees.contains(authorizer)) {
            return;
        }
        if(this.products.containsValue(name_Product)) {
            this.products.put( name_Product , quantity);
        }

        // We can't use a foreach loop to remove elements, so let's use an iterator instead
        Iterator<Request> it = this.requestedProducts.iterator();
        while(it.hasNext()){
            Request temp = it.next();
            if (temp.checkIfRequested(getName())){
                it.remove();
            }
        }

        System.out.println("Prodotto "+ name_Product +" aggiunto con successo  da " + authorizer.getUsername());
    }

    /**
     * This method returns the orders a user has made
     *
     * @param requester
     * @return the orders
     */

    public ArrayList<Order> getOrdersForUser (User requester) {
        if(!this.users.contains(requester)) {
            return null;
        }
        ArrayList<Order> orders = new ArrayList<Order>();
        for (Order tempOrder: this.orders) {
            if (requester.equals(tempOrder.getOrderer())){
                orders.add(tempOrder);
            }
        }
        return orders;
    }

    /**
     * This method looks for products by their name
     * @param loggedIn
     * @param input_name_product ;
     * @return*/
    public HashMap<Product, InventoryItem> findProductsName(Person loggedIn, String input_name_product) {
        for (String p_name_iterator : products.keySet()) {
            if (p_name_iterator == input_name_product ) {
                System.out.println("Prodotto :" + input_name_product +" già esistente in products list");
            }
            else {
                System.out.println("Prodotto non esistente nel product list");
            }
        }
        return null;
    }

    /**
     * This method looks for products by their code
     * @param input_code_prooduct;
     * */

    public void findProductsCode(String input_code_prooduct) {
        for (String p_name_iterator : products.keySet()) {
            if (p_name_iterator == input_code_prooduct ) {
                System.out.println("Prodotto :" + input_code_prooduct +" già esistente in products list");
            }
            else {
                System.out.println("Prodotto non esistente nel product list");
            }
        }
    }

    /**
     * This method returns a string with all the products in inventory
     *
     * @return the string
     */
    public String stringAllProducts() {
        String returnedString = "";
        returnedString += "Products:\n";
        for (Map.Entry<String, Integer> productItem: this.getProducts().entrySet()) {
            returnedString += productItem.getKey().toString() + "\n" + productItem.getValue().toString();
        }
        return returnedString;
    }



}






















