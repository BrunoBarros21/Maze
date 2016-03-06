package maze.logic;

import java.util.Random;

public class Labirinto 
{	
	public enum GameState{PLAYING,DRAGON_WIN,HERO_WIN};

	private char labirinto[][];
	private Heroi hero;
	private Dragon dragon;
	private Sword sword;
	private Exit exit;
	private GameState state;

	public Labirinto()
	{
		hero= new Heroi(1,1);
		dragon=new Dragon(3,1);
		sword=new Sword(8,1);
		exit=new Exit(5,9);
		state=GameState.PLAYING;
		labirinto = geraLabirinto();

	}
	public Labirinto(char [][] m)
	{
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				if (m[i][j] == 'H')
					hero= new Heroi(i,j);
			}
			
			for(int j = 0; j < m[i].length; j++)
			{
				if (m[i][j] == 'D')
					dragon=new Dragon(i,j);
			}
			
			for(int j = 0; j < m[i].length; j++)
			{
				if (m[i][j] == 'E')
					sword=new Sword(i,j);
			}
			
			for(int j = 0; j < m[i].length; j++)
			{
				if (m[i][j] == 'S')
					exit=new Exit(i,j);
			}
			
		}
		state=GameState.PLAYING;
		labirinto = m;

	}
	

	//GET'S-------------------------------
	public GameState getGameState(){
		return state;
	}
	public int getDragonX()
	{
		return dragon.getX();
	}
	public int getDragonY()
	{
		return dragon.getY();
	}
	public boolean getDragonLifeState(){
		return dragon.getLifeState();
	}
	public boolean getDragonSleep(){
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
	//-------------------------------------
	public char[][] geraLabirinto()
	{
		char labirinto[][] = new char[10][10];

		for (int i = 0; i < labirinto.length; i++)
		{
			for(int j = 0; j < labirinto[i].length; j++)
			{
				if(i == 0 || i == 9)
					labirinto[i][j] = 'X';

				else 
				{
					if (j == 0)
						labirinto[i][j] = 'X';

					else if (j == 9)
					{
						if (i == 5)
							labirinto[i][j] = ' ';
						else
							labirinto[i][j] = 'X';
					}

					else if (j == 2 || j == 3)
					{
						if (i == 1 || i == 5)
							labirinto[i][j] = ' ';
						else 
							labirinto[i][j] = 'X';
					}

					else if (j == 5)
					{
						if (i == 1 || i == 5 || i == 8)
							labirinto[i][j] = ' ';
						else 
							labirinto[i][j] = 'X';
					}

					else if (j == 7)
					{
						if (i == 1 || i == 8)
							labirinto[i][j] = ' ';
						else 
							labirinto[i][j] = 'X';
					}

					else 
						labirinto[i][j] = ' ';

				}
			}
		}

		labirinto[hero.getX()][hero.getY()] = 'H';
		labirinto[dragon.getX()][dragon.getY()] = 'D';
		labirinto[sword.getX()][sword.getY()] = 'E';
		labirinto[exit.getX()][exit.getY()] = 'S';

		return labirinto;
	}

	public void movimentaHeroi(char direcao)
	{
		if (direcao == 'a')
		{
			if(labirinto[hero.getX()][hero.getY() - 1] != 'X')
			{
				if(labirinto[hero.getX()][hero.getY() - 1] == ' ')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('a');
					if(hero.getEspada())
						labirinto[hero.getX()][hero.getY()] = 'A';
					else
						labirinto[hero.getX()][hero.getY()] = 'H';
				}

				else if(labirinto[hero.getX()][hero.getY() - 1] == 'E')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('a');
					labirinto[hero.getX()][hero.getY()] = 'A';
					hero.setEspada();
					sword.pickSword();
				}
				
				else if(labirinto[hero.getX()][hero.getY() - 1] == 'D')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('w');
					labirinto[hero.getX()][hero.getY()] = 'A';
				}
			}
		}

		else if (direcao == 's')
		{
			if(labirinto[hero.getX() + 1][hero.getY()] != 'X')
			{
				if(labirinto[hero.getX() + 1][hero.getY()] == ' ')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('s');
					if(hero.getEspada())
						labirinto[hero.getX()][hero.getY()] = 'A';
					else
						labirinto[hero.getX()][hero.getY()] = 'H';
				}

				else if(labirinto[hero.getX() + 1][hero.getY()] == 'E')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('s');
					labirinto[hero.getX()][hero.getY()] = 'A';
					hero.setEspada();
					sword.pickSword();
				}
				
				else if(labirinto[hero.getX() + 1][hero.getY()] == 'D')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('w');
					labirinto[hero.getX()][hero.getY()] = 'A';
				}
			}
		}

		else if (direcao == 'd')
		{
			if(labirinto[hero.getX()][hero.getY() + 1] != 'X')
			{
				if(labirinto[hero.getX()][hero.getY() + 1] == ' ')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('d');
					if(hero.getEspada())
						labirinto[hero.getX()][hero.getY()] = 'A';
					else
						labirinto[hero.getX()][hero.getY()] = 'H';
				}

				else if(labirinto[hero.getX()][hero.getY() + 1] == 'E')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('d');
					labirinto[hero.getX()][hero.getY()] = 'A';
					hero.setEspada();
					sword.pickSword();
				}
				
				else if(labirinto[hero.getX()][hero.getY() + 1] == 'D')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('w');
					labirinto[hero.getX()][hero.getY()] = 'A';
				}
			}
		}

		else if (direcao == 'w')
		{
			if(labirinto[hero.getX() - 1][hero.getY()] != 'X')
			{
				if(labirinto[hero.getX() - 1][hero.getY()] == ' ')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('w');
					if(hero.getEspada())
						labirinto[hero.getX()][hero.getY()] = 'A';
					else
						labirinto[hero.getX()][hero.getY()] = 'H';
				}

				else if(labirinto[hero.getX() - 1][hero.getY()] == 'E')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('w');
					labirinto[hero.getX()][hero.getY()] = 'A';
					hero.setEspada();
					sword.pickSword();
				}

				else if(labirinto[hero.getX() - 1][hero.getY()] == 'D')
				{
					labirinto[hero.getX()][hero.getY()] = ' ';
					hero.movimenta('w');
					labirinto[hero.getX()][hero.getY()] = 'A';
				}
			}
		}
		if(!(dragon.getLifeState()) && hero.getX() == exit.getX() && hero.getY() == exit.getY())
			state=GameState.HERO_WIN;
	}

	public 	void movimentaDragao(){
		boolean gotDir=false;

		while(!gotDir)
		{
			char dir=geraDirecao();

			if (dir == 'a')
			{
				if(labirinto[dragon.getX()][dragon.getY() - 1] != 'X')
				{
					if(labirinto[dragon.getX()][dragon.getY() - 1] == ' ')
					{
						if (dragon.getX() == sword.getX() && dragon.getY() == sword.getY())
							labirinto[dragon.getX()][dragon.getY()] = 'E';
						else
							labirinto[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.movimenta('a');
							labirinto[dragon.getX()][dragon.getY()] = 'D';
							
						}
						gotDir=true;
					}

					else if(labirinto[dragon.getX()][dragon.getY() - 1] == 'E')
					{
						labirinto[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.movimenta('a');
							labirinto[dragon.getX()][dragon.getY()] = 'F';
						}
						gotDir=true;
					}
					else if(labirinto[dragon.getX()][dragon.getY() - 1] == 'H')
					{
						state=GameState.DRAGON_WIN;
						gotDir=true;
					}
					else if(labirinto[dragon.getX()][dragon.getY() - 1] == 'A')
					{
						//labirinto[dragon.getX()][dragon.getY()] = ' ';
						labirinto[5][9] = ' ';
						dragon.setDragonLife();
						gotDir=true;
					}
				}
			}

			else if (dir == 's')
			{
				if(labirinto[dragon.getX() + 1][dragon.getY()] != 'X')
				{
					if(labirinto[dragon.getX() + 1][dragon.getY()] == ' ')
					{
						if (dragon.getX() == sword.getX() && dragon.getY() == sword.getY())
							labirinto[dragon.getX()][dragon.getY()] = 'E';
						else
							labirinto[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.movimenta('s');
							labirinto[dragon.getX()][dragon.getY()] = 'D';
						}
						gotDir=true;
					}
					else if(labirinto[dragon.getX() + 1][dragon.getY()] == 'E')
					{
						labirinto[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.movimenta('s');
							labirinto[dragon.getX()][dragon.getY()] = 'F';
						}
						gotDir=true;
					}
					else if(labirinto[dragon.getX()+1][dragon.getY()] == 'H')
					{
						state=GameState.DRAGON_WIN;
						gotDir=true;
					}
					else if(labirinto[dragon.getX()+1][dragon.getY()] == 'A')
					{
						labirinto[5][9] = ' ';
						dragon.setDragonLife();
						gotDir=true;
					}
				}
			}

			else if (dir == 'd')
			{
				if(labirinto[dragon.getX()][dragon.getY() + 1] != 'X')
				{
					if(labirinto[dragon.getX()][dragon.getY() + 1] == ' ')
					{
						if (dragon.getX() == sword.getX() && dragon.getY() == sword.getY())
							labirinto[dragon.getX()][dragon.getY()] = 'E';
						else
							labirinto[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.movimenta('d');
							labirinto[dragon.getX()][dragon.getY()] = 'D';
						}
						gotDir=true;
					}
					else if(labirinto[dragon.getX()][dragon.getY() + 1] == 'E')
					{
						labirinto[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.movimenta('d');
							labirinto[dragon.getX()][dragon.getY()] = 'F';
						}
						gotDir=true;
					}
					else if(labirinto[dragon.getX()][dragon.getY() + 1] == 'H')
					{
						state=GameState.DRAGON_WIN;
						gotDir=true;
					}
					else if(labirinto[dragon.getX()][dragon.getY() + 1] == 'A')
					{
						//labirinto[dragon.getX()][dragon.getY()] = ' ';
						labirinto[5][9] = ' ';
						dragon.setDragonLife();
						gotDir=true;
					}
				}
			}

			else if (dir == 'w')
			{
				if(labirinto[dragon.getX() - 1][dragon.getY()] != 'X')
				{
					if(labirinto[dragon.getX() - 1][dragon.getY()] == ' ')
					{
						if (dragon.getX() == sword.getX() && dragon.getY() == sword.getY())
							labirinto[dragon.getX()][dragon.getY()] = 'E';
						else
							labirinto[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.movimenta('w');
							labirinto[dragon.getX()][dragon.getY()] = 'D';
						}
						gotDir=true;
					}

					else if(labirinto[dragon.getX() - 1][dragon.getY()] == 'E')
					{
						labirinto[dragon.getX()][dragon.getY()] = ' ';
						if (dragon.getLifeState())
						{
							dragon.movimenta('w');
							labirinto[dragon.getX()][dragon.getY()] = 'F';
						}
						gotDir=true;
					}
					else if(labirinto[dragon.getX()-1][dragon.getY()] == 'H')
					{
						state=GameState.DRAGON_WIN;
						gotDir=true;
					}
					else if(labirinto[dragon.getX()-1][dragon.getY()] == 'A')
					{
						//labirinto[dragon.getX()][dragon.getY()] = ' ';
						labirinto[5][9] = ' ';
						dragon.setDragonLife();
						gotDir=true;
					}
				}
			}
		}
	}
	
	public void updateSleepDragon(){
		Random rand=new Random();

		int num=rand.nextInt(4);

		if(num==1)
			dragon.setSleep(true);
		else
			dragon.setSleep(false);

	}

	public char geraDirecao(){
		Random r=new Random();

		int num_dir=r.nextInt(3);

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

	public void checkDragonPosition(){
		if (dragon.getLifeState()) {
			if (!(hero.getEspada())) {
				if (labirinto[hero.getX() + 1][hero.getY()] == 'D')
					state = GameState.DRAGON_WIN;
				else if (labirinto[hero.getX()][hero.getY() + 1] == 'D')
					state = GameState.DRAGON_WIN;
				else if (labirinto[hero.getX() - 1][hero.getY()] == 'D')
					state = GameState.DRAGON_WIN;
				else if (labirinto[hero.getX()][hero.getY() - 1] == 'D')
					state = GameState.DRAGON_WIN;
			} else if (hero.getEspada()) {
				if (labirinto[hero.getX() + 1][hero.getY()] == 'D' || labirinto[hero.getX() + 1][hero.getY()] == 'd') {
					dragon.setDragonLife();
					labirinto[dragon.getX()][dragon.getY()] = ' ';
					labirinto[exit.getX()][exit.getY()] = ' ';
				} else if (labirinto[hero.getX()][hero.getY() + 1] == 'D'
						|| labirinto[hero.getX()][hero.getY() + 1] == 'd') {
					dragon.setDragonLife();
					labirinto[dragon.getX()][dragon.getY()] = ' ';
					labirinto[exit.getX()][exit.getY()] = ' ';
				} else if (labirinto[hero.getX() - 1][hero.getY()] == 'D'
						|| labirinto[hero.getX() - 1][hero.getY()] == 'd') {
					dragon.setDragonLife();
					labirinto[dragon.getX()][dragon.getY()] = ' ';
					labirinto[exit.getX()][exit.getY()] = ' ';
				} else if (labirinto[hero.getX()][hero.getY() - 1] == 'D'
						|| labirinto[hero.getX()][hero.getY() - 1] == 'd') {
					dragon.setDragonLife();
					labirinto[dragon.getX()][dragon.getY()] = ' ';
					labirinto[exit.getX()][exit.getY()] = ' ';
				}
			}

		}

	}

	public void adormeceDragao() {
		if (labirinto[dragon.getX()][dragon.getY()] == 'D')
			labirinto[dragon.getX()][dragon.getY()] = 'd';
		else if (labirinto[dragon.getX()][dragon.getY()] == 'F')
			labirinto[dragon.getX()][dragon.getY()] = 'f';
	}

	public String toString()
	{
		String s = "";
		for(int i = 0; i < labirinto.length; i++)
		{
			for (int j = 0; j < labirinto[i].length; j++)
			{
				s=s+labirinto[i][j];
				s+=" ";
			}
			s+="\n";
		}
		return s;
	}

}
