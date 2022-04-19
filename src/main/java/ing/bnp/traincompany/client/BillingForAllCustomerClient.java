package ing.bnp.traincompany.client;

import ing.bnp.traincompany.service.BillingForAllCustomersService;

public class BillingForAllCustomerClient {

    static BillingForAllCustomersService service = new BillingForAllCustomersService();

    public static void main(String[] args) {
        String inputFile = args[0] != null ? args[0] : null;

        if (args.length == 0){
            System.out.println("You have specified no entry "); // to be tested
        }
        else if (args.length > 2)
            System.out.println("You have specified more entry than needed"); // to be tested
        else if (!( inputFile instanceof String))
            System.out.println("You have specified a wrong path as entry, please check again..."); // to be tested

        if(service.computeBillingForAllCustomers(inputFile).size() > 0 ) {
            String outputFile = args[1] != null ? args[1]: null;
            if (outputFile instanceof String){
                System.out.println("You have specified a wrong path as entry, please check again..."); // to be tested
                service.storeTripPrices(outputFile);
            }
        }
        else System.out.println("Your Customer Trips of the Day list is empty !");

    }

}
