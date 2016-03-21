package maze.logic;
public class Hero 
{
	private int x;
	private int y;
	private boolean espada;
	
	public Hero(int x,int y)
	{
		this.x = x;
		this.y = y;
		espada = false;
	}
	//GET'S------------------
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public boolean getEspada()
	{
		return espada;
	}
	//SET'S------------------
	public void setEspada()
	{
		espada = true;
	}
	
	public void move(char direcao)
	{
		if (direcao == 'a')
			y--;
		if (direcao == 's')
			x++;
		if (direcao == 'd')
			y++;
		if (direcao == 'w')
			x--;
	}
	
	public static void main(String[] args) 
	{
		
	}
}
