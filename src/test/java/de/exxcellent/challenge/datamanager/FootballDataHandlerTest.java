package de.exxcellent.challenge.datamanager;

import de.exxcellent.challenge.datamodel.FootballDataPoint;
import de.exxcellent.challenge.datamodel.WeatherDataPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballDataHandlerTest {
    private FootballDataHandler footballDataHandler;

    @BeforeEach
    void setUp() {
        footballDataHandler = new FootballDataHandler();
    }

    @DisplayName("Absolute difference calculation should work")
    @Test
    void testCalculateGoalDistance() {
        assertEquals(1, footballDataHandler.calculateGoalDistance(20, 21), "Absolute difference calculation should work (A<B)");
        assertEquals(24, footballDataHandler.calculateGoalDistance(45, 21), "Absolute difference calculation should work (A>B)");
        assertEquals(11, footballDataHandler.calculateGoalDistance(34, 45), "Absolute difference calculation should work (A<B)");
        assertEquals(0, footballDataHandler.calculateGoalDistance(1, 1), "Absolute difference calculation should work (A=B)");
    }

    @DisplayName("Parsing of a list of lists of strings should work")
    @Test
    void testParseDataPoints() {
        List<String> firstRow = new ArrayList<>()
        {{
            add("Team");
            add("Games");
            add("Wins");
            add("Looses");
            add("Goals");
            add("Goals Allowed");
        }};
        List<String> secondRow = new ArrayList<>()
        {{
            add("Middlesbrough");
            add("30");
            add("20");
            add("2");
            add("74");
            add("12");
        }};
        List<String> thirdRow = new ArrayList<>()
        {{
            add("Leeds");
            add("30");
            add("18");
            add("12");
            add("53");
            add("37");
        }};
        List<List<String>> listOfDataPoints = Arrays.asList(firstRow, secondRow, thirdRow);

        List<FootballDataPoint> footballDataPoints = footballDataHandler.parseDataPoints(listOfDataPoints);

        FootballDataPoint fp1   = new FootballDataPoint("Middlesbrough", 74, 12, 62);
        FootballDataPoint fp2  = new FootballDataPoint("Leeds", 53, 37, 16);

        List<FootballDataPoint> expectedList = Arrays.asList(fp1,fp2);

        assertEquals(expectedList, footballDataPoints,"Parsed data didn't match constructed data");
    }
}
