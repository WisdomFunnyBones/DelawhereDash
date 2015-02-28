package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controller.Controller;


public class Arbovitae extends Exotic{
	// this is exotic
	static int waterbenefit = 500;
	static int gardenbenefit = 500;
	static int weatherbenefit = 500;
	static int duration = 25;
	
	public Arbovitae(int xLoc, int yLoc){
		super(xLoc, yLoc, weatherbenefit, gardenbenefit, waterbenefit, duration);
		name = "arbovitae";
		this.image = Controller.getImgRes().getArbovitae();
		//System.out.println(this.waterbenefit+ ""+ this.gardenbenefit+""+ this.weatherbenefit);
	}

	@Override
	public String getName() {
		return name;
	}

}
