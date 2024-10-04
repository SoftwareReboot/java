package polymorphism;

public class PayPalPayment extends Payment {
    private String email;
    
    
    public PayPalPayment(String email){
        this.email = email;
    }

    //override
        public void processPayment(){
            System.out.println(" Processing payment...");
            System.out.println(" Paypal Email: " + email);
        }

}