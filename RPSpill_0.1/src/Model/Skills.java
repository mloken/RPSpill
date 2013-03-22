package model;

import controller.JDBC;

public class Skills {

	public int id;
	public int dmg;
	public String name;
	
	public Skills() throws Exception {
		JDBC.createSkills(this.createSkills("Standard", 10));
	}

	public Skills createSkills(String name, int dmg) {
		this.name = name;
		this.dmg = dmg;
		return this;
	}
}
