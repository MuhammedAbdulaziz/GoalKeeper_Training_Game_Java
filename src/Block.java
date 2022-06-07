import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * The type Block.
 */
public class Block extends GameObject
{
    private final BufferedImage block_image;

    /**
     * Instantiates a new Block.
     *
     * @param x        the x
     * @param y        the y
     * @param elements the elements
     * @param ss       the ss
     */
    public Block(int x, int y, Elements elements, SpriteSheet ss) {
        super(x, y, elements, ss);
        block_image = ss.grabImage(5, 2, 32, 32);
    }

    @Override
    public void tick(){}

    @Override
    public void render(Graphics g)
    {
       g.drawImage(block_image, x, y, null);
     }
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x,y,32,32);
     }

}
