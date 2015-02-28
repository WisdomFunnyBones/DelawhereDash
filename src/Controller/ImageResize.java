package Controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageResize {

	static Image zombieGrass;
	static Image arbovitae;
	static Image bee;
	static Image fox;
	static Image gasCloud;
	static Image grassZombieFront;
	static Image grassZombieBack;
	static Image puddle;
	static Image questionMark;
	static Image rabbit;
	static Image deer;
	static Image bradfordPear;
	static Image burningBush;
	static Image commonMilkweed;
	static Image maidenGrass;
	static Image scarletOak;
	static Image astroImgfull;
	static Image astroImg1_7;
	static Image astroImg2_7;
	static Image astroImg3_7;
	static Image astroImg4_7;
	static Image astroImg5_7;
	static Image astroImg6_7;
	static Image astroImgempty;
	static Image dmgastroImgfull;
	static Image dmgastroImg1_7;
	static Image dmgastroImg2_7;
	static Image dmgastroImg3_7;
	static Image dmgastroImg4_7;
	static Image dmgastroImg5_7;
	static Image dmgastroImg6_7;
	static Image dmgastroImgempty;

	double resObject;
	double resizeVal;
	
	private Map<String, Image> imageMap;
	
	
	public ImageResize() {
		try {
			zombieGrass = ImageIO.read(new File ("images/zombiegrass.png"));
			arbovitae = ImageIO.read(new File("images/arbovitae.png"));
			bee = ImageIO.read(new File("images/bee.png"));
			fox = ImageIO.read(new File("images/fox.png"));
			gasCloud = ImageIO.read(new File("images/cloud.png"));
			grassZombieFront = ImageIO.read(new File("images/grasszombiefront.png"));
			grassZombieBack = ImageIO.read(new File("images/grasszombieback.png"));
			puddle = ImageIO.read(new File("images/puddle.png"));
			rabbit = ImageIO.read(new File("images/newrabbit.png"));
			deer = ImageIO.read(new File("images/deer.png"));
			bradfordPear = ImageIO.read(new File("images/BradfordPear.png"));
			burningBush = ImageIO.read(new File("images/burning_bush.png"));
			commonMilkweed = ImageIO.read(new File("images/common_milkweed.png"));
			maidenGrass = ImageIO.read(new File("images/maiden_grass.png"));
			scarletOak = ImageIO.read(new File("images/ScarletOak.png"));
			questionMark = ImageIO.read(new File("images/questionmark.png"));
			astroImgfull = ImageIO.read(new File("images/astro/normal/astro_full.png"));
			astroImg1_7 = ImageIO.read(new File("images/astro/normal/astro_1-7.png"));
			astroImg2_7 = ImageIO.read(new File("images/astro/normal/astro_2-7.png"));
			astroImg3_7 = ImageIO.read(new File("images/astro/normal/astro_3-7.png"));
			astroImg4_7 = ImageIO.read(new File("images/astro/normal/astro_4-7.png"));
			astroImg5_7 = ImageIO.read(new File("images/astro/normal/astro_5-7.png"));
			astroImg6_7 = ImageIO.read(new File("images/astro/normal/astro_6-7.png"));
			astroImgempty = ImageIO.read(new File("images/astro/normal/astro_empty.png"));
			dmgastroImgfull = ImageIO.read(new File("images/astro/damaged/astro_dmg_full.png"));
			dmgastroImg1_7 = ImageIO.read(new File("images/astro/damaged/astro_dmg_1-7.png"));
			dmgastroImg2_7 = ImageIO.read(new File("images/astro/damaged/astro_dmg_2-7.png"));
			dmgastroImg3_7 = ImageIO.read(new File("images/astro/damaged/astro_dmg_3-7.png"));
			dmgastroImg4_7 = ImageIO.read(new File("images/astro/damaged/astro_dmg_4-7.png"));
			dmgastroImg5_7 = ImageIO.read(new File("images/astro/damaged/astro_dmg_5-7.png"));
			dmgastroImg6_7 = ImageIO.read(new File("images/astro/damaged/astro_dmg_6-7.png"));
			dmgastroImgempty = ImageIO.read(new File("images/astro/damaged/astro_dmg_empty.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		imageMap = new HashMap<String, Image>();
		imageMap.put("Arbovitae",arbovitae);
		imageMap.put("Bee",bee);
		imageMap.put("Fox",fox);
		imageMap.put("GasCloud",gasCloud);
		imageMap.put("GrassZombieFront",grassZombieFront);
		imageMap.put("GrassZombieBack",grassZombieBack);
		imageMap.put("Puddle",puddle);
		imageMap.put("Rabbit",rabbit);
		imageMap.put("Deer", deer);
		imageMap.put("BradfordPear", bradfordPear);
		imageMap.put("BurningBush", burningBush);
		imageMap.put("CommonMilkweed", commonMilkweed);
		imageMap.put("MaidenGrass", maidenGrass);
		imageMap.put("ScarletOak", scarletOak);
		imageMap.put("QuestionMark",questionMark);
		imageMap.put("astroImgfull", astroImgfull);
		imageMap.put("astroImg1_7", astroImg1_7);
		imageMap.put("astroImg2_7", astroImg2_7);
		imageMap.put("astroImg3_7", astroImg3_7);
		imageMap.put("astroImg4_7", astroImg4_7);
		imageMap.put("astroImg5_7", astroImg5_7);
		imageMap.put("astroImg6_7", astroImg6_7);
		imageMap.put("astroImgempty", astroImgempty);
		imageMap.put("dmgastroImgfull", dmgastroImgfull);
		imageMap.put("dmgastroImg1_7", dmgastroImg1_7);
		imageMap.put("dmgastroImg2_7", dmgastroImg2_7);
		imageMap.put("dmgastroImg3_7", dmgastroImg3_7);
		imageMap.put("dmgastroImg4_7", dmgastroImg4_7);
		imageMap.put("dmgastroImg5_7", dmgastroImg5_7);
		imageMap.put("dmgastroImg6_7", dmgastroImg6_7);
		imageMap.put("dmgastroImgempty", dmgastroImgempty);
		imageMap.put("zombieGrass", zombieGrass);
 		double screenWidth=(double) Controller.screenWidth;
		resizeVal = screenWidth/20;
		for(Object obj: imageMap.keySet().toArray()){
			String key = (String) obj;
			Image value = imageMap.get(key);
			resObject =(double)(value.getWidth(null))/(double)(value.getHeight(null));
			imageMap.remove(key);
			imageMap.put(key, value.getScaledInstance((int)(resizeVal), (int)(resizeVal / resObject), Image.SCALE_SMOOTH));
		}
		
	}
	
	public Image getZombieGrass(){
		return imageMap.get("zombieGrass");
	}
	
	public Image getArbovitae(){
		return imageMap.get("Arbovitae");
	}

	public Image getBee(){
		return imageMap.get("Bee");
	}
	
	public Image getFox(){
		return imageMap.get("Fox");
	}
	
	public Image getgasCloud(){
		return imageMap.get("GasCloud");
	}
	
	public Image getgrassZombieFront(){
		return imageMap.get("GrassZombieFront");
	}
	
	public Image getgrassZombieBack(){
		return imageMap.get("GrassZombieBack");
	}
	
	public Image getPuddle(){
		return imageMap.get("Puddle");
	}
	
	public Image getRabbit(){
		return imageMap.get("Rabbit");
	}
	
	public Image getDeer(){
		return imageMap.get("Deer");
	}
	
	public Image getBradfordPear(){
		return imageMap.get("BradfordPear");
	}
	
	public Image getBurningBush(){
		return imageMap.get("BurningBush");
	}
	
	public Image getCommonMilkweed(){
		return imageMap.get("CommonMilkweed");
	}
	
	public Image getMaidenGrass(){
		return imageMap.get("MaidenGrass");
	}
	
	public Image getScarletOak(){
		return imageMap.get("ScarletOak");
	}
	
	public Image getquestionMark(){
		return imageMap.get("QuestionMark");
	}
	public Image getdmgastroImgfull(){
		return imageMap.get("dmgastroImgfull");
	}
	public Image getdmgastroImg1_7(){
		return imageMap.get("dmgastroImg1_7");
	}
	public Image getdmgastroImg2_7(){
		return imageMap.get("dmgastroImg2_7");
	}
	public Image getdmgastroImg3_7(){
		return imageMap.get("dmgastroImg3_7");
	}
	public Image getdmgastroImg4_7(){
		return imageMap.get("dmgastroImg4_7");
	}
	public Image getdmgastroImg5_7(){
		return imageMap.get("dmgastroImg5_7");
	}
	public Image getdmgastroImg6_7(){
		return imageMap.get("dmgastroImg6_7");
	}
	public Image getdmgastroImgempty(){
		return imageMap.get("dmgastroImgempty");
	}
	public Image getastroImgfull(){
		return imageMap.get("astroImgfull");
	}
	public Image getastroImg1_7(){
		return imageMap.get("astroImg1_7");
	}
	public Image getastroImg2_7(){
		return imageMap.get("astroImg2_7");
	}
	public Image getastroImg3_7(){
		return imageMap.get("astroImg3_7");
	}
	public Image getastroImg4_7(){
		return imageMap.get("astroImg4_7");
	}
	public Image getastroImg5_7(){
		return imageMap.get("astroImg5_7");
	}
	public Image getastroImg6_7(){
		return imageMap.get("astroImg6_7");
	}
	public Image getastroImgempty(){
		return imageMap.get("astroImgempty");
	}
	
}
