package marcus;

import java.util.ArrayList;

public class WeaponTest {

	public static void main(String[] args) {

		ArrayList<Sword> swordList = new ArrayList<Sword>();
		int level = 90;
		
		for(int i = 0; i < 20; i++){
			swordList.add(new Sword(level));
			System.out.println(swordList.get(i));
		}
	}
}
