package it.unibo.mvc;

import java.util.List;

/**
 * Models a simple controller responsible of I/O access.
 */
public interface Controller {

    /**
    * Sets the next string to print.
    * @param s string to be setted
    */
    void setNextStringToPrint(String s);

    /**
    * @return the next string that will be printed
    */
    String getNextStringToPrint();

    /**
    * @return all the strings printed
    */
    List<String> getStringsHistory();

    /**
    * Print the current string.
    */
    void printCurrentString();
}
