package Model;


public abstract class Plant extends LaneObject {

	int waterbenefit;
	int gardenbenefit;
	int weatherbenefit;
	int duration;
	public String name;

	public Plant(int xLoc, int yLoc, int weatherbenefit, int gardenbenefit, int waterbenefit, int duration) {
		this.xLoc=xLoc;
		this.yLoc=yLoc;
		this.gardenbenefit = gardenbenefit;
		this.waterbenefit = waterbenefit;
		this.weatherbenefit = weatherbenefit;
		this.duration = duration;
	}
	
	public abstract String getName();
	
	public int getDuration(){
		return this.duration;
	}
	
	public int getWaterbenefit() {
		return waterbenefit;
	}

	public int getGardenbenefit() {
		return gardenbenefit;
	}

	public int getWeatherbenefit() {
		return weatherbenefit;
	}

}
