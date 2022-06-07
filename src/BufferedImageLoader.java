import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


/**
 * The type Buffered image loader.
 */
public class BufferedImageLoader
{
    private BufferedImage image;

    /**
     * Load image buffered image.
     *
     * @param path the path
     * @return the buffered image
     */
    public BufferedImage loadImage(String path)
    {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return image;
    }

}