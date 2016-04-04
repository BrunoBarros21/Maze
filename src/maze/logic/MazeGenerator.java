package maze.logic;

import java.util.ArrayDeque;
import java.util.Random;
/**
 * MazeGenerator.java-Class responsible for generate a random labirinth according to the size and number of dragons given.
 * @author Jose
 *
 */
public class MazeGenerator {

	private int x, y, xB, yB;
	private int width, height;
	private char maze[][];
	private boolean b[][];
	private boolean visited[][];
	private Random rand = new Random();
	private Point heroPos,swordPos,dragonPos;
	private int numDragons;
	/**
	 * Costructor that receive's the size of the labirinth and the number of dragons.
	 * @param h A Int data type.
	 * @param w A Int data type.
	 * @param numDragons A Int data type.
	 */
	public MazeGenerator(int h,int w,int numDragons){
		
		if((h < 5 && w < 5) || (h>23 && w>23))
			throw new IllegalArgumentException();
		if(numDragons>4 || numDragons<1)
			throw new IllegalArgumentException();
			
		this.x=rand.nextInt(w);
		this.y=rand.nextInt(h);
		width=w;
		height=h;
		maze=new char[h][w];
		b = new boolean[(h - 1)/ 2][(w - 1)/ 2];
		visited=new boolean[h][w];
		this.numDragons=numDragons;
	}
//-----------------------------------------------
	/**
	 * Verify if all cells were visited.
	 * @return A Boolean data type.
	 */
	public boolean fullB()
	{
		for(int i = 0; i < b.length; i++)
		{
			for(int j = 0; j < b[i].length; j++)
			{
				if(b[i][j] == false)
					return false;
			}
		}
		return true;
	}
	/**
	 * Verify if is possible to move to any cell or is necessary to go back.
	 * @return A Boolean data type.
	 */
	public boolean haveNeighbours()
	{
		if (xB != 0)
		{
			if (b[xB - 1][yB] == false)
				return true;
		}

		if (xB != ((height -1)/2) - 1)
		{
			if (b[xB + 1][yB] == false)
				return true;
		}

		if (yB != 0)
		{
			if (b[xB][yB - 1] == false)
				return true;
		}

		if (yB != ((height -1)/2) - 1)
		{
			if (b[xB][yB + 1] == false)
				return true;
		}

		return false;

	}
	/**
	 * Generates a random direction. Returns true if was possible to move, otherwise returns false.
	 * @return A Boolean data type.
	 */
	public boolean generateDirection()
	{
		boolean end = false;

		if(haveNeighbours())
		{

			while(!end)
			{
				Random r=new Random();
				int dir=r.nextInt(4);

				if (dir == 0 && xB != 0)
				{
					if (b[xB - 1][yB] == false)
					{
						xB--;
						b[xB][yB] = true;
						x--;
						maze[x][y] = ' ';
						x--;
						end = true;
					}
				}

				if (dir == 1 && xB != ((height -1)/2) - 1)
				{
					if (b[xB + 1][yB] == false)
					{
						xB++;
						b[xB][yB] = true;
						x++;
						maze[x][y] = ' ';
						x++;
						end = true;
					}
				}

				if (dir == 2 && yB != 0)
				{
					if (b[xB][yB - 1] == false)
					{
						yB--;
						b[xB][yB] = true;
						y--;
						maze[x][y] = ' ';
						y--;
						end = true;
					}
				}

				if (dir == 3 && yB != ((height -1)/2) - 1)
				{
					if (b[xB][yB + 1] == false)
					{
						yB++;
						b[xB][yB] = true;
						y++;
						maze[x][y] = ' ';
						y++;
						end = true;
					}
				}
			}
		}
		return end;
	}
	/**
	 * Function that build all the maze.
	 */
	public void buildMaze(){
		ArrayDeque<Point> stack = new ArrayDeque<Point>();

		while(!fullB())
		{
			while(generateDirection())
			{
				stack.addFirst(new Point(x, y));
			}

			while(!generateDirection())
			{
				x = stack.getFirst().getX();
				y = stack.getFirst().getY();
				xB = (x - 1)/2;
				yB = (y - 1)/2;
				stack.removeFirst();

				if(stack.isEmpty())
					return;
			}
		}
	}
	/**
	 * Initialize the structure of the maze.
	 */
	public void fillMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if ((i % 2) == 0)
					maze[i][j] = 'X';
				else
				{
					if((j % 2) == 0)
						maze[i][j] = 'X';
					else
						maze[i][j] = ' ';
				}

			}
		}
	}
	/**
	 * Display the maze.
	 */
	public void displayMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j]+ " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	/**
	 * Generates a random exit in the maze.
	 */
	public void makeExit(){

		Random r=new Random();

		int parede=r.nextInt(3);
		int bloco;

		if(parede==0) //parede da esquerda
		{
			do
			{
				bloco=r.nextInt(width-2)+1;
			}while(bloco % 2 == 0);
			maze[bloco][0]='S';
			maze[bloco][1]=' ';
			x = bloco;
			y = 1;
			xB = (x - 1)/2;
			yB = (y - 1)/2;
			b[xB][yB] = true;
		}
		else if(parede==1){ // parede de cima
			do
			{
				bloco=r.nextInt(height-2)+1;
			}while(bloco % 2 == 0);
			maze[0][bloco]='S';
			maze[1][bloco]=' ';
			x = 1;
			y = bloco;
			xB = (x - 1)/2;
			yB = (y - 1)/2;
			b[xB][yB] = true;
		}
		else if(parede==2){ //parede da direita
			do
			{
				bloco=r.nextInt(width-2)+1;
			}while(bloco % 2 == 0);
			
			maze[bloco][height-1]='S';
			maze[bloco][height-2]=' ';
			x = bloco;
			y = height-2;
			xB = (x - 1)/2;
			yB = (y - 1)/2;
			b[xB][yB] = true;
		}
		else if(parede==3){ //parede de baixo
			do
			{
				bloco=r.nextInt(height-2)+1;
			}while(bloco % 2 == 0);
			
			maze[width-1][bloco]='S';
			maze[width-2][bloco]=' ';
			x = width-2;
			y = bloco;
			xB = (x - 1)/2;
			yB = (y - 1)/2;
			b[xB][yB] = true;
		}
	}
	/**
	 * Retrieve the structure of the maze.
	 * @return A Char[][] data type.
	 */
	public char[][] getMaze(){
		return maze;
	}
	//------------------------------------------
	/**
	 * Place all the caracters(hero,sword and dragons) in the maze.
	 */
	public void placeCaracters(){
		placeSword();
		for(int i=0;i<numDragons;i++){
		placeDragon();
		}
		placeHero();
	}
	/**
	 * Place the hero in the maze.
	 */
	public void placeHero(){
		int x = 0;
		int y = 0;
		do {
			do {
				x = rand.nextInt(height - 2) + 1;
				y = rand.nextInt(width - 2) + 1;
			} while (maze[x][y] != ' ');
		} while (!HeroToSword(x, y) && checkIfHeroAround(x,y));

		maze[x][y] = 'H';
		heroPos = new Point(x, y);
		
	}
	/**
	 * Place the dragons in the maze.
	 */
	public void placeDragon(){
		int x = 0;
		int y = 0;
		do {
			x = rand.nextInt(height - 2) + 1;
			y = rand.nextInt(width - 2) + 1;
		} while (maze[x][y] != ' ');

		maze[x][y] = 'D';
		dragonPos = new Point(x, y);

	}
	/**
	 * Place the sword in the maze.
	 */
	public void placeSword(){
		int x=0;
		int y=0;

		do {
			x = rand.nextInt(height - 2) + 1;
			y = rand.nextInt(width - 2) + 1;
		} while (maze[x][y] != ' ');

		maze[x][y] = 'E';
		swordPos = new Point(x,y);
		
	}
	/**
	 * Verify if the hero is side by side with the dragon with coordinates (x,y).
	 * @param x A Int variable type.
	 * @param y A Int variable type.
	 * @return A Boolean data type.
	 */
	public boolean checkIfHeroAround(int x, int y) {
		if (x > 1 && x < height && y > 1 && y < width) {
			if (maze[x - 1][y] == 'H')
				return false;
			else if (maze[x + 1][y] == 'H')
				return false;
			else if (maze[x][y + 1] == 'H')
				return false;
			else if (maze[x][y - 1] == 'H')
				return false;
		}

		return true;
	}
	/**
	 * Call all the functions to build the maze.
	 */
	public void startMaze(){
		fillMaze();
		fillVisitedMaze();
		makeExit();
		buildMaze();
		placeCaracters();
	}
	/**
	 * Fill the attribute responsible to verify if a cell was visited or not.
	 */
	public void fillVisitedMaze(){
		for(int i=0;i<visited.length;i++){
			for(int j=0;j<visited[i].length;j++)
			{
				visited[i][j]=false;
			}
		}
	}
	/**
	 * Verify if Hero can reach the sword from the initial position.
	 * @param x A Int variable type.
	 * @param y A Int variable type.
	 * @return  A Boolean data type.
	 */
	public boolean HeroToSword(int x,int y){
		
		if(maze[x][y]=='E')
			return true;

		if(maze[x][y]=='D' || maze[x][y]=='X')
			return false;

		visited[x][y]=true;

		if((x>0 && visited[x-1][y]==false) && HeroToSword(x-1,y))
			return true;
		else if((x<height-1 && visited[x+1][y]==false) && HeroToSword(x+1,y))
			return true;
		else if((y>0 && visited[x][y-1]==false) && HeroToSword(x,y-1))
			return true;
		else if((y<width-1 && visited[x][y+1]==false) && HeroToSword(x,y+1))
			return true;

		return false;
	}
	
	
	public static void main(String[] args) {
		
	}
}
