package ing.bnp.traincompany.utils;

import com.google.gson.Gson;
import ing.bnp.traincompany.entities.CustomerTripsPrice;
import ing.bnp.traincompany.entities.DailyTaps;
import ing.bnp.traincompany.entities.Tap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDataMgnmtHelper {

    public static Object retrieveObjFromInputFile(String inputFile, Class currentClass) {
        if (inputFile == null) {
            System.out.println("You must specified an input file path"); // to be tested
            return null;
        }

        Object obj = null;
        try  {
            Path path = Paths.get(inputFile);
            String inputJsonContent = Files.readString(path);

            //Read JSON file
            Gson gson = new Gson();
            if (currentClass != null)
                obj = gson.fromJson(inputJsonContent, currentClass); // to be tested
            else System.out.println("Parametres d appel incorrects pour retrieveObjFromInputFile()");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }


    public static boolean generateTripListToOutputFile(List<CustomerTripsPrice> customerList, String outputFile){
        if (outputFile == null) {
            System.out.println("You must specified output file path"); // to be tested
            return false;
        }
        //...

        return true;
    }


}
