package Controller;

import java.io.IOException;

public class CreateCharacterController extends AbstractController{

	public CreateCharacterController() throws IOException{
		System.out.print("Choose name: ");
		String inn = this.waitForInput();
		System.out.println("" + inn + " is a great name!");
	}
	
	public static void main(String[] args){
		
	}
}
