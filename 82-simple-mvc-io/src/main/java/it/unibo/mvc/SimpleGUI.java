package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();
    private static final int PROPORTION = 5;

    /**
     * Creates the GUI.
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextArea area = new JTextArea("Write text here");
        panel.add(area, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        panel.add(save, BorderLayout.SOUTH);
        frame.add(panel);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                controller.writeStringOnFile(area.getText());
            }
        });
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screen.getWidth();
        final int height = (int) screen.getHeight();
        frame.setSize(width / PROPORTION, height / PROPORTION);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("My first Java graphical interface");
        frame.setVisible(true);
    }

    /**
     * Make the GUI visible.
     */
    private void display() {
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     * @param args unused
     */
    public static void main(final String[] args) {
        final SimpleGUI gui = new SimpleGUI(); 
        gui.display();
    }
}
