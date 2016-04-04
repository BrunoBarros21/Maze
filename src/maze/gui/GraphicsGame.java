package maze.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GraphicsGame extends JPanel{ 
	
	private BufferedImage[] heroArmed=new BufferedImage[4];
	private BufferedImage[] heroUnarmed=new BufferedImage[4];
	private BufferedImage wall;
	private BufferedImage dragon;
	private BufferedImage sword;
	private BufferedImage exit;
	private BufferedImage floor;
	private char direction;
	
	private char[][] mazeGraph=new char[11][11];
	
	public GraphicsGame(){
		
		try {
			heroArmed[0] = ImageIO.read(new File("images/NarutoSuper.png"));
			heroArmed[1] = ImageIO.read(new File("images/NarutoSuperUp.png"));
			heroArmed[2] = ImageIO.read(new File("images/NarutoSuperLeft.png"));
			heroArmed[3] = ImageIO.read(new File("images/NarutoSuperRight.png"));
			heroUnarmed[0] =  ImageIO.read(new File("images/NarutoNormal.png"));
			heroUnarmed[1] =  ImageIO.read(new File("images/NarutoNormalUp.png"));
			heroUnarmed[2] =  ImageIO.read(new File("images/NarutoNormalLeft.png"));
			heroUnarmed[3] =  ImageIO.read(new File("images/NarutoNormalRight.png"));
			wall =  ImageIO.read(new File("images/Wall.png"));
			dragon =  ImageIO.read(new File("images/Akatsuki1.png"));
			sword =  ImageIO.read(new File("images/Sword.png"));
			exit = ImageIO.read(new File("images/Exit.png"));
			floor =ImageIO.read(new File("images/Floor.png"));
			direction='s';
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				switch (keyEvent.getKeyCode()){
				case KeyEvent.VK_UP:
					GraphicsMenu.window.nextTurn('w'); 
					break;
				case KeyEvent.VK_DOWN:
					GraphicsMenu.window.nextTurn('s');
					break;
				case KeyEvent.VK_RIGHT:
					GraphicsMenu.window.nextTurn('d');
					break;
				case KeyEvent.VK_LEFT:
					GraphicsMenu.window.nextTurn('a');
					break;
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});

	}
	
	@Override
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		drawGraphMaze(g);
	}
	
	public void setMazeGraph(char[][] m){
		mazeGraph=m;
		repaint();
	}
	
	public void setDirection(char dir) {
		direction=dir;
	}
	
	public void drawGraphMaze(java.awt.Graphics g){
		
		char [][] temp = mazeGraph;
		int x = 0;
		int y = 0;
		for(int i = 0; i < temp.length; i++)
		{
			x = 0;
			for(int j = 0; j < temp[i].length; j++)
			{
				if(temp[i][j] == 'X')
					g.drawImage(wall, x, y,null);
				else if(temp[i][j] == 'D')
					g.drawImage(dragon,x, y,null);
				else if(temp[i][j]=='d')
					g.drawImage(dragon,x, y,null);
				else if(temp[i][j]=='F')
					g.drawImage(dragon,x, y,null);
				else if(temp[i][j]=='f')
					g.drawImage(dragon,x, y,null);	
				else if(temp[i][j] == 'H')
				{
					g.drawImage(floor,x, y,null);
					if(direction=='s')
					g.drawImage(heroUnarmed[0],x, y,null);
					else if(direction=='a')
						g.drawImage(heroUnarmed[2],x, y,null);
					else if(direction=='w')
						g.drawImage(heroUnarmed[1],x, y,null);
					else if(direction=='d')
						g.drawImage(heroUnarmed[3],x, y,null);
				}
				else if(temp[i][j] == 'A')
					{
					g.drawImage(floor,x, y,null);
					if(direction=='s')
					g.drawImage(heroArmed[0],x, y,null);
					else if(direction=='a')
						g.drawImage(heroArmed[2],x, y,null);
					else if(direction=='w')
						g.drawImage(heroArmed[1],x, y,null);
					else if(direction=='d')
						g.drawImage(heroArmed[3],x, y,null);
					
					}
				else if(temp[i][j] == 'E')
					g.drawImage(sword,x, y,null);
				else if(temp[i][j]=='S')
					g.drawImage(exit, x, y, null);
				else
					g.drawImage(floor,x,y,null);
				
				x += 35;
			}
			y += 35;
		}
	}
	
}
