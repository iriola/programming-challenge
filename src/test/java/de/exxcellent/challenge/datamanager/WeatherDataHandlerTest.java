package de.exxcellent.challenge.datamanager;

import de.exxcellent.challenge.datamodel.WeatherDataPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


public class WeatherDataHandlerTest {

    private WeatherDataHandler weatherDataHandler;

    @BeforeEach
    void setUp() {
        weatherDataHandler = new WeatherDataHandler();
    }

    @DisplayName("Simple subtraction should work")
    @Test
    void testCalculateTemperatureSpread() {

        float tempSpread = weatherDataHandler.calculateTemperatureSpread(5.0f, 2.0f);

        assertEquals(3, tempSpread, "Failed: wrong value");
    }

    @DisplayName("Parsing of a list of lists of strings should work")
    @Test
    void testParseDataPoints() {
        List<String> firstRow = new ArrayList<>() {{
            add("Day");
            add("MxT");
            add("MnT");
            add("AvT");
        }};
        List<String> secondRow = new ArrayList<>() {{
            add("1");
            add("88.8");
            add("59.3");
            add("74");
        }};
        List<String> thirdRow = new ArrayList<>() {{
            add("2");
            add("79.8");
            add("63.6");
            add("71");
        }};
        List<List<String>> listOfDataPoints = Arrays.asList(firstRow, secondRow, thirdRow);

        List<WeatherDataPoint> weatherDataPoints = weatherDataHandler.parseDataPoints(listOfDataPoints);


        WeatherDataPoint day1 = new WeatherDataPoint("1", 88.8f, 59.3f, 29.5f);
        WeatherDataPoint day2 = new WeatherDataPoint("2", 79.8f, 63.6f, 16.2f);

        List<WeatherDataPoint> expectedList = Arrays.asList(day1, day2);

        assertEquals(expectedList, weatherDataPoints, "wrong return list");

    }


}
