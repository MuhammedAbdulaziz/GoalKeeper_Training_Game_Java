import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


/**
 * The type Shooter.
 */
public class Shooter extends GameObject
{
    /**
     * The Handler.
     */
    Handler handler ;
    private final BufferedImage players_image;


    /**
     * Instantiates a new Shooter.
     *
     * @param x        the x
     * @param y        the y
     * @param elements the elements
     * @param handler  the handler
     * @param ss       the ss
     */
    public Shooter(int x, int y, Elements elements, Handler handler , SpriteSheet ss) {
        super(x, y, elements,ss);
        this.handler = handler ;
        players_image = ss.grabImage(1, 1, 32, 48);
    }

    @Override
    public void tick() 
    {
        x +=velx ;
        y+= vely;
        collision();
         if(handler.isUp()) vely = -5;
         else if (!handler.isDown()) vely = 0;
         
         if(handler.isDown()) vely = 5;
         else if (!handler.isUp()) vely = 0;
         
         if(handler.isRight()) velx = 5;
         else if (!handler.isLeft()) velx = 0;
         
         if(handler.isLeft()) velx = -5;
         else if (!handler.isRight()) velx = 0;
         
     }
    private void collision()
    {
        for(int i = 0 ; i <handler.object.size() ; i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == Elements.Block)
            {
                if (getBounds().intersects(tempObject.getBounds()))
                {
                    x+= velx* -1 ;
                    y+= vely *-1;
                                        
                }
                
            }

        }
        
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(players_image, x, y, null);
     }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x,y,32,48);
     }
    
}
