package de.exxcellent.challenge.datamodel;

import java.util.Objects;

/**
 * Entity to store / describe a single measurement of football data.
 */
public class FootballDataPoint {

    private String teamName;
    private int goals;
    private int goalsAllowed;
    private int smallestGoalDistance;

    public FootballDataPoint(String teamName, int goals, int goalsAllowed, int smallestGoalDistance) {
        this.teamName = teamName;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
        this.smallestGoalDistance = smallestGoalDistance;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public void setGoalsAllowed(int goalsAllowed) {
        this.goalsAllowed = goalsAllowed;
    }

    public int getSmallestGoalDistance() {
        return smallestGoalDistance;
    }

    public void setSmallestGoalDistance(int smallestGoalDistance) {
        this.smallestGoalDistance = smallestGoalDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballDataPoint that = (FootballDataPoint) o;
        return goals == that.goals && goalsAllowed == that.goalsAllowed
                && smallestGoalDistance == that.smallestGoalDistance && Objects.equals(teamName, that.teamName);
    }


}
