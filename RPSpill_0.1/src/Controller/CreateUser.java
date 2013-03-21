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
		System.out.println("Welcome to RPGame.\n" +
				"Please create a user by selecting a " +
				"username and a password.");
		boolean a = true;
		do {
			System.out.print("\nPlease enter your desired username: ");
			u = sc.nextLine();
			u = u.toLowerCase().trim();
				
			System.out.print("\nEnter your desired password: ");
			p = sc.nextLine();
			System.out.print("\nRe-enter desired password: ");
			p2 = sc.nextLine();
			if (u.length() > 12 || u.length() < 4 || u == "") 
				System.out.println("Username must be between 4 and 12 characters.");
			else if (JDBC.UsernameExists(u)) 
				System.out.println("Username already exists.");
			else if (p.length() > 20 || p.length() < 4 || p == "") 
				System.out.println("Password must be between 4 and 20 characters.");
			else if (!p.equals(p2)) 
				System.out.println("Passwords don't match.");
			else 
				a = false;
		} while(a);
		
		this.u = u;
		this.p = p;
	}

//	public static void main(String[] args) {
//		CreateUser user = new CreateUser();
//		JDBC.addUser(user);
//		JDBC.close();
//	}
	
}
