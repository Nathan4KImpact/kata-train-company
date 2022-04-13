import ing.bnp.traincompany.entities.CustomerTripsPrice;
import ing.bnp.traincompany.service.BillingForAllCustomersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class BillingForAllCustomersTest  {

    static String inputFile;
    static BillingForAllCustomersService service;
    static List<CustomerTripsPrice> tripsPricesPerCustomerExpectedData;
    static List<CustomerTripsPrice> tripsPricesPerCustomerList;

    @BeforeAll
    static void setUp(){
        inputFile = ""; // provide here
        tripsPricesPerCustomerExpectedData = new ArrayList<>(); // to be provided here
        Collections.sort(tripsPricesPerCustomerExpectedData);
        tripsPricesPerCustomerList = service.computeBillingForAllCustomers(inputFile);
        Collections.sort(tripsPricesPerCustomerList);

    }

    /*
      The list of expected data and the list of expected result should have the same length
     */
    @Test
    public void test_ListLength() {
        Assertions.assertFalse(tripsPricesPerCustomerList.size() != tripsPricesPerCustomerExpectedData.size());
    }

    /*
     *  Test case final : The list of expected prices per customer should be equal to the computed prices list
     */
    @Test
    public void test_BillAllCustomers() {

        Optional<CustomerTripsPrice> optDiffPrice = IntStream.range(0, tripsPricesPerCustomerList.size() - 1)
                        .filter(i-> ! tripsPricesPerCustomerList.get(i).equals(tripsPricesPerCustomerExpectedData.get(i)))
                        .mapToObj(tripsPricesPerCustomerList::get)
                        .findAny();
        Assertions.assertTrue(optDiffPrice.isEmpty());
    }
}
