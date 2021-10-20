package assegnamento1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Login contains helper methods to login a user and generate its dashboard.
 */
public class Login {

    /**
     * This method returns a dashboard given a user and a shop.
     *
     * @param username
     * @param password
     * @param shop
     *
     * @return the dashboard.
     */
    private static Dash logIntoShop (String username, String password, Shop shop) {
        Person loggingIn = shop.login(username, password);
        if (loggingIn == null){
            return null;
        }
        if (loggingIn instanceof User)
            return new UserDash(new User(loggingIn), shop);
        else if (loggingIn instanceof Employee)
            return new AdminDash(new Employee(loggingIn), shop);
        else
            return null;
    }

    /**
     * This method generates the UI to log the user in.
     *
     * @param shop
     */
    public static void loginPage(Shop shop) {
        System.out.println("Please insert username: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        System.out.println("Please insert password: ");
        String username = input;
        try {
            input = reader.readLine();
        } catch (IOException exc) {
            System.out.println("IOEXception thrown. Exiting now.");
            return;
        }
        String password = input;
        if(shop.isRegistered(username, password)) {
            Dash db = Login.logIntoShop(username, password, shop);
            db.mainMenu();
        } else {
            System.out.println("Attenzione! Username o password non corrette, riprovare.\n");
            loginPage(shop);
        }


    }
}
