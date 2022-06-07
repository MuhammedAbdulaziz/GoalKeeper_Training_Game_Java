/**
 * The type Camera.
 */
public class Camera
{
    private float x = 0,y = 0 ;

    /**
     * Instantiates a new Camera.
     *
     * @param x the x
     * @param y the y
     */
    public Camera(float x , float y )
    {
        this.x= x ;
        this.y = y;
    }

    /**
     * Tick.
     *
     * @param object the object
     */
    public void tick(GameObject object)
    {
		x+= ((object.getX()-x)-1000/2)* 0.05f;
                y+= ((object.getY()-y)-563/2) *0.05f;
                
                if (x <= 0 ) x=0;
                if(x >= 1032) x=1032;
                if( y<= 0) y=0;
                if( y>= 563+48) y=563+48;
                
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }
    
}
