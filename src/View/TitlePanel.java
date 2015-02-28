package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		Image image = null;
		try {
			image = ImageIO.read(new File("images/faketitle.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = image.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
		g.drawImage(image, 0, 0, null);
	}

	JButton newGameButton;
	JButton tutorialButton;
	JPanel buttonPanel;

	int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	
	public TitlePanel(){

		setBackground(Color.green);
		
		newGameButton = new JButton("New Game");
		tutorialButton = new JButton("Tutorial");

		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new GridLayout(2, 1, 0, screenHeight/30));
		
		buttonPanel.add(newGameButton);
		buttonPanel.add(tutorialButton);
		
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(screenHeight/2 + screenHeight/5, 0, 0, 0));
		add(buttonPanel);
	}

}
