package Model;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Item {

	String name = "";
	int ID;
	int str, dex, intel, AtkDmg, SpellDmg, hp, mp;
	int rStr, rDex, rInt, rLevel, rClass;
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	public Item() {
		int i = 1;
		this.createWeapon(i, "Sword #", 10*i, 10*i, 10*i, 10*i, 10*i);		
//		itemList.add(this);
//		itemList.toString();
	}
	
	public void createPotion(int pID, String name, int hp, int mp) {
		
	}

	private void createWeapon(int wID, String name, int str, int dex, int intel, int AtkDmg, int SpellDmg) {
		this.ID = wID; this.name = name;
		this.str = str;	this.dex = dex;	this.intel = intel;
		this.AtkDmg = AtkDmg;
		this.SpellDmg = SpellDmg;
		this.rLevel = this.rStr = this.rDex = this.rInt = 0;
	}
	
}
