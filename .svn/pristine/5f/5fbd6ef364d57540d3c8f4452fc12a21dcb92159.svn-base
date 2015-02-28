package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Environment;

public class EnvironmentTest {

	Environment testE = new Environment();
	
	@Test
	public void testResetEnviro() {
		System.out.println(testE.getAirQuality());
		testE.decreaseEnviro(200);
		System.out.println(testE.getAirQuality());
		testE.resetEnviro();
		assertEquals(testE.getAirQuality(),2000);
		assertEquals(testE.getWaterQuality(),2000);
		assertEquals(testE.getAnimalQuality(),2500);
	}

	@Test
	public void testPickedPlant() {
		testE.resetEnviro();
		testE.pickedPlant(true);
		assertEquals(testE.getAirQuality(),2150);
		assertEquals(testE.getWaterQuality(),2150);
		assertEquals(testE.getAnimalQuality(),2700);
		testE.resetEnviro();
		testE.pickedPlant(false);
		assertEquals(testE.getAirQuality(),2150);
		assertEquals(testE.getWaterQuality(),2150);
		assertEquals(testE.getAnimalQuality(),2550);
	}

	@Test
	public void testPickedZombiePlant() {
		testE.resetEnviro();
		testE.pickedZombiePlant();
		assertEquals(testE.getAirQuality(),1900);
		assertEquals(testE.getWaterQuality(),1900);
		assertEquals(testE.getAnimalQuality(),2400);
	}

	@Test
	public void testDecreaseEnviro() {
		testE.resetEnviro();
		testE.decreaseEnviro(200);
		assertEquals(testE.getAirQuality(),1800);
		assertEquals(testE.getWaterQuality(),1800);
		assertEquals(testE.getAnimalQuality(),2300);
		
	}

}
