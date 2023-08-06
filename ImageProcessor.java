// Шаблон
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageProcessor {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem mi1, mi2, mi3, mi4, mi5;
    private File selectedFile;

    public ImageProcessor() {
        frame = new JFrame("Image Processor");
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        mi1 = new JMenuItem("Mirror Image");
        mi2 = new JMenuItem("Grayscale Conversion");
        mi3 = new JMenuItem("Negative Image Conversion");
        mi4 = new JMenuItem("RGB Image Conversion");
        mi5 = new JMenuItem("Sepia Image Conversion");

        mi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFile = chooseFile("Select an Image");
                if (selectedFile != null) {
                    // Example: createMirrorImage(selectedFile);
                }
            }
        });

        mi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFile = chooseFile("Select an Image");
                if (selectedFile != null) {
                    // Example: convertToGrayscale(selectedFile);
                }
            }
        });

        mi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFile = chooseFile("Select an Image");
                if (selectedFile != null) {
                    // Example: convertToNegativeImage(selectedFile);
                }
            }
        });

        mi4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFile = chooseFile("Select an Image");
                if (selectedFile != null) {
                    // Example: convertToRGBImage(selectedFile);
                }
            }
        });

        mi5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFile = chooseFile("Select an Image");
                if (selectedFile != null) {
                    // Example: convertToSepiaImage(selectedFile);
                }
            }
        });

        menu.add(mi1);
        menu.add(mi2);
        menu.add(mi3);
        menu.add(mi4);
        menu.add(mi5);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private File chooseFile(String title) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(title);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    public static void main(String args[]) {
        new ImageProcessor();
    }
}
