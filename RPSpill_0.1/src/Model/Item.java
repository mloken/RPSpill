package Model;

import Controller.JDBC;

public class Item {

	public String name = "";
	public String rClass = "";
	public int ID;
	public int str, dex, intel, AtkDmg, SpellDmg, hp, mp;
	public int rStr, rDex, rInt, rLevel, quality;
	
	public Item() throws Exception {
		
		JDBC.addItems(this.createWeapon(0, "Sword #1", "Common", 0, 10, 10, 10, 10, 10, 0, 0, 0, 1));
		JDBC.addItems(this.createWeapon(1, "BentSword", "Master", 100, 1000, 1000, 1000, 1000, 1000, 0, 0, 0, 5));
		JDBC.addItems(this.createWeapon(2, "Bow", "Ranger", 10, 5, 10, 0, 15, 0, 0, 0, 0, 1));
	}
	
	public void createPotion(int pID, String name, int hp, int mp) {
		
	}

	// This should probably be done in another way..? 
	public Item createWeapon(int wID, String name, String rClass, int rLevel, int str, int dex, int intel,
			int AtkDmg, int SpellDmg, int rStr, int rDex, int rInt, int quality) {
		
		this.ID = wID; this.name = name;
		this.str = str;	this.dex = dex;	this.intel = intel;
		this.AtkDmg = AtkDmg;
		this.SpellDmg = SpellDmg;
		this.rClass = rClass;
		this.rLevel = rLevel;
		this.rStr = rStr;
		this.rDex = rDex;
		this.rInt = rInt;
		this.quality = quality;
		
		return this;
	}
	
	public String printWeapon() {
		
		String Requirement = "\n  -Requirements-\n  Class: " + this.rClass + "\n  Lvl:" + this.rLevel +
				"\n  Str:" + this.rStr + "\n  Dex:" + this.rDex + "\n  Int:" + this.rInt;
		String s = "" + this.name +  Requirement +
				"\n    Attack damage: " + this.AtkDmg +
				"\n    Magic damage: " + this.SpellDmg +
				"\n    Str: " + this.str
				+ "\n    Dex: " + this.dex + "\n    Int: " + this.intel  + 
				"\n       Quality: " + this.quality;
		return s;
	}
}
