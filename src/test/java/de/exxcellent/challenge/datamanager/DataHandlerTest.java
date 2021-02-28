package de.exxcellent.challenge.datamanager;

import de.exxcellent.challenge.datamodel.WeatherDataPoint;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataHandlerTest {

    @Test
    void testToGetDayWithSmallestTempSpread() {
        WeatherDataPoint day1 = new WeatherDataPoint("1", 14.9f, 3.3f, 11.6f);
        WeatherDataPoint day2 = new WeatherDataPoint("2", 4.9f, 3.1f, 1.8f);
        WeatherDataPoint day3 = new WeatherDataPoint("3", 20, 3, 17);
        WeatherDataPoint day4 = new WeatherDataPoint("4", 4, 3, 1);
        List<WeatherDataPoint> weatherDataPoints = Arrays.asList(day1,day2,day3, day4);
        DataHandler dataHandler = new DataHandler();

        String day = dataHandler.getDayWithSmallestTempSpread(weatherDataPoints);

        assertEquals("4", day, "Incorrect day was returned");
    }
}
