package maze.test;

import static org.junit.Assert.*;
import org.junit.Test;
import maze.logic.*;
import maze.logic.Labirinto.GameState;

public class TestMazeWithStaticDragon {
	char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', ' ', ' ', 'H', 'S' },
					{ 'X', ' ', 'X', ' ', 'X' },
					{ 'X', 'E', ' ', 'D', 'X' },
					{ 'X', 'X', 'X', 'X', 'X' } };

	@Test
	public void testMoveHeroToFreeCell() {
		Labirinto maze = new Labirinto(m1);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.movimentaHeroi('a');
		assertEquals(1, maze.getHeroX());
		assertEquals(2, maze.getHeroY());
	}

	@Test
	public void testHeroDies() {
		Labirinto maze = new Labirinto(m1);
		assertEquals(false, maze.getHeroArmed());
		maze.movimentaHeroi('s');
		maze.checkDragonPosition();
		assertEquals(GameState.DRAGON_WIN, maze.getGameState());
	}
	
	@Test
	public void moveToWall(){
		Labirinto maze = new Labirinto(m1);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.movimentaHeroi('w');
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
	}
	
	@Test
	public void moveToSword(){
		Labirinto maze = new Labirinto(m1);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.movimentaHeroi('a');
		maze.movimentaHeroi('a');
		maze.movimentaHeroi('s');
		maze.movimentaHeroi('s');
		assertEquals(3, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
	}
	
	@Test
	public void moveToKillDragon(){
		Labirinto maze = new Labirinto(m1);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.movimentaHeroi('a');
		maze.movimentaHeroi('a');
		maze.movimentaHeroi('s');
		maze.movimentaHeroi('s');
		maze.movimentaHeroi('d');
		maze.checkDragonPosition();
		assertEquals(false, maze.getDragonLifeState());
	}
	
	@Test
	public void HeroRun(){
		Labirinto maze = new Labirinto(m1);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.movimentaHeroi('a');
		maze.movimentaHeroi('a');
		maze.movimentaHeroi('s');
		maze.movimentaHeroi('s');
		maze.movimentaHeroi('d');
		maze.checkDragonPosition();
		maze.movimentaHeroi('d');
		maze.movimentaHeroi('w');
		maze.movimentaHeroi('w');
		maze.movimentaHeroi('d');
		assertEquals(GameState.HERO_WIN, maze.getGameState());
	}
	
	@Test
	public void testExitFail() {
		Labirinto maze = new Labirinto(m1);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.movimentaHeroi('d');
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
	}
	
	@Test
	public void moveToExitWithSwordButDragonAlive(){
		Labirinto maze = new Labirinto(m1);
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.movimentaHeroi('a');
		maze.movimentaHeroi('a');
		maze.movimentaHeroi('s');
		maze.movimentaHeroi('s');
		assertEquals(3, maze.getHeroX());
		assertEquals(1, maze.getHeroY());
		assertEquals(true, maze.getHeroArmed());
		maze.movimentaHeroi('w');
		maze.movimentaHeroi('w');
		maze.movimentaHeroi('d');
		maze.movimentaHeroi('d');
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
		maze.movimentaHeroi('d');
		assertEquals(1, maze.getHeroX());
		assertEquals(3, maze.getHeroY());
	}
}