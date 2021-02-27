package de.exxcellent.challenge.datamodel;


public class WeatherDataPoint {

    private String day;
    private float maxTemperature;
    private float minTemperature;
    private float temperatureSpreadValue;


    public WeatherDataPoint(String day, float maxTemperature, float minTemperature, float temperatureSpreadValue){
        this.day = day;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.temperatureSpreadValue = temperatureSpreadValue;
    }

    public WeatherDataPoint(String day, float maxTemperature, float minTemperature) {
        this.day = day;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

