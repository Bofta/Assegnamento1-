
/**
 * @author Montasser Rajeb - Omar Stringhini
 */


package assegnamento1;


/**
 * Product describes a single type of product.
 */
public class Product {

    private String name_Product;
    private String producer_Product;
    private Integer code_Product;
    private double price_Product;

    /**
     * This constructor generates an empty Product object
     */
    public Product() {
        this.name_Product = "";
        this.producer_Product = "";
        this.code_Product = 0;
        this.price_Product = 0;
    }

    /**
     * This constructor generates a Product object by its properties
     *
     * @param name_Product
     * @param producer_Product
     * @param code_Product
     * @param price_Product
     */
    public Product(final String name_Product, final String producer_Product, final Integer code_Product , final double price_Product) {
        this.name_Product = name_Product;
        this.producer_Product = producer_Product;
        this.code_Product = code_Product;
        this.price_Product = price_Product;
    }

    /**
     * This method gets the product name
     *
     * @return the name
     */
    public String getName() {
        return this.name_Product;
    }

    /**
     * This method sets the product name
     *
     * @param name_Product
     */
    public void setName(final String name_Product) {
        this.name_Product = name_Product;
    }

    /**
     * This method gets the products's producer's name
     *
     * @return the notes
     */
    public String getProducer_Product() {
        return this.producer_Product;
    }

    /**
     * This method sets the product producer's name
     *
     * @param producer_Product
     */
    public void setProducer_Product(final String producer_Product) {
        this.producer_Product = producer_Product;
    }

    /**
     * This method gets the product's code
     *
     * @return the product
     */
    public Integer getCode_Product() {
        return this.code_Product;
    }

    /**
     * This method sets the product's code
     *
     * @param code_Product
     */
    public void setCode_Product(final Integer code_Product) {
        this.code_Product = code_Product;
    }

    /**
     * This method checks if two products are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return (name_Product.equals(product.name_Product)) && (producer_Product.equals(product.producer_Product)) && (code_Product.equals(product.code_Product));
    }

    /**
     * This method generates a string describing the product
     */
    @Override
    public String toString() {
        return "----PRODUCT----" + " name='" + getName() + "'\n" + "producer='" + getProducer_Product() + "'\n" + " code='" + getCode_Product() + "'\n" + "\n";
    }
}