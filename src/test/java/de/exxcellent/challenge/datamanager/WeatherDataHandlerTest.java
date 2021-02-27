package de.exxcellent.challenge.datamanager;

import de.exxcellent.challenge.datamodel.WeatherDataPoint;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void testCalculateTemperatureSpread() {

        float tempSpread = weatherDataHandler.calculateTemperatureSpread(5.0f, 2.0f);

        assertEquals(3, tempSpread, "Failed: wrong value");
    }



}
