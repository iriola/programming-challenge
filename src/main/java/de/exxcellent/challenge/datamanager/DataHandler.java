package de.exxcellent.challenge.datamanager;

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
}
