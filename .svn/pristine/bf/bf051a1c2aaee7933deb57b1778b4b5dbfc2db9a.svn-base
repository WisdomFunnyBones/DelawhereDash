package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controller.Controller;

public class Water {
	int count=0;
	private static int waterCondition = 2000;
	public Image waterImg1;
	public Image waterImg2;
	public Image waterImg3;
	public Image waterImg4;
	
	public Water(){
		waterCondition=2000;
		try {
			waterImg1 = ImageIO.read(new File("images/waves.png"));
			waterImg2 = ImageIO.read(new File("images/waves_green.png"));
			waterImg3 = ImageIO.read(new File("images/water_green-brown.png"));
			waterImg4 = ImageIO.read(new File("images/water_brown.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void reset(){
		waterCondition=2000;
	}
	
	public static int getWaterCondition(){
		return waterCondition;
	}
	
	public Image getWaterImg(){
		if(count==0){
			count+=1;
		return waterImg1;
		}
		else if (count==1){
			count+=1;
			return waterImg2;
			}
		else if (count==2){
			count+=1;
			return waterImg3;
			}
		else{
			return waterImg4;
		}
	}

	
	// updates the water condition depending on the plant that was picked up
	public void update(){
		LaneObject[] playerInventory = Inventory.getInventory();
		int count = 0;
		for(LaneObject i : playerInventory){
			if(i != null){
			count+= ((Plant) i).getWaterbenefit();
		}}
		waterCondition += count;
	}
	
}

