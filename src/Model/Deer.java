package Model;

import Controller.Controller;

public class Deer extends Animal{

	public Deer(int xLoc, int yLoc) {
		super(xLoc, yLoc);
		this.image = Controller.getImgRes().getDeer();
	}

}

