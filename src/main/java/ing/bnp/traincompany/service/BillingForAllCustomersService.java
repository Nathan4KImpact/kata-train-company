package ing.bnp.traincompany.service;

import ing.bnp.traincompany.entities.CustomerTripsPrice;
import ing.bnp.traincompany.entities.Tap;
import ing.bnp.traincompany.utils.ReadFile;

import java.math.BigDecimal;
import java.util.List;

public class BillingForAllCustomersService {

    public static List<CustomerTripsPrice> tripsPricesPerCustomerList;

    public static void computeBillingForAllCustomersFromFile(String inputFile, String outputFile) {
        List<Tap> tapsOfTheDay = ReadFile.retrieveTapListFromInputFile(inputFile);

        tripsPricesPerCustomerList = computeBillingForAllCustomers(tapsOfTheDay);

        ReadFile.generateTripListToFile(tripsPricesPerCustomerList, outputFile);

    }

    public static  List<CustomerTripsPrice> computeBillingForAllCustomers(List<Tap> tapsOfTheDay) {
        List<CustomerTripsPrice> tripsPricesPerCustomerList;
        tapsOfTheDay.stream()
                .forEach(tap -> {

                });

        return null;
    }
}
