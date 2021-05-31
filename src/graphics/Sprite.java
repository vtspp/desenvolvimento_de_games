package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static java.util.Objects.isNull;

public class Sprite {

    private BufferedImage bufferedImage;

    protected Sprite(String path) {
        if (bufferedImage == null)
        read(path);
    }

    private BufferedImage read (String path) {
        try {
            bufferedImage = ImageIO.read(getClass().getResource(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    protected BufferedImage getImageByPosition (int x, int y, int width, int height) {
        return bufferedImage.getSubimage(x, y, width, height);
    }

}
