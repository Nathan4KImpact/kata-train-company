package ing.bnp.traincompany.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ing.bnp.traincompany.entities.AllTripsPrices;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

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


    public static boolean generateTripListToOutputFile(AllTripsPrices allTripsPrices, String outputFile){
        if (outputFile == null) {
            System.out.println("You must specified output file path"); // to be tested
            return false;
        }

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String jsonString = gson.toJson(allTripsPrices);

        try {
            Path outputPath = Paths.get(outputFile);
            Files.writeString (outputPath, jsonString, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


}
