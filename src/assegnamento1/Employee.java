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
     * This method adds a single product to the shop.
     *
     * @param newProduct
     * @param code_Product
     * @param shop
     */
    public void addProducts(Product newProduct, Integer code_Product, Shop shop) {
        shop.addProduct(this, newProduct, code_Product);
    }
}