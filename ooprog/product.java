package ooprog;
//Encapsulation
public class product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public product(String productId,String productName,int quantity,double price ){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    //getters
    public String getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getPrice(){
        return price;
    }
    //setters
    public void setQuantity(int quantity){
        if (quantity >= 0) {
            this.quantity = quantity;
        }else
           throw new InvalidQuantityException(" Quantity Cannot be Negative");
    }

    public void setPrice(double Price){
        this.price = price;
    }
}


