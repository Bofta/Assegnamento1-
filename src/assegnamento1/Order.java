package assegnamento1;

import javafx.beans.property.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * @author Montasser Ben Rejeb - Omar Stringhini
 * Order describes a product order object.
 */


public class Order {

    private User orderer;
    private Product orderedProduct;
    private IntegerProperty quantity;
    private BooleanProperty shipped;


    /**
     * This constructor generates an empty order.
     *
     * @param orderer
     * @param wantedProduct
     * @param code
     * @param quantity
     * @param shipped
     */
    public Order(User orderer, Product wantedProduct, Integer code, Integer quantity, boolean shipped)
    {
        this.orderer = new User ();
        this.orderedProduct = new Product();
        this.quantity = new SimpleIntegerProperty(0);
        this.shipped = new SimpleBooleanProperty(false);
    }
    /**
     * This constructor generates an order from its data.
     *
     * @param orderer
     * @param orderedProduct
     * @param quantity
     * @param shipped
     */
    public Order(final User orderer, final Product orderedProduct,  final Integer quantity, final boolean shipped){
        this.orderer = orderer;
        this.orderedProduct = orderedProduct;
        this.quantity = new SimpleIntegerProperty(quantity);
        this.shipped = new SimpleBooleanProperty(shipped);
    }


    /**
     * This method returns the user that ordered the product.
     *
     * @return the user
     */
    public User getOrderer() {
        return this.orderer;
    }

    /**
     * This method sets the user that ordered the product.
     *
     * @param orderer
     */
    public void setOrderer(User orderer) {
        this.orderer = orderer;
    }

    /**
     * This method returns the ordered product object.
     *
     * @return the product
     */
    public Product getOrderedProduct() {
        return this.orderedProduct;
    }

    /**
     * This method sets the ordered product.
     *
     * @param orderedproduct
     */
    public void setOrderedProduct(Product orderedproduct) {
        this.orderedProduct = orderedProduct;
    }

    /**
     * This method gets the ordered quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity.get();
    }

    public IntegerProperty quantityProperty(){
        return this.quantity;
    }
    /**
     * This method sets a quantity for the order.
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }


    /**
     * This method returns whether the order was shipped.
     *
     * @return whether the order is shipped
     */
    public boolean isShipped() {
        return this.shipped.get();
    }

    /**
     * This method sets whether the order was shipped or not
     *
     * @param shipped
     */
    public void setShipped(boolean shipped) {
        this.shipped.set(shipped);
    }

    public StringProperty getOrderStatus (){
        String status = this.shipped.getValue() ? "Shipped" : "Confirmed";
        return new SimpleStringProperty(status);
    }
    public BooleanProperty shippedProperty (){
        return this.shipped;
    }

    /**
     * This method generates a string describing the order
     * @return
     */
    @Override
    public String toString() {
        return "Order: " + this.getOrderedProduct() + " effettuato da " + this.getOrderer().getUsername() + " quantità:  " + this.getQuantity() +"\n";
    }
}
