package ing.bnp.traincompany.entities;

public class Customer {
    private int customerId;
    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                '}';
    }
}
