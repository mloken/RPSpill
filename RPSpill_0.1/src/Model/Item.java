package model;

import controller.JDBC;

public class Item {

	public String name = "";
	public String type = "";
	public int str, dex, intel, dmg;
	public int level, quality;
	
	public Item() throws Exception {
		
		JDBC.addItems(this.createWeapon("Sword #1", "Sword", 1, 10, 10, 10, 10, 1));
		JDBC.addItems(this.createWeapon("BentSword", "Sword", 100, 1000, 1000, 1000, 1000, 5));
		JDBC.addItems(this.createWeapon("Bow", "Bow", 10, 5, 10, 0, 15, 1));
	}

	// This should probably be done in another way..? 
	public Item createWeapon(String name, String type, int level, int str, int dex, int intel,
			int dmg, int quality) {
		
		this.name = name;
		this.type = type;
		this.level = level;
		this.str = str;	this.dex = dex;	this.intel = intel;
		this.dmg = dmg;
		this.quality = quality;
		
		return this;
	}
	
	public String printWeapon() {
		
		String Requirement = "\n  -Requirements-\n  Lvl:" + this.level;
				
		String s = "" + this.name +  Requirement +
				"\n    Attack damage: " + this.dmg +
				"\n    Str: " + this.str
				+ "\n    Dex: " + this.dex + "\n    Int: " + this.intel  + 
				"\n       Quality: " + this.quality;
		return s;
	}
	
	public void createPotion(int pID, String name, int hp, int mp) {
		
	}
}
