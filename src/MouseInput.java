
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * The type Mouse input.
 */
public class MouseInput extends MouseAdapter
{
    private final Handler handler ;
    private final Camera camera ;
    /**
     * The Mx.
     */
    static int mx;
    /**
     * The My.
     */
    static int my;
    /**
     * The Ss.
     */
    protected SpriteSheet ss;
    /**
     * The Game.
     */
    Game game;

    /**
     * Instantiates a new Mouse input.
     *
     * @param handler the handler
     * @param camera  the camera
     * @param ss      the ss
     * @param game    the game
     */
    public MouseInput(Handler handler, Camera camera, SpriteSheet ss , Game game )
    {
        this.handler = handler;
        this.camera= camera ;
        this.ss = ss ;
        this.game = game;
    }
    public void mousePressed(MouseEvent e) {
        mx = (int) (e.getX() + camera.getX());
        my = (int) (e.getY() + camera.getY());

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == Elements.Player) {
                handler.addObject(new Ball(tempObject.getX() + 16, tempObject.getY() + 24, Elements.Ball, handler, mx, my, ss));

            }
        }
    }}
