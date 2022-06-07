
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
   private Elements elements;
    /**
     * The Ss.
     */
    protected SpriteSheet ss;
    /**
     * The Hp.
     */
    public int hp  =100 ;

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
     * Sets x.
     *
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
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
     * Sets y.
     *
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets velx.
     *
     * @return the velx
     */
    public float getVelx() {
        return velx;
    }

    /**
     * Sets velx.
     *
     * @param velx the velx to set
     */
    public void setVelx(float velx) {
        this.velx = velx;
    }

    /**
     * Gets vely.
     *
     * @return the vely
     */
    public float getVely() {
        return vely;
    }

    /**
     * Sets vely.
     *
     * @param vely the vely to set
     */
    public void setVely(float vely) {
        this.vely = vely;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Elements getId() {
        return elements;
    }

    /**
     * Sets id.
     *
     * @param elements the id to set
     */
    public void setId(Elements elements) {
        this.elements = elements;
    }
    
    
    
    
    
}
