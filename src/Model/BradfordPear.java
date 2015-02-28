package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controller.Controller;


public class BradfordPear extends Invasive {
	//this is Invasive
	static int waterbenefit = 500;
	static int gardenbenefit = 500;
	static int weatherbenefit = 500;
	static int duration = 30;
	
	public BradfordPear(int xLoc, int yLoc){
		super(xLoc, yLoc, weatherbenefit, gardenbenefit, waterbenefit, duration);
		name = "Bradford Pear";
		this.image = Controller.getImgRes().getBradfordPear();
	}

	@Override
	public String getName() {
		return name;
	}

}