import ing.bnp.traincompany.entities.AllTripsPrices;
import ing.bnp.traincompany.entities.DailyTaps;
import ing.bnp.traincompany.service.BillingForAllCustomersService;
import ing.bnp.traincompany.utils.FileDataMgnmtHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class BillingForAllCustomersTest  {

    static String inputFile;
    static String outputFile;
    static BillingForAllCustomersService service = new BillingForAllCustomersService();
    static DailyTaps tapListData;
    static AllTripsPrices tripsPricesExpectedData, tripsPricesRetrieved = new AllTripsPrices();

    @BeforeAll
    static void setUp(){
        inputFile = "D:\\MesPROJETS\\Ingeniance\\devs\\kata-train-company\\src\\main\\resources\\CandidateInputExample.txt"; // provide here
        outputFile = "D:\\MesPROJETS\\Ingeniance\\devs\\kata-train-company\\src\\main\\resources\\CandidateOutputExample.txt"; // provide here

        tapListData = (DailyTaps)
                FileDataMgnmtHelper.retrieveObjFromInputFile(inputFile, DailyTaps.class);

        tripsPricesExpectedData = (AllTripsPrices)
                FileDataMgnmtHelper.retrieveObjFromInputFile(outputFile, AllTripsPrices.class);

        if(tripsPricesRetrieved.getCustomerSummaries().size() > 0)
        Collections.sort(tripsPricesExpectedData.getCustomerSummaries());

        tripsPricesRetrieved.addCustomerSummaries(
                service.computeBillingForAllCustomers(inputFile)
        );
        if(tripsPricesRetrieved.getCustomerSummaries().size() > 0)
            Collections.sort(tripsPricesRetrieved.getCustomerSummaries());

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
    public void test_ExpectedListVsRetrievedListLength() {
       Assertions.assertFalse(
               tripsPricesRetrieved.getCustomerSummaries().size() != tripsPricesExpectedData.getCustomerSummaries().size()
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
