package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home") + System.getProperty("file.separator");
    private File currentFile = new File(PATH + "output.txt");

    public void setCurrentFile(final File f) {
        Objects.requireNonNull(f);
        this.currentFile = f;
    }

    public void writeStringOnFile(final String message)  {
        try (PrintWriter fileStream = new PrintWriter(currentFile)) {
            fileStream.print(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public File getCurrentFile() {
        return this.currentFile;
    }

    public String getCurrentFileName() {
        return this.currentFile.getName();
    }

    public String getCurrentFilePath() {
        return this.currentFile.getAbsolutePath();
    }
}