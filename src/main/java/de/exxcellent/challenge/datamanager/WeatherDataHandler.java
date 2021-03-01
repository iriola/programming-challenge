package de.exxcellent.challenge.datamanager;

import de.exxcellent.challenge.datamodel.WeatherDataPoint;

import java.util.*;

/**
 * class used to parse list of lists (table-like structure) to get a list of required weather data points.
 * contains a method to calculate the temperature spread.
 * Implements the DataParser Interface
 */
public class WeatherDataHandler implements DataParser<WeatherDataPoint> {

    String dayHeaderLabel = "Day";
    String maxTemperatureHeaderLabel = "MxT";
    String minTemperatureHeaderLabel = "MnT";


    /**
     * method to calculate temperature spread from maximum temperature and minimum temperature
     * @param maxTemp is the maximum temperature
     * @param minTemp is the minimum temperature
     * @return calculated temperature spread based on maxTemp and minTemp
     */
    public float calculateTemperatureSpread(float maxTemp, float minTemp) {
        return maxTemp - minTemp;
    }

    /**
     * method to parse a list of all data points from a list of lists of strings to get a list of weather data points
     * @param allDataPoints is a list of lists of strings (table-like structure; outer list: rows, inner list: cells)
     * @return a list of weather data point
     */
    @Override
    public List<WeatherDataPoint> parseDataPoints(List<List<String>> allDataPoints) {
        // HashMap contains the value from the first row (as key) and the index (as value) at which this data can be found in a row
        // generated based on the first (header row) of the table (mapping defined through the instance variables dayHeaderLabel, maxTemperatureHeaderLabel, minTemperatureHeaderLabel)
        HashMap<String, Integer> firstRowIndexMap = new HashMap<>();
        for(String firstRowElement : allDataPoints.get(0)) {
            if (firstRowElement.contains(dayHeaderLabel)) {
                firstRowIndexMap.put(firstRowElement, allDataPoints.get(0).indexOf(firstRowElement));
            }
            if(firstRowElement.contains(maxTemperatureHeaderLabel)){
                firstRowIndexMap.put(firstRowElement, allDataPoints.get(0).indexOf(firstRowElement));
            }
            if(firstRowElement.contains(minTemperatureHeaderLabel)){
                firstRowIndexMap.put(firstRowElement, allDataPoints.get(0).indexOf(firstRowElement));
            }
        }

        List<WeatherDataPoint> weatherDataPoints = new ArrayList<>();

        // generate a list of weather data point using the key of the map to get the right cell in the table row
        for(List<String> wdo : allDataPoints.subList(1, allDataPoints.size())){

            try {
                String day = wdo.get(firstRowIndexMap.get("Day"));
                float maxTemp = Float.parseFloat(wdo.get(firstRowIndexMap.get("MxT")));
                float minTemp = Float.parseFloat(wdo.get(firstRowIndexMap.get("MnT")));

                weatherDataPoints.add(new WeatherDataPoint(day, maxTemp, minTemp, calculateTemperatureSpread(maxTemp, minTemp)));

            }catch (Exception e) {
                e.printStackTrace();
            }

        }
        return weatherDataPoints;
    }




}
