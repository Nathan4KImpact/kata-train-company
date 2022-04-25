package ing.bnp.traincompany;
import ing.bnp.traincompany.entities.AllTripsPrices;
import ing.bnp.traincompany.entities.DailyTaps;
import ing.bnp.traincompany.service.BillingForAllCustomersService;
import ing.bnp.traincompany.utils.FileDataMgnmtHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Collections;
import java.util.ResourceBundle;

public class BillingForAllCustomersTest  {

    static String inputFile;
    static String outputFile;
    static String outputFileSample;
    static BillingForAllCustomersService service = new BillingForAllCustomersService();
    static DailyTaps tapListData;
    static AllTripsPrices tripsPricesExpectedData, tripsPricesComputed = new AllTripsPrices();

    @BeforeAll
    static void setUp(){
        //final ResourceBundle config = ResourceBundle.getBundle("ing.bnp.traincompany.resources.config");
        //inputFile = config.getString("inputFileSample");
        //outputFileSample = config.getString("outputFileSample"); //"D:\\MesPROJETS\\Ingeniance\\devs\\kata-train-company\\src\\main\\resources\\CandidateOutputExample.txt";
        //outputFile = config.getString("outputFile"); //"D:\\MesPROJETS\\Ingeniance\\devs\\kata-train-company\\src\\main\\resources\\CandidateOutput.txt";

        inputFile = "D:\\MesPROJETS\\Ingeniance\\kata-specs\\clients\\bnp\\CandidateInputExample.txt";
        outputFile = "D:\\MesPROJETS\\Ingeniance\\kata-specs\\clients\\bnp\\CandidateOutput.txt";
        outputFileSample = "D:\\MesPROJETS\\Ingeniance\\kata-specs\\clients\\bnp\\CandidateOutputExample.txt";

        tapListData = (DailyTaps)
                FileDataMgnmtHelper.retrieveObjFromInputFile(inputFile, DailyTaps.class);

        tripsPricesExpectedData = (AllTripsPrices)
                FileDataMgnmtHelper.retrieveObjFromInputFile(outputFileSample, AllTripsPrices.class);

        if(tripsPricesExpectedData.getCustomerSummaries().size() > 0)
        Collections.sort(tripsPricesExpectedData.getCustomerSummaries());

        tripsPricesComputed.addCustomerSummaries(
                service.computeBillingForAllCustomers(inputFile)
        );
        if(tripsPricesComputed.getCustomerSummaries().size() > 0)
            Collections.sort(tripsPricesComputed.getCustomerSummaries());

    }

    /*
      The list of input data sample should be equal to 16
     */
    @Test
    public void test_TapListLength() {
        Assertions.assertEquals(16, tapListData.getTaps().size());
    }


    /*
     The list of expected data and the list of expected result should have the same length
    */
    @Test
    public void test_ComputedListToJson() {
        Assertions.assertTrue(
                FileDataMgnmtHelper.generateTripListToOutputFile(tripsPricesExpectedData, outputFile)
        );
    }

    /*
      The list of expected data and the list of expected result should have the same length
     */
    @Test
    public void test_ExpectedListVsRetrievedListLength() {
       Assertions.assertFalse(
               tripsPricesComputed.getCustomerSummaries().size() != tripsPricesExpectedData.getCustomerSummaries().size()
       );
    }

    /*
     *  Test case final : The list of expected prices per customer should be equal to the computed prices list
     */

    /* @Test
   public void test_BillAllCustomers() {

        Optional<CustomerTripsPrice> optDiffPrice = IntStream.range(0, tripsPricesPerCustomerList.size() - 1)
                        .filter(i-> ! tripsPricesPerCustomerList.get(i).equals(tripsPricesPerCustomerExpectedData.get(i)))
                        .mapToObj(tripsPricesPerCustomerList::get)
                        .findAny();
        Assertions.assertTrue(optDiffPrice.isEmpty());


    } */

 }
