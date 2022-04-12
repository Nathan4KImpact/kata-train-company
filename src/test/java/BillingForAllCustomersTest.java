import ing.bnp.traincompany.entities.CustomerTripsPrice;
import ing.bnp.traincompany.service.BillingForAllCustomersService;
import ing.bnp.traincompany.utils.ReadFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class BillingForAllCustomersTest extends AbstractTrainCompanyData {
    @BeforeAll
    static void setUp(){
        tapsOfTheDaySampleData = null;// provide a list
        tripsPricesPerCustomerExpectedData = null;// provide a list
    }

    @Test
    public void test_BillAllCustomers() {
        List<CustomerTripsPrice> tripsPricesPerCustomerList = BillingForAllCustomersService.computeBillingForAllCustomers(tapsOfTheDaySampleData);
        Collections.sort(tripsPricesPerCustomerList);
        Collections.sort(tripsPricesPerCustomerExpectedData);

        Assertions.assertFalse(tripsPricesPerCustomerList.size() != tripsPricesPerCustomerExpectedData.size());

        Optional optDiffPrice = IntStream.range(0, tripsPricesPerCustomerList.size() - 1)
                        .filter(i-> ! tripsPricesPerCustomerList.get(i).equals(tripsPricesPerCustomerExpectedData.get(i)))
                        .mapToObj(tripsPricesPerCustomerList::get)
                        .findAny();

        Assertions.assertTrue(optDiffPrice.isEmpty());

    }
}
