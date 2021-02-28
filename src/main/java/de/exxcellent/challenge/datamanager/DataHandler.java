package de.exxcellent.challenge.datamanager;

import de.exxcellent.challenge.datainput.CSVReader;
import de.exxcellent.challenge.datamodel.WeatherDataPoint;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class DataHandler {


    /**
     * method to get the day with smallest temperature spread out of a list with weatherdatapoints
     * @param weatherDataPoints is a list
     * @return the day as a string
     */
    public String getDayWithSmallestTempSpread(List<WeatherDataPoint> weatherDataPoints) {
        WeatherDataPoint minTempSpread = weatherDataPoints
                .stream()
                .min(Comparator.comparing(WeatherDataPoint::getTemperatureSpreadValue))
                .orElseThrow(NoSuchElementException::new);
        return minTempSpread.getDay();
    }

    /**
     * calls a set of methods (readData from CSVReader, parseDataPoints WeatherDataHandler) to get the day with the
     * smallest temperature spread
     * @param dataPath contains the path to the data which should be read
     * @return the day with smallest temperature spread
     */
    public String getDayWithSmallestTempSpread(String dataPath) {

        CSVReader reader = new CSVReader();
        List<List<String>> listOfAllElements = reader.readData(dataPath);

        WeatherDataHandler weatherDataHandler = new WeatherDataHandler();
        List<WeatherDataPoint> weatherDataPoints = weatherDataHandler.parseDataPoints(listOfAllElements);
        return getDayWithSmallestTempSpread(weatherDataPoints);
    }
}
