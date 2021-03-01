package de.exxcellent.challenge;


import de.exxcellent.challenge.datamanager.DataHandler;

/**
 * The entry class for my solution. Takes 0-2 CLI arguments and either executes the weather or football
 * challenge or both (default: both).
 * Prints out the solution to System.out
 *
 */
public final class App {
    /**
     * Enum that contains the possible tasks in this challenge
     */
    enum Measurements {BOTH, WEATHER, FOOTBALL}


    /**
     * This is the main entry method of my program.
     *
     * @param args The CLI arguments passed
     *             0:["--weather" or "--football"]
     *             1:["weather.csv" or "football.csv"]
     */
    public static void main(String... args) {

        //default values for task and paths
        Measurements taskToSolve = Measurements.BOTH;
        String dataPathWeather = "weather.csv";
        String dataPathFootball = "football.csv";

        //check if cli arguments were passed
        if(args.length > 0){
            //check if passed cli arguments contains "weather" or "football"
            //set path to file and enum to particular task
            if(args[0].contains("weather")){
                taskToSolve = Measurements.WEATHER;
                if(args.length>1){
                    dataPathWeather = args[1];
                }else {
                    dataPathWeather = "weather.csv";
                }
            }
            if(args[0].contains("football")){
                taskToSolve = Measurements.FOOTBALL;
                if(args.length>1){
                    dataPathFootball = args[1];
                }else {
                    dataPathFootball = "football.csv";
                }
            }
        }

        // initialize the DataHandler which handles data processing and calculation of the solution
        DataHandler dataHandler = new DataHandler();
        String dayWithSmallestTempSpread;
        String teamWithSmallestGoalSpread;

        //check which task enum value is set and execute the particular method(s)
        switch (taskToSolve){
            case WEATHER:
                dayWithSmallestTempSpread = dataHandler
                        .getDayWithSmallestTempSpread("de/exxcellent/challenge/" + dataPathWeather);
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
                break;
            case FOOTBALL:
                teamWithSmallestGoalSpread = dataHandler
                        .getTeamWithSmallestGoalDistance("de/exxcellent/challenge/" + dataPathFootball);
                System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
                break;
            case BOTH:
                dayWithSmallestTempSpread = dataHandler
                        .getDayWithSmallestTempSpread("de/exxcellent/challenge/" + dataPathWeather);
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
                teamWithSmallestGoalSpread = dataHandler
                        .getTeamWithSmallestGoalDistance("de/exxcellent/challenge/" + dataPathFootball);
                System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
                break;
        }

    }
}
