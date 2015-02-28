package Model;

public abstract class Invasive extends Plant{

	public Invasive(int xLoc, int yLoc, int weatherbenefit, int gardenbenefit,
			int waterbenefit, int duration) {
		super(xLoc, yLoc, weatherbenefit, gardenbenefit, waterbenefit, duration);
	}

}
