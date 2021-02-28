package de.exxcellent.challenge.datainput;

import java.util.List;

/**
 * Interface to provide methods to load / read data
 */
public interface Reader {

    /**
     * method to deliver a list of lists that contains all elements from a file / resource (as a table structure) with passed path
     * @param path is the location (path, url,...) where the data is available from
     * @return a list of lists with all elements from the data (outer list: rows, inner list: cells)
     */
    List<List<String>> readData(String path);
}
