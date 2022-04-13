package ing.bnp.traincompany.service;

import ing.bnp.traincompany.dao.TrainCompanyDao;
import ing.bnp.traincompany.entities.CustomerTripsPrice;
import ing.bnp.traincompany.utils.ReadFile;

import java.util.List;
import java.util.stream.Collectors;

public class BillingForAllCustomersService {

    static TrainCompanyDao dao;
    public static List<CustomerTripsPrice> tripsPricesPerCustomerList;
    CustomerTripsPrice customerTripPrice;

    public List<CustomerTripsPrice> computeBillingForAllCustomers(String inputFile) {
        dao.retrieveTapsOfTheDayFromInFile(inputFile);
        tripsPricesPerCustomerList =
            dao.getTapsOfTheDay()
                    .stream()
                    .map(tap -> {
                        customerTripPrice = null;

                        return customerTripPrice;
                    })
                    .collect(Collectors.toList());

        return null;
    }

    public void storeTripPrices(String outputFile) {
        dao.storeTripPricesPerCustomer(tripsPricesPerCustomerList, outputFile);
    }
}
