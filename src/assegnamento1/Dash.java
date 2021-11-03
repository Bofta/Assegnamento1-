package assegnamento1;

    /**
     * @author Montasser Ben Rejeb - Omar Stringhini
     * This class describes a generic dashboard.
     */

    public class Dash {
        protected Person loggedIn;
        protected Shop shop;

        /**
         * This constructor generates an empty dashboard.
         */
        public Dash() {
            this.loggedIn = new Person();
            this.shop = new Shop();
        }

        /**
         * This constructor logs a user in a Shop.
         *
         * @param loggingIn
         * @param shop
         */
        public Dash(Person loggingIn, Shop shop) {
            this.loggedIn = loggingIn;
            this.shop = shop;
        }

        /**
         * This method is implemented in subclasses.
         */
        public void mainMenu() {
        }
    }

