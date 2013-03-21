package controller;

import java.util.Scanner;

public class Run {
	
	static String owner = "";
	static String p = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		owner = sc.nextLine();
		System.out.print("Password: ");
		String p = sc.nextLine();
		boolean a = (JDBC.logIn(owner, p));
		if (!a) {
			System.out.println("Wrong username or password.");
			return;
		}
		System.out.println("Logged in as: " + owner.toLowerCase());
		System.out.println("Press 1 to create a character.");
		System.out.println("Press 2 to choose existing character.");
		boolean b;
		int x = 0;
		do {
			String number = sc.nextLine();
			try { 
				x = Integer.parseInt(number); 
				b = true;
			} 
			catch(NumberFormatException nFE) { 
				b = false;
				System.out.println("Invalid input.");
			}
		} while (!b);
		System.out.println(x);
	}

}
