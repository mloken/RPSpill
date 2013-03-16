package Model;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Item {

	Item item = new Item();
	String name = "";
	int ID;
	int str, dex, intel, AtkDmg, SpellDmg, hp, mp;
	int rStr, rDex, rInt, rLevel, rClass;
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	public Item() {
		for (int i = 1; i < 11; i++ ) {
			System.out.println("" + i);
			item.createWeapon(i, "Sword #" + i, 10*i, 10*i, 10*i, 10*i, 10*i);		
			itemList.add(item);
		}
		itemList.toString();
	}
	
	public void createPotion(int pID, String name, int hp, int mp) {
		
	}

	private void createWeapon(int wID, String name, int str, int dex, int intel, int AtkDmg, int SpellDmg) {
		item.ID = wID; item.name = name;
		item.str = str;	item.dex = dex;	item.intel = intel;
		item.AtkDmg = AtkDmg;
		item.SpellDmg = SpellDmg;
		item.rLevel = item.rStr = item.rDex = item.rInt = 0;
	}
	
}
