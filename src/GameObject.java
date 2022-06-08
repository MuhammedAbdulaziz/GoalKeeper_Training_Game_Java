import java.awt.Graphics;
import java.awt.Rectangle;


/**
 * The type Game object.
 */
public abstract class GameObject
{
    /**
     * The X.
     */
    protected int x, /**
 * The Y.
 */
y;
    /**
     * The Velx.
     */
    protected float velx = 0 , /**
 * The Vely.
 */
vely = 0 ;
   private final Elements elements;
    /**
     * The Ss.
     */
    protected SpriteSheet ss;


    /**
     * Instantiates a new Game object.
     *
     * @param x        the x
     * @param y        the y
     * @param elements the elements
     * @param ss       the ss
     */
    public GameObject(int x , int y, Elements elements, SpriteSheet ss  )
    {
        this.x = x ; 
        this.y= y ;
        this.elements = elements;
        this.ss = ss;
        
    }

    /**
     * Tick.
     */
    public abstract void tick();

    /**
     * Render.
     *
     * @param g the g
     */
    public abstract void render(Graphics g );

    /**
     * Gets bounds.
     *
     * @return the bounds
     */
    // detecting collision between objects
    public abstract Rectangle getBounds();

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Elements getId() {
        return elements;
    }


}
