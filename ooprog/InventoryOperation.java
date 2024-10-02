package ooprog;

abstract class InventoryOperation {
   public abstract void addProduct(product product);
   public abstract void removeProduct(String productId) throws InsufficientStockException;
   
}
