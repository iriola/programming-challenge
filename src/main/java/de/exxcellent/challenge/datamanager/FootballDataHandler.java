package de.exxcellent.challenge.datamanager;

import de.exxcellent.challenge.datamodel.FootballDataPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * class used to parse list of lists (table-like structure) to get a list of required football data points.
 * contains a method to calculate the absolute goal spread.
 * Implements the DataParser Interface
 */
public class FootballDataHandler implements DataParser<FootballDataPoint> {

    String teamNameLabel = "Team";
    String goalsLabel = "Goals";
    String goalsAllowedLabel = "Goals Allowed";

    /**
     * calculate the absolute differance from goals and goals allowed
     * @param goals number of goals the team has scored
     * @param goalsAllowed number of goals the team allowed
     * @return absolute difference based on goals and goalsAllowed
     */
    public int calculateGoalDistance(int goals, int goalsAllowed) {
        return Math.abs(goals - goalsAllowed);
    }


    /**
     * method to parse a list of all data points from a list of lists of strings to get a list of football data points
     * @param allDataPoints is a list of lists of strings (table-like structure; outer list: rows, inner list: cells)
     * @return a list of football data points
     */
    @Override
    public List<FootballDataPoint> parseDataPoints(List<List<String>> allDataPoints) {
        // HashMap contains the value from the first row (as key) and the index (as value) at which this data can be
        // found in a row.
        // Generated based on the first (header row) of the table (mapping defined through the instance variables
        // teamNameLabel, goalsLabel, goalsAllowedLabel)
        HashMap<String, Integer> firstRowIndexMap = new HashMap<>();
        for(String firstRowElement : allDataPoints.get(0)) {
            if (firstRowElement.contains(teamNameLabel)) {
                firstRowIndexMap.put(firstRowElement, allDataPoints.get(0).indexOf(firstRowElement));
            }
            if(firstRowElement.equals(goalsLabel)){
                firstRowIndexMap.put(firstRowElement, allDataPoints.get(0).indexOf(firstRowElement));
            }
            if(firstRowElement.equals(goalsAllowedLabel)){
                firstRowIndexMap.put(firstRowElement, allDataPoints.get(0).indexOf(firstRowElement));
            }
        }

        List<FootballDataPoint> footballDataPoints = new ArrayList<>();

        // generate a list of football data point using the key of the map to get the right cell in the table row
        for(List<String> fdp : allDataPoints.subList(1, allDataPoints.size())){

            try {
                String teamName = fdp.get(firstRowIndexMap.get("Team"));
                int goals = Integer.parseInt((fdp.get(firstRowIndexMap.get("Goals"))));
                int goalsAllowed = Integer.parseInt((fdp.get(firstRowIndexMap.get("Goals Allowed"))));

                footballDataPoints.add(new FootballDataPoint(teamName, goals, goalsAllowed,
                        calculateGoalDistance(goals, goalsAllowed)));

            }catch (Exception e) {
                e.printStackTrace();
            }

        }
        return footballDataPoints;

    }
}
