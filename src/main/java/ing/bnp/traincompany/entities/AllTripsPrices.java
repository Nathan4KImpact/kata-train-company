package ing.bnp.traincompany.entities;

import java.util.ArrayList;
import java.util.List;

public class AllTripsPrices {
    List<CustomerTripsPrice> customerSummaries;

    public AllTripsPrices() {
        this.customerSummaries = new ArrayList<>();
    }


    public List<CustomerTripsPrice> getCustomerSummaries() {
        return customerSummaries;
    }

    public void addCustomerSummaries(List<CustomerTripsPrice> custSummaries){
        customerSummaries.addAll(custSummaries);
    }
    @Override
    public String toString() {
        return "AllTripsPrices{" +
                "customerSummaries=" + customerSummaries.toString() +
                '}';
    }
}
