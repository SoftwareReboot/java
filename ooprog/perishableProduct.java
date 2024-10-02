package ooprog;

public class perishableProduct extends product {
    private String expirationDate;

    public perishableProduct(String productId, String productName, int quantity, double price, String expirationDate){
        super(productId, productName, quantity, price);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate(){
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }

    public void updateStock(int amount)  {
        if (amount < 0) {
            throw new InsufficientStockException(" Insufficient Stock for the Product: " + getProductName());
        }
        if (getQuantity() + amount > 100) {
            throw new IllegalArgumentException("Cannot exceed maximum quantity of 100 for perishable products.");
        }
        setQuantity(getQuantity() + amount);
        System.out.println("Stock updated: " + getProductName() + ", New Quantity: " + getQuantity());
    }
}

