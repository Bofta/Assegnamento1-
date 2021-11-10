/**
 * @author Montasser Ben Rejeb - Omar Stringhini
 */

package assegnamento1;

import java.util.HashMap;
import java.util.Map;

/**
 * InventoryItem describes the inventory entries for a single product.

 */
public class InventoryItem {

    public HashMap<Integer,Integer> code_Product , quantity;



    /**
     * This constructor generates an empty inventory.
     * @param name_Product
     * @param quantity
     */
    public InventoryItem(String name_Product, Integer quantity) {
        this.code_Product = new HashMap<Integer,Integer>();
    }

    /**
     * This constructor generates an inventory item with just a code possessed.
     *
     * @param code_Product
     * @param quantity
     */
    public InventoryItem(Integer code_Product, Integer quantity) {
        this.code_Product = new HashMap<Integer,Integer>();
        this.code_Product.put(Integer.valueOf(code_Product),Integer.valueOf(quantity));
    }

    /**
     * This constructor generates the InventoryItem from a HashMap.
     *
     * @param code_Product
     */
    public InventoryItem(HashMap<Integer,Integer> code_Product) {
        this.code_Product = new HashMap<Integer,Integer>(code_Product);
    }

    /**
     * This method returns a quantity for a specific code_Product.
     *
     * @param code_Product
     *
     * @return the quantity
     */
    public Integer getQuantityForcode_Product(final Integer code_Product) {
        return this.code_Product.get(quantity);
    }

    /**
     * This method adds/removes a quantity from the inventory.
     *
     * @param quantity
     * @param toSum
     *
     * @return whether the sum was ok
     */
    public boolean sumQuantity(Integer quantity, Integer toSum) {
        if (! this.code_Product.containsKey(quantity)) {
            this.code_Product.put(quantity, 0);
        }
        if((this.code_Product.get(quantity)+toSum)<0) {
            return false;
        }
        this.code_Product.put(quantity, toSum + this.code_Product.get(quantity));
        return true;
    }

    /**
     * This method generates a string that describes the inventory for a product.
     */
    @Override
    public String toString() {
        String returnable = "Quantities:\n";
        for (Map.Entry<Integer, Integer> inventory: this.code_Product.entrySet()) {
            returnable += (inventory.getKey()+": "+inventory.getValue())+"\n";
        }
        return returnable;
    }


}