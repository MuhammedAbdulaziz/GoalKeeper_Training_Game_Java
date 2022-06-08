import java.awt.Graphics;
import java.util.LinkedList;


/**
 * The type Handler.
 */

// updating every game object
public class Handler
{

	/**
	 * The Object.
	 */
	public LinkedList<GameObject> object = new LinkedList<>();
    private boolean up = false, down = false, left = false, right = false;

	/**
	 * Tick.
	 */
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			//storing each object temporary then get the id of each one which is i
			GameObject tempObject = object.get(i);
			//calling .tick to update each object in our list
			tempObject.tick();
		}
	}

	/**
	 * Render.
	 *
	 * @param g the g
	 */
	// same as tick
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}

	/**
	 * Add object.
	 *
	 * @param gameObject the game object
	 */
	public void addObject(GameObject gameObject) {
		this.object.add(gameObject);
	}

	/**
	 * Remove object.
	 *
	 * @param gameObject the game object
	 */
	public void removeObject(GameObject gameObject) {
		this.object.remove(gameObject);
	}

	/**
	 * Is up boolean.
	 *
	 * @return the boolean
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * Sets up.
	 *
	 * @param up the up
	 */
	public void setUp(boolean up) {
		this.up = up;
	}

	/**
	 * Is down boolean.
	 *
	 * @return the boolean
	 */
	public boolean isDown() {
		return down;
	}

	/**
	 * Sets down.
	 *
	 * @param down the down
	 */
	public void setDown(boolean down) {
		this.down = down;
	}

	/**
	 * Is left boolean.
	 *
	 * @return the boolean
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * Sets left.
	 *
	 * @param left the left
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}

	/**
	 * Is right boolean.
	 *
	 * @return the boolean
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * Sets right.
	 *
	 * @param right the right
	 */
	public void setRight(boolean right) {
		this.right = right;
	}
}
