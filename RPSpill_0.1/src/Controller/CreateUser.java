package controller;

import java.util.Scanner;

public class CreateUser {

	String u = "";
	String p = "";
	String p2 = "";
	String username = "";
	String password = "";
	
	public CreateUser() {
		do {
			System.out.println("Welcome to RPGame.\n" +
					"Please create a user by selecting a " +
					"username and a password.");
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter your desired username: ");
			u = sc.nextLine();
			if (!JDBC.existingUsername(u)) {
				if (!(u.length() > 12)) {
					System.out.println("Username cannot exceed 12 characters.");
				}
				System.out.println("\nEnter your desired password: ");
				p = sc.nextLine();
				System.out.println("Re-enter desired password: ");
				if (p.equals(p2))
					System.out.println("\nok\n");
				else
					System.out.println("Passwords didn't match.");
			}
			else 
				System.out.println("Existing username.");
		} while(!u.equals(""));
	}

	public static void main(String[] args) {
		CreateUser user = new CreateUser();
		JDBC.addUser(user);
	}
}
