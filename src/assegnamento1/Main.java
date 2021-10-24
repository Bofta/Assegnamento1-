/**
 * @author Montasser Rajeb - Omar Stringhini
 */

package assegnamento1;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Person FirstPerson = new Person();
        FirstPerson.setUsername("Elon Musk");
        FirstPerson.setPassword("A unhashable passoword ");

        Employee enrico = new Employee("Enrico", "buonasera");

        User alberto = new User("albzan", "nhu345");
        User massimo = new User("maxacqua", "ert675");
        User joe = new User("sleepyJoe","maga2021");

        ArrayList<User> users = new ArrayList<User>();
        users.add(alberto);
        users.add(massimo);
        users.add(joe);

        ArrayList<Employee> employee = new ArrayList<Employee> ();
        employee.add(enrico);


        Product JvD_tastieraRed = new Product("JvD Tastiera Red", "Zagabri Srl", 224, 169.89);

        HashMap<Product,InventoryItem> products = new HashMap<Product, InventoryItem>();
        products.put(JvD_tastieraRed, new InventoryItem(224,1256));

        Shop store = new Shop(products, employee, users);
        store.login(massimo.getUsername(),massimo.getPassword());

        System.out.println(store.getShopData(enrico));
        System.out.println(FirstPerson.username);
        System.out.println(FirstPerson.password);

    }
}