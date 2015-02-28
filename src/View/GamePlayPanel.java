package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.Controller;
import Controller.Controller.OnDamagedListener;
import Controller.GameThread;
import Model.Animal;
import Model.Astronaut;
import Model.Garden;
import Model.Inventory;
import Model.Inventory.OnItemAddListener;
import Model.Lane;
import Model.LaneObject;
import Model.Native;
import Model.Plant;
import Model.Water;
import Model.Weather;

public class GamePlayPanel extends JPanel implements OnItemAddListener, OnDamagedListener{

	private static final long serialVersionUID = 1L;

	int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

	int miniBossLoc =2;
	int miniBossInt=0;
	
	int COLUMN0;
	int COLUMN1;
	int COLUMN2;
	int COLUMN3;
	int COLUMN4;

	int introInt=0;
	int adder = 10;
	int acceleration=0;

	BorderLayout layout;

	JPanel weatherPanel;
	public JPanel getWeatherPanel() {
		return weatherPanel;
	}
	
	public int getBossx(){
		return miniBossLoc;
	}
	
	public int getBossY(){
		return screenHeight/20;
	}
	
	public void setMiniBossLoc(int i){
		miniBossLoc=i;
	}

	JPanel inventoryPanel;
	JPanel gardenPanel;
	JPanel oceanPanel;
	LanesPanel lanesPanel;

	public JPanel getGardenPanel(){
		return gardenPanel;
	}

	public JPanel getOceanPanel(){
		return oceanPanel;
	}
	
	public LanesPanel getLanesPanel() {
		return lanesPanel;
	}

	boolean damaged = false;
	int damageTimer = 0;
	boolean dmgTimerRunning = false;

	BoxLayout inventoryLayout;

	GenericItem item0;
	GenericItem item1;
	GenericItem item2;
	GenericItem item3;
	GenericItem item4;
	GenericItem item5;

	ImageIcon laneIcon;

	int lanesPanelWidth;
	final int spacerWidth;

	final Image finLanesImg;
	int astroWidth;
	int astroHeight;

	public boolean fact = false;
	public boolean question = false;

	public int getAstroWidth() {
		return astroWidth;
	}

	public int getAstroHeight() {
		return astroHeight;
	}

	public Timer factTimer;
	public Timer answerTimer;
	public int factDuration;
	public int answerDuration;

	int background1=0;
	int background2=0;
	int background3=0;

	boolean firstCall=true;
	boolean secondCall=false;

	boolean gardenLoaded = false;
	boolean weatherLoaded = false;
	boolean lanesLoaded = false;
	boolean oceanLoaded = false;

	public GamePlayPanel() {
		Astronaut astro = Controller.astro; //assigns the astronaut class instance created in controller
		Weather weather = Controller.weather;// assigns the weather class instance created in controller
		Garden garden = Controller.garden; //assigns the garden class "" ""
		Lane lanes	= Controller.lanes; // assigns the lane class "" ""
		Water water = Controller.water; // assigns the water class "" ""

		//initializing images
		Image weatherImg = null;
		Image gardenImg = null;
		Image lanesImg = null;
		Image oceanImg = null;
		//trying to load the images from files
		//weatherImg = weather.getWeatherImg();
		gardenImg = garden.getGardenImg();
		lanesImg = lanes.getLanesImg();
		

		//creates a final image from the loaded images, required by some panels
		final Image finWeatherImg1 = weather.getWeatherImg();
		final Image finWeatherImg2 = weather.getWeatherImg();
		final Image finWeatherImg3 = weather.getWeatherImg();
		final Image finWeatherImg4 = weather.getWeatherImg();
		final Image finGardenImg = gardenImg;
		final Image finOceanImg1 = water.getWaterImg();
		final Image finOceanImg2 = water.getWaterImg();
		final Image finOceanImg3 = water.getWaterImg();
		final Image finOceanImg4 = water.getWaterImg();
		finLanesImg = lanesImg;


		//sets variables of astronaut's dimensions for collision purposes
		System.out.println(Controller.getAstro().getAstroImg());
		astroWidth = Controller.getAstro().getAstroImg().getWidth(null);
		astroHeight = Controller.getAstro().getAstroImg().getHeight(null);
		introInt=(int)(-3*astroHeight);

		//panel representing weather & air quality
		weatherPanel = new JPanel(){

			Image weatherImage1;
			Image weatherImage2;
			Image weatherImage3;
			Image weatherImage4;
			int width;
			int height;
			int x;
			int y;
			Font questionFont = new Font("questionFont", Font.BOLD, 25);

			public void paint(Graphics g){

				/*if (g.getFont() != questionFont){
					g.setFont(questionFont);
				}*/

				if (!weatherLoaded){
					weatherImage1 = finWeatherImg1.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH);
					weatherImage2 = finWeatherImg2.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH);
					weatherImage3 = finWeatherImg3.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH);
					weatherImage4 = finWeatherImg4.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH);
					width = (int) weatherPanel.getSize().getWidth();
					height = (int) weatherPanel.getSize().getHeight();
					x = width/80;
					y = height/10;
					width-=x*2;
					height-=y*2;
					weatherLoaded = true;
				}

				if(Controller.getEnviro().getAirQuality()>1500){
					g.drawImage(weatherImage1, 0, 0, null);
				}
				else if(Controller.getEnviro().getAirQuality()>1000){
					g.drawImage(weatherImage2, 0, 0, null);
				}
				else if(Controller.getEnviro().getAirQuality()>500){
					g.drawImage(weatherImage3, 0, 0, null);
				}
				else{
					g.drawImage(weatherImage4, 0, 0, null);
				}

				if (factDuration == 10){
					fact = false;
					factTimer.stop();
					repaint();
					factDuration = 0;
				}
				if (answerDuration == 10){
					question = false;
					answerTimer.stop();
					answerDuration = 0;
					repaint();
				}
				/*
				 * when we want to show the fact to the user, set "fact" to true and 
				 * repaint this panel. set false when you no longer want to show it
				 */
				if (fact){

					g.setColor(new Color(0, 0, 0, 150));
					g.fillRoundRect(x, y, width, height, 20, 20);
					g.setColor(Color.white);
					String questionString = "This is just a test of a fact that we will be showing the user.";
					int stringLength = (int) g.getFontMetrics().getStringBounds(questionString, g).getWidth();
					int stringHeight = (int) g.getFontMetrics().getStringBounds(questionString, g).getHeight();
					int start = (width/2) - stringLength/2;
					int end = (height/2) + stringHeight/2;
					g.drawString(questionString, start , end);
					System.out.println("fact");
				}
				/*
				 * set question to true when we want to show the question
				 */
				else if (question){
					System.out.println("question");
					g.setColor(new Color(0, 0, 0, 150));
					g.fillRoundRect(x, y, width, height, 20, 20);

					g.setColor(Color.white);
					String test = "This is just a question of a fact that we will be showing the user?";
					String[] answers = new String[]{"a. these", "b. are", "c. the", "d. an", "e. sers"};
					int stringLength = (int) g.getFontMetrics().getStringBounds(test, g).getWidth();
					int stringHeight = (int) g.getFontMetrics().getStringBounds(test, g).getHeight();
					int start = (width/2) - stringLength/2;
					int end = (height/2) + stringHeight/2;
					g.drawString(test, start, (end - stringHeight/2));
					String answerConcat = "";
					for (int j = 0; j < answers.length; j++){
						answerConcat = answerConcat.concat(answers[j] + "     ");
					}
					answerConcat = answerConcat.trim();
					int answerWidth = (int) g.getFontMetrics().getStringBounds(answerConcat, g).getWidth();
					int answerStart = (width/2) - answerWidth/2;
					g.drawString(answerConcat, answerStart , (end + stringHeight));

				}


			}
		};
		inventoryPanel = new JPanel();

		gardenPanel = new JPanel(){
			private static final long serialVersionUID = 1L;

			Image gardenImage1;
			Image gardenImage2;
			Image gardenImage3;

			public void paint(Graphics g){
				// prints the animals stored in the animal array located in the Garden class

				//checks if the sizes have been loaded so that we don't set images every paint
				if (!gardenLoaded){
					gardenImage1 = finGardenImg.getScaledInstance(this.getSize().width, this.getSize().height, Image.SCALE_SMOOTH);
					gardenImage2 = gardenImage1;
					gardenImage3 = gardenImage1;
					gardenLoaded = true;
				}

				//draws moving background
				g.drawImage(gardenImage1, 0, background1, null);

				if(secondCall){
					background2=(-1)*gardenImage1.getHeight(null)+gardenImage1.getHeight(null);
					background3=(-2)*gardenImage1.getHeight(null)+gardenImage1.getHeight(null);
					secondCall=false;
				}

				g.drawImage(gardenImage2, 0, background2, null);
				g.drawImage(gardenImage3, 0, background3, null);
				

				// loops for size of plant array
				Controller.garden.updateYLoc(screenHeight * 8/9);
				Controller.inventory.updateYLoc();
				for(int i=0; i<Inventory.getInventory().length; i++){
					Animal animal = Garden.animals[i];

					// inserts animal if there is plant. We can add a check here to see if it is
					// native/ non native/ invasive/ exotic
					if(Inventory.getInventory()[i] != null && Inventory.getInventory()[i] instanceof Native){
						int res = animal.getImage().getWidth(null) / animal.getImage().getHeight(null);
						g.drawImage(animal.getImage(), animal.getX(), (int) (animal.getY()), null);
					}
					int ylocation = (int) (getSize().getHeight()/25);

					// pulls plants in inventory, resizes them, and prints them into garden
					for(LaneObject p : Inventory.getInventory()){
						//prints the plant
						if (p != null){
							g.drawImage(p.getImage(), (int) (getSize().getWidth()*3)/8,  p.getY(), null);
						}
					}

				}
			}

		};

		oceanPanel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Image water1;
			Image water2;
			Image water3;
			Image water4;
			boolean firstDraw=true;
			
			public void paint(Graphics g){
				Image image1;
				Image image2;
				Image image3;
				if(firstDraw){
					water1=finOceanImg1.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH);
					water2=finOceanImg2.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH);
					water3=finOceanImg3.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH);
					water4=finOceanImg4.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH);
				}

				if(Controller.getEnviro().getWaterQuality()>1500){
					image1=water1;
					image2=water1;
					image3=water1;
					}
					else if (Controller.getEnviro().getWaterQuality()>1000){
						image1=water2;
						image2=water2;
						image3=water2;
						}
					else if (Controller.getEnviro().getWaterQuality()>500){
						image1=water3;
						image2=water3;
						image3=water3;
						}
					else{
						image1=water4;
						image2=water4;
						image3=water4;
					}
				
				g.drawImage(image1, 0, background1, null);
				g.drawImage(image2, 0, background2, null);
				g.drawImage(image3, 0, background3, null);
			}
		};
		// Constants for positions
		//COLUMN2 = (screenWidth / 2) - (resizedAstro.getWidth(null) / 2);
		COLUMN2 = 0;
		COLUMN1 = COLUMN2 - COLUMN2 / 5;
		COLUMN0 = COLUMN1 - COLUMN2 / 5;
		COLUMN3 = COLUMN2 + COLUMN2 / 5;
		COLUMN4 = COLUMN3 + COLUMN2 / 5;

		lanesPanel = new LanesPanel();

		weatherPanel.setPreferredSize(new Dimension(screenWidth, screenHeight / 8));
		inventoryPanel.setPreferredSize(new Dimension(screenWidth, screenHeight / 9));
		gardenPanel.setPreferredSize(new Dimension(screenWidth / 6, screenHeight));
		oceanPanel.setPreferredSize(new Dimension(screenWidth / 6, screenHeight));

		spacerWidth = screenWidth/30;
		final int itemWidth = (screenWidth - (spacerWidth)*7)/6;

		int inventHeight = inventoryPanel.getPreferredSize().height;

		item0 = new GenericItem(0, itemWidth, inventHeight);
		item1 = new GenericItem(1, itemWidth, inventHeight);
		item2 = new GenericItem(2, itemWidth, inventHeight);
		item3 = new GenericItem(3, itemWidth, inventHeight);
		item4 = new GenericItem(4, itemWidth, inventHeight);
		item5 = new GenericItem(5, itemWidth, inventHeight);

		inventoryLayout = new BoxLayout(inventoryPanel, BoxLayout.LINE_AXIS);
		inventoryPanel.setLayout(inventoryLayout);
		inventoryPanel.add(new Spacer());
		inventoryPanel.add(item0);
		inventoryPanel.add(new Spacer());
		inventoryPanel.add(item1);
		inventoryPanel.add(new Spacer());
		inventoryPanel.add(item2);
		inventoryPanel.add(new Spacer());
		inventoryPanel.add(item3);
		inventoryPanel.add(new Spacer());
		inventoryPanel.add(item4);
		inventoryPanel.add(new Spacer());
		inventoryPanel.add(item5);
		inventoryPanel.add(new Spacer());

		layout = new BorderLayout();
		setLayout(layout);

		add(weatherPanel, BorderLayout.PAGE_START);
		add(gardenPanel, BorderLayout.LINE_START);
		add(lanesPanel, BorderLayout.CENTER);
		add(oceanPanel, BorderLayout.LINE_END);
		add(inventoryPanel, BorderLayout.PAGE_END);

	}

	public final class LanesPanel extends JPanel implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		boolean timerRunning;
		Timer timer;
		int currTime;
		int duration = 4;
		Image grassImg1;
		Image grassImg2;
		Image grassImg3;

		public void startTimer(){
			this.timerRunning = true;
			this.currTime = 0;
			this.timer.start();
		}

		@Override
		public void paint(Graphics g) {

			if (!lanesLoaded){
				grassImg1 = finLanesImg.getScaledInstance(lanesPanel.getSize().width, 
						lanesPanel.getSize().height, Image.SCALE_SMOOTH);
				grassImg2 = grassImg1;
				grassImg3 = grassImg2;
				lanesLoaded = true;
			}
			g.drawImage(grassImg1, 0, background1, null);
			if(secondCall){
				background2=(-1)*grassImg1.getHeight(null)+grassImg1.getHeight(null);
				background3=(-2)*grassImg1.getHeight(null)+grassImg1.getHeight(null);
				secondCall=false;
			}
			g.drawImage(grassImg2, 0, background2, null);
			g.drawImage(grassImg3, 0, background3, null);

			lanesPanelWidth = (int) lanesPanel.getSize().getWidth();

			COLUMN2 = (int) (lanesPanel.getSize().getWidth()/2 - (astroWidth/2));
			COLUMN1 = COLUMN2 - (COLUMN2/10) - COLUMN2 / 3;
			COLUMN0 = COLUMN1 - (COLUMN2/10) - COLUMN2 / 3;
			COLUMN3 = COLUMN2 + (COLUMN2/10) + COLUMN2 / 3;
			COLUMN4 = COLUMN3 + (COLUMN2/10) + COLUMN2 / 3;

			for (LaneObject[] laneArray : Controller.getLanes().getLanes()) {
				for (int i = 0; i < laneArray.length; i++) {
					if (laneArray[i] != null) {
						g.drawImage(laneArray[i].getImage(), paintPos(laneArray[i].getX()), laneArray[i].getY(), null);
						/*
						 * the laneArray[i].getY() causes a non-crashing exception because
						 * you are painting the items offscreen
						 */
					}
				}
			}
			Controller.getAstro().setYLoc(lanesPanel.getHeight()  - Controller.getAstro().getAstroImg().getHeight(null));
			if(Controller.getIntro()){
				introInt+=(int)(screenHeight/60);// + acceleration;
				if (introInt +(int)(screenHeight/30)> ((int) lanesPanel.getSize().getHeight()) * 33/40){
					Controller.setIntro();
				}

				g.drawImage(Controller.getImgRes().getgrassZombieBack(), paintPos(0)-(int)(Controller.getImgRes().getgrassZombieBack().getWidth(null)*(0.125)), introInt+(astroHeight*3), null);
				g.drawImage(Controller.getImgRes().getgrassZombieBack(), paintPos(1)-(int)(Controller.getImgRes().getgrassZombieBack().getWidth(null)*(0.125)), introInt+(astroHeight*2), null);
				g.drawImage(Controller.getImgRes().getgrassZombieBack(), paintPos(2)-(int)(Controller.getImgRes().getgrassZombieBack().getWidth(null)*(0.125)), introInt+(astroHeight), null);
				g.drawImage(Controller.getImgRes().getgrassZombieBack(), paintPos(3)-(int)(Controller.getImgRes().getgrassZombieBack().getWidth(null)*(0.125)), introInt+(astroHeight*2), null);
				g.drawImage(Controller.getImgRes().getgrassZombieBack(), paintPos(4)-(int)(Controller.getImgRes().getgrassZombieBack().getWidth(null)*(0.125)), introInt+(astroHeight*3), null);
				g.drawImage(Controller.getAstro().getAstroImg(), paintPos(Controller.getAstro().getPosition()), introInt, null);

			}
			else {
				g.drawImage(Controller.getAstro().getAstroImg(), paintPos(Controller.getAstro().getPosition()), Controller.getAstro().getY(), null);
			}
			if(GameThread.getMiniBoss()){
				if (miniBossInt<screenHeight/20){
					miniBossInt+=(int)(miniBossInt+(Controller.getSpeed()));
				}
				g.drawImage(Controller.getImgRes().getgrassZombieFront(),paintPos(miniBossLoc)-(int)(Controller.getImgRes().getgrassZombieBack().getWidth(null)*(0.125)), miniBossInt, null);
			}
			
			

		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			timerRunning = false;
			this.timer.stop();
		}

	}

	public int paintPos(int pos) {
		switch (pos) {
		case 0:
			return COLUMN0;
		case 1:
			return COLUMN1;
		case 2:
			return COLUMN2;
		case 3:
			return COLUMN3;
		case 4:
			return COLUMN4;

		}
		return COLUMN2;
	}

	//these are the separators in the inventory panel
	class Spacer extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Image image;

		@Override
		public void paint(Graphics g) {
			g.drawImage(image,  0,  0,  null);
			
		}

		Spacer(){
			Image frontwood = null;
			try {
				//trying to load the images from files
				frontwood = ImageIO.read((new File("images/frontwood.png")));
			} catch (IOException e3) {
				e3.printStackTrace();
			}

			setMaximumSize(new Dimension(spacerWidth-1, inventoryPanel.getPreferredSize().height));
			setPreferredSize(getMaximumSize());
			this.image = frontwood.getScaledInstance(getMaximumSize().width, getMaximumSize().height, Image.SCALE_SMOOTH);;
		}
	}

	//this is a panel in the inventory that holds plants
	final class GenericItem extends JPanel implements ActionListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int pos;
		Image image;
		int duration;
		int currTime;
		boolean timerRunning;
		Timer timer;

		public void startTimer(int duration){
			this.timerRunning = true;
			this.duration = duration;
			this.currTime = 0;
			this.timer.start();
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(image,  0,  0,  null);

			if (this.timerRunning){
				int width = getMaximumSize().width;
				int height = getMaximumSize().height;
				int x = width/10;
				int y = height/10;
				width = width - x*2;
				height = height - y*2;

				Color backColor = new Color(0, 0, 0, 128);
				g.setColor(backColor);
				g.fillRoundRect(x, y, width, height, 15, 15);
				Color frontColor = new Color(200, 255, 200, 90);
				g.setColor(frontColor);

				double dblCurr = currTime;
				double dblDur = duration;

				int timerHeight = (int) (y + (height * (dblCurr/dblDur)));

				g.fillRoundRect(x, timerHeight, width, height - timerHeight + y, 15, 15);

				if (Inventory.getInventory() != null && Inventory.getInventory()[pos] != null){
					Image plantImg = Inventory.getInventory()[pos].getImage();
					int drawX = (width/2) - (plantImg.getWidth(null)/2) + x;
					int drawY = (height/2) - (plantImg.getHeight(null)/2) + y;
					g.drawImage(plantImg, drawX, drawY, null);
					g.drawString(((Plant) (Inventory.getInventory()[pos])).getName(),drawX, drawY);
				}
			}


		}

		GenericItem(int itemNumber, int itemWidth, int inventHeight){
			Image backwood = null;
			try {
				//trying to load the images from files
				backwood = ImageIO.read((new File("images/backwood.png")));
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			this.pos = itemNumber;
			this.timerRunning = false;
			setMaximumSize(new Dimension(itemWidth, inventHeight));
			setPreferredSize(getMaximumSize());
			this.image = backwood.getScaledInstance(getMaximumSize().width, getMaximumSize().height, Image.SCALE_SMOOTH);
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			if (currTime == this.duration){
				this.timer.stop();
				this.timerRunning = false;
				currTime = 0;
				this.repaint();
				Inventory.getInventory()[this.pos] = null;
				gardenPanel.repaint();

			}
			else{
				this.currTime++;
				this.repaint();
			}

		}

	}

	@Override
	public void onItemAdded(int position, LaneObject laneObject) {
		if (laneObject instanceof Plant){
			Plant plant = (Plant) laneObject;

			switch (position){
			case 0:
				item0.repaint();
				item0.timer = new Timer(1000, item0);
				item0.startTimer(plant.getDuration());
				break;
			case 1:
				item1.repaint();
				item1.timer = new Timer(1000, item1);
				item1.startTimer(plant.getDuration());
				break;
			case 2:
				item2.repaint();
				item2.timer = new Timer(1000, item2);
				item2.startTimer(plant.getDuration());
				break;
			case 3:
				item3.repaint();
				item3.timer = new Timer(1000, item3);
				item3.startTimer(plant.getDuration());
				break;
			case 4:
				item4.repaint();
				item4.timer = new Timer(1000, item4);
				item4.startTimer(plant.getDuration());
				break;
			case 5:
				item5.repaint();
				item5.timer = new Timer(1000, item5);
				item5.startTimer(plant.getDuration());
				break;
			}
		}
		gardenPanel.repaint();

	}

	@Override
	public void onDamaged(int time) {
		lanesPanel.timer = new Timer(time, lanesPanel);
		lanesPanel.startTimer();
		lanesPanel.repaint();
	}

	public void updateBackground(){
		if (firstCall){
			background1=0;
			firstCall=false;
			secondCall=true;
		}
		else{
			background1+=Controller.getSpeed();
			if (background1>lanesPanel.getSize().height){
				background1=(-1)*lanesPanel.getSize().height+Controller.getSpeed();
			}
			background2+=Controller.getSpeed();
			if (background2>lanesPanel.getSize().height){
				background2=(-1)*lanesPanel.getSize().height+Controller.getSpeed();
			}
			background3+=Controller.getSpeed();
			if (background3>lanesPanel.getSize().height){
				background3=(-1)*lanesPanel.getSize().height+Controller.getSpeed();
			}
		}
	}
}