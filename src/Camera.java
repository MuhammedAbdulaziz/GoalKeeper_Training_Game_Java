/**
 * The type Camera.
 */
public class Camera
{
    private float x,y;

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
                y+= ((object.getY()-y)-600/2) *0.05f;
                // set map boundries
                if (x <= 0 ) x=0;
                if(x >= 900) x=900;
                if( y<= 0) y=0;
                if( y>= 900+48) y=900+48;
                
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
     * Gets y.
     *
     * @return the y
     */
    public float getY() {
        return y;
    }

}
