package ing.bnp.traincompany.client;

import ing.bnp.traincompany.service.BillingForAllCustomersService;

public class BillingForAllCustomerClient {

    static BillingForAllCustomersService service;

    public static void main(String[] args) {
        String inputFile = args[0];
        String outputFile = args[1];

        if (args.length > 2)
            System.out.println("You have specified more entry than needed"); // to be tested
        if (( inputFile == null) || (outputFile == null))
            System.out.println("You must specified an input fil path and an output file path"); // to be tested
        if (!( inputFile instanceof String) || !(outputFile instanceof String))
            System.out.println("You have specified a wrong path as entry, please check again..."); // to be tested

        service.computeBillingForAllCustomers(inputFile);
        service.storeTripPrices(outputFile);

    }

}
