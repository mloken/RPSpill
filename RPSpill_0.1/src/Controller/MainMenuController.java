package Controller;

import java.io.IOException;

public class MainMenuController {
	
	public class CreateCharacterController {

	}

	public static void main(String[] arg) throws Exception {
		new MainMenuController();
	}
	
	public MainMenuController() throws IOException{
		System.out.println("Welcome to RP-game");
		System.out.println("Please create character");
		new CreateCharacterController();
	}
	
}
