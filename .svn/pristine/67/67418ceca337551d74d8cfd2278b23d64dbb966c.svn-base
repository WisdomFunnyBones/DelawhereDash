package Model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;
import Controller.Controller;
import View.GameFrame;


// this class stores the items that astro has picked up. Detected and set through
// the controller class by the "collided" method
public class Inventory {

	public static LaneObject[] inventory;//array of max size 6

	public Inventory(){
		inventory = new LaneObject[6]; 

	}

	public boolean addItem(LaneObject object) {
		// loops through array of inventory
		for(int i = 0; i < Inventory.inventory.length; i++){
			// if there's an empty spot in the array it adds the object. 
			// otherwise returns false
			if(Inventory.inventory[i] == null){
				object = createObj(object);
				Inventory.inventory[i] = object;
				OnItemAddListener listener = GameFrame.getGamePlayPanel();
				listener.onItemAdded(i, object);
				return true; // returns true if object was added
			}
		}
		return false;
	}

	public static LaneObject[] getInventory(){
		return inventory;
	}
	public void updateYLoc() {
		for (int i = 0; i < 6; i++) {
			LaneObject l = inventory[i];
			if (l != null) {
				l.yLoc = Controller.garden.getAnimals()[i].getY();
			}
		}
	}
	public Plant createObj(LaneObject obj) {
		if (obj instanceof BradfordPear) {
			return new BradfordPear(0,0);
		}
		else if (obj instanceof BurningBush) {
			return new BurningBush(0,0);
		}
		else if (obj instanceof CommonMilkweed) {
			return new CommonMilkweed(0,0);
		}
		else if (obj instanceof MaidenGrass) {
			return new MaidenGrass(0,0);
		}
		else if (obj instanceof Arbovitae) {
			return new Arbovitae(0,0);
		}
		else if (obj instanceof ZombieGrass) {
			return new ZombieGrass(0,0);
		}
		return new ScarletOak(0,0);
	}

	public void setInventory(LaneObject[] inventory){
		Inventory.inventory = inventory;
	}

	public interface OnItemAddListener{
		public void onItemAdded(int position, LaneObject laneObject);

		void onDamaged(int time);
	}

}
