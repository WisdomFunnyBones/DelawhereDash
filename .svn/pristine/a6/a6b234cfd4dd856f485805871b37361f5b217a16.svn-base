package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;
import Controller.GameThread;

public class EndPanel extends JPanel {

	JButton homeButton;
	
	int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	
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
	
	public EndPanel(){
		Image goodEnd = null;
		Image badEnd = null;
		try {
			goodEnd = ImageIO.read(new File("images/goodending.png"));
			badEnd = ImageIO.read(new File("images/badending.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double res = (double) goodEnd.getHeight(null)/goodEnd.getWidth(null);
		double width = (double) screenWidth/2.5;
		double height = (double) width*res;
		goodEnd = goodEnd.getScaledInstance((int)width, (int) height, Image.SCALE_SMOOTH);
		badEnd = badEnd.getScaledInstance((int)width, (int) height, Image.SCALE_SMOOTH);
		
		setLayout(new FlowLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		setBackground(Color.black);
		homeButton = new JButton("Home");
		JLabel picture;
		if (Controller.getEnviro().getAirQuality()>=1000 && Controller.getEnviro().getAnimalQuality()>=1250){
			picture = new JLabel(new ImageIcon(goodEnd));
		}
		else{
			picture = new JLabel(new ImageIcon(badEnd));
		}
		add(picture, gbc);
		//add(new JLabel(new ImageIcon(badEnd)));
		gbc.gridy++;
		add(homeButton, gbc);
		GameThread.setIntroTrue();
		Controller.getEnviro().resetEnviro();
	}
	
	
	
}
