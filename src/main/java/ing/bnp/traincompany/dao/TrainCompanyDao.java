package ing.bnp.traincompany.dao;

import ing.bnp.traincompany.entities.AllTripsPrices;
import ing.bnp.traincompany.entities.CustomerTripsPrice;
import ing.bnp.traincompany.entities.DailyTaps;
import ing.bnp.traincompany.entities.Tap;
import ing.bnp.traincompany.utils.FileDataMgnmtHelper;

import java.util.List;

public class TrainCompanyDao {

    List<Tap> tapsOfTheDay;

    public TrainCompanyDao(){
    }

    public TrainCompanyDao(String inputFile) {
        tapsOfTheDay= ((DailyTaps) FileDataMgnmtHelper.retrieveObjFromInputFile(inputFile, DailyTaps.class)).getTaps();
    }

    public List<Tap> getTapsOfTheDay() {
        return tapsOfTheDay;
    }

    public void retrieveTapsOfTheDayFromInFile(String inputFile) {
        DailyTaps dailyTaps = (DailyTaps) FileDataMgnmtHelper.retrieveObjFromInputFile(inputFile, DailyTaps.class);
        tapsOfTheDay = dailyTaps.getTaps();
    }

    public void storeTripPricesPerCustomer(List<CustomerTripsPrice> tripsPricesPerCustomerList, String outputFile) {
        AllTripsPrices allTripsPrices = new AllTripsPrices();
        allTripsPrices.addCustomerSummaries(tripsPricesPerCustomerList);
        FileDataMgnmtHelper.generateTripListToOutputFile(allTripsPrices, outputFile);
    }
}
