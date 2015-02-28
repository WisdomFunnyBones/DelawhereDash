package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TutorialPanel extends JPanel {

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

	final static String LANELABEL = "Lane label";
	final static String INVENTLABEL = "Inventory label";
	final static String GARDENLABEL = "Garden label";
	final static String WEATHERLABEL = "Weather label";
	final static String WATERLABEL = "Water label";
	static String CURRENTLABEL = LANELABEL;
	
	int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	
	
	final static String[] LABELARRAY = new String[]{LANELABEL, INVENTLABEL, GARDENLABEL, WEATHERLABEL, WATERLABEL};
	static int currentIndex = 0;
	
	JButton nextButton;
	JButton previousButton;
	JButton homeButton;
	JPanel buttonPanel;
	JPanel imagePanel;
	
	JLabel laneLabel;
	JLabel inventLabel;
	JLabel gardenLabel;
	JLabel weatherLabel;
	JLabel waterLabel;
	
	CardLayout cardLayout;

	public TutorialPanel(){
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		imagePanel = new JPanel();
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		setBackground(Color.cyan);
		cardLayout = new CardLayout();
		imagePanel.setLayout(cardLayout);
		
		nextButton = new JButton("Next");
		previousButton = new JButton("Previous");
		homeButton = new JButton("Home");

		previousButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.previous(imagePanel);
			}
			
		});
		nextButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.next(imagePanel);
			}
		});
		
		Image tut1 = null;
		Image tut2 = null;
		Image tut3 = null;
		Image tut4 = null;
		Image tut5 = null;

		try {
			tut1 = ImageIO.read(new File("images/tut1.png"));
			tut2 = ImageIO.read(new File("images/tut2.png"));
			tut3 = ImageIO.read(new File("images/tut3.png"));
			tut4 = ImageIO.read(new File("images/tut4.png"));
			tut5 = ImageIO.read(new File("images/tut5.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		double res = (double) tut1.getHeight(null)/tut1.getWidth(null);
		double width = (double) screenWidth/1.2;
		double height = (double) width*res;
		Image newTut1 = tut1.getScaledInstance((int)width, (int)height, Image.SCALE_SMOOTH);
		Image newTut2 = tut2.getScaledInstance((int)width, (int)height, Image.SCALE_SMOOTH);
		Image newTut3 = tut3.getScaledInstance((int)width, (int)height, Image.SCALE_SMOOTH);
		Image newTut4 = tut4.getScaledInstance((int)width, (int)height, Image.SCALE_SMOOTH);
		Image newTut5 = tut5.getScaledInstance((int)width, (int)height, Image.SCALE_SMOOTH);
		
		laneLabel = new JLabel(new ImageIcon(newTut1));
		weatherLabel = new JLabel(new ImageIcon(newTut4));
		gardenLabel = new JLabel(new ImageIcon(newTut3));
		inventLabel = new JLabel(new ImageIcon(newTut2));
		waterLabel = new JLabel(new ImageIcon(newTut5));

		imagePanel.setMaximumSize(laneLabel.getMinimumSize());
		imagePanel.setOpaque(false);
		
		imagePanel.add(laneLabel, LANELABEL);
		imagePanel.add(inventLabel, INVENTLABEL);
		imagePanel.add(gardenLabel, GARDENLABEL);
		imagePanel.add(weatherLabel, WEATHERLABEL);
		imagePanel.add(waterLabel, WATERLABEL);
		
		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(buttonPanel.getMinimumSize());
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		buttonPanel.add(homeButton);
		buttonPanel.add(previousButton);
		buttonPanel.add(nextButton);

		add(Box.createRigidArea(new Dimension(10, 50)));
		add(imagePanel);
		add(Box.createRigidArea(new Dimension(10, 20)));

		add(buttonPanel);
	}

}
