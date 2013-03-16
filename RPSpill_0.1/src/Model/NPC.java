package Model;

public class NPC {

	boolean talk; //Can an NPC talk/interact with a player?
	boolean merch, hasQuest;
	int NPCID, mapID, posx, posy; //In what map and where in the map can an NPC be found?
	String name; 
	
	public NPC() {
		createNPC(0, "Bent", 1, 100, 0, true, true, true);
		createNPC(1, "Marcus", 1, 80, 0, true, true, true); //Creating us :D
	}
	
	public void createNPC(int ID, String name, int mapID, int posx, int posy, boolean talk, boolean merch, boolean hasQuest) {
		this.mapID = mapID;
		this.posx = posx;
		this.posy = posy;
		this.talk = talk;
		this.merch = merch;
		this.hasQuest = hasQuest;
	}
	
}
