package maze.logic;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;



public class Maze 
{	
	public enum GameState{PLAYING,DRAGON_WIN,HERO_WIN};
	public enum GameMode{STATIC,MOVE,MOVE_AND_SLEEP};

	private char labirinth[][];
	private Hero hero;
	private LinkedList<Dragon> dragons = new LinkedList<Dragon>();
	private Sword sword;
	private Exit exit;
	private GameState state;
	private GameMode mode;

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
	public GameState getGameState(){
		return state;
	}
	public boolean getDragonLifeState(Dragon dragon){
		return dragon.getLifeState();
	}
	public boolean getDragonSleep(Dragon dragon){
		return dragon.getSleep();
	}
	public boolean getHeroArmed()
	{
		return hero.getEspada();
	}
	public int getHeroX()
	{
		return hero.getX();
	}
	public int getHeroY()
	{
		return hero.getY();
	}
	public GameMode getMode(){
		return mode;
	}
	//-------------------------------------
	public void setMode(int t){
		if(t==0)
			mode=GameMode.STATIC;
		else if(t==1)
			mode=GameMode.MOVE;
		else if(t==2)
			mode=GameMode.MOVE_AND_SLEEP;
	}
	
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
			state=GameState.HERO_WIN;
	}

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
						//labirinth[exit.getX()][exit.getY()] = ' ';
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
						//labirinth[exit.getX()][exit.getY()] = ' ';
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
						//labirinth[exit.getX()][exit.getY()] = ' ';
						dragon.setDragonLife();
						gotDir=true;
					}
				}
			}
		}
	}

	public void updateSleepDragon(Dragon dragon){
		Random rand=new Random();

		int num=rand.nextInt(4);

		if(num==1)
			dragon.setSleep(true);
		else
			dragon.setSleep(false);

	}

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

	public void adormeceDragao(Dragon dragon) {
		if (labirinth[dragon.getX()][dragon.getY()] == 'D')
			labirinth[dragon.getX()][dragon.getY()] = 'd';
		else if (labirinth[dragon.getX()][dragon.getY()] == 'F')
			labirinth[dragon.getX()][dragon.getY()] = 'f';
	}

	public boolean checkAllDragonsLife(){

		for(Iterator<Dragon> iterator=dragons.iterator();iterator.hasNext();)
		{
			if(iterator.next().getLifeState())
				return false;
		}
		labirinth[exit.getX()][exit.getY()]=' ';
		return true;
	}

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

	public void checkAllDragonsPositions(){
		for(Iterator<Dragon> iterator=dragons.iterator();iterator.hasNext();)
		{
			checkDragonPosition(iterator.next());
		}
	}

	public void updateAllSleepDragons(){
		for(Iterator<Dragon> iterator=dragons.iterator();iterator.hasNext();)
		{
			updateSleepDragon(iterator.next());
		}
	}
	
	public void updateDragons(){
			moveAllDragons();
			updateAllSleepDragons();
			checkAllDragonsPositions();
			checkAllDragonsLife();
	}

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
