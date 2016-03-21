package maze.logic;


import maze.cli.CommandLine;
import maze.logic.Maze.GameMode;
import maze.logic.Maze.GameState;

public class Logic {
	private Maze maze;
	private CommandLine cli;
	private MazeGenerator mazeBuild;
	char[][] m1 = { { 'X', 'X', 'X', 'X', 'X' },
					{ 'X', 'D',' ', 'E', 'S' },
					{ 'X', 'X','X', ' ', 'X' },
					{ 'X', 'D',' ', 'H', 'X' },
					{ 'X', 'X','X', 'X', 'X' } };

	public Logic(){
		
		//maze=new Maze(m1);
		cli=new CommandLine();
	}

	public void play(){
		
		char dir;
		cli.initializeGame();
		int size=cli.getSize();
		int numDragons=cli.getNumDragons();
		mazeBuild=new MazeGenerator(size,size,numDragons);
		mazeBuild.startMaze();
		maze=new Maze(mazeBuild.getMaze());
		maze.setMode(cli.getMode()-1);
		
		if(maze.getMode() == GameMode.STATIC)//Static Dragon Mode
			while(maze.getGameState()==GameState.PLAYING)
			{
				cli.displayMaze(maze.toString());
				dir=cli.getCommands();
				maze.moveHero(dir);
				maze.checkAllDragonsPositions();
			}
		if(maze.getMode() == GameMode.MOVE)//Random directioned Dragon Mode
			while(maze.getGameState()==GameState.PLAYING)
			{
				cli.displayMaze(maze.toString());
				dir=cli.getCommands();
				maze.moveHero(dir);
				maze.updateDragons();
			}
		if(maze.getMode() == GameMode.MOVE_AND_SLEEP)//Random directioned and sleepy Dragon Mode
			while(maze.getGameState()==GameState.PLAYING)
			{
				cli.displayMaze(maze.toString());
				dir=cli.getCommands();
				maze.moveHero(dir);
				maze.updateDragons();
			}

		cli.displayMaze(maze.toString());
		
		cli.endGame(maze.getGameState());
	}
	
	

	public static void main(String[] args) {
		Logic l=new Logic();
		
		l.play();
	}

}
