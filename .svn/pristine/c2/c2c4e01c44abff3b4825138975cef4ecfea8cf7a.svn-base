package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComicPanel extends JPanel {

	JButton nextButton;
	JButton backButton;
	JButton playButton;
	JButton homeButton;
	JPanel buttonPanel;
	
	@Override
	protected void paintComponent(Graphics g) {
		Image background = null;
		try {
			background = ImageIO.read(new File("images/woodback.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		background = background.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
		g.drawImage(background, 0, 0, null);
	}
	
	int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	
	
	public ComicPanel(){

		setBackground(Color.blue);
		
		//nextButton = new JButton("Next");
		playButton = new JButton("Play");
		backButton = new JButton("Back");
		homeButton = new JButton("Home");
		
		//add(backButton);
		//add(nextButton);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(getBackground());
		buttonPanel.setLayout(new GridLayout(1, 2, screenWidth/20, 0));
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		Image comic = null;
		try {
			comic = ImageIO.read(new File("images/comic.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		double res = (double) comic.getHeight(null)/comic.getWidth(null);
		double width = (double) screenWidth/2.5;
		double height = (double) width*res;
		Image newComic = comic.getScaledInstance((int)width, (int)height, Image.SCALE_SMOOTH);
		add(new JLabel(new ImageIcon(newComic)), gbc);
		buttonPanel.add(homeButton);
		buttonPanel.add(backButton);
		buttonPanel.add(playButton);
		
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(screenHeight/2 + screenHeight/3, 0, 0, 0));
		//add(new JPanel());
		gbc.gridy++;
		add(buttonPanel, gbc);
	}
	
}
