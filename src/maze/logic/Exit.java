package maze.logic;

import java.io.Serializable;

/**
 * Exit.java - Class that represent de "Exit" object in the Maze game.
 * @author José Monteiro and Bruno Barros.
 *
 */
public class Exit implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private boolean HeroOut;
	/**
	 * Constructor that receives the initial x and y coordinate of the exit in the maze.
	 * @param x A Int variable type.
	 * @param y A Int variable type.
	 */
	public Exit(int x,int y)
	{
		this.x=x;
		this.y=y;
		HeroOut=false;
	}
	//GET'S---------------------
	/**
	 * Retrieve the x coordinate of the exit in the maze.
	 * @return A Int data type.
	 */
	public int getX(){
		return x;
	}
	/**
	 * Retrieve the y coordinate of the exit in the maze.
	 * @return A Int data type.
	 */
	public int getY(){
		return y;
	}
	/**
	 * Retrieve if the exit is open (true) or not (false).
	 * @return A Boolean data type.
	 */
	public boolean getExitState(){
		return HeroOut;
	}
	//SET'S-----------------
	/**
	 * Open the exit.
	 */
	public void setHeroOut(){
		HeroOut=true;
	}

}
