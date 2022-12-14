package it.unibo.mvc;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();
    private static final int PROPORTION = 5;

    /**
     * Creates the GUI.
     */
    public SimpleGUIWithFileChooser() {
        final JTextArea area = new JTextArea("Write text here");
        frame.add(area, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        frame.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                controller.writeStringOnFile(area.getText());
            }
        });

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextField field = new JTextField();
        field.setEditable(false);
        field.setText(controller.getCurrentFilePath());
        panel.add(field, BorderLayout.CENTER);
        final JButton browse = new JButton("Browse...");
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final JFileChooser fChooser = new JFileChooser();
                final int returnValue = fChooser.showOpenDialog(panel);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(fChooser.getSelectedFile());
                    field.setText(controller.getCurrentFilePath());
                } else if (returnValue != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(panel, "An error has occurred");
                }
            }
        });
        panel.add(browse, BorderLayout.LINE_END);

        frame.add(panel, BorderLayout.NORTH);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screen.getWidth();
        final int height = (int) screen.getHeight();
        frame.setSize(width / PROPORTION, height / PROPORTION);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("My second Java graphical interface");
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
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(); 
        gui.display();
    }
}
