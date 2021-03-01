package de.exxcellent.challenge.datamanager;

import de.exxcellent.challenge.datamodel.FootballDataPoint;
import de.exxcellent.challenge.datamodel.WeatherDataPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataHandlerTest {
    DataHandler dataHandler;

    @BeforeEach
    void setUp() {
        dataHandler = new DataHandler();
    }

    @DisplayName("Ensure to determine the correct day with smallest temperature spread")
    @Test
    void testFindDayWithSmallestTempSpread() {
        WeatherDataPoint day1 = new WeatherDataPoint("1", 14.9f, 3.3f, 11.6f);
        WeatherDataPoint day2 = new WeatherDataPoint("2", 4.9f, 3.1f, 1.8f);
        WeatherDataPoint day3 = new WeatherDataPoint("3", 20, 3, 17);
        WeatherDataPoint day4 = new WeatherDataPoint("4", 4, 3, 1);
        List<WeatherDataPoint> weatherDataPoints = Arrays.asList(day1, day2, day3, day4);


        String day = dataHandler.findDayWithSmallestTempSpread(weatherDataPoints);

        assertEquals("4", day, "Incorrect day was returned");
    }

    @DisplayName("Ensure to get the right day (lowest temperature spread) using CSV-file")
    @Test
    void testGetDayWithSmallestTempSpread() {
        String filePath = "de/exxcellent/challenge/weather.csv";

        assertEquals("14", dataHandler.getDayWithSmallestTempSpread(filePath));
    }

    @DisplayName("Ensure to determine the team with smallest goal distance ")
    @Test
    void testFindSmallestGoalDistance() {
        FootballDataPoint team1 = new FootballDataPoint("Arsenal", 79, 36, 43);
        FootballDataPoint team2 = new FootballDataPoint("Liverpool", 67, 30, 37);
        FootballDataPoint team3 = new FootballDataPoint("Manchester United", 87, 45, 42);
        FootballDataPoint team4 = new FootballDataPoint("Newcastle", 74, 52, 22);

        List<FootballDataPoint> footballDataPoints = Arrays.asList(team1, team2, team3, team4);

        assertEquals("Newcastle", dataHandler.findTeamWithSmallestGoalDistance(footballDataPoints)
                , "Expected team is different to actual team.");
    }

    @DisplayName("Ensure to get the right team (lowest goal distance) using CSV-file")
    @Test
    void testGetSmallestGoalDistance() {
        String filePath = "de/exxcellent/challenge/football.csv";

        assertEquals("Aston_Villa", dataHandler.getTeamWithSmallestGoalDistance(filePath)
                , "Expected team is different to actual team.");

    }
}
