package Model;

public class Environment {
	static int airQuality = 2000;
	static int waterQuality = 2000;
	static int animalQuality = 2500;
	
	public int getAirQuality(){
		return airQuality;
	}
	
	public int getWaterQuality(){
		return waterQuality;
	}
	
	public int getAnimalQuality(){
		return animalQuality;
	}
	
	public void resetEnviro(){
		airQuality = 2000;
		waterQuality = 2000;
		animalQuality = 2500;
	}
	
	public void pickedPlant(boolean karma){
		airQuality+=150;
		waterQuality+=150;
		if (karma==true){
			animalQuality+=200;
		}
		else if (animalQuality>0){
			animalQuality+=50;
		}
	}
	
	public void pickedZombiePlant(){
		airQuality-=100;
		waterQuality-=100;
		animalQuality-=100;
	}
	
		
	public void decreaseEnviro(int i){
		if (airQuality>1){
		airQuality-=i;
		}
		if (waterQuality>1){
			waterQuality-=i;
		}
		if (animalQuality>1){
			animalQuality-=i;
		}
	}

}
