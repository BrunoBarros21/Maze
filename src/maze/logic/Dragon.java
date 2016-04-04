package maze.logic;

import java.io.Serializable;

/**
* Dragon.java-Class that represent "Dragon" objects in Maze game.
* @author José Monteiro and Bruno Barros.
*/
public class Dragon implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private boolean sleep;
	private boolean alive;
	/**
	 * Constructor that receives the initial x and y coordinate of this dragon in the maze.
	 * @param x A Int variable type.
	 * @param y A Int variable type.
	 */
	public Dragon(int x,int y){
		this.x=x;
		this.y=y;
		sleep=false;
		alive=true;
	}
	//GET'S------------------------------
	/**
	 * Retrieve the x coordinate of the dragon in the maze.
	 * @return A Int data type.
	 */
	public int getX(){
		return x;
	}
	/**
	 * Retrieve the y coordinate of the dragon in the maze.
	 * @return A Int data type.
	 */
	public int getY(){
		return y;
	}
	/**
	 * Retrieve if the dragon is in sleep mode (true) or not (false).
	 * @return A Boolean data type.
	 */
	public boolean getSleep(){
		return sleep;
	}
	/**
	 * Retrieve if the dragon is alive (true) or not (false).
	 * @return A Boolean data type.
	 */
	public boolean getLifeState(){
		return alive;
	}
	//SET'S-----------------------------
	/**
	 * Set the dragon mode (Sleep or awake).
	 * @param s A Boolean variable type.
	 */
	public void setSleep(boolean s){
		sleep = s;
	}
	/**
	 * Set the dragon life to dead.
	 */
	public void setDragonLife(){
		alive=false;
	}
	//-----------------------------------
	/**
	 * Update the coordinates of the dragon according to the direction that he taked.
	 * @param direcao A Char variable type.
	 */
	public void move(char direcao){
		if (direcao == 'a')
			y--;
		if (direcao == 's')
			x++;
		if (direcao == 'd')
			y++;
		if (direcao == 'w')
			x--;
	}

}
