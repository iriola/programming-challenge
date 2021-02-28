package de.exxcellent.challenge.datainput;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Load and read CSV files to be used for further processing.
 * Implements the Reader Interface.
 */
public class CSVReader implements Reader{

    final String CSV_SEPARATOR = ",";


    /**
     * method to load and read a CSV file from resource location and get a list of lists with all elements inside the file.
     * The separator is a <code>CSV_SEPARATOR</code>
     * @param path is the location (path, url,...) where the data is available from
     * @return list of lists with all elements
     */
    @Override
    public List<List<String>> readData(String path) {

        List<List<String>> allElementsFromData = new ArrayList<>();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(path);
            if(inputStream != null){
                InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    String[] values = line.split(CSV_SEPARATOR);
                    allElementsFromData.add(Arrays.asList(values));
                }

            }
        }catch (IOException e){
            System.err.println("Error IOException " + e);

        }catch (IllegalArgumentException e){
            System.err.println("Error IllegalArgumentException " + e);
        }


        return allElementsFromData;
    }
}
