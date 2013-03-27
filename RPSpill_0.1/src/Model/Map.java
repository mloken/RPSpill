package model;

import controller.JDBC;

public class Map {
	
	int mapID;
	public String level =	"##########x" +
							"#        #x" +
							"#        #x" +
							"#		  #x" +
							"##########x";
	
	public Map() throws Exception {
		JDBC.createMap(level);
	}
	
}
