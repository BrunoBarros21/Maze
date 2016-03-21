package maze.cli;

import java.util.Scanner;

import maze.logic.Maze.GameState;

public class CommandLine {
	private Scanner info=new Scanner(System.in);
	private int size;
	private int mode;
	private int numDragons;
	
	public CommandLine(){
		
	}
	
	public void initializeGame(){
		System.out.println("Game Modes:\n");
		System.out.println(" 1 - Static Dragon\n");
		System.out.println(" 2 - Random directioned Dragon\n");
		System.out.println(" 3 - Random directioned and sleepy Dragon\n");
		System.out.println("Choose the game mode:\n");
		mode = info.nextInt();
		System.out.println("Choose the size of the maze:");
		size=info.nextInt();
		System.out.println("How many dragons you want?");
		numDragons=info.nextInt();
	}
	
	public void endGame(GameState state){
		if(state==GameState.DRAGON_WIN)
			System.out.println("You lost the game!");
		else if(state==GameState.HERO_WIN)
			System.out.println("You won the game!");
	}
	
	public void displayMaze(String maze){
		System.out.println(maze);
	}
	
	public char getCommands(){
		char dir;
		System.out.println("Choose the direction to move the hero : ");
		dir=info.next().charAt(0);
		return dir;
	}
	
	public int getMode(){
		return mode;
	}
	
	public int getNumDragons(){
		return numDragons;
	}
	
	public int getSize(){
		return size;
	}

	public static void main(String[] args) {
		
	}

}
