package maze.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Image extends JPanel {
 
	private BufferedImage back; 
	
	/**
	 * Create the panel.
	 */
	public Image() {
		try {
			back = ImageIO.read(new File("images/back.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
