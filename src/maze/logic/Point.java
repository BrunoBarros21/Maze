package maze.logic;

/**
 * Point.java-Class that represents a point with coordinates x and y.
 * @author José Monteiro and Bruno Barros.
 *
 */
public class Point {
    protected int x;
    protected int y;
    /**
     * Retrieve the coordinate x.
     * @return A Int data type.
     */
    public int getX()
    {
    	return x;
    }
    /**
     * Retrieve the coordinate y.
     * @return A Int data type.
     */
    public int getY()
    {
    	return y;
    }
    /**
     * Constructor of the class Point that receive as parameters the coordinates x and y, initializing the the attributes of the class.
     * @param x A Int data type.
     * @param y A Int data type.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Override toString() to this class.
     * @return A String data type.
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

