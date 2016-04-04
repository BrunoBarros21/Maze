package maze.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import maze.logic.*;
import maze.logic.Maze.GameMode;
import maze.logic.Maze.GameState;

public class TestMazeWithStaticDragon {
	char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', ' ', ' ', 'H', 'S' },
					{ 'X', ' ', 'X', ' ', 'X' },
					{ 'X', 'E', ' ', 'D', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };

	@Test
	public void testMoveHeroToFreeCell() {
		Maze maze = new Maze(m1);
		maze.setMode(0);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('a');
		assertEquals(1, maze.getHeroX());
		assertEquals(2, maze.getHeroY());
	}

	@Test
	public void testHeroDies() {
		Maze maze = new Maze(m1);
		maze.setMode(0);
		assertEquals(false, maze.getHeroArmed());
		maze.moveHero('s');
		maze.checkAllDragonsPositions();;
		assertEquals(GameState.DRAGON_WIN, maze.getGameState());
	}

	@Test
	public void moveToWall(){
		Maze maze = new Maze(m1);
		maze.setMode(0);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('w');
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
	}

	@Test
	public void moveToSword(){
		Maze maze = new Maze(m1);
		maze.setMode(0);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('a');
		maze.moveHero('a');
		maze.moveHero('s');
		maze.moveHero('s');
		assertEquals(3, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
	}

	@Test
	public void moveToKillDragon(){
		Maze maze = new Maze(m1);
		maze.setMode(0);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('a');
		maze.moveHero('a');
		maze.moveHero('s');
		maze.moveHero('s');
		assertEquals(true, maze.getSword().getSwordState());
		maze.moveHero('d');
		maze.checkAllDragonsPositions();;
		assertEquals(true, maze.checkAllDragonsLife());
	}

	@Test
	public void HeroRun(){
		Maze maze = new Maze(m1);
		maze.setMode(0);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('a');
		maze.moveHero('a');
		maze.moveHero('s');
		maze.moveHero('s');
		maze.moveHero('d');
		maze.checkAllDragonsPositions();
		maze.moveHero('d');
		maze.moveHero('w');
		maze.moveHero('w');
		maze.moveHero('d');
		assertEquals(true, maze.getExit().getExitState());
		assertEquals(GameState.HERO_WIN, maze.getGameState());
	}

	@Test
	public void testExitFail() {
		Maze maze = new Maze(m1);
		maze.setMode(0);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('d');
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
	}

	@Test
	public void moveToExitWithSwordButDragonAlive(){
		Maze maze = new Maze(m1);
		maze.setMode(0);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('a');
		maze.moveHero('a');
		maze.moveHero('s');
		maze.moveHero('s');
		assertEquals(3, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
		maze.moveHero('w');
		maze.moveHero('w');
		maze.moveHero('d');
		maze.moveHero('d');
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('d');
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
	}
	
	@Test
	public void compareTostring(){
		Maze maze = new Maze(m1);
		assertEquals("X X X X X \nX     H S \nX   X   X \nX E   D X \nX X X X X \n"	, maze.toString());
	}
}