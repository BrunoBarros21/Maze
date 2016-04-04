package maze.logic;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


/**
 * Maze.java-Class responsible for the logic and the structure of the maze game.
 * @author José Monteiro and Bruno Barros.
 *
 */
public class Maze implements Serializable{
	private static final long serialVersionUID = 1L;

	public enum GameState{PLAYING,DRAGON_WIN,HERO_WIN};
	public enum GameMode{STATIC,MOVE,MOVE_AND_SLEEP};

	private char labirinth[][];
	private Hero hero;
	private LinkedList<Dragon> dragons = new LinkedList<Dragon>();
	private Sword sword;
	private Exit exit;
	private GameState state;
	private GameMode mode;
	/**
	 * Costructor of the class that receive the structure of the maze and the initial positions of the objects.
	 * @param m A Char variable type.
	 */
	public Maze(char [][] m)
	{
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				if (m[i][j] == 'H')
					hero= new Hero(i,j);
				
				else if (m[i][j] == 'D')
				{
					Dragon dragon=new Dragon(i,j);
					dragons.add(dragon);
				}
				
				else if (m[i][j] == 'E')
					sword=new Sword(i,j);
				
				else if (m[i][j] == 'S')
					exit=new Exit(i,j);
			}
			
		}
		state=GameState.PLAYING;
		labirinth = m;

	}


	//GET'S-------------------------------
	/**
	 * Retrieve the "Exit" object.
	 * @return A Exit data type.
	 */
	public Exit getExit(){
		return exit;
	}
	/**
	 * Retrieve the "Sword" object.
	 * @return A Sword data type.
	 */
	public Sword getSword(){
		return sword;
	}
	/**
	 * Retrieve the state of the game (Playing, Hero win or Hero loose).
	 * @return A Enum data type.
	 */
	public GameState getGameState(){
		return state;
	}
	/**
	 * Retrieve the life state of the dragon passed as parameter.
	 * @param dragon A Dragon variable type.
	 * @return A Boolean data type.
	 */
	public boolean getDragonLifeState(Dragon dragon){
		return dragon.getLifeState();
	}
	/**
	 * Retrieve the mode (sleeping or awake) of the dragon passed as parameter.
	 * @param dragon A Dragon variable type.
	 * @return A Boolean data type.
	 */
	public boolean getDragonSleep(Dragon dragon){
		return dragon.getSleep();
	}
	/**
	 * Retrieve the state of the hero (armed or unarmed).
	 * @return A Boolean data type.
	 */
	public boolean getHeroArmed()
	{
		return hero.getEspada();
	}
	/**
	 * Retrieve the hero x coordinates in the maze.
	 * @return A Int data type.
	 */
	public int getHeroX()
	{
		return hero.getX();
	}
	/**
	 * Retrieve the hero y coordinates in the maze.
	 * @return A Int data type.
	 */
	public int getHeroY()
	{
		return hero.getY();
	}
	/**
	 * Retrieve the hero object of the maze.
	 * @return A Hero data type.
	 */
	public Hero getHero(){
		return hero;
	}
	/**
	 * Retrieve the game mode (static dragon, moving dragon and sleepy and moving dragon).
	 * @return A Enum data type.
	 */
	public GameMode getMode(){
		return mode;
	}
	/**
	 * Retrieve the dragons of the maze.
	 * @return A LinkedList data type.
	 */
	public LinkedList<Dragon> getDragons(){
		return dragons;
	}
	/**
	 * Retrieve the maze structure.
	 * @return A Char[][] data type.
	 */
	public char[][] getLabirinth(){
		return labirinth;
	}
	//-------------------------------------
	/**
	 * Changes the cell with coordinates x,y to the cell C.
	 * @param x A Int data type.
	 * @param y A Int data type.
	 * @param c A Char data type.
	 */
	public void setALabirinthPosition(int x, int y, char c){
		labirinth[x][y] = c;
	}
	/**
	 * Set the game mode (static dragon,moving dragon and sleeping and moving dragon) of the current maze.
	 * @param t A Int variable type.
	 */
	public void setMode(int t){
		if(t==0)
			mode=GameMode.STATIC;
		else if(t==1)
			mode=GameMode.MOVE;
		else 
			mode=GameMode.MOVE_AND_SLEEP;
	}
	/**
	 * This function is responsible for all the conditions to move the hero. It receive a direction as a parameter and verify if the direction is a valid one. If is a valid direction it actualize the cells of the maze according to the move that was made.
	 * @param direction A variable of type char.
	 */
	public void moveHero(char direction)
	{
		if (direction == 'a')
		{
			if(labirinth[hero.getX()][hero.getY() - 1] != 'X')
			{
				if(labirinth[hero.getX()][hero.getY() - 1] == ' ')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('a');
					if(hero.getEspada())
						labirinth[hero.getX()][hero.getY()] = 'A';
					else
						labirinth[hero.getX()][hero.getY()] = 'H';
				}

				else if(labirinth[hero.getX()][hero.getY() - 1] == 'E')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('a');
					labirinth[hero.getX()][hero.getY()] = 'A';
					hero.setEspada();
					sword.pickSword();
				}

				else if(labirinth[hero.getX()][hero.getY() - 1] == 'D')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('a');
					labirinth[hero.getX()][hero.getY()] = 'A';
				}
			}
		}

		else if (direction == 's')
		{
			if(labirinth[hero.getX() + 1][hero.getY()] != 'X')
			{
				if(labirinth[hero.getX() + 1][hero.getY()] == ' ')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('s');
					if(hero.getEspada())
						labirinth[hero.getX()][hero.getY()] = 'A';
					else
						labirinth[hero.getX()][hero.getY()] = 'H';
				}

				else if(labirinth[hero.getX() + 1][hero.getY()] == 'E')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('s');
					labirinth[hero.getX()][hero.getY()] = 'A';
					hero.setEspada();
					sword.pickSword();
				}

				else if(labirinth[hero.getX() + 1][hero.getY()] == 'D')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('s');
					labirinth[hero.getX()][hero.getY()] = 'A';
				}
			}
		}

		else if (direction == 'd')
		{
			if(labirinth[hero.getX()][hero.getY() + 1] != 'X')
			{
				if(labirinth[hero.getX()][hero.getY() + 1] == ' ')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('d');
					if(hero.getEspada())
						labirinth[hero.getX()][hero.getY()] = 'A';
					else
						labirinth[hero.getX()][hero.getY()] = 'H';
				}

				else if(labirinth[hero.getX()][hero.getY() + 1] == 'E')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('d');
					labirinth[hero.getX()][hero.getY()] = 'A';
					hero.setEspada();
					sword.pickSword();
				}

				else if(labirinth[hero.getX()][hero.getY() + 1] == 'D')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('d');
					labirinth[hero.getX()][hero.getY()] = 'A';
				}
			}
		}

		else if (direction == 'w')
		{
			if(labirinth[hero.getX() - 1][hero.getY()] != 'X')
			{
				if(labirinth[hero.getX() - 1][hero.getY()] == ' ')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('w');
					if(hero.getEspada())
						labirinth[hero.getX()][hero.getY()] = 'A';
					else
						labirinth[hero.getX()][hero.getY()] = 'H';
				}

				else if(labirinth[hero.getX() - 1][hero.getY()] == 'E')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('w');
					labirinth[hero.getX()][hero.getY()] = 'A';
					hero.setEspada();
					sword.pickSword();
				}

				else if(labirinth[hero.getX() - 1][hero.getY()] == 'D')
				{
					labirinth[hero.getX()][hero.getY()] = ' ';
					hero.move('w');
					labirinth[hero.getX()][hero.getY()] = 'A';
				}
			}
		}
		if(checkAllDragonsLife() && hero.getX() == exit.getX() && hero.getY() == exit.getY())
		{
			exit.setHeroOut();
			state=GameState.HERO_WIN;
		}
	}
	/**
	 * This function is responsible for all the conditions to move the dragon. It uses the function getRandomDirection() to get a direction and then verify's if that direction is a valid one for the specific dragon. If it is valid the dragon is moved and the cells are actualized according to the move that was made.
	 * @param dragon A variable of type Dragon.
	 */
	public 	void moveDragon(Dragon dragon){
		boolean gotDir=false;

		while(!gotDir)
		{
			char dir=getRandomDirection();

			if (dir == 'a')
			{
				if(labirinth[dragon.getX()][dragon.getY() - 1] != 'X')
				{
					if(labirinth[dragon.getX()][dragon.getY() - 1] == ' ')
					{
						if (dragon.getX() == sword.getX() && dragon.getY() == sword.getY())
							labirinth[dragon.getX()][dragon.getY()] = 'E';
						else
							labirinth[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.move('a');
							labirinth[dragon.getX()][dragon.getY()] = 'D';

						}
						gotDir=true;
					}

					else if(labirinth[dragon.getX()][dragon.getY() - 1] == 'E')
					{
						labirinth[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.move('a');
							labirinth[dragon.getX()][dragon.getY()] = 'F';
						}
						gotDir=true;
					}
					else if(labirinth[dragon.getX()][dragon.getY() - 1] == 'H')
					{
						state=GameState.DRAGON_WIN;
						gotDir=true;
					}
					else if(labirinth[dragon.getX()][dragon.getY() - 1] == 'A')
					{
						labirinth[dragon.getX()][dragon.getY()] = ' ';
						dragon.setDragonLife();
						gotDir=true;
					}
				}
			}

			else if (dir == 's')
			{
				if(labirinth[dragon.getX() + 1][dragon.getY()] != 'X')
				{
					if(labirinth[dragon.getX() + 1][dragon.getY()] == ' ')
					{
						if (dragon.getX() == sword.getX() && dragon.getY() == sword.getY())
							labirinth[dragon.getX()][dragon.getY()] = 'E';
						else
							labirinth[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.move('s');
							labirinth[dragon.getX()][dragon.getY()] = 'D';
						}
						gotDir=true;
					}
					else if(labirinth[dragon.getX() + 1][dragon.getY()] == 'E')
					{
						labirinth[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.move('s');
							labirinth[dragon.getX()][dragon.getY()] = 'F';
						}
						gotDir=true;
					}
					else if(labirinth[dragon.getX()+1][dragon.getY()] == 'H')
					{
						state=GameState.DRAGON_WIN;
						gotDir=true;
					}
					else if(labirinth[dragon.getX()+1][dragon.getY()] == 'A')
					{
						labirinth[dragon.getX()][dragon.getY()] = ' ';
						dragon.setDragonLife();
						gotDir=true;
					}
				}
			}

			else if (dir == 'd')
			{
				if(labirinth[dragon.getX()][dragon.getY() + 1] != 'X')
				{
					if(labirinth[dragon.getX()][dragon.getY() + 1] == ' ')
					{
						if (dragon.getX() == sword.getX() && dragon.getY() == sword.getY())
							labirinth[dragon.getX()][dragon.getY()] = 'E';
						else
							labirinth[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.move('d');
							labirinth[dragon.getX()][dragon.getY()] = 'D';
						}
						gotDir=true;
					}
					else if(labirinth[dragon.getX()][dragon.getY() + 1] == 'E')
					{
						labirinth[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.move('d');
							labirinth[dragon.getX()][dragon.getY()] = 'F';
						}
						gotDir=true;
					}
					else if(labirinth[dragon.getX()][dragon.getY() + 1] == 'H')
					{
						state=GameState.DRAGON_WIN;
						gotDir=true;
					}
					else if(labirinth[dragon.getX()][dragon.getY() + 1] == 'A')
					{
						labirinth[dragon.getX()][dragon.getY()] = ' ';
						dragon.setDragonLife();
						gotDir=true;
					}
				}
			}

			else if (dir == 'w')
			{
				if(labirinth[dragon.getX() - 1][dragon.getY()] != 'X')
				{
					if(labirinth[dragon.getX() - 1][dragon.getY()] == ' ')
					{
						if (dragon.getX() == sword.getX() && dragon.getY() == sword.getY())
							labirinth[dragon.getX()][dragon.getY()] = 'E';
						else
							labirinth[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.move('w');
							labirinth[dragon.getX()][dragon.getY()] = 'D';
						}
						gotDir=true;
					}

					else if(labirinth[dragon.getX() - 1][dragon.getY()] == 'E')
					{
						labirinth[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.move('w');
							labirinth[dragon.getX()][dragon.getY()] = 'F';
						}
						gotDir=true;
					}
					else if(labirinth[dragon.getX()-1][dragon.getY()] == 'H')
					{
						state=GameState.DRAGON_WIN;
						gotDir=true;
					}
					else if(labirinth[dragon.getX()-1][dragon.getY()] == 'A')
					{
						labirinth[dragon.getX()][dragon.getY()] = ' ';
						dragon.setDragonLife();
						gotDir=true;
					}
				}
			}
		}
	}
	/**
	 * Update the mode (sleep or awake) of the dragon passed as parameter. The mode is switched by generating a random number between 0 and 3, if the number is 1 the dragon passes to sleep mode else passes to mode awake. Retrieve true if dragon was set to sleep otherwise retrieve false.
	 * @param dragon A Dragon variable type.
	 * @return A Boolean data type.
	 */
	public boolean updateSleepDragon(Dragon dragon){
		Random rand=new Random();

		int num=rand.nextInt(4);

		if(num==1){
			dragon.setSleep(true);
			return true;
			}
		else{
			dragon.setSleep(false);
			return false;
		}

	}
	/**
	 * Generates a random number between 0 and 3 to make a random direction to the dragons.
	 * @return A Char data type.
	 */
	public char getRandomDirection(){
		Random r=new Random();

		int num_dir=r.nextInt(4);

		char dir=' ';

		switch(num_dir){
		case 0:
			dir='w';
			break;
		case 1:
			dir='a';
			break;
		case 2:
			dir='s';
			break;
		case 3:
			dir='d';
			break;
		default:
			break;
		}
		return dir;
	}
	/**
	 * Verify if the dragon passed as a parameter is near to the hero.
	 * @param dragon A variable of type Dragon.
	 */
	public void checkDragonPosition(Dragon dragon) {
		if (dragon.getLifeState()) {
			if (!(hero.getEspada())) {
				if (labirinth[hero.getX() + 1][hero.getY()] == 'D')
					state = GameState.DRAGON_WIN;
				else if (labirinth[hero.getX()][hero.getY() + 1] == 'D')
					state = GameState.DRAGON_WIN;
				else if (labirinth[hero.getX() - 1][hero.getY()] == 'D')
					state = GameState.DRAGON_WIN;
				else if (labirinth[hero.getX()][hero.getY() - 1] == 'D')
					state = GameState.DRAGON_WIN;
			} else if (hero.getEspada()) {
				if (labirinth[dragon.getX() + 1][dragon.getY()] == 'A') {
					dragon.setDragonLife();
					labirinth[dragon.getX()][dragon.getY()] = ' ';
				} else if (labirinth[dragon.getX()][dragon.getY() + 1] == 'A') {
					dragon.setDragonLife();
					labirinth[dragon.getX()][dragon.getY()] = ' ';
				} else if (labirinth[dragon.getX() - 1][dragon.getY()] == 'A') {
					dragon.setDragonLife();
					labirinth[dragon.getX()][dragon.getY()] = ' ';
				} else if (labirinth[dragon.getX()][dragon.getY() - 1] == 'A') {
					dragon.setDragonLife();
					labirinth[dragon.getX()][dragon.getY()] = ' ';
				}
			}

		}

	}
	/**
	 * Update the symbol of the dragon in case of he is in sleep mode.
	 * @param dragon A Dragon variable type.
	 */
	public void adormeceDragao(Dragon dragon) {
		if (labirinth[dragon.getX()][dragon.getY()] == 'D'){
			labirinth[dragon.getX()][dragon.getY()] = 'd';
			dragon.setSleep(true);
			}
		else if (labirinth[dragon.getX()][dragon.getY()] == 'F'){
			labirinth[dragon.getX()][dragon.getY()] = 'f';
			dragon.setSleep(true);
		}
	}
	/**
	 * Verify the life state of all dragons, return true if all the dragons are dead, otherwise return false.
	 * @return A Boolean data type.
	 */
	public boolean checkAllDragonsLife(){

		for(Iterator<Dragon> iterator=dragons.iterator();iterator.hasNext();)
		{
			if(iterator.next().getLifeState())
				return false;
		}
		labirinth[exit.getX()][exit.getY()]=' ';
		return true;
	}
	/**
	 * Update the position of all dragons.
	 */
	public void moveAllDragons(){
		if (mode == GameMode.MOVE)
		{
			for(Iterator<Dragon> iterator=dragons.iterator();iterator.hasNext();)
			{
				Dragon d = iterator.next();
				if(d.getLifeState())
					moveDragon(d);
			}
		}
		if (mode == GameMode.MOVE_AND_SLEEP)
		{
			for(Iterator<Dragon> iterator=dragons.iterator();iterator.hasNext();)
			{
				Dragon d = iterator.next();
				if(d.getLifeState())
				{
					if (!d.getSleep())
					{
						moveDragon(d);
					}
					else 
						adormeceDragao(d);
				}
			}
		}
	}
	/**
	 * Verify if the hero is side by side with any dragon.
	 */
	public void checkAllDragonsPositions(){
		for(Iterator<Dragon> iterator=dragons.iterator();iterator.hasNext();)
		{
			checkDragonPosition(iterator.next());
		}
	}
	/**
	 * Update the mode (sleep or awake) of all dragons.
	 */
	public void updateAllSleepDragons(){
		for(Iterator<Dragon> iterator=dragons.iterator();iterator.hasNext();)
		{
			updateSleepDragon(iterator.next());
		}
	}
	/**
	 * Call all the update functions related to the dragons (move,sleep and collisions functions).
	 */
	public void updateDragons(){
			moveAllDragons();
			updateAllSleepDragons();
			checkAllDragonsPositions();
			checkAllDragonsLife();
	}
	
	@Override
	public String toString()
	{
		String s = "";
		for(int i = 0; i < labirinth.length; i++)
		{
			for (int j = 0; j < labirinth[i].length; j++)
			{
				s=s+labirinth[i][j];
				s+=" ";
			}
			s+="\n";
		}
		return s;
	}

}
