package maze.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;
import maze.logic.*;
import maze.logic.Maze.GameMode;
import maze.logic.Maze.GameState;

public class TestMazeDragonSleep 
{
	char [][] m1 = {{'X', 'X', 'X', 'X', 'X'},
					{'X', ' ', ' ', 'H', 'S'},
					{'X', ' ', 'X', ' ', 'X'},
					{'X', 'E', ' ', 'D', 'X'},
					{'X', 'X', 'X', 'X', 'X'}};
	
	char [][] m2 = {{'X', 'X', 'X', 'X', 'X'},
			{'X', ' ', ' ', 'H', 'S'},
			{'X', ' ', 'X', 'X', 'X'},
			{'X', ' ', 'E', 'D', 'X'},
			{'X', 'X', 'X', 'X', 'X'}};

	@Test
	public void testSleepDragon() 
	{
		Maze maze = new Maze(m1);
		maze.setMode(2);
		assertEquals(GameMode.MOVE_AND_SLEEP, maze.getMode());
		LinkedList<Dragon> dragons = maze.getDragons();		

		// If you add another dragon replace the index on "get" by it's index (the array is read from top to bottom and left to right)
		Dragon currentDragon = dragons.get(0);
		assertEquals(3, currentDragon.getX());
		assertEquals(3, currentDragon.getY());
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		currentDragon.setSleep(true);
		assertEquals(true, currentDragon.getSleep());
		maze.moveHero('s');
		assertEquals(3, maze.getHeroY());
		assertEquals(2, maze.getHeroX());
		assertEquals(GameState.PLAYING, maze.getGameState());
		currentDragon.setSleep(false);
		assertEquals(false, currentDragon.getSleep());
	}

	@Test
	public void testKillSleepDragon() 
	{
		Maze maze = new Maze(m1);
		maze.setMode(2);
		LinkedList<Dragon> dragons = maze.getDragons();

		// If you add another dragon replace the index on "get" by it's index (the array is read from top to bottom and left to right)
		Dragon currentDragon = dragons.get(0);
		assertEquals(3, currentDragon.getX());
		assertEquals(3, currentDragon.getY());
		assertEquals(1, maze.getHero().getX());
		assertEquals(3, maze.getHero().getY());
		maze.adormeceDragao(currentDragon);
		assertEquals(true, maze.getDragonLifeState(currentDragon));
		assertEquals(true, maze.getDragonSleep(currentDragon));
		assertEquals(true, currentDragon.getSleep());
		maze.moveHero('a');
		maze.moveHero('a');
		maze.moveHero('s');
		maze.moveHero('s');
		assertEquals(1, maze.getHeroY());
		assertEquals(3, maze.getHeroX());
		assertEquals(true, maze.getHeroArmed());
		maze.moveHero('d');
		maze.checkAllDragonsPositions();
		maze.checkAllDragonsLife();
		assertEquals(false, currentDragon.getLifeState());
	}

	@Test
	public void testSleepDragons() 
	{
		Maze maze = new Maze(m2);
		maze.setMode(2);
		LinkedList<Dragon> dragons = maze.getDragons();

		// If you add another dragon replace the index on "get" by it's index (the array is read from top to bottom and left to right)
		Dragon currentDragon = dragons.get(0);
		assertEquals(3, currentDragon.getX());
		assertEquals(3, currentDragon.getY());
		assertEquals(1, maze.getHero().getX());
		assertEquals(3, maze.getHero().getY());
		maze.updateDragons();
		assertEquals(true, maze.getDragonLifeState(currentDragon));
	}

	@Test(timeout = 1000)
	public void testRandomSleepDragon()
	{
		Maze maze = new Maze(m1);
		maze.setMode(2);
		LinkedList<Dragon> dragons = maze.getDragons();

		// If you add another dragon replace the index on "get" by it's index (the array is read from top to bottom and left to right)
		Dragon currentDragon = dragons.get(0);
		boolean sleep = false, noSleep = false;
		assertEquals(3, currentDragon.getX());
		assertEquals(3, currentDragon.getY());
		assertEquals(false, currentDragon.getSleep());
		while(!sleep || !noSleep)
		{
			if(maze.updateSleepDragon(currentDragon) && !sleep)
			{
				sleep = true;
				assertEquals(true, currentDragon.getSleep());
			}
			else if(!noSleep)
			{
				noSleep = true;
				//assertEquals(false, currentDragon.getSleep());
			}
		}
	}
	@Test
	public void testSleepDragonInSword() 
	{
		Maze maze = new Maze(m2);
		maze.setMode(2);
		LinkedList<Dragon> dragons = maze.getDragons();
		Dragon currentDragon = dragons.get(0);
		assertEquals(3, currentDragon.getX());
		assertEquals(3, currentDragon.getY());
		assertEquals(1, maze.getHero().getX());
		assertEquals(3, maze.getHero().getY());
		maze.moveDragon(currentDragon);
		maze.adormeceDragao(currentDragon);
		assertEquals(true, currentDragon.getSleep());
		assertEquals(true, maze.getDragonSleep(currentDragon));
	}
}
