package Model;

public class NPC {

	// Slik jeg tenker det. �pen for endringer ofc
	boolean talk; //Om en NPC kan snakke. Si at du klikker en NPC for � snakke. Enten har NPC'en noe � si eller ikke.
	boolean Merch;
	boolean hasQuest;
	
	int mapID, posx, posy; //I hvilke(t) og hvor i et map finnes NPC'en.
	
	public NPC() {
		NPC Bent = new NPC();
		Bent.talk = true;
		Bent.Merch = false;
		Bent.hasQuest = true;
	}
	
	public static void main(String[] args) {
		
	}
	
	
}
