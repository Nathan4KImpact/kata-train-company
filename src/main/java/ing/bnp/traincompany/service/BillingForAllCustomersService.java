package ing.bnp.traincompany.service;

import ing.bnp.traincompany.entities.Tap;
import ing.bnp.traincompany.utils.ReadFile;

import java.util.List;

public class BillingForAllCustomersService {

    public static void computeBillingForAllCustomers(String inputFile, String outputFile) {
        List<Tap> tapsOfTheDay = ReadFile.retrieveTapListFromInputFile(inputFile);
        tapsOfTheDay.stream()
                .forEach(tap -> {

                });

    }
}
