package Model;

import java.util.ArrayList;

public class Item {

	String name = "";
	String rClass = "";
	int ID;
	int str, dex, intel, AtkDmg, SpellDmg, hp, mp;
	int rStr, rDex, rInt, rLevel, quality;
	
	ArrayList<Item> itemList;
	
	public Item() {
		itemList = new ArrayList<Item>();
		this.createWeapon(0, "Sword #1", "Common", 0, 10, 10, 10, 10, 10, 0, 0, 0, 1);
		this.createWeapon(1, "BentSword", "Master", 100, 1000, 1000, 1000, 1000, 1000, 0, 0, 0, 5);
//		for (Item item : itemList) {
//			System.out.println(item.printWeapon());
//		}
	}
	
	public void createPotion(int pID, String name, int hp, int mp) {
		
	}

	// This should probably be done in another way..
	private void createWeapon(int wID, String name, String rClass, int rLevel, int str, int dex, int intel,
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
		
		itemList.add(this);
		ItemList.addItem(this);
		System.out.println(this.printWeapon());
	}
	
	public String printWeapon() {
		
		String a = "\n -Requirements-\n Class: " + this.rClass + "\n Lvl:" + this.rLevel +
				"\n Str:" + this.rStr + "\n Dex:" + this.rDex + "\n Int:" + this.rInt + 
				"\n Quality:" + this.quality;
		String s;
		s = "" + this.name +  a +
				"\n  Attack damage: " + this.AtkDmg +
				"\n  Magic damage: " + this.SpellDmg +
				"\n  Str: " + this.str
				+ "\n  Dex: " + this.dex + "\n  Int: " + this.intel;
		return s;
	}
	
}
