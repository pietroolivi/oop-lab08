package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller ctrl;

    /**
    * Builds the GUI.
    * @param controller controller of the mvc pattern
    */
    @SuppressFBWarnings(
            value = { "EI_EXPOSE_REP2" },
            justification = "I implemented the class Controller myself"
    )
    public SimpleGUI(final Controller controller) {
        this.ctrl = controller;
        final JPanel panel = new JPanel();
        final JTextField field = new JTextField();
        final JTextArea area = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                ctrl.printCurrentString();
            }
        });

        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                area.setText(ctrl.getStringsHistory().toString());
            }
        });

        frame.add(field, BorderLayout.NORTH);
        frame.add(area, BorderLayout.CENTER);
        panel.setLayout(new FlowLayout());
        panel.add(print);
        panel.add(showHistory);
        frame.add(panel, BorderLayout.SOUTH);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screen.getWidth();
        final int height = (int) screen.getHeight();
        frame.setSize(width / PROPORTION, height / PROPORTION);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
    * Make the frame visible.
    */
    private void display() {
        this.frame.setVisible(true);
    }

    /**
     * Launches the application.
     * @param args unused
    */
    public static void main(final String[] args) {
        final Controller ctrl = new SimpleController();
        final SimpleGUI gui = new SimpleGUI(ctrl);
        for (final String s : List.of("Ciao", "Hello", "Hola")) {
            ctrl.setNextStringToPrint(s);
        }
        gui.display();
    }

}
