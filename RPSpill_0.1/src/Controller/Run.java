package controller;

import java.util.Scanner;

public class Run {
	
	static String owner = "";
	static String p = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.print("Username: ");
			owner = sc.nextLine();
			System.out.print("Password: ");
			String p = sc.nextLine();
			boolean a = (JDBC.logIn(owner, p));
			if (!a) {
				System.out.println("Wrong username or password.");
				continue;
			}
			else
				break;
		}while(true);
		
		System.out.println("Logged in as: " + owner.toLowerCase());
		System.out.println("Press 1 to choose existing character.");
		System.out.println("Press 2 to create a character.");
		System.out.println("Press 3 to delete a character.");

		int x;
		do {
			String number = sc.nextLine();
			try { 
				x = Integer.parseInt(number); 
				break;
			} 
			catch(NumberFormatException nFE) { 
				System.out.println("Invalid input.");
				continue;
			}
		} while (true);
		
		if (x == 2) 
			new CreateCharacter();
	}

}
