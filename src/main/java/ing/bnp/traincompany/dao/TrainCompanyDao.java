package ing.bnp.traincompany.dao;

import ing.bnp.traincompany.entities.CustomerTripsPrice;
import ing.bnp.traincompany.entities.Tap;
import ing.bnp.traincompany.utils.ReadFile;

import java.util.ArrayList;
import java.util.List;

public class TrainCompanyDao {

    List<Tap> tapsOfTheDay;

    public TrainCompanyDao(String inputFile) {
        tapsOfTheDay = ReadFile.retrieveTapListFromInputFile(inputFile);
    }

    public List<Tap> getTapsOfTheDay() {
        return tapsOfTheDay;
    }

    public void retrieveTapsOfTheDayFromInFile(String inputFile) {
        tapsOfTheDay = ReadFile.retrieveTapListFromInputFile(inputFile);
    }

    public void storeTripPricesPerCustomer(List<CustomerTripsPrice> tripsPricesPerCustomerList, String outputFile) {
        ReadFile.generateTripListToFile(tripsPricesPerCustomerList, outputFile);
    }
}
