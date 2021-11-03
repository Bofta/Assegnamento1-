/**
 * @author Montasser Rajeb - Omar Stringhini
 */

package assegnamento1;

/**
 * Employee is a superuser that works for the shop.
 */
public class Employee extends Person{

    /**
     * This constructor generates an empty employee.
     */
    public Employee() {
        super();
    }
    /**
     * This constructor generates a employee from its username and password.
     *
     * @param username
     * @param password
     */
    public Employee(String username, String password) {
        super(username, password);
    }
    /**
     * This constructor generates a Seller from a generic Person.
     *
     * @param person
     */
    public Employee (Person person){
        super(person.getUsername(), person.getPassword());
    }


    /**
     * This method ships the ordered products.
     *
     * @param shop
     */
    public void shipOrders (Shop shop) {
        shop.shipProducts(this);
    }
    /**
     * This method adds a new product to the shop with an arbitrary quantity.
     *
     * @param newProduct
     * @param quantity
     * @param shop
     */
    public void addProducts(Product newProduct, Integer quantity, Shop shop) {
        shop.addProduct(newProduct, quantity);
    }



}