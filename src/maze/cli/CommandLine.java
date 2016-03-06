package maze.cli;

import java.util.Scanner;

import maze.logic.Labirinto.GameState;

public class CommandLine {
	private Scanner info=new Scanner(System.in);
	
	public CommandLine(){
		
	}
	
	public int initializeGame(){
		System.out.println("Game Modes:\n");
		System.out.println(" 1 - Static Dragon\n");
		System.out.println(" 2 - Random directioned Dragon\n");
		System.out.println(" 3 - Random directioned and sleepy Dragon\n");
		System.out.println("Choose the game mode:\n");
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
		return op;
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
		System.out.println("Indique a direção do heroi: ");
		dir=info.next().charAt(0);
		return dir;
	}

	public static void main(String[] args) {
		
	}

}
