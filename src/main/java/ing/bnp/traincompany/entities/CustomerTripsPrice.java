package ing.bnp.traincompany.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerTripsPrice implements Comparable<CustomerTripsPrice> {
    private int customerId;
    private BigDecimal totalCostInCents;
    protected List<Trip> trips;

    public CustomerTripsPrice() {
        trips =  new ArrayList<>();
        totalCostInCents = BigDecimal.ZERO;
    }

    public int getCustomerId() {
        return customerId;
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
                "customerId=" + customerId+ ", " +
                "totalCostInCents=" + totalCostInCents + ", " +
                //"trips =" + Arrays.toString(trips.toArray()) +
                "trips =" + trips.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerTripsPrice that = (CustomerTripsPrice) o;
        return customerId == that.customerId && totalCostInCents.equals(that.totalCostInCents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, totalCostInCents);
    }
}
