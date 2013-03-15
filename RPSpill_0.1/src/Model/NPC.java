package Model;

public class NPC {

	boolean talk;
	boolean sellItems;
	boolean buyItems;
	boolean hasQuest;
	
	public void NPC() {
		NPC Bent = new NPC();
		Bent.talk = true;
		Bent.sellItems = false;
		Bent.buyItems = false;
		Bent.hasQuest = true;
	}
	
	public static void main(String[] args) {
		
	}
	
	
}
