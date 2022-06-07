import java.awt.Dimension;
import javax.swing.JFrame;


/*https://stackoverflow.com/questions/61373469/jframe-not-the-size-i-set-it-to*/

/**
 * The type Window.
 */
public class Window
{

    /**
     * Instantiates a new Window.
     *
     * @param width  the width
     * @param height the height
     * @param title  the title
     * @param game   the game
     */
    public Window(int width , int height , String title , Game game)
    {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width , height ));
        frame.setMaximumSize(new Dimension(width , height ));
        frame.setMinimumSize(new Dimension(width , height ));
        frame.add(game);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
