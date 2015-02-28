package Model;

import Controller.Controller;

public class ZombieGrass extends Zombie{
	// this is Zombie

	static int waterbenefit = -100;
	static int gardenbenefit = -100;
	static int weatherbenefit = -100;
	static int duration = 5;
	
	public ZombieGrass(int xLoc, int yLoc) {
				super(xLoc, yLoc, weatherbenefit, gardenbenefit, waterbenefit, duration);
				name = "ZombieGrass";
				this.image = Controller.getImgRes().getZombieGrass();
				//System.out.println(this.waterbenefit+ ""+ this.gardenbenefit+""+ this.weatherbenefit);
			}

			@Override
			public String getName() {
				return name;
			}

		}