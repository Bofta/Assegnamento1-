package assegnamento1;

import java.util.ArrayList;
import java.util.HashMap;

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
}