package assegnamento1;

/**
 * @author Montasser Ben Rejeb - Omar Stringhini
 * Class with methods to display a user UI.

 */
public class UserDash extends Dash{

    /**
     * This constructor generates a dashboard from the user and the shop
     *
     * @param loggingIn
     * @param shop
     */
    public UserDash (User loggingIn, Shop shop){
        super(loggingIn, shop);
    }

    /**
     * This method prints the main menu
     */
    /*
    public void mainMenu(){
        Integer action = 0;
        do {
            System.out.println("Welcome to the shop \n0) Exit\n1) Search product by name\n2) Search product by code\n3) Print all products\n4) Request product");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                action = Integer.valueOf(reader.readLine());
            } catch (IOException exc) {
                System.out.println("IOEXception thrown. Exiting now.");
                return;
            }
            switch (action) {
                case 1:

                    this.searchProductByName();
                    break;
                case 2:
                    this.searchProductByCode();
                    break;
                case 3:
                    this.printAllProducts();
                    break;
                case 4:
                    this.requestProduct();
                    break;
            }

                     } while (!action.equals(0));
                     */
    }




