package maze.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import maze.logic.Logic;
import maze.logic.Maze;
import maze.logic.MazeGenerator;
import maze.logic.Maze.GameMode;
import maze.logic.Maze.GameState;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GraphicsMenu extends JFrame{

	private JFrame frame;
	private JTextField mazeSize;
	private JTextField numDragons;
	JButton btnUp;
	JButton btnRight;
	JButton btnDown;
	JButton btnLeft;
	JLabel info;
	private int md;
	private Maze maze;
	private int size=11;
	private int nDragons=1;
	private ArrayList<JButton> mButtons=new ArrayList<JButton>();
	private GraphicsGame graphicsMaze;
	public static GraphicsMenu window;
	private Boolean isPlaying=false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window=new GraphicsMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GraphicsMenu() {
		initialize();

	}

	public GraphicsMenu(char[][] m) {
		initialize();
		maze = new Maze(m);
		playing(maze);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*JTextArea mazeArea = new JTextArea();
		mazeArea.setBounds(565, 192, 190, 197);
		frame.getContentPane().add(mazeArea);
		mazeArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		mazeArea.setEditable(false);
		mazeArea.setToolTipText("");*/
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		Image panel = new Image();
		frame.getContentPane().add(panel);

		JLabel numDragonsRange = new JLabel("[1 , 4]");
		numDragonsRange.setBounds(281, 60, 45, 14);

		btnUp = new JButton("UP");
		btnUp.setBounds(647, 30, 80, 23);

		btnLeft = new JButton("LEFT");
		btnLeft.setBounds(595, 64, 80, 23);

		btnDown = new JButton("DOWN");
		btnDown.setBounds(647, 98, 80, 23);


		JButton btnGenerateButton = new JButton("Generate Maze");
		btnGenerateButton.setBounds(439, 11, 128, 23);

		JButton btnEndGame = new JButton("End Game");
		btnEndGame.setBounds(438, 91, 129, 23);

		JButton CreateMaze = new JButton("Create Maze");
		CreateMaze.setBounds(439, 50, 128, 23);

		btnRight = new JButton("RIGHT");
		btnRight.setBounds(694, 64, 80, 23);

		JLabel lblTipoDeDrages = new JLabel("Type of dragons");
		lblTipoDeDrages.setBounds(28, 102, 107, 14);

		JComboBox dragonType = new JComboBox();
		dragonType.setBounds(164, 95, 249, 20);
		dragonType.setModel(new DefaultComboBoxModel(new String[] {"Static Dragon", "Random directioned Dragon", "Random directioned and sleepy Dragon"}));

		info = new JLabel("You can generate your maze.");
		info.setBounds(28, 156, 431, 14);

		//Jogo com Imagens -------------------------------
		graphicsMaze=new GraphicsGame();
		graphicsMaze.setBounds(28, 183, 35*11, 35*11);
		graphicsMaze.setFocusable(true);

		JLabel mazeSizeRange = new JLabel("[7 , 23]");
		mazeSizeRange.setBounds(281, 26, 45, 14);

		JLabel MazeDimension = new JLabel("Maze dimensions");
		MazeDimension.setBounds(28, 26, 120, 14);

		mazeSize = new JTextField();
		mazeSize.setBounds(177, 23, 86, 20);
		mazeSize.setText("11");
		mazeSize.setColumns(10);

		JLabel NumberOfDragons = new JLabel("Number of dragons");
		NumberOfDragons.setBounds(28, 68, 120, 14);

		numDragons = new JTextField();
		numDragons.setBounds(177, 57, 86, 20);
		numDragons.setText("1");
		numDragons.setColumns(10);
		graphicsMaze.setLayout(null);
		panel.setLayout(null);
		panel.add(btnLeft);
		panel.add(btnRight);
		panel.add(btnDown);
		panel.add(info);
		panel.add(graphicsMaze);
		panel.add(btnUp);
		panel.add(NumberOfDragons);
		panel.add(MazeDimension);
		panel.add(mazeSize);
		panel.add(mazeSizeRange);
		panel.add(numDragons);
		panel.add(numDragonsRange);
		panel.add(lblTipoDeDrages);
		panel.add(dragonType);
		panel.add(btnEndGame);
		panel.add(btnGenerateButton);
		panel.add(CreateMaze);
		
		JButton btnNewButton = new JButton("Saved Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectInputStream is = null;
				try {
					is = new ObjectInputStream(new FileInputStream("savedFiles/file.dat"));
					try {
						maze = (Maze) is.readObject();
					} catch (ClassNotFoundException f) {
						f.printStackTrace();
					}
				}
				catch (IOException f){}
				finally { if (is != null)
					try {
						is.close();
					} catch (IOException f) {
						f.printStackTrace();
					} }
				playing(maze);
			}
		});
		btnNewButton.setBounds(438, 127, 129, 25);
		panel.add(btnNewButton);

		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextTurn('d');
				//mazeArea.setText(maze.toString());
				graphicsMaze.requestFocus();
			}
		});
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextTurn('s');
				//mazeArea.setText(maze.toString());
				graphicsMaze.requestFocus();
			}
		});
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextTurn('a');
				//mazeArea.setText(maze.toString());
				graphicsMaze.requestFocus();
			}
		});
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextTurn('w');
				//mazeArea.setText(maze.toString());
				graphicsMaze.requestFocus();
			}
		});

		CreateMaze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				graphicsMaze.setFocusable(true);
				
				try
				{
					nDragons=Integer.parseInt(numDragons.getText());
					size=Integer.parseInt(mazeSize.getText());
					if(size%2==0)
						size++;
					if((size < 5 && size < 5) || (size>23 && size>23))
					throw new IllegalArgumentException();
				if(nDragons>4 || nDragons<1)
					throw new IllegalArgumentException();
				} catch(NumberFormatException e)	
				{
					info.setText("Wrong type of arguments. Verify your arguments and generate your maze.");
					return;
				} catch(IllegalArgumentException e)
				{
					info.setText("Arguments out of range, please choose other arguments.");
					return;
				}
				

				if(dragonType.getSelectedIndex()==0)
					md = 0;//Static Dragon
				else if((Integer)dragonType.getSelectedIndex()==1)
					md = 1;//Move Dragon
				else if((Integer)dragonType.getSelectedIndex()==2)
					md = 2;//Move and sleep Dragon

				JFrame f = new MazeCreator(size, nDragons, window, md);			
			}
		});
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isPlaying){
				ObjectOutputStream os = null;
				try {
				os = new ObjectOutputStream( new FileOutputStream("savedFiles/file.dat"));
				os.writeObject(maze);
				}
				catch (IOException i) {}
				finally { if (os != null)
					try {
						os.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					} }
				}
				System.exit(0);
			}
		});
		btnGenerateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				graphicsMaze.setFocusable(true);

				try
				{
					nDragons=Integer.parseInt(numDragons.getText());
					size=Integer.parseInt(mazeSize.getText());
					if(size%2==0)
						size++;
				} catch(NumberFormatException e)	
				{
					info.setText("Wrong type of arguments. Verify your arguments and generate your maze.");
					return;
				}

				try{
					MazeGenerator mazeBuild=new MazeGenerator(size,size,nDragons);
					mazeBuild.startMaze();
					maze=new Maze(mazeBuild.getMaze());
				} catch(IllegalArgumentException e)
				{
					info.setText("Arguments out of range, please choose other arguments.");
					return;
				}
				if(dragonType.getSelectedIndex()==0)
					maze.setMode(0);//Static Dragon
				else if((Integer)dragonType.getSelectedIndex()==1)
					maze.setMode(1);//Move Dragon
				else if((Integer)dragonType.getSelectedIndex()==2)
					maze.setMode(2);//Move and sleep Dragon

				playing(maze);
			}
		});




		//frame.pack();
	}

	public void playing(Maze m){
		maze = m;
		
		graphicsMaze.setMazeGraph(maze.getLabirinth());
		graphicsMaze.setBounds(41, 192, 35*maze.getLabirinth().length, 35*maze.getLabirinth().length);
		frame.setBounds(100, 100, 800+15*maze.getLabirinth().length, 250+35*maze.getLabirinth().length);
		graphicsMaze.requestFocus();



		//mazeArea.setText(maze.toString());

		btnUp.setEnabled(true);
		btnDown.setEnabled(true);
		btnLeft.setEnabled(true);
		btnRight.setEnabled(true);

		mButtons.add(btnUp);
		mButtons.add(btnDown);
		mButtons.add(btnLeft);
		mButtons.add(btnRight);

		graphicsMaze.repaint();
		
		isPlaying=true;

		info.setText("You can Play!");
	}

	public void moveCaracters(char dir)
	{
		maze.moveHero(dir);
		maze.updateDragons();

	}

	public void setButtonsOff(){
		btnUp.setEnabled(false);
		btnRight.setEnabled(false);
		btnDown.setEnabled(false);
		btnLeft.setEnabled(false);
	}

	public void verifyGameState(){
		if(maze.getGameState()!=GameState.PLAYING)
		{
			if(maze.getGameState()==GameState.HERO_WIN)
			{
				info.setText("Hero win!");
			}
			else if(maze.getGameState()==GameState.DRAGON_WIN)
			{
				info.setText("Hero loose!");
			}
			setButtonsOff();
			graphicsMaze.setFocusable(false);
			isPlaying=false;
		}
	}

	public void nextTurn(char dir)
	{
		moveCaracters(dir);
		graphicsMaze.setMazeGraph(maze.getLabirinth());
		graphicsMaze.setDirection(dir);
		graphicsMaze.repaint();
		verifyGameState();

	}
}