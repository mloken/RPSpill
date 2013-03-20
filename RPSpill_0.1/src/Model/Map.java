package model;

public class Map {
	int mapID;
	int gravity;
	boolean hasPlayer; //Does a map contain any players? Might be uneccessary,
	// but if we spawn mobs in all the maps in the game when there are no players there
	// it might cause the system to run more slowly
	
	public Map() {
		
	}
	
}
