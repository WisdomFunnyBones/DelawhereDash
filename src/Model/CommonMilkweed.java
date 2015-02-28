package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controller.Controller;

public class CommonMilkweed extends Native{

	//this is Native
	static int waterbenefit = 500;
	static int gardenbenefit = 500;
	static int weatherbenefit = 500;
	static int duration = 15;
	
	public CommonMilkweed(int xLoc, int yLoc){
		super(xLoc, yLoc, weatherbenefit, gardenbenefit, waterbenefit, duration);
		name = "Common MIlkweed";
		this.image = Controller.getImgRes().getCommonMilkweed();
	}

	@Override
	public String getName() {
		return name;
	}
}
