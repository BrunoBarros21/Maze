package maze.logic;

import java.io.Serializable;

/**
 * Hero.java-Class that represent "Dragon" objects in Maze game.
 * @author José Monteiro and Bruno Barros.
 *
 */
public class Hero implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private boolean espada;
	/**
	 * Constructor that receives the initial x and y coordinate of the hero in the maze.
	 * @param x A Int data type.
	 * @param y A Int data type.
	 */
	public Hero(int x,int y)
	{
		this.x = x;
		this.y = y;
		espada = false;
	}
	//GET'S------------------
	/**
	 * Retrieve the x coordinate of the hero in the maze.
	 * @return A Int data type.
	 */
	public int getX()
	{
		return x;
	}
	/**
	 * Retrieve the y coordinate of the hero in the maze.
	 * @return A Int data type.
	 */
	public int getY()
	{
		return y;
	}
	/**
	 * Retrieve if the hero got he sword (true) or not (false).
	 * @return A Boolean data type.
	 */
	public boolean getEspada()
	{
		return espada;
	}
	//SET'S------------------
	/**
	 * Set the hero to have the sword.
	 */
	public void setEspada()
	{
		espada = true;
	}
	/**
	 * Update the coordinates of the hero according to the direction that he made.
	 * @param direcao A Char data type.
	 */
	public void move(char direcao)
	{
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
