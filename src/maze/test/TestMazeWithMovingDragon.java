package maze.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import maze.logic.*;
import maze.logic.Maze.GameMode;
import maze.logic.Maze.GameState;

public class TestMazeWithMovingDragon {
	char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', ' ', ' ', 'H', 'S' },
					{ 'X', ' ', 'X', ' ', 'X' },
					{ 'X', 'E', 'X', 'D', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };

	char[][] m2 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', 'D', ' ', 'H', 'S' },
					{ 'X', 'X', 'X', ' ', 'X' },
					{ 'X', 'E', ' ', ' ', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };

	char[][] m3 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', 'H', ' ', 'D', 'S' },
					{ 'X', ' ', 'X', 'X', 'X' },
					{ 'X', 'E', 'X', ' ', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };

	char[][] m4 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', ' ', 'X', 'D', 'S' },
					{ 'X', ' ', 'X', ' ', 'X' },
					{ 'X', 'E', ' ', 'H', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };

	char[][] m5 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', 'X', 'X', ' ', 'S' },
					{ 'X', 'D', 'X', ' ', 'X' },
					{ 'X', 'E', ' ', 'H', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };

	char[][] m6 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', 'E', ' ', ' ', 'S' },
					{ 'X', 'D', 'X', ' ', 'X' },
					{ 'X', 'X', 'X', 'H', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };

	char[][] m7 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', ' ', ' ', 'H', 'S' },
					{ 'X', ' ', 'X', 'X', 'X' },
					{ 'X', 'E', 'D', 'X', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };

	char[][] m8 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', ' ', ' ', 'H', 'S' },
					{ 'X', 'X', 'X', ' ', 'X' },
					{ 'X', 'D', 'E', ' ', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };
	
	char[][] m9 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', ' ', ' ', 'H', 'S' },
					{ 'X', 'X', 'X', ' ', 'X' },
					{ 'X', 'D', ' ', 'E', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };
	
	char[][] m10 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', 'E', ' ', 'H', 'S' },
					{ 'X', 'X', 'X', ' ', 'X' },
					{ 'X', 'D', ' ', ' ', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };
	
	char[][] m11 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', 'H', ' ', 'E', 'S' },
					{ 'X', 'X', 'X', ' ', 'X' },
					{ 'X', 'D', ' ', ' ', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };
	
	char[][] m12 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', ' ', ' ', 'E', 'S' },
					{ 'X', 'X', 'X', ' ', 'X' },
					{ 'X', 'D', ' ', 'H', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };



	@ Test
	public void testHeroDies1(){
		Maze maze = new Maze(m1);
		maze.setMode(1);
		assertEquals(3, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(2, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.checkAllDragonsPositions();
		assertEquals(GameState.DRAGON_WIN, maze.getGameState());
	}

	@ Test
	public void testHeroDies2(){
		Maze maze = new Maze(m2);
		maze.setMode(1);
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(1, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(2, maze.getDragons().get(0).getY());
		maze.checkAllDragonsPositions();
		assertEquals(GameState.DRAGON_WIN, maze.getGameState());
	}

	@ Test
	public void testHeroDies3(){
		Maze maze = new Maze(m3);
		maze.setMode(1);
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(2, maze.getDragons().get(0).getY());
		maze.checkAllDragonsPositions();
		assertEquals(GameState.DRAGON_WIN, maze.getGameState());
	}

	@ Test
	public void testHeroDies4(){
		Maze maze = new Maze(m4);
		maze.setMode(1);
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(2, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.checkAllDragonsPositions();
		assertEquals(GameState.DRAGON_WIN, maze.getGameState());
	}

	@ Test
	public void testDragonDies1(){
		Maze maze = new Maze(m1);
		maze.setMode(1);
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
		maze.moveHero('s');
		assertEquals(2, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.checkAllDragonsPositions();
		assertEquals(true, maze.checkAllDragonsLife());
		assertEquals(GameState.PLAYING, maze.getGameState());
		maze.moveHero('s');
	}

	@ Test
	public void testDragonDies2(){
		Maze maze = new Maze(m2);
		maze.setMode(1);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('s');
		maze.moveHero('s');
		maze.moveHero('a');
		maze.moveHero('a');
		assertEquals(3, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
		maze.moveHero('d');
		maze.moveHero('d');
		maze.moveHero('w');
		maze.moveHero('w');
		maze.moveHero('a');
		assertEquals(1, maze.getHeroX());
		assertEquals(2, maze.getHeroY());
		maze.checkAllDragonsPositions();
		assertEquals(true, maze.checkAllDragonsLife());
		assertEquals(GameState.PLAYING, maze.getGameState());
		maze.moveHero('a');
	}

	@ Test
	public void testDragonDies3(){
		Maze maze = new Maze(m3);
		maze.setMode(1);
		assertEquals(1, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		maze.moveHero('s');
		maze.moveHero('s');
		assertEquals(3, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
		maze.moveHero('w');
		maze.moveHero('w');
		maze.moveHero('d');
		assertEquals(1, maze.getHeroX());
		assertEquals(2, maze.getHeroY());
		maze.checkAllDragonsPositions();
		assertEquals(true, maze.checkAllDragonsLife());
		assertEquals(GameState.PLAYING, maze.getGameState());
		maze.moveHero('d');
	}

	@ Test
	public void testDragonDies4(){
		Maze maze = new Maze(m4);
		maze.setMode(1);
		assertEquals(3, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('a');
		maze.moveHero('a');
		assertEquals(3, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
		maze.moveHero('d');
		maze.moveHero('d');
		maze.moveHero('w');
		assertEquals(2, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.checkAllDragonsPositions();
		assertEquals(true, maze.checkAllDragonsLife());
		assertEquals(GameState.PLAYING, maze.getGameState());
		maze.moveHero('w');
	}

	@ Test
	public void testMoveDragonToSword1(){
		Maze maze = new Maze(m5);
		maze.setMode(1);
		assertEquals(2, maze.getDragons().get(0).getX());
		assertEquals(1, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(3, maze.getDragons().get(0).getX());
		assertEquals(1, maze.getDragons().get(0).getY());
	}

	@ Test
	public void testMoveDragonToSword2(){
		Maze maze = new Maze(m6);
		maze.setMode(1);
		assertEquals(2, maze.getDragons().get(0).getX());
		assertEquals(1, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(1, maze.getDragons().get(0).getY());
	}

	@ Test
	public void testMoveDragonToSword3(){
		Maze maze = new Maze(m7);
		maze.setMode(1);
		assertEquals(3, maze.getDragons().get(0).getX());
		assertEquals(2, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(3, maze.getDragons().get(0).getX());
		assertEquals(1, maze.getDragons().get(0).getY());
	}

	@ Test
	public void testMoveDragonToSword4(){
		Maze maze = new Maze(m8);
		maze.setMode(1);
		assertEquals(3, maze.getDragons().get(0).getX());
		assertEquals(1, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(3, maze.getDragons().get(0).getX());
		assertEquals(2, maze.getDragons().get(0).getY());
	}

	@ Test
	public void testDragonKillHero(){
		Maze maze = new Maze(m1);
		maze.setMode(2);
		assertEquals(3, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(2, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.setALabirinthPosition(3, 3, 'X');
		maze.moveAllDragons();
	}

	@ Test
	public void testDragonKillHero2(){
		Maze maze = new Maze(m2);
		maze.setMode(2);
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(1, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(2, maze.getDragons().get(0).getY());
		maze.setALabirinthPosition(1, 1, 'X');
		maze.moveAllDragons();
	}

	@ Test
	public void testDragonKillHero3(){
		Maze maze = new Maze(m3);
		maze.setMode(2);
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(2, maze.getDragons().get(0).getY());
		maze.setALabirinthPosition(1, 3, 'X');
		maze.moveAllDragons();
	}

	@ Test
	public void testDragonKillHero4(){
		Maze maze = new Maze(m4);
		maze.setMode(2);
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(2, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.setALabirinthPosition(1, 3, 'X');
		maze.moveAllDragons();
	}
	
	@ Test
	public void testDragonKillHero5(){
		Maze maze = new Maze(m1);
		maze.setMode(2);
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
		assertEquals(3, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(2, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.setALabirinthPosition(3, 3, 'X');
		maze.moveAllDragons();
	}

	@ Test
	public void testDragonKillHero6(){
		Maze maze = new Maze(m2);
		maze.setMode(2);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('s');
		maze.moveHero('s');
		maze.moveHero('a');
		maze.moveHero('a');
		assertEquals(3, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
		maze.moveHero('d');
		maze.moveHero('d');
		maze.moveHero('w');
		maze.moveHero('w');
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(1, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(2, maze.getDragons().get(0).getY());
		maze.setALabirinthPosition(1, 1, 'X');
		maze.moveAllDragons();
	}

	@ Test
	public void testDragonKillHero7(){
		Maze maze = new Maze(m3);
		maze.setMode(2);
		assertEquals(1, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		maze.moveHero('s');
		maze.moveHero('s');
		assertEquals(3, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
		maze.moveHero('w');
		maze.moveHero('w');
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(2, maze.getDragons().get(0).getY());
		maze.setALabirinthPosition(1, 3, 'X');
		maze.moveAllDragons();
	}

	@ Test
	public void testDragonKillHero8(){
		Maze maze = new Maze(m4);
		maze.setMode(2);
		assertEquals(3, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('a');
		maze.moveHero('a');
		assertEquals(3, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
		maze.moveHero('d');
		maze.moveHero('d');
		assertEquals(1, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.moveAllDragons();
		assertEquals(2, maze.getDragons().get(0).getX());
		assertEquals(3, maze.getDragons().get(0).getY());
		maze.setALabirinthPosition(1, 3, 'X');
		maze.moveAllDragons();
	}
	
	@ Test
	public void HeroToSword(){
		Maze maze = new Maze(m9);
		maze.setMode(0);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('s');
		maze.moveHero('s');
		assertEquals(3, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
	}
	
	@ Test
	public void HeroToSword2(){
		Maze maze = new Maze(m10);
		maze.setMode(0);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('a');
		maze.moveHero('a');
		assertEquals(1, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
	}
	
	@ Test
	public void HeroToSword3(){
		Maze maze = new Maze(m11);
		maze.setMode(0);
		assertEquals(1, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		maze.moveHero('d');
		maze.moveHero('d');
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
	}
	
	@ Test
	public void HeroToSword4(){
		Maze maze = new Maze(m12);
		maze.setMode(0);
		assertEquals(3, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.moveHero('w');
		maze.moveHero('w');
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
	}
}
