package de.exxcellent.challenge.datamanager;

import de.exxcellent.challenge.datainput.CSVReader;
import de.exxcellent.challenge.datamodel.FootballDataPoint;
import de.exxcellent.challenge.datamodel.WeatherDataPoint;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * interface between main / App class and the logic of weather task and football task
 */
public class DataHandler {

    CSVReader reader;

    /**
     * method to get the day with smallest temperature spread out of a list with weather data points
     * determines the smallest temperature spread with the help of the Stream API
     *
     * @param weatherDataPoints a list with weather data points
     * @return the day with the smallest temperature spread
     */
    public String findDayWithSmallestTempSpread(List<WeatherDataPoint> weatherDataPoints) {
        WeatherDataPoint minTempSpread = weatherDataPoints
                .stream()
                .min(Comparator.comparing(WeatherDataPoint::getTemperatureSpreadValue))
                .orElseThrow(NoSuchElementException::new);
        return minTempSpread.getDay();
    }

    /**
     * calls a set of methods (readData from CSVReader, parseDataPoints from WeatherDataHandler) to get the day with the
     * smallest temperature spread
     *
     * @param dataPath contains the path to the data which should be read
     * @return the day with smallest temperature spread
     */
    public String getDayWithSmallestTempSpread(String dataPath) {

        reader = new CSVReader();
        List<List<String>> listOfAllElements = reader.readData(dataPath);

        WeatherDataHandler weatherDataHandler = new WeatherDataHandler();
        List<WeatherDataPoint> weatherDataPoints = weatherDataHandler.parseDataPoints(listOfAllElements);
        return findDayWithSmallestTempSpread(weatherDataPoints);
    }

    /**
     * calls a set of methods (readData from CSVReader, parseDataPoints from FootballDataHandler) to get the team with
     * the smallest goal distance
     *
     * @param dataPath contains the path to the data which should be read
     * @return the team with smallest goal distance
     */
    public String getTeamWithSmallestGoalDistance(String dataPath) {

        reader = new CSVReader();
        List<List<String>> listOfAllElements = reader.readData(dataPath);

        FootballDataHandler footballDataHandler = new FootballDataHandler();
        List<FootballDataPoint> footballDataPoints = footballDataHandler.parseDataPoints(listOfAllElements);
        return findTeamWithSmallestGoalDistance(footballDataPoints);
    }

    /**
     * method to get the team with smallest goal spread out of a list with football data points
     * determines the smallest goal distance with the help of the Stream API
     *
     * @param footballDataPoints a list with football data points
     * @return the team with the smallest goal distance
     */
    public String findTeamWithSmallestGoalDistance(List<FootballDataPoint> footballDataPoints) {
        FootballDataPoint minDiff = footballDataPoints
                .stream()
                .min(Comparator.comparing(FootballDataPoint::getSmallestGoalDistance))
                .orElseThrow(NoSuchElementException::new);
        return minDiff.getTeamName();
    }

}
