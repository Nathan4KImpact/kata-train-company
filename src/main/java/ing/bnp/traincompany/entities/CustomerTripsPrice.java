package ing.bnp.traincompany.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerTripsPrice {
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

}
