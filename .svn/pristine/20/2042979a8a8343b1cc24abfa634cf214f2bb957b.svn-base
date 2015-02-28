package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Model.Animal;
import Model.Exotic;
import Model.Invasive;
import Model.Inventory;
import Model.Lane;
import Model.LaneObject;
import Model.Native;
import Model.Obstacle;
import Model.Plant;
import Model.Zombie;
import View.GameFrame;

public class GameThread extends Thread {

	static boolean intro = true;
	static boolean miniBoss = false;
	static int event = 200;
	static int bossCounter=600;
	int COLLISIONPROTECTION = 60;
	boolean full = true;
	// This thread runs constantly and repaints.
	private boolean keepGoing = true;

	public interface onStaminaDepletedListener {
		void onStaminaDepleted();

	}

	public static boolean getMiniBoss() {
		return miniBoss;
	}

	public static boolean getIntro() {
		return intro;
	}

	public static void setIntro() {
		intro = false;
	}

	public static void setIntroTrue() {
		intro = true;
	}

	public boolean isKeepGoing() {
		return keepGoing;
	}

	public void setKeepGoing(boolean keepGoing) {
		this.keepGoing = keepGoing;
	}

	@Override
	public void run() {
		int count = COLLISIONPROTECTION;
		event = (int) (50 + (Math.random() * ((30) + 1) * 30));
		int updateSpeed = 0;
		while (keepGoing) {
			//System.out.println(event);
			// System.out.println("Air=" +
			// Controller.getEnviro().getAirQuality());
			// System.out.println("Water=" +
			// Controller.getEnviro().getWaterQuality());
			// System.out.println("Animal=" +
			// Controller.getEnviro().getAnimalQuality());
			full = true;
			event--;
			if (event == 0) {
				miniBoss = true;
			}
			if (miniBoss==true){
				bossCounter--;
				if(bossCounter==0){
					miniBoss=false;
				}
			}
			for (int j = 0; j < Inventory.getInventory().length; j++) {
				if (Inventory.getInventory()[j] == null) {
					full = false;
				}
			}
			try {
				Controller.getAstro().depleteStamina(1);
				if (Controller.getEnviro().getAirQuality() > 0
						&& Controller.getEnviro().getWaterQuality() > 0
						&& !intro) {
					if(!miniBoss){
						Controller.getEnviro().decreaseEnviro(1);
					}
				}
				// if (Math.random() > .5)
				if(!miniBoss){
					Controller.getLanes().addNewItem(false);
				}
				if(miniBoss && bossCounter%50==0){
					Controller.getLanes().addNewItem(true);
				}
				Controller.move();
				updateSpeed++;
				if (updateSpeed > 600) {
					updateSpeed = 0;
					Controller.setSpeed(Controller.getSpeed() + 1);
				}
				sleep(28);
				Controller.repaint();/*
									 * if (Controller.currentTime == 10 &&
									 * !GameFrame.getGamePlayPanel().fact){
									 * GameFrame.getGamePlayPanel().fact = true;
									 * GameFrame.getGamePlayPanel().factTimer
									 * =(new Timer(1000, new ActionListener(){
									 * 
									 * @Override public void
									 * actionPerformed(ActionEvent ae) {
									 * GameFrame
									 * .getGamePlayPanel().factDuration++; }
									 * 
									 * }));
									 * GameFrame.getGamePlayPanel().factTimer
									 * .start();
									 * GameFrame.getGamePlayPanel().getWeatherPanel
									 * ().repaint(); } if
									 * (Controller.currentTime == 15 &&
									 * GameFrame.getGamePlayPanel().fact){
									 * GameFrame.getGamePlayPanel().question =
									 * true;
									 * GameFrame.getGamePlayPanel().answerTimer=
									 * (new Timer(1000, new ActionListener(){
									 * 
									 * @Override public void
									 * actionPerformed(ActionEvent arg0) {
									 * GameFrame
									 * .getGamePlayPanel().answerDuration++; }
									 * 
									 * }));
									 * GameFrame.getGamePlayPanel().answerTimer
									 * .start();
									 * GameFrame.getGamePlayPanel().getWeatherPanel
									 * ().repaint(); Lane.questionMode = true; }
									 */
				LaneObject[] laneArray = Controller.getLanes().getLanes()[Controller
						.getAstro().getPosition()];
				for (int i = 0; i < laneArray.length; i++) {
					if (laneArray[i] != null) {
						if (Controller.collided(laneArray[i]) != null) {
							if (Controller.getAstro().getDamaged() == false
									&& (laneArray[i] instanceof Obstacle)) {
								if (laneArray[i] instanceof Animal) {
									Controller.getLanes().removeAnimals();
								} else
									Controller.getLanes().removeCloNPud();
								laneArray[i] = null;
								Controller.getAstro().Damaged(true);
							} else if (laneArray[i] instanceof Plant && !full) {
								System.out.println("hit plant");
								Controller.updatePanels(laneArray[i]);
								Controller.getLanes().removePlants();
								if (laneArray[i] instanceof Exotic) {
									Controller.getAstro().Damaged(true);
									Controller.getEnviro().pickedPlant(false);
									Controller.getAstro().depleteStamina(20);
								} else if (laneArray[i] instanceof Native) {
									Controller.getEnviro().pickedPlant(true);
								} else if (laneArray[i] instanceof Invasive) {
									Controller.getAstro().Damaged(true);
									Controller.getEnviro().pickedPlant(false);
								}else if(laneArray[i] instanceof Zombie){
									System.out.print("hit ZombiePLant");
									Controller.getEnviro().pickedZombiePlant();
									Controller.getAstro().Damaged(true);
								}
								laneArray[i] = null;

								// should replace the above line of code if we
								// chose to go that way
								// Controller.updatePanels(laneArray[i]); //
								// updates weather, water and garden panel
								// Conditions

							}

						}
					}

				}
				if (Controller.getAstro().getStamina() <= 0) {
					kill();
					onStaminaDepletedListener endListener = Controller
							.getFrame();
					endListener.onStaminaDepleted();

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (Controller.getAstro().getDamaged()) {
				count--;
				if (count == 0) {
					Controller.getAstro().Damaged(false);
					count = COLLISIONPROTECTION;
				}
			}
		}
	}

	public void kill() {
		keepGoing = false;
		event = 200;
		bossCounter=600;
	}

}
