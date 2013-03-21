package controller;

import java.util.Scanner;

public class Run {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		String u = sc.nextLine();
		System.out.print("Password: ");
		String p = sc.nextLine();
		boolean a = (JDBC.logIn(u, p)) ? true : false;
		if (!a) {
			System.out.println("Wrong username or password.");
			return;
		}
		System.out.println("Press 1 to create a character.");
		System.out.println("Press 2 to choose existing character.");
		System.out.println("Press 3 to go fuck yourself.");
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
