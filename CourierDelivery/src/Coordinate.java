
/**
 * This class contains the x, y values
 * of a point.
 * @author Sandy
 *
 */
public class Coordinate {

	/**
	 * Creates a new Coordinate point
	 * with the input values.
	 * @param x The x value of the coordinate point.
	 * @param y The y value of the point.
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Get the X value of the coordinate point.
	 * @return An integer that represents the X value
	 * of the point.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Get the Y value of the coordinate point.
	 * @return An integer that represents the Y value
	 * of the point.
	 */
	public int getY() {
		return y;
	}
	
	private int x;
	private int y;
}
