package assegnamento1;

import java.util.*;

public class Shop {

    private String name;
    private HashMap<assegnamento1.Product, assegnamento1.InventoryItem> products;
    private ArrayList<Employee> employees;
    private ArrayList<User> users;
    private ArrayList<Order> orders;
    private ArrayList<Request> requestedProducts;

    public Shop() {
        this.name = "";
        this.products = new HashMap<assegnamento1.Product, assegnamento1.InventoryItem>();
        this.employees = new ArrayList<Employee>();
        this.users = new ArrayList<User>();
        this.orders= new ArrayList<Order>();
        this.requestedProducts= new ArrayList<Request>();

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
     * This method gets the Shop's wines
     *
     * @return the products
     */
    public HashMap<Product,InventoryItem> getWines(){
        return this.products;
    }

    /**
     * This method sets the Shop's products
     *
     * @param products
     */
    public void setProducts(HashMap<Product,InventoryItem> products) {
        this.products = new HashMap<Product,InventoryItem>(products);
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
     * This method gets the Shop's requested wines
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
     * This method looks for wines in the DB by their name
     *
     * @param authorizer
     * @param toSearch
     * @return the results
     */
    public HashMap<Product,InventoryItem> findProductsName(Person authorizer, String toSearch){
        if (!(this.users.contains(authorizer)||this.employees.contains(authorizer))) {
            return null;
        }
        HashMap<Product, InventoryItem> searched = new HashMap<>();
        for(Map.Entry<Product,InventoryItem> temp : this.products.entrySet()) {
            if(toSearch.equals(temp.getKey().getName())) {
                searched.put(temp.getKey(), temp.getValue());
            }
        }
        return searched;
    }





    public void addProduct(Employee authorizer, Product toAdd, Integer code_Product , Integer quantity) {
        //guardo se authorizer è un employee
        if(!this.employees.contains(authorizer)) {
            return;
        }
        // We can't use a foreach loop to remove elements, so let's use an iterator instead
        Iterator<Request> it = this.requestedProducts.iterator();
        while(it.hasNext()){
            Request temp = it.next();
            if (temp.checkIfRequested(toAdd.getName())){
                it.remove();
            }
        }

        System.out.println("Prodotto aggiunto con successo: " + toAdd.getName() + " del " + code_Product);
    }



    /**
     * This method orders a new product
     *
     * @param orderer
     * @param wantedProduct
     * @param code_Product
     * @param quantity
     */


    /**
     * This method ships the ordered products
     *
     * @param authorizer
     */



    /**
     * This method returns the orders a user has made
     *
     * @param requester
     * @return the orders
     */


    /**
     * This method returns all the shop data in a string
     *
     * @param loggedIn
     * @return the resulting string
     */
    public String getShopData(Person loggedIn) {
        //verifico authorizer
        if(!this.employees.contains(loggedIn)) {
            return "";
        }
        String returnedString;
        returnedString = "Shop: "+this.getName()+"\n";
        returnedString += "\nUSERS:\n";
        for (User printingUser: this.getUsers()) {
            returnedString += printingUser.toString();
        }
        returnedString += "\nEMPLOYEES::\n";
        for (Employee printingAdmin: this.getemployees()) {
            returnedString += printingAdmin.toString();
        }

        returnedString += "\nORDERS:\n";
        for (Order printingOrder: this.getOrders()) {
            returnedString += printingOrder.toString();
        }
        return returnedString;
    }

    /**
     * This method adds a new single wine to the database
     *
     * @param authorizer
     * @param toAdd
     * @param code_Product
     */
    public void addProduct(Employee authorizer, Product toAdd, Integer code_Product) {
        //guardo se authorizer è un seller
        if(!this.employees.contains(authorizer)) {
            return;
        }

        else {
            this.products.put(toAdd,new InventoryItem(code_Product,Integer.valueOf(1)));
        }
        for (Request temp: this.requestedProducts) {
            if (temp.checkIfRequested(toAdd.getName())){
                this.requestedProducts.remove(temp);
            }
        }
        System.out.println("Prodotto aggiunto con successo: " + toAdd.getName() + " del " + code_Product);
    }

    /**
     * This method returns a string with all the wines in inventory
     *
     * @return the string
     */
    public String stringAllProducts () {
        String returnedString = "";
        returnedString += "PRODUCTS:\n";
        for (Map.Entry<Product, InventoryItem> productItem: this.getWines().entrySet()) {
            returnedString += productItem.getKey().toString() + "\n" + productItem.getValue().toString();
        }
        return returnedString;
    }
}