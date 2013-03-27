package model;

import controller.JDBC;

public class Monsters {
	
	public boolean turn;
	public int id, level, hp, mp;
	public int armour;
	public int expReward = 0;
	public String name;
	int posx, posy = 0;
	
	public Monsters(int x, int y) {
		this.posx = x;
		this.posy = y;
//		JDBC.createMonster(this.createMonster("Snail", 1, 10, 0, 0, 10));
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

	public void move(int i, int SPACE) {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
