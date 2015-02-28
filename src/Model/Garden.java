package Model;

import java.awt.Image;
import Controller.Controller;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Garden {
	public static Animal[] animals;
	public static int gardenCondition = 2500;
	public Image gardenImg;
	int yLoc;
	int buffer = Toolkit.getDefaultToolkit().getScreenSize().height/40;
	
	public static void reset(){
		gardenCondition=2500;
	}
	
	public Garden(){
		gardenCondition=2500;
		 animals = new Animal[6];
		 yLoc = 0;
		 animals[0] = new Rabbit(10, yLoc);
		 yLoc = yLoc + Controller.getImgRes().getRabbit().getHeight(null) + buffer;
		 animals[1] = new Bee(10, yLoc);
		 yLoc = yLoc + Controller.getImgRes().getBee().getHeight(null) + buffer;
		 animals[2] = new Fox(10, yLoc);
		 yLoc = yLoc + Controller.getImgRes().getFox().getHeight(null) + buffer;
		 animals[3] = new Deer(10, yLoc);
		 yLoc = yLoc + Controller.getImgRes().getDeer().getHeight(null) + buffer;
		 animals[4] = new Fox(10, yLoc);
		 yLoc = yLoc + Controller.getImgRes().getBee().getHeight(null) + buffer;
		 animals[5] = new Bee(10, yLoc);
		 
		 try {
			gardenImg = ImageIO.read(new File("images/tiledgarden.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void updateYLoc( int size) {
		for (Animal a : animals) {
			a.yLoc = (a.yLoc + Controller.getSpeed()) % size;
		}
	}
	
	public Image getGardenImg(){
		return this.gardenImg;
	}
	
	
	public static int getGardenCondition(){
		return gardenCondition;
	}
	
	public static Animal[] getAnimals(){
		return animals;
	}
	
	
	// updates the water condition depending on the plant that was picked up
	public void update(){
		LaneObject[] inventory = Inventory.getInventory();
		
		int count = 0;
		for(LaneObject i : inventory){
			if(i != null){
				count+= ((Plant) i).getGardenbenefit();
			}
		}
		gardenCondition += count;
	}
}
