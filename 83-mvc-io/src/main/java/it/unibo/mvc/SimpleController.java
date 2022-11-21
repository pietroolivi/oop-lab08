package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String currentString;
    private final List<String> history;

    /**
    * Initialize the variables.
    */
    public SimpleController() {
        this.currentString = null;
        this.history = new ArrayList<>();
    }

    @Override
    public void setNextStringToPrint(final String s) {
        this.currentString = s;
        this.history.add(this.currentString);
    }

    @Override
    public String getNextStringToPrint() {
        return this.currentString;
    }

    @Override
    public List<String> getStringsHistory() {
        return new ArrayList<String>(history);
    }

    @Override
    public void printCurrentString() {
        if (this.currentString == null) {
            throw new IllegalStateException();
        } else {
            System.out.println(this.currentString); // NOPMD: allowed as this is just an exercise
        }
    }

}
