package JavaCore.task16.task1631;

import com.javarush.task.task16.task1631.common.*;


public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes i) {
        if (i != null) {
            if (i.equals(ImageTypes.BMP)) return new BmpReader();
            if (i.equals(ImageTypes.JPG)) return new JpgReader();
            if (i.equals(ImageTypes.PNG)) return new PngReader();
        }
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
