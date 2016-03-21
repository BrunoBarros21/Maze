package maze.logic;


public class Point {
    protected int x;
    protected int y;

    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

