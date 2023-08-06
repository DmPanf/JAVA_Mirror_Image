import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MirrorLoadImage {
    public static void main(String args[]) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
        fileChooser.setFileFilter(filter);
        // Установка заголовка для диалога выбора файла
        fileChooser.setDialogTitle("Выберите изображение для обработки");
        int returnValue = fileChooser.showOpenDialog(null);
        File selectedFile = null;
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }

        BufferedImage mirroredImage = createMirrorImage(selectedFile);

        // fileChooser.setSelectedFile(new File(""));
        // Установка заголовка для диалога сохранения файла
        fileChooser.setDialogTitle("Сохранить зеркальное изображение как...");
        returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File outputfile = fileChooser.getSelectedFile();
            ImageIO.write(mirroredImage, "png", outputfile);
        }
    }

    // метод createMirrorImage принимает входной файл и возвращает зеркальное изображение в виде BufferedImage
    private static BufferedImage createMirrorImage(File file) throws IOException {
        BufferedImage simg = ImageIO.read(file);
        int width = simg.getWidth();
        int height = simg.getHeight();
        BufferedImage mimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) {
                int p = simg.getRGB(lx, y);
                mimg.setRGB(rx, y, p);
            }
        }

        return mimg;
    }
}
