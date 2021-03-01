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

        assertEquals(3.1f, weatherDataHandler.calculateTemperatureSpread(5.3f, 2.2f),
                0.0001, "Simple subtraction between floats should work");
        assertEquals(2.8f, weatherDataHandler.calculateTemperatureSpread(5.0f, 2.2f),
                0.0001, "Simple subtraction between floats should work");
        assertEquals(4, weatherDataHandler.calculateTemperatureSpread(5, 1),
                0.0001, "Simple subtraction between integers should work");
        assertEquals(0, weatherDataHandler.calculateTemperatureSpread(7.8f, 7.8f),
                0.0001, "Simple subtraction between floats should work");
        assertEquals(5.2f, weatherDataHandler.calculateTemperatureSpread(7, 1.8f),
                0.0001, "Simple subtraction between different data types should work");
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

        assertEquals(expectedList, weatherDataPoints, "Parsed data didn't match constructed data");

    }


}
