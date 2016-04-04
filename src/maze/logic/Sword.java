package maze.logic;

import java.io.Serializable;

/**
 * Sword.java-Class that represent "Sword" object in Maze game.
 * @author José Monteiro and Bruno Barros.
 *
 */
public class Sword implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private boolean gotSword;
	/**
	 * Constructor that receives the initial x and y coordinate of the sword in the maze.
	 * @param x A Int data type.
	 * @param y A Int data type.
	 */
	public Sword(int x,int y){
		this.x=x;
		this.y=y;
		gotSword=false;
	}
	/**
	 * Retrieve the x coordinate of the sword in the maze.
	 * @return A Int data type.
	 */
	public int getX(){
		return x;
	}
	/**
	 * Retrieve the y coordinate of the sword in the maze.
	 * @return A Int data type.
	 */
	public int getY(){
		return y;
	}
	/**
	 * Retrieve if the sword was already picked (true) or not (false).
	 * @return A Boolean data type.
	 */
	public boolean getSwordState(){
		return gotSword;
	}
	/**
	 * Set true the attribute relative to the state of the sword.
	 */
	public void pickSword(){
		gotSword=true;
	}

}
