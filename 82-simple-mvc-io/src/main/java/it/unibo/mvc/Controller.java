package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home") + System.getProperty("file.separator");
    private File currentFile = new File(PATH + "output.txt");

    /**
     * Sets a new file to write to.
     * @param f file to set as current
     */
    public void setCurrentFile(final File f) {
        Objects.requireNonNull(f);
        this.currentFile = f;
    }

    /**
     * Writes in currentFile a message.
     * @param message String to be printed
     */
    public void writeStringOnFile(final String message)  {
        try (PrintWriter fileStream = new PrintWriter(currentFile, StandardCharsets.UTF_8)) {
            fileStream.print(message);
        } catch (IOException e) {
            e.printStackTrace(); // NOPMD: allowed as this is required by the exercise
        }
    }

    /**
     * @return the current output file 
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * @return the current output file's name
     */
    public String getCurrentFileName() {
        return this.currentFile.getName();
    }

    /**
     * @return the current output file's path
     */
    public String getCurrentFilePath() {
        return this.currentFile.getAbsolutePath();
    }
}
