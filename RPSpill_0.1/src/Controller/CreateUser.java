package controller;

import java.util.Scanner;

public class CreateUser {

	String u = "";
	String p = "";
	String p2 = "";
	String username = "";
	String password = "";
	Scanner sc;
	
	public CreateUser() {
		sc = new Scanner(System.in);
		boolean a = true;
		do {
			System.out.print("\nPlease enter your desired Character name: ");
			u = sc.nextLine();
			u = u.toLowerCase().trim();
			System.out.print("\nPlease enter your password: ");
			p = sc.nextLine();
			System.out.print("\nRe-enter your password: ");
			p2 = sc.nextLine();
			
			if (u.length() > 12 || u.length() < 4) 
				System.out.println("Your name must be between 4 and 12 characters.");
			else if (JDBC.existingCharacterName(u)) 
				System.out.println("That name already exists.");
			else if (p.length() < 6 || p.length() > 15)
				System.out.println("Password length must be between 6 and 15.");
			else if (!p.equals(p2))
				System.out.println("Passwords must match.");
			else 
				a = false;
		} while(a);
		
		this.u = u;
		this.p = p;
	}

	public static void main(String[] args) {
		CreateUser user = new CreateUser();
		JDBC.addUser(user);
		JDBC.close();
	}
	
}
