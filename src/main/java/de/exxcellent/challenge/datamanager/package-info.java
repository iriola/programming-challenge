/**
 * This package contains classes and an interface that let you parse and calculate the delivered data from
 * {@link de.exxcellent.challenge.datainput.CSVReader} or other data sources implementing
 * {@link de.exxcellent.challenge.datainput.Reader}
 *
 * <ul>
 *     <li> {@link de.exxcellent.challenge.datamanager.DataHandler} connects main / App class and the logic
 *     of weather task and football task</li>
 *     <li>{@link de.exxcellent.challenge.datamanager.DataParser} Interface to provide method to parse data of list
 *     of lists of strings</li>
 *     <li>{@link de.exxcellent.challenge.datamanager.WeatherDataHandler}  class used to parse list of lists
 *     (table-like structure) to get a list of required weather data points.</li>
 *     <li>{@link de.exxcellent.challenge.datamanager.FootballDataHandler} class used to parse list of lists
 *     (table-like structure) to get a list of required football data points.</li>
 * </ul>
 */
package de.exxcellent.challenge.datamanager;