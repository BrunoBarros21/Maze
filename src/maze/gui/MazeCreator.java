package maze.gui;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import maze.logic.Maze;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class MazeCreator extends JFrame{

	private JFrame graphicCreator;
	private GraphicsMenu parent;
	private int size = 11;
	private int numD = 1;
	private int mode = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MazeCreator window = new MazeCreator(11, 1, new GraphicsMenu(), 0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MazeCreator(int s, int d, GraphicsMenu p, int m) {
		size = s;
		numD = d;
		parent = p;
		mode = m;
		initialize();
	}

	private void initialize() {
		graphicCreator = new JFrame(); 
		graphicCreator.setTitle("Graphics Demo");
		graphicCreator.setBounds(100, 100, 500, 500);
		graphicCreator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		MazeCreatorPanel panel = new MazeCreatorPanel(size, numD);
		graphicCreator.getContentPane().add(panel);
		panel.setBounds(100,100,35*size,35*size);
		graphicCreator.setBounds(100,100,200+35*size,200+35*size);
		
		JButton btnFinish = new JButton("Play");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel.verifyMaze())
				{
					System.out.println("saiu");
					//chama aqui a cena de começar o jogo com o labirinth
					Maze m = new Maze(panel.getMaze());
					m.setMode(mode);
					parent.playing(m);
				} 
				else
				{
					panel.reiniciateArrays();
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(396, Short.MAX_VALUE)
					.addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(223, Short.MAX_VALUE)
					.addComponent(btnFinish)
					.addGap(215))
		);
		panel.setLayout(gl_panel);

		graphicCreator.setVisible(true);
		
		panel.requestFocus();
	}

}
