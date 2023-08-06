// Main.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

// Если ImageProcessingUtils находится в том же пакете, что и Main, то импорт не требуется
// Если ImageProcessingUtils в другом пакете, то вы должны использовать полное имя класса, например:
// import com.example.ImageProcessingUtils;
// import ImageProcessingUtils.ImageProcessingUtils;

public class Main {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem mi1, mi2, mi3, mi4, mi5;
    private File selectedFile;

    public Main() {
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
                    try {
                        ImageProcessingUtils.createMirrorImage(selectedFile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        // Можно добавить больше логики обработки ошибок здесь, например, показать пользователю сообщение об ошибке.
                    }
                }
            }
        });

        // ...

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
        new Main();
    }
}
