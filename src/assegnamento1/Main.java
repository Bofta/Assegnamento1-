/**
 * @author Montasser Ben Rejeb - Omar Stringhini
 */

package assegnamento1;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // User(User class) and Admin(Employee) initialization

        User alberto = new User("albzan", "nhu345");
        User massimo = new User("maxacqua", "ert675");
        User joe = new User("sleepyJoe","maga2021");
        Employee monta = new Employee("montasser","montapassword");



        ArrayList<User> users = new ArrayList<User>();
        users.add(alberto);
        users.add(massimo);
        users.add(joe);

        Employee enrico = new Employee("Enrico", "buonasera");
        ArrayList<Employee> employee = new ArrayList<Employee> ();
        employee.add(enrico);

        System.out.println(users);
        System.out.println(employee);


        // Products initialization and their data


        Product schermo = new Product("Bravia" , "Sony" , 1 , 700.00 , 100);
        Product mouse = new Product("MX518" ,"Logitech" , 2 , 40.00 , 200 );

        HashMap<Product,InventoryItem> products = new HashMap<Product,InventoryItem>();
        products.put(schermo, new InventoryItem(1,100));
        products.put(mouse, new InventoryItem(2,200));

        for (java.util.Map.Entry<Product, InventoryItem> productInventoryItemEntry : products.entrySet()) {
            System.out.println(productInventoryItemEntry);
        }



        // Shop initialization

        Shop shop = new Shop(products , employee , users);
        shop.login(joe.getUsername() , joe.getPassword());
        joe.checkLogin(joe.getPassword());
        joe.orderProduct(mouse , shop, 2 , 10);

        // Verify if registered user in the shop (enrico registered -> True )
        System.out.println(shop.isRegistered(enrico.username, enrico.password ));
        // Verify if a non registered user in the shop (monta non registered -> False )
        System.out.println(shop.isRegistered(monta.username, monta.password ));

        // user order a product and get notified if it has been added succesfuly or not
        shop.orderProduct(joe , schermo , 1 , 10);
        System.out.println("Orders : " + joe.getMyOrders(shop));
        joe.searchProduct("MX518");

        shop.addProduct(enrico,"MX518" , 1);
        System.out.println(shop.stringAllProducts());

        shop.stringAllProducts();


        AdminDash monta_dash_admin = new AdminDash(monta , shop);
        monta_dash_admin.mainMenu();

        products.toString();






    }
}