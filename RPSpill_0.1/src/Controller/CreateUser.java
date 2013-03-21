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
			
			if (u.length() > 12 || u.length() < 4 || u == "") 
				System.out.println("Your name must be between 4 and 12 characters.");
			else if (JDBC.existingCharacterName(u)) 
				System.out.println("That name already exists.");
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
