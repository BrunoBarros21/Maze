package maze.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
import maze.logic.*;

public class TestMazeRandomMovement 
{
	char [][] m1 = {{'X', 'X', 'X', 'X', 'X'},
					{'X', ' ', ' ', 'H', 'S'},
					{'X', ' ', 'X', ' ', 'X'},
					{'X', 'E', ' ', 'D', 'X'},
					{'X', 'X', 'X', 'X', 'X'}};

	char [][] m2 = {{'X', 'X', 'X', 'X', 'X'},
					{'X', ' ', ' ', 'H', 'S'},
					{'X', 'E', 'X', 'X', 'X'},
					{'X', 'X', ' ', 'D', 'X'},
					{'X', 'X', 'X', 'X', 'X'}};
	
	char [][] m3 = {{'X', 'X', 'X', 'X', 'X'},
					{'X', ' ', 'H', 'X', 'S'},
					{'X', 'E', 'X', ' ', 'X'},
					{'X', 'X', 'X', 'D', 'X'},
					{'X', 'X', 'X', 'X', 'X'}};

	@Test
	public void testDragonMovement() 
	{
		Maze maze = new Maze(m1);
		maze.setMode(1);
		LinkedList<Dragon> dragons = maze.getDragons();
		Dragon currentDragon = dragons.get(0);
		assertEquals(3, currentDragon.getX());
		assertEquals(3, currentDragon.getY());
		Point x = new Point (currentDragon.getX(), currentDragon.getY());
		assertEquals("(3, 3)", x.toString());
		maze.moveDragon(currentDragon);
		Point p = new Point(currentDragon.getX(), currentDragon.getY());
		assertNotEquals(new Point(3,3), p);
	}

	@Test
	public void testDragonMovement2() 
	{
		Maze maze = new Maze(m2);
		maze.setMode(1);
		LinkedList<Dragon> dragons = maze.getDragons();
		Dragon currentDragon = dragons.get(0);
		assertEquals(3, currentDragon.getX());
		assertEquals(3, currentDragon.getY());
		Point x = new Point (currentDragon.getX(), currentDragon.getY());
		assertEquals("(3, 3)", x.toString());
		maze.moveDragon(currentDragon);
		Point p = new Point(currentDragon.getX(), currentDragon.getY());
		assertNotEquals(new Point(3,3), p);
		maze.moveDragon(currentDragon);
		Point z = new Point(currentDragon.getX(), currentDragon.getY());
		assertNotEquals(p, z);
	}
	
	@Test
	public void testDragonMovement3() 
	{
		Maze maze = new Maze(m3);
		maze.setMode(1);
		LinkedList<Dragon> dragons = maze.getDragons();
		Dragon currentDragon = dragons.get(0);
		assertEquals(3, currentDragon.getX());
		assertEquals(3, currentDragon.getY());
		Point x = new Point (currentDragon.getX(), currentDragon.getY());
		assertEquals("(3, 3)", x.toString());
		maze.moveDragon(currentDragon);
		Point p = new Point(currentDragon.getX(), currentDragon.getY());
		assertNotEquals(new Point(3,3), p);
		maze.moveDragon(currentDragon);
		Point z = new Point(currentDragon.getX(), currentDragon.getY());
		assertNotEquals(p, z);
	}


}
