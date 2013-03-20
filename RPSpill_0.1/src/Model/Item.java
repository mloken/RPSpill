package model;

import controller.JDBC;

public class Item {

	public String name = "";
	public String rClass = "";
	public String type = "";
	public int str, dex, intel, AtkDmg;
	public int level, quality;
	
	public Item() throws Exception {
		
		JDBC.addItems(this.createWeapon("Sword #1", "Common", "Sword", 1, 10, 10, 10, 10, 1));
		JDBC.addItems(this.createWeapon("BentSword", "Master", "Sword", 100, 1000, 1000, 1000, 1000, 5));
		JDBC.addItems(this.createWeapon("Bow", "Ranger", "Bow", 10, 5, 10, 0, 15, 1));
	}

	// This should probably be done in another way..? 
	public Item createWeapon(String name, String rClass, String type, int level, int str, int dex, int intel,
			int AtkDmg, int quality) {
		
		this.name = name;
		this.rClass = rClass;
		this.type = type;
		this.level = level;
		this.str = str;	this.dex = dex;	this.intel = intel;
		this.AtkDmg = AtkDmg;
		this.quality = quality;
		
		return this;
	}
	
	public String printWeapon() {
		
		String Requirement = "\n  -Requirements-\n  Class: " + this.rClass + "\n  Lvl:" + this.level;
				
		String s = "" + this.name +  Requirement +
				"\n    Attack damage: " + this.AtkDmg +
				"\n    Str: " + this.str
				+ "\n    Dex: " + this.dex + "\n    Int: " + this.intel  + 
				"\n       Quality: " + this.quality;
		return s;
	}
	
	public void createPotion(int pID, String name, int hp, int mp) {
		
	}
}
