
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * The type Key input.
 */
public class KeyInput  extends KeyAdapter
{
    private Handler handler;
	/**
	 * The Game.
	 */
	Game  game;
	/**
	 * The Ss.
	 */
	SpriteSheet ss;
	/**
	 * The Camera.
	 */
	Camera camera;

	/**
	 * Instantiates a new Key input.
	 *
	 * @param handler the handler
	 * @param game    the game
	 * @param ss      the ss
	 * @param camera  the camera
	 */
	public KeyInput(Handler handler , Game game ,SpriteSheet ss,Camera camera) {
		this.camera = camera;
		this.ss =ss;
		this.handler = handler;
                this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == Elements.Player) {
				if (key == KeyEvent.VK_P)
				{
					new Game();
				}
				if (key == KeyEvent.VK_W) {
					handler.setUp(true);
                                       // game.moves--;
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(true);
                                       //  game.moves--;
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(true);
                                        // game.moves--;
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(true);
                                       //  game.moves--;
				}
			}

		}
		for (int i = 0; i < handler.object.size(); i++) {
			 GameObject tempObject = handler.object.get(i);
			 if (tempObject.getId() == Elements.Player1) {
				if (key == KeyEvent.VK_P)
				{
					new Game();
				}
				if (key == KeyEvent.VK_NUMPAD8) {
					handler.setUp(true);
					// game.moves--;
				}
				if (key == KeyEvent.VK_NUMPAD5) {
					handler.setDown(true);
					//  game.moves--;
				}
				if (key == KeyEvent.VK_NUMPAD4) {
					handler.setLeft(true);
					// game.moves--;
				}
				if (key == KeyEvent.VK_NUMPAD6) {
					handler.setRight(true);
					//  game.moves--;
				}
				if (key == KeyEvent.VK_NUMPAD0) {
					handler.addObject(new Ball(tempObject.getX()+16 , tempObject.getY()+24 , Elements.Ball , handler, MouseInput.mx,MouseInput.my,ss));
					//  game.moves--;
				}
			 }
		}
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == Elements.Player2) {
				if (key == KeyEvent.VK_P)
				{
					new Game();
				}
				if (key == KeyEvent.VK_UP) {
					handler.setUp(true);
					// game.moves--;
				}
				if (key == KeyEvent.VK_DOWN) {
					handler.setDown(true);
					//  game.moves--;
				}
				if (key == KeyEvent.VK_LEFT) {
					handler.setLeft(true);
					// game.moves--;
				}
				if (key == KeyEvent.VK_RIGHT) {
					handler.setRight(true);
					//  game.moves--;
				}
				if (key == KeyEvent.VK_SPACE) {
					handler.addObject(new Ball(tempObject.getX()+16 , tempObject.getY()+24 , Elements.Ball , handler, MouseInput.mx,MouseInput.my,ss));
					//  game.moves--;
				}
			}
		}
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == Elements.Player3) {
				if (key == KeyEvent.VK_P)
				{
					new Game();
				}
				if (key == KeyEvent.VK_U) {
					handler.setUp(true);
					// game.moves--;
				}
				if (key == KeyEvent.VK_J) {
					handler.setDown(true);
					//  game.moves--;
				}
				if (key == KeyEvent.VK_H) {
					handler.setLeft(true);
					// game.moves--;
				}
				if (key == KeyEvent.VK_K) {
					handler.setRight(true);
					//  game.moves--;
				}
				if (key == KeyEvent.VK_ENTER) {
					handler.addObject(new Ball(tempObject.getX()+16 , tempObject.getY()+24 , Elements.Ball , handler, MouseInput.mx,MouseInput.my,ss));
					//  game.moves--;
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == Elements.Player) {
				if (key == KeyEvent.VK_W) {
					handler.setUp(false);
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(false);
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(false);
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(false);
				}
			}
			if (tempObject.getId() == Elements.Player1) {
				if (key == KeyEvent.VK_NUMPAD8) {
					handler.setUp(false);
				}
				if (key == KeyEvent.VK_NUMPAD5) {
					handler.setDown(false);
				}
				if (key == KeyEvent.VK_NUMPAD4) {
					handler.setLeft(false);
				}
				if (key == KeyEvent.VK_NUMPAD6) {
					handler.setRight(false);
				}
			}
			if (tempObject.getId() == Elements.Player2) {
				if (key == KeyEvent.VK_UP) {
					handler.setUp(false);
				}
				if (key == KeyEvent.VK_DOWN) {
					handler.setDown(false);
				}
				if (key == KeyEvent.VK_LEFT) {
					handler.setLeft(false);
				}
				if (key == KeyEvent.VK_RIGHT) {
					handler.setRight(false);
				}
			}
			if (tempObject.getId() == Elements.Player3) {
				if (key == KeyEvent.VK_U) {
					handler.setUp(false);
				}
				if (key == KeyEvent.VK_J) {
					handler.setDown(false);
				}
				if (key == KeyEvent.VK_H) {
					handler.setLeft(false);
				}
				if (key == KeyEvent.VK_K) {
					handler.setRight(false);
				}
			}
		}
	}
}
