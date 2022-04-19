package ing.bnp.traincompany.service;

import ing.bnp.traincompany.dao.TrainCompanyDao;
import ing.bnp.traincompany.entities.CustomerTripsPrice;

import java.util.List;
import java.util.stream.Collectors;

public class BillingForAllCustomersService {

    static TrainCompanyDao dao = new TrainCompanyDao();
    public static List<CustomerTripsPrice> tripsPricesPerCustomerList;
    CustomerTripsPrice customerTripPrice;

    public List<CustomerTripsPrice> computeBillingForAllCustomers(String inputFile) {
        dao.retrieveTapsOfTheDayFromInFile(inputFile);
        tripsPricesPerCustomerList =  dao.getTapsOfTheDay()
                    .stream()
                    .map(tap -> {
                        customerTripPrice = new CustomerTripsPrice();

                        return customerTripPrice;
                    })
                    .collect(Collectors.toList());

        return tripsPricesPerCustomerList;
    }

    public void storeTripPrices(String outputFile) {
        dao.storeTripPricesPerCustomer(tripsPricesPerCustomerList, outputFile);
    }
}
