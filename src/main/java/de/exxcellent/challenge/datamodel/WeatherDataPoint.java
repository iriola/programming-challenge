package de.exxcellent.challenge.datamodel;

/**
 * Entity to store / describe a single measurement of weather data.
 */
public class WeatherDataPoint {

    private String day;
    private float maxTemperature;
    private float minTemperature;
    private float temperatureSpreadValue;

    /**
     * constructor to create a new instance of a weather data point
     * @param day the day of measurement
     * @param maxTemperature the maximum temperature value of the day
     * @param minTemperature the minimum temperature value of the day
     * @param temperatureSpreadValue the temperature spread value of the day
     */
    public WeatherDataPoint(String day, float maxTemperature, float minTemperature, float temperatureSpreadValue){
        this.day = day;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.temperatureSpreadValue = temperatureSpreadValue;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public float getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(float maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public float getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(float minTemperature) {
        this.minTemperature = minTemperature;
    }

    public float getTemperatureSpreadValue() {
        return temperatureSpreadValue;
    }

    public void setTemperatureSpreadValue(float temperatureSpreadValue) {
        this.temperatureSpreadValue = temperatureSpreadValue;
    }

    /**
     * override the equals method of the object class
     * uses a threshold of .0001 to enable comparison of floats
     * @param obj instance of a weather data point to compare with this instance
     * @return a boolean: true if day, maxTemperature, minTemperature and temperatureSpreadValue match and false if obj is not an instance of WeatherDataPoint or parameters don't match
     */
    @Override
    public boolean equals(Object obj) {
        float THRESHOLD = 0.0001f;
        if(obj == this){
            return true;
        }if(!(obj instanceof WeatherDataPoint)){
            return false;
        }
        WeatherDataPoint wdp = (WeatherDataPoint) obj;
        return day.equals(wdp.day) && Float.compare(maxTemperature, wdp.maxTemperature)==0
                && Float.compare(minTemperature, wdp.minTemperature)==0
                && Math.abs(temperatureSpreadValue - wdp.temperatureSpreadValue)<THRESHOLD;
    }
}

