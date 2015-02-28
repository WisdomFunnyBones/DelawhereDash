package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controller.Controller;

public class Puddle extends Obstacle{

	static int staminaPenalty= 50;
	
	public Puddle(int xLoc, int yLoc){
		super(xLoc, yLoc, staminaPenalty);
		this.image = Controller.getImgRes().getPuddle();

	}

}
