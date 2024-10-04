package polymorphism;


public class CreditCardPayment extends Payment {
    private int cardNumber;
    private String cardHolderName;
    private int expirationDate;
    private String cvv;

    public CreditCardPayment(int cardNumber2,  String cardHolderName, int expirationDate2, String cvv){
        this.cardNumber = cardNumber2;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate2;
        this.cvv = cvv;
    }

    
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
        System.out.println("Cardholder: " + cardHolderName);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiration Date: " + expirationDate);
        // Logic to process the payment can be added here
    }
}