package marcus;

public class Sword extends Weapon{
	
	private int level;
	
	public static final int ROOT_DMG = 10;
	
	//initialiserer et sverd med et gitt level
	public Sword(int level){
		super();
		this.level = level;
		int avgDmg = ROOT_DMG + 2*(level - 1);
		this.calcDamage(avgDmg);
	}
	
	public int getLevel() {
		return level;
	}

	public String toString(){
		return "Sword:\nLevel: " + getLevel() + "\nDmg: " + this.getLowDmg() + " - " + this.getHighDmg() + "\n";
	}
}
