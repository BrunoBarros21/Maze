package maze.gui;

import java.awt.Component;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Graphics {

	private JFrame frame;
	private JTextField mazeSize;
	private JTextField numDragons;
	private Maze maze;
	private ArrayList<JButton> mButtons=new ArrayList<JButton>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphics window = new Graphics();
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
	public Graphics() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel MazeDimension = new JLabel("Maze dimensions");
		MazeDimension.setBounds(31, 24, 144, 36);
		frame.getContentPane().add(MazeDimension);
		
		mazeSize = new JTextField();
		mazeSize.setText("11");
		mazeSize.setBounds(178, 29, 93, 22);
		frame.getContentPane().add(mazeSize);
		mazeSize.setColumns(10);
		
		JLabel NumberOfDragons = new JLabel("Number of dragons");
		NumberOfDragons.setBounds(31, 74, 124, 22);
		frame.getContentPane().add(NumberOfDragons);
		
		numDragons = new JTextField();
		numDragons.setText("1");
		numDragons.setBounds(178, 74, 93, 22);
		frame.getContentPane().add(numDragons);
		numDragons.setColumns(10);
		
		JLabel lblTipoDeDrages = new JLabel("Type of dragons");
		lblTipoDeDrages.setBounds(31, 119, 124, 22);
		frame.getContentPane().add(lblTipoDeDrages);
		
		JComboBox dragonType = new JComboBox();
		dragonType.setModel(new DefaultComboBoxModel(new String[] {"Static Dragon", "Random directioned Dragon", "Random directioned and sleepy Dragon"}));
		dragonType.setBounds(178, 119, 201, 22);
		frame.getContentPane().add(dragonType);
		
		JLabel Info = new JLabel("You can generate your maze.");
		Info.setBounds(31, 454, 177, 22);
		frame.getContentPane().add(Info);
		
		JTextArea mazeArea = new JTextArea();
		mazeArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		mazeArea.setEditable(false);
		mazeArea.setToolTipText("");
		mazeArea.setBounds(42, 171, 263, 266);
		frame.getContentPane().add(mazeArea);
		
		
		JButton btnUp = new JButton("UP");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveCaracters('w');
				verifyGameState(Info,mButtons.toArray());
				mazeArea.setText(maze.toString());
			}
		});
		btnUp.setBounds(396, 225, 75, 25);
		frame.getContentPane().add(btnUp);
		
		JButton btnLeft = new JButton("LEFT");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveCaracters('a');
				verifyGameState(Info,mButtons.toArray());
				mazeArea.setText(maze.toString());
			}
		});
		btnLeft.setBounds(351, 263, 75, 25);
		frame.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("RIGHT");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveCaracters('d');
				verifyGameState(Info,mButtons.toArray());
				mazeArea.setText(maze.toString());
			}
		});
		btnRight.setBounds(441, 263, 75, 25);
		frame.getContentPane().add(btnRight);
		
		JButton btnDown = new JButton("DOWN");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveCaracters('s');
				verifyGameState(Info,mButtons.toArray());
				mazeArea.setText(maze.toString());
			}
		});
		btnDown.setBounds(396, 301, 75, 25);
		frame.getContentPane().add(btnDown);
		
		JButton btnNewButton = new JButton("Generate Maze");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int size=Integer.parseInt(mazeSize.getText());
				int nDragons=Integer.parseInt(numDragons.getText());
				
				MazeGenerator mazeBuild=new MazeGenerator(size,size,nDragons);
				mazeBuild.startMaze();
				
				maze=new Maze(mazeBuild.getMaze());
				
				System.out.println(dragonType.getSelectedIndex());
				
				if(dragonType.getSelectedIndex()==0)
					maze.setMode(0);//Static Dragon
				else if((Integer)dragonType.getSelectedIndex()==1)
					maze.setMode(1);//Move Dragon
				else if((Integer)dragonType.getSelectedIndex()==2)
					maze.setMode(2);//Move and sleep Dragon
				
				mazeArea.setText(maze.toString());
				
				btnUp.setEnabled(true);
				btnDown.setEnabled(true);
				btnLeft.setEnabled(true);
				btnRight.setEnabled(true);
				
				mButtons.add(btnUp);
				mButtons.add(btnDown);
				mButtons.add(btnLeft);
				mButtons.add(btnRight);
				
				
				
				Info.setText("You can Play!");
				
			}
		});
		btnNewButton.setBounds(341, 30, 124, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEndGame = new JButton("End Game");
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnEndGame.setBounds(341, 73, 124, 25);
		frame.getContentPane().add(btnEndGame);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(42, 171, 263, 266);
		frame.getContentPane().add(textArea);
	}
	
	public void moveCaracters(char dir)
	{
		maze.moveHero(dir);
		maze.updateDragons();
	}
	
	public void setButtonsOff(Object[] objects){
		for(Object j: objects)
		{
			((Component) j).setEnabled(false);
		}
	}
	
	public void verifyGameState(JLabel i,Object[] objects){
		if(maze.getGameState()!=GameState.PLAYING)
		{
			if(maze.getGameState()==GameState.HERO_WIN)
			{
				i.setText("Hero win!");
			}
			else if(maze.getGameState()==GameState.DRAGON_WIN)
			{
				i.setText("Hero loose!");
			}
			setButtonsOff(objects);
		}
	}
}
