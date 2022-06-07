import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * The type Goal keeper.
 */
public class GoalKeeper extends GameObject {
    private final Game game;
    /**
     * The R.
     */
    Random r = new Random() ;
    /**
     * The Goalcount.
     */
    int goalcount;

    {
        goalcount =0;
    }

    /**
     * The Choose.
     */
    int choose = 0 ;
    /**
     * The Balls blocked.
     */
    static int balls_blocked = 100;
    /**
     * The Handler.
     */
    Handler handler ;
    private final BufferedImage enemy_image;

    /**
     * Instantiates a new Goal keeper.
     *
     * @param x        the x
     * @param y        the y
     * @param elements the elements
     * @param handler  the handler
     * @param ss       the ss
     * @param game     the game
     */
    public GoalKeeper(int x, int y, Elements elements, Handler handler, SpriteSheet ss , Game game) {
        super(x, y, elements,ss);
        this.handler = handler ;
        enemy_image = ss.grabImage(4, 1, 32, 32);
        this.game = game;
    }

    @Override
    public void tick() 
    {
        x+= velx ;
        y+=vely;
        choose = r.nextInt(100);
        for(int i = 0 ; i< handler.object.size() ; i++)
        {
            GameObject tempObject = handler.object.get(i);
          
            if ( tempObject.getId() == Elements.Block)
            {
                if ( getBoundsBig().intersects(tempObject.getBounds()))
                {
                    x += (velx*2)* -1;
                    y += (vely*2)* -1;
                    velx *= -1 ;
                    vely *= -1;
                }
                else if (choose == 0 )
        {
            vely = r.nextInt((10 + 10) - 10);
        }
            }
                    if(tempObject.getId()== Elements.Ball)
                    {
                        if ( getBounds().intersects(tempObject.getBounds()))
                        {
                          balls_blocked -= 1 ;
                          handler.removeObject(tempObject);
                        }
                    }
        }
     }

    @Override
    public void render(Graphics g) {
         g.drawImage(enemy_image, x, y, null);
     }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
        
     }

    /**
     * Gets bounds big.
     *
     * @return the bounds big
     */
    public Rectangle getBoundsBig() {
        return new Rectangle(x-16,y-16,64,64);
     }
}
