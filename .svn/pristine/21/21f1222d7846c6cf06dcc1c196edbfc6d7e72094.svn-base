package Controller;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Model.Animal;
import Model.Astronaut;
import Model.Environment;
import Model.Exotic;
import Model.Garden;
import Model.GasCloud;
import Model.Invasive;
import Model.Inventory;
import Model.Lane;
import Model.LaneObject;
import Model.Obstacle;
import Model.Plant;
import Model.Water;
import Model.Weather;
import Model.Zombie;
import View.GameFrame;

public class Controller {

	static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

	public static int STAMINA = 6300;
	static int STARTINGX = 100;
	static int STARTINGY = (screenHeight * 9) / 12;
	private static int speed = 5;

	public static Astronaut astro;
	public static Lane lanes;
	public static GameFrame frame;
	public static Inventory inventory;
	public static Garden garden;
	public static Water water;
	public static Weather weather;
	public static Environment enviro;
	public static Timer questionTimer;
	public static Timer showQuestionMarkTimer;
	public static int currentTime = 0;
	private static ImageResize imgRes;

	public static int getStamina() {
		return STAMINA;
	}

	/*
	 * Creates the things necessary for model and view to do their thing.
	 */
	public static void createGame() {
		speed = 5;
		setImgRes(new ImageResize());
		astro = new Astronaut(STAMINA, STARTINGX, STARTINGY);
		lanes = new Lane();
		enviro = new Environment();
		// creates new inventory class, which creates a new empty array of sized
		// 6
		// can be accessed with Inventory.getInventory()
		inventory = new Inventory();
		garden = new Garden();
		water = new Water();
		weather = new Weather();
		frame = new GameFrame();
		questionTimer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				currentTime++;
			}

		});
		questionTimer.start();
		Controller.move();

	}

	public static boolean getIntro() {
		return GameThread.getIntro();
	}

	public static void setIntro() {
		GameThread.setIntro();
	}

	public static Environment getEnviro() {
		return enviro;
	}

	public interface OnDamagedListener {
		public void onDamaged(int time);
	}

	static public LaneObject collided(LaneObject laneObject) {
		LaneObject collidedObject;
		int astroX = astro.getPosition();
		int astroY = getAstro().getY();
		int height = laneObject.getImage().getHeight(null);
		// System.out.println("Astro's position"+ astro.getPosition());

		if (astroX == laneObject.getX()) {
			if (astroY < laneObject.getY()
					+ laneObject.getImage().getHeight(null)
					&& astroY + getImgRes().getastroImgfull().getHeight(null) > laneObject
							.getY()) {
				// depletes stamina based on obstacle's staminaPenalty
				// plants have staminaPenalty = 0;
				collidedObject = laneObject;

				OnDamagedListener listener = GameFrame.getGamePlayPanel();
				if (laneObject instanceof Obstacle && !astro.getDamaged()) {
					listener.onDamaged(600);
					Obstacle obstacle = (Obstacle) laneObject;
					astro.depleteStamina(obstacle.getStaminaPenalty());
				} else if (laneObject instanceof Exotic
						|| laneObject instanceof Invasive || laneObject instanceof Zombie) {
					listener.onDamaged(50);
				}
				return collidedObject;
			}

		}
		return null;
	}

	// this updates the panels' models. They should all have an update method
	// that gets called
	public static void updatePanels(LaneObject collidedObject) {
		if (inventory.addItem(collidedObject)) {
			garden.update(); // calls an update in garden class to add or remove
			water.update(); // calls update in water class
			weather.update(); // calls update in weather class
		}
	}

	public static Astronaut getAstro() {
		return astro;
	}

	public static Lane getLanes() {
		return lanes;
	}

	public static void repaint() {
		// frame.revalidate();
		GameFrame.getGamePlayPanel().getGardenPanel().repaint();
		GameFrame.getGamePlayPanel().getLanesPanel().repaint();
		GameFrame.getGamePlayPanel().getOceanPanel().repaint();
		GameFrame.getGamePlayPanel().getWeatherPanel().repaint();
	}

	public static void move() {
		if (!GameThread.getIntro()) {
			Lane l = getLanes();
			for (LaneObject[] laneArray : l.getLanes()) {
				for (int i = 0; i < laneArray.length; i++) {
					if (laneArray[i] != null) {
						if (laneArray[i].getY() > (Toolkit.getDefaultToolkit()
								.getScreenSize().height * (9))
								/ 10
								- laneArray[i].getImage().getHeight(null)) {
							if (laneArray[i] instanceof Plant)
								l.removePlants();
							else if (laneArray[i] instanceof Animal) {

								l.removeAnimals();
							} else
								l.removeCloNPud();
							laneArray[i] = null;

						} else
							laneArray[i].setY(speed);
					}
				}
			}
		}
		frame.getGamePlayPanel().updateBackground();
	}

	public static void reset() {
		astro.setStamina(STAMINA);

	}

	public static GameFrame getFrame() {
		return frame;
	}

	public static ImageResize getImgRes() {
		return imgRes;
	}

	public static void setImgRes(ImageResize imgRes) {
		Controller.imgRes = imgRes;
	}

	public static void setSpeed(int speed) {
		Controller.speed = speed;
	}

	public static int getSpeed() {
		return speed;
	}

}
