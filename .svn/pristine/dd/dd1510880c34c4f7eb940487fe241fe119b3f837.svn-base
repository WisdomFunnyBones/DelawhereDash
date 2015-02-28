package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Weather {

	private static int weatherCondition = 2000;
	public Image weatherImg1;
	public Image weatherImg2;
	public Image weatherImg3;
	public Image weatherImg4;

	int count = 0;

	public Weather() {
		weatherCondition = 2000;
		try {
			weatherImg1 = ImageIO.read(new File("images/weather.png"));
			weatherImg2 = ImageIO
					.read(new File("images/almostgoodweather.png"));
			weatherImg3 = ImageIO.read(new File("images/lessbadweather.png"));
			weatherImg4 = ImageIO.read(new File("images/badweather.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void reset() {
		weatherCondition = 2000;
	}

	public static int getWeatherCondition() {
		return weatherCondition;
	}

	public Image getWeatherImg() {
		if (count == 0) {
			count++;
			return weatherImg1;
		}
		if (count == 1) {
			count++;
			return weatherImg2;
		}
		if (count == 2) {
			count++;
			return weatherImg3;
		}
		else {
			return weatherImg4;
		}
	}

	// updates the water condition depending on the plant that was picked up
	public void update() {
		LaneObject[] inventory = Inventory.getInventory();
		int count = 0;
		for (LaneObject i : inventory) {
			if (i != null) {
				count += ((Plant) i).getWeatherbenefit();
			}
		}
		weatherCondition += count;
	}

}
