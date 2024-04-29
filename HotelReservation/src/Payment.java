public class Payment {
    private double amount;
    private String paymentMethod;

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void processPayment() {
        // Simulate payment processing (e.g., charging credit card, handling cash payment)
        System.out.println("Processing payment of $" + amount + " via " + paymentMethod + "...");
        // Add more logic here based on the actual payment processing requirements
        System.out.println("Payment processed successfully!");
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
