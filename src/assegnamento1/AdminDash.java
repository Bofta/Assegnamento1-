package assegnamento1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Montasser Ben Rejeb - Omar Stringhini
 * Class with methods to display an admin UI.
 */
public class AdminDash extends Dash{

    /**
     * Constructor for the dashboard. Logs a user in.
     *
     * @param loggingIn the user
     * @param shop 		the shop we're working on
     */
    public AdminDash(Employee loggingIn, Shop shop){
        super(loggingIn, shop);
    }

    /**
     * Prints the main menu and calls the right functions
     *
     */
    public void mainMenu(){
        Integer action = null;
        do {
            System.out.println("Welcome back to work.\n0) Exit\n1) Ship orders\n2) Add product\n3) Check requests\n4) Print all data\n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                action = Integer.valueOf(reader.readLine());
            } catch (IOException exc) {
                System.out.println("IOEXception thrown. Exiting now.");
                return;
            }
            switch (action) {
                case 1:
                    System.out.println("Function to ship products");
                case 2:
                    System.out.println("2nd option");
                    break;
                case 3:
                    System.out.println("3rd option");
                    break;
                case 4:
                    System.out.println("Manca una funzione per stampare i dati del shop");
                    break;
            }
        } while (!action.equals(0));
    }











}
