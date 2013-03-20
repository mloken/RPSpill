package marcus;

import java.util.Random;

public abstract class Weapon {
	
	Random generator;
	private int lowDmg, highDmg;
	
	public Weapon(){
		generator = new Random();
	}
	
	//Metode som tar inn "avg damage" og regner ut lowDmg og highDmg til våpenet
	public void calcDamage(int avgDmg){
		int tailDmg = avgDmg / 2;
		
		double m = dmgMulti();
		setLowDmg((int) (tailDmg * m));
		
		m = dmgMulti();
		setHighDmg((int) ((avgDmg + tailDmg) * m));
	}
	
	//Metode som genererer en damage-multiplier fra 0,5 -> 1 (større sjanse for
	//lavere multiplier, kvadratisk fordeling)
	private double dmgMulti(){
		double r = generator.nextDouble();
		r = ((Math.pow(r, 2)) / 2) + 0.5;
		return r;
	}
	
	public int getLowDmg() {
		return lowDmg;
	}

	public void setLowDmg(int lowDmg) {
		this.lowDmg = lowDmg;
	}

	public int getHighDmg() {
		return highDmg;
	}

	public void setHighDmg(int highDmg) {
		this.highDmg = highDmg;
	}
}
