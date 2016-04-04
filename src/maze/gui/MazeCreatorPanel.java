package maze.gui;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MazeCreatorPanel extends JPanel {
	private BufferedImage wall;
	private BufferedImage ash;
	private BufferedImage dragon;
	private BufferedImage exit;
	private BufferedImage sword;
	private BufferedImage floor;
	private boolean putAsh = false; 
	private boolean putExit = false;
	private boolean putSword = false;
	private int dragonsLeft;
	private char input;
	private int size;
	private char labirinth[][];
	private boolean visited[][];
	private boolean visitedE[][];

	private int width=100, height=100;

	public void fillMaze() {
		for (int i = 0; i < labirinth.length; i++) {
			for (int j = 0; j < labirinth[i].length; j++) {
				labirinth[i][j] = 'X';
			}
		}
	}
	
	public char[][] getMaze(){
		return labirinth;
	}

	public MazeCreatorPanel(int s, int d) 
	{
		try {
			wall =  ImageIO.read(new File("images/Wall.png"));
			ash =  ImageIO.read(new File("images/NarutoNormal.png"));
			dragon =  ImageIO.read(new File("images/Akatsuki1.png"));
			sword =  ImageIO.read(new File("images/Sword.png"));
			exit =  ImageIO.read(new File("images/Exit.png"));
			floor = ImageIO.read(new File("images/Floor.png"));
			size = s;
			labirinth = new char[size][size];
			visited = new boolean[size][size];
			visitedE = new boolean[size][size];
			dragonsLeft = d;
			input = ' ';
			fillMaze();
		} catch (IOException e) {
			e.printStackTrace();
		}	

		addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX() / 35;
				int y = e.getY() / 35;



				if (e.getX() > (labirinth.length + 1) * 35)
				{
					if(e.getX() > (labirinth.length + 1) * 35 && e.getX() < (labirinth.length + 2) * 35 && e.getY() > 0 && e.getY() < 35 && !putAsh)
					{
						input = 'H';
					}

					else if(e.getX() > (labirinth.length + 1) * 35 && e.getX() < (labirinth.length + 2) * 35 && e.getY() > 35 && e.getY() < 70  && !putSword)
					{
						input = 'E';
					}

					else if(e.getX() > (labirinth.length + 1) * 35 && e.getX() < (labirinth.length + 2) * 35 && e.getY() > 70 && e.getY() < 105 && !putExit)
					{
						input = 'S';
					}

					else if(e.getX() > (labirinth.length + 1) * 35 && e.getX() < (labirinth.length + 2) * 35 && e.getY() > 105 && e.getY() < 140 && dragonsLeft > 0)
					{
						input = 'D';
					}
				}
				else if (input == 'S')
				{
					if ((x == 0 || x == labirinth[0].length -1) && y != 0 && y != labirinth.length -1)
					{
						labirinth[y][x] = input;
						putExit = true;
					}

					else if ((y == 0 || y == labirinth.length -1)&& x != 0 && x != labirinth[0].length -1)
					{
						labirinth[y][x] = input;
						putExit = true;
					}
					input = ' ';
				}

				else if (((x == 0 || x == labirinth[0].length -1) && y != 0 && y != labirinth.length -1) || ((y == 0 || y == labirinth.length -1)&& x != 0 && x != labirinth[0].length -1))
				{
					if (labirinth[y][x] == 'S'){
						labirinth[y][x] = 'X';
						putExit = false;
					}
				}

				else if (x > 0 && y > 0 && x < labirinth[0].length -1 && y < labirinth.length -1)
				{
					if (labirinth[y][x] == 'X')
					{
						labirinth[y][x] = input;
						if (labirinth[y][x] == 'H')
							putAsh = true;
						else if (labirinth[y][x] == 'E')
							putSword = true;
						else if (labirinth[y][x] == 'D')
							dragonsLeft--;
					}
					else if (labirinth[y][x] == ' '){
						if (input == ' ')
							labirinth[y][x] = 'X';
						else	
						{
							labirinth[y][x] = input;
							if (labirinth[y][x] == 'H')
								putAsh = true;
							else if (labirinth[y][x] == 'E')
								putSword = true;
							else if (labirinth[y][x] == 'D')
								dragonsLeft--;
						}
					}
					else if (labirinth[y][x] != 'X'){
						if (labirinth[y][x] == 'H')
							putAsh =false;
						else if (labirinth[y][x] == 'E')
							putSword =false;
						else if (labirinth[y][x] == 'D')
							dragonsLeft++;
						labirinth[y][x] = 'X';
					}
					input = ' ';
				}
				repaint();

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}	
		});


	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (labirinth != null)
		{
			int w = 0;
			int h = 0;

			for(int i = 0; i < labirinth.length; i++)
			{
				w = 0;
				for(int j = 0; j < labirinth[i].length; j++)
				{
					if(labirinth[i][j] == 'X')
						g.drawImage(wall, w, h,null);
					else if(labirinth[i][j] == 'D' || labirinth[i][j] == 'd' || labirinth[i][j] == 'F')
						g.drawImage(dragon, w, h,null);
					else if(labirinth[i][j] == 'H' || labirinth[i][j] == 'A')
						g.drawImage(ash, w, h,null);
					else if(labirinth[i][j] == 'E')
						g.drawImage(sword, w, h,null);
					else if(labirinth[i][j] == 'S')
						g.drawImage(exit, w, h,null);
					else 
						g.drawImage(floor, w, h,null);

					w += 35;
				}
				h += 35;
			}
			g.drawImage(ash, (labirinth.length + 1) * 35, 0, null);
			g.drawImage(sword, (labirinth.length + 1) * 35, 35, null);
			g.drawImage(exit, (labirinth.length + 1) * 35, 70, null);
			g.drawImage(dragon, (labirinth.length + 1) * 35, 105, null);
		}
	}

	public boolean heroToExit(int x,int y){

		if (visitedE != null)
		{

			visitedE[x][y]=true;

			if(labirinth[x][y]=='S')
			{
				visitedE = new boolean[size][size];
				return true;
			}

			else if(labirinth[x][y]=='X')
				return false;

			if(x>0 && (visitedE[x-1][y]==false && heroToExit(x-1,y)))
				return true;
			else if(x<labirinth.length-1 && (visitedE[x+1][y]==false && heroToExit(x+1,y)))
				return true;
			else if(y>0 && (visitedE[x][y-1]==false && heroToExit(x,y-1)))
				return true;
			else if(y<labirinth.length-1 && (visitedE[x][y+1]==false && heroToExit(x,y+1)))
				return true;

			return false;
		}
		return false;
	}
	
	public void reiniciateArrays(){
		visited = new boolean[size][size];
		visitedE = new boolean[size][size];
	}

	public boolean heroToSword(int x,int y){

		if (visited != null)
		{
			visited[x][y]=true;

			if(labirinth[x][y]=='E')
			{
				visited = new boolean[size][size];
				return heroToExit(x,y);
			}

			else if(labirinth[x][y]=='D' || labirinth[x][y]=='X')
				return false;


			if(x>0 && (visited[x-1][y]==false && heroToSword(x-1,y)))
				return true;
			else if(x<labirinth.length-1 && (visited[x+1][y]==false && heroToSword(x+1,y)))
				return true;
			else if(y>0 && (visited[x][y-1]==false && heroToSword(x,y-1)))
				return true;
			else if(y<labirinth.length-1 && (visited[x][y+1]==false && heroToSword(x,y+1)))
				return true;

			return false;
		}
		return false;
	}

	public boolean verifyMaze(){
		int numHeros = 0;
		int numExits = 0;
		int numSwords = 0;
		int heroX = 0;
		int heroY = 0;
		if (labirinth != null)
		{
			for (int i = 0; i < labirinth.length; i++)
			{
				for (int j = 0; j < labirinth[i].length; j++)
				{
					if(labirinth[i][j] == 'H')
					{
						numHeros++;
						heroX = i;
						heroY = j;
					}
					else if(labirinth[i][j] == 'S')
						numExits++;
					else if(labirinth[i][j] == 'E')
						numSwords++;
				}
			}

			if (numHeros != 1)
			{
				System.out.println("heroi");
				return false;
			}
			if (dragonsLeft != 0){
				System.out.println("dragoes");
				return false;
			}
			if (numExits != 1){
				System.out.println("saida");
				return false;
			}
			if (numSwords != 1){
				System.out.println("espada");
				return false;
			}

			System.out.println("funcao");
			return heroToSword(heroX, heroY);
		}
		return false;
	}

}
