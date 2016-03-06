package maze.logic;

import java.util.Random;
import java.util.Scanner;

import maze.cli.CommandLine;
import maze.logic.Labirinto.GameState;

public class Logic {
	private Labirinto maze;
	private CommandLine cli;

	public Logic(){
		maze=new Labirinto();
		cli=new CommandLine();
	}

	public void play(){
		
		char dir;
		int mode=cli.initializeGame();
		if(mode == 1)//Static Dragon Mode
			while(maze.getGameState()==GameState.PLAYING)
			{
				cli.displayMaze(maze.toString());
				dir=cli.getCommands();
				maze.movimentaHeroi(dir);
				maze.checkDragonPosition();
			}
		if(mode == 2)//Random directioned Dragon Mode
			while(maze.getGameState()==GameState.PLAYING)
			{
				cli.displayMaze(maze.toString());
				dir=cli.getCommands();
				maze.movimentaHeroi(dir);
				maze.movimentaDragao();
				maze.checkDragonPosition();
			}
		if(mode == 3)//Random directioned and sleepy Dragon Mode
			while(maze.getGameState()==GameState.PLAYING)
			{
				cli.displayMaze(maze.toString());
				dir=cli.getCommands();
				maze.movimentaHeroi(dir);
				if(!maze.getDragonSleep() && maze.getDragonLifeState())
				{
					maze.movimentaDragao();
				}
				else
					maze.adormeceDragao();
				maze.checkDragonPosition();
				maze.updateSleepDragon();
			}

		cli.displayMaze(maze.toString());
		
		cli.endGame(maze.getGameState());
	}
	
	

	public static void main(String[] args) {
		Logic l=new Logic();
		
		l.play();
	}

}
