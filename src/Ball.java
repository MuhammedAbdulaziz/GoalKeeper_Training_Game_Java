import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 * The type Ball.
 */
public class Ball extends GameObject {
 private final Handler handler;

    /**
     * Instantiates a new Ball.
     *
     * @param x        the x
     * @param y        the y
     * @param elements the elements
     * @param handler  the handler
     * @param mx       the mx
     * @param my       the my
     * @param ss       the ss
     */
    public Ball(int x, int y, Elements elements, Handler handler , int mx , int my , SpriteSheet ss ) {
        super(x, y, elements,ss);
        this.handler = handler;
        velx = (mx-x) /10;
        vely = (my-y)/10;
    }

    @Override
    public void tick()
    {
        x+= velx;
        y+= vely;
        for ( int i = 0 ; i< handler.object.size() ; i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == Elements.Block)
            {
            if(getBounds().intersects(tempObject.getBounds()))
            {
                handler.removeObject(this);
            }
            }
        }
     }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 8, 8);
     }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,8,8);
     }
    
}
