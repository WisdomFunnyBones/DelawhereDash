package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.GameThread;

public class GameThreadTest {

	GameThread thread = new GameThread();
	//thread.start();
	
	@Test
	public void testIsKeepGoing() {
		System.out.println(thread.isKeepGoing());
		assertEquals(thread.isKeepGoing(),true);
	}

	@Test
	public void testKill() {
		thread.kill();
		assertEquals(thread.isKeepGoing(),false);
	}

}
