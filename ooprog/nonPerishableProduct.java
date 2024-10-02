package ooprog;

public class nonPerishableProduct extends product{
    private int shelfLife;

    public nonPerishableProduct(String productId, String productName, int quantity, double price, int shelfLife){
        super(productId, productName, quantity, price);
        this.shelfLife = shelfLife;
    }

    public int getShelfLife(){
        return shelfLife;
    }

    public void setShelfLife(int shelfLife){
        this.shelfLife = shelfLife;
    }

    public void updateStock(int amount)  {
        if (getQuantity() + amount < 0) {
            throw new InsufficientStockException("Insufficient stock for product " + getProductName());
        }
        setQuantity(getQuantity() + amount);
        System.out.println("Stock updated: " + getProductName() + ", New Quantity: " + getQuantity());
    }
}

