package controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
	
	static Scanner sc;
	static String owner = "";
	static String p = "";
	static ArrayList<String> charList;
	static int c = 0;
	boolean hasDeleted;

	public static boolean isInt(String x) {
		do {
			try { 
				int a = Integer.parseInt(x); 
				return true;
			} 
			catch(NumberFormatException nFE) { 
				System.out.println("Invalid input. Try again: ");
			}
			x = sc.nextLine();
		} while (false);
		return false;
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
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

		int x = 0;
		sc = new Scanner(System.in);
		String number = sc.nextLine();
		if (isInt(number))
			x = Integer.parseInt(number);

		switch (x) {
		case 1:
			charList = new ArrayList<String>();
			System.out.println("Please choose your character from the list below: ");
			charList = JDBC.characterList(owner);
			System.out.println(charList);
			System.out.print("Character number: ");
			int a = sc.nextInt();
			break;
		case 2:
			new CreateCharacter();
			break;
		case 3:
			System.out.println("Which character do you want to delete?");
			System.out.println(charList);
			System.out.print("Character number: ");
			String b = sc.nextLine();
			if (isInt(b))
				c = Integer.parseInt(b);
			if (JDBC.deleteCharacter(charList.get(c)))
				System.out.println("Character was deleted successfully." );
			else
				System.out.println("no");
		default:
			break;
		} 
			
	}

}
