package de.exxcellent.challenge.datamanager;

import de.exxcellent.challenge.datamodel.WeatherDataPoint;

import java.util.HashMap;
import java.util.List;

public class WeatherDataHandler {

    /**
     * method to calculate values of maximum temperature and minimum temperature
     * @param maxTemp is the maximum temperature
     * @param minTemp is the minimum temperature
     * @return calculated temperature spread based on maxTemp and minTemp
     */
    public float calculateTemperatureSpread(float maxTemp, float minTemp) {
        return maxTemp - minTemp;
    }

}
