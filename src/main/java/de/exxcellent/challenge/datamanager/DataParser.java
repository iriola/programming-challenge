package de.exxcellent.challenge.datamanager;

import java.util.List;

/**
 * Interface to provide method to parse data of list of lists of strings
 * @param <T> generic parameter describing the result data instance expected after parsing
 */
public interface DataParser<T> {

    /**
     * method to deliver list of T that contains the required data element (WeatherDataPoint, FootballDataPoint)
     * needed for further use.
     * @param allDataPoints is a list of lists of strings (as a table structure; outer list: rows, inner list: cells)
     * @return list of instances of T
     */
    List<T> parseDataPoints(List<List<String>> allDataPoints);
}
