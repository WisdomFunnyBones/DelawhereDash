package Model;


public abstract class Obstacle extends LaneObject{
	
	int staminaPenalty;
	
	public int getStaminaPenalty() {
		return staminaPenalty;
	}

	public Obstacle(int xLoc, int yLoc, int staminaPenalty){
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.staminaPenalty=staminaPenalty;
	}
		
}
