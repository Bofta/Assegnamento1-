package assegnamento1;

/**
 * Request is made from a user when he wants a specific product.*
 */
public class Request {
    private User requester;
    private String productName;

    /**
     * This constructor generates an empty request
     */
    public Request (){
        this.requester = new User();
        this.productName = "";
    }
    /**
     * This constructor generates a request from its user and the product name
     *
     * @param requester
     * @param productName
     */
    public Request (User requester, String productName){
        this.requester = requester;
        this.productName = productName;
    }

    /**
     * This method returns the requester
     *
     * @return the requester
     */
    public User getRequester() {
        return this.requester;
    }

    /**
     * This method sets the product requester
     *
     * @param requester
     */
    public void setRequester(User requester) {
        this.requester = requester;
    }

    /**
     * This method gets the product name
     *
     * @return the name
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * This method sets the product name
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method checks if a newly arrived product was requested by someone. If it was, it notifies the user.
     *
     * @param addedProduct
     * @return whether the wine was requested once.
     */
    public boolean checkIfRequested (String addedProduct) {
        if (addedProduct.equals(this.productName)) {
            this.requester.notifyProductAdded();
            return true;
        }
        return false;
    }
}
