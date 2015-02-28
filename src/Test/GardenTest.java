package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.Controller;
import Controller.ImageResize;
import Model.Fox;
import Model.Garden;

public class GardenTest {

	@Test
	public void testReset() {
		Garden g = new Garden();
		int gC = g.getGardenCondition();
		g.reset();
		int gC2 = g.getGardenCondition();
		assertEquals(gC, gC2);
	}

	@Test
	public void testUpdateYLoc() {
		Controller.createGame();
		Garden g = Controller.garden;
		int a1 = g.getAnimals()[0].getY();
		int a5 = g.getAnimals()[5].getY();
		g.updateYLoc(1000);
		int b1 = g.getAnimals()[0].getY();
		int b5 = g.getAnimals()[5].getY();
		assertEquals(a1, b1-5);
		assertEquals(a5+5,b5);
	}


	@Test
	public void testUpdate() {

		Controller.createGame();
		Garden g = Controller.garden;
		int gC = g.getGardenCondition();
		g.update();
		int gC2 = g.getGardenCondition();
		assertEquals(gC,gC2);
		
	}
	

}
