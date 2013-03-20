package model;

import java.util.ArrayList;

public class ItemList {

	int str, dex, intelligence, AtkDmg, SpellDmg;
	int rStr, rDex, rInt, rLevel, rClass;
	
	static ArrayList<Item> items = new ArrayList<Item>();
	
	public ItemList() {
		
	}
	
	public static void addItem(Item item) {
		if (!items.contains(item))
			items.add(item);
		for (int i = 0; i < items.size(); i++)
			System.out.println(items.get(i).printWeapon());
	}
	// Should we have a quality-item type of class?
	// All items are of a type:
	// Top/Bottom/Overall, Hat, Shoes, wand, sword, 2 handed axe, bow, etc.

}
