package ooprog;
import java.util.*;

public class Inventory extends InventoryOperation {
    ArrayList<product> prods = new ArrayList<>();

    @Override
    public void addProduct(product product) {
       prods.add(product);
       System.out.println("Product added: " + product.getProductName() + " with quantity Of: " + product.getQuantity());
       
    }

    @Override
    public void removeProduct(String productId) throws InsufficientStockException {
        for(product product : prods){
            if (product.getProductId().equals(productId)) {
                prods.remove(product);
                System.out.println();
                System.out.println("Product removed: " + productId);
                return;
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'removeProduct'");
    }
    
   
}
