package Model;

public class NPC {

	boolean talk; //Can an NPC talk/interact with a player?
	boolean Merch;
	boolean hasQuest;
	
	int mapID, posx, posy; //In what map and where in the map can an NPC be found?
	
	public NPC() {
		NPC Bent = new NPC();
		Bent.talk = true;
		Bent.Merch = false;
		Bent.hasQuest = true;
	}
	
}
