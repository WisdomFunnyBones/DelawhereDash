package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.Controller;
import Model.Lane;
import Model.LaneObject;
import Model.Puddle;

public class ControllerTest {



	@Test
	public void testCollided() {

		Puddle p = new Puddle(2, 10);
		Controller.createGame();
		assertEquals(Controller.collided(p), null);
	}



	@Test
	public void testMove() {

		Controller.createGame();
		Lane l = Controller.getLanes();
		LaneObject[][] lo = l.getLanes();
		lo[0][0] = new Puddle(2,30);
		LaneObject i = lo[0][0];
		int y = i.getY();
		Controller.move();
		assertEquals(i.getY(), y);	
	}

	@Test
	public void testReset() {
		Controller.createGame();
		Controller.getAstro().depleteStamina(10);
		Controller.reset();
		assertEquals(Controller.getAstro().getStamina(), Controller.STAMINA);
	}


}
