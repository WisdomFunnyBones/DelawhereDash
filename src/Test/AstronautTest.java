package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Astronaut;

public class AstronautTest {

	Astronaut a1 = new Astronaut(500, 2, 0);

	@Test
	public void testMoveLeft() {
		int i = a1.getPosition();
		if (a1.moveLeft()) {
			int x = a1.getPosition();
			assertEquals(i, x + 1);
		}
		else
			assertTrue(true);
	}

	@Test
	public void testMoveRight() {
		int i = a1.getPosition();
		if (a1.moveRight()) {
			int x = a1.getPosition();
			assertEquals(i, x - 1);
		}
		else
			assertTrue(true);
	}

	@Test
	public void testDepleteStamina() {
		int x = a1.getStamina();
		a1.depleteStamina(20);
		int y = a1.getStamina();
		assertEquals(x,y+20);
		
	}

	@Test
	public void testDamaged() {
		a1.Damaged(true);
		assertEquals(a1.getDamaged(),true);
		a1.Damaged(false);
		assertEquals(a1.getDamaged(),false);
	}

}
