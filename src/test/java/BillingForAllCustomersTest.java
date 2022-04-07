import ing.bnp.traincompany.service.BillingForAllCustomersService;
import ing.bnp.traincompany.utils.ReadFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BillingForAllCustomersTest extends AbstractTrainCompanyData {
    @BeforeAll
    static void setUp(){
        outputFileWithExpectedValues = "";// provide path from cmd
        outputFileWithComputedValues = "";// provide path
    }

    @Test
    public void test_BillAllCustomers(){
        BillingForAllCustomersService.computeBillingForAllCustomers(outputFileWithExpectedValues , outputFileWithComputedValues);
        Assertions.assertTrue(
                ReadFile.compare(outputFileWithExpectedValues , outputFileWithComputedValues)
        );
    }
}
