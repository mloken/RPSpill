package model;

import controller.JDBC;

public class Monsters {
	
	public int id, level, hp, mp;
	public int armour;
	public int expReward = 0;
	public String name;
	
	public Monsters() {
		JDBC.createMonster(this.createMonster("Snail", 1, 10, 0, 0, 10));
	}
	
	public Monsters createMonster(String name, int level, int hp, int mp, int armour, int expReward) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.mp = mp;
		this.armour = armour;
		this.expReward = expReward;
		return this;
	}

	

	
	
}
