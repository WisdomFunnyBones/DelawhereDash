package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.Controller;
import Model.Arbovitae;
import Model.Fox;
import Model.Inventory;
import Model.LaneObject;

public class InventoryTest {

	//Creating the game is necessary otherwise you get null pointers.
	@Test
	public void testAddItem() {
		Controller.createGame();
		Inventory i = new Inventory();
		LaneObject l = new Arbovitae(3,0);
		i.addItem(l);
		LaneObject l2 = new Arbovitae(0,Controller.garden.getAnimals()[0].getY());
		assertEquals(l2.getY(),i.getInventory()[0].getY());
	}

	@Test
	public void testUpdateYLoc() {
		Controller.createGame();
		Inventory i = Controller.inventory;
		LaneObject l = new Arbovitae(1, 9);
		i.addItem(l);
		i.updateYLoc();
		assertEquals(i.getInventory()[0].getY(), Controller.garden.getAnimals()[0].getY());
	}

	@Test
	public void testCreateObj() {
		Controller.createGame();
		Inventory i = new Inventory();
		Arbovitae a = new Arbovitae(6,0);
		assertEquals(i.createObj(a).getX(), 0);
		assertEquals(i.createObj(a).getY(),0);
		assertEquals(i.createObj(a).name, "arbovitae");
	}

}
