
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 * The type Box.
 */
public class Box extends GameObject
{

    /**
     * Instantiates a new Box.
     *
     * @param x        the x
     * @param y        the y
     * @param elements the elements
     * @param ss       the ss
     */
    public Box(int x, int y, Elements elements, SpriteSheet ss)
    {
        super(x, y, elements,ss);
    }

    @Override
    public void tick()
    {
        x+=velx;
        y+=vely;
    }

    @Override
    public void render(Graphics g) 
    {
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 32);
        
        
    }

    @Override
    public Rectangle getBounds()
    {
        return null;
    }
    
}
