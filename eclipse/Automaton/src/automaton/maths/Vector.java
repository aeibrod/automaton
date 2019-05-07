package automaton.maths;

/**
 * <p>
 * The vector class is used to represent a translation
 * or a movement.
 * </p>
 * 
 * <p>
 * Should <b>not</b> be used to define a location in
 * the world or as a key in a map, use respectively
 * a coordinates or a point for that.
 * </p>
 * 
 * @see Coordinates
 * @see Point
 */
public class Vector {

	protected int x;
	protected int y;


	/**
	 * <p>
	 * The vector class is used to represent a translation
	 * or a movement.
	 * </p>
	 * 
	 * <p>
	 * Should <b>not</b> be used to define a location in
	 * the world or as a key in a map, use respectively
	 * a coordinates or a point for that.
	 * </p>
	 * 
	 * @see Coordinates
	 * @see Point
	 */
	public Vector() {
		this(0, 0);
	}

	/**
	 * <p>
	 * The vector class is used to represent a translation
	 * or a movement.
	 * </p>
	 * 
	 * <p>
	 * Should <b>not</b> be used to define a location in
	 * the world or as a key in a map, use respectively
	 * a coordinates or a point for that.
	 * </p>
	 * 
	 * @param x The default abscissa value.
	 * @param y The default ordinate value.
	 * 
	 * @see Coordinates
	 * @see Point
	 */
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}


	/**
	 * Defines a new abscissa value.
	 * 
	 * @param newx The new abscissa value.
	 */
	public void setX(int newx) {
		this.x = newx;
	}

	/**
	 * Defines a new ordinate value.
	 * 
	 * @param newy The new ordinate value.
	 */
	public void setY(int newy) {
		this.y = newy;
	}


	/**
	 * Returns the abscissa value.
	 * 
	 * @return The abscissa value.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the ordinate value.
	 * 
	 * @return The ordinate value.
	 */
	public int getY() {
		return y;
	}

}
