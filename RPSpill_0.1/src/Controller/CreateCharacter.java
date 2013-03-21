package controller;

import java.util.Scanner;

public class CreateCharacter {
	
	String u = "";
	
	public CreateCharacter() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("\nPlease enter your desired Character name: ");
			u = sc.nextLine();
			u = u.toLowerCase().trim();

			if (JDBC.existingCharacterName(u)) 
				System.out.println("Character name already exists.");
			else if (u.length() > 12 || u.length() < 4) 
				System.out.println("Your name must be between 4 and 12 characters.");
			else
				break;
		} while (true);
		JDBC.createCharacter(Run.owner, u );
	}
	
}
