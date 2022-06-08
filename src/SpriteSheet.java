import java.awt.image.BufferedImage;


/**
 * The type Sprite sheet.
 */
public class SpriteSheet
{
    private final BufferedImage image;

    /**
     * Instantiates a new Sprite sheet.
     *
     * @param image the image
     */
    public SpriteSheet (BufferedImage image )
    {
        this.image = image ;
    }

    /**
     * Grab image buffered image.
     *
     * @param col    the col
     * @param row    the row
     * @param width  the width
     * @param height the height
     * @return the buffered image
     */
    public BufferedImage grabImage ( int col , int row, int width , int height )
    {
        // to select if we want to select column 1 and row 1 not 0 and 0 and because 32 * 32
        return image.getSubimage((col*32)-32, (row*32)-32, width, height);
    }
    
}
