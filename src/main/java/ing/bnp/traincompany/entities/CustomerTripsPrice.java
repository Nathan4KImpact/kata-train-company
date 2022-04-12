package ing.bnp.traincompany.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerTripsPrice implements Comparable<CustomerTripsPrice> {
    private Customer customer;
    protected List<Trip> trips = new ArrayList<>();
    private BigDecimal totalCostInCents;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public BigDecimal getTotalCostInCents() {
        return totalCostInCents;
    }

    public void setTotalCostInCents(BigDecimal totalCostInCents) {
        this.totalCostInCents = totalCostInCents;
    }

    @Override
    public int compareTo(CustomerTripsPrice o) {
        return this.totalCostInCents.compareTo(o.getTotalCostInCents());
    }

    @Override
    public String toString() {
        return "CustomerTripsPrice{" +
                "customer=" + customer +
                ", totalCostInCents=" + totalCostInCents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerTripsPrice that = (CustomerTripsPrice) o;
        return customer.equals(that.customer) && totalCostInCents.equals(that.totalCostInCents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, totalCostInCents);
    }
}
