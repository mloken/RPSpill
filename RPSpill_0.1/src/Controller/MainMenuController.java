package controller;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainMenuController extends JFrame{

	public static void main(String[] arg) throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainMenuController mmc;
				try {
					mmc = new MainMenuController();
					mmc.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }
        });
	}
	
	public MainMenuController() throws IOException{
		setTitle("Main Menu");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		new CreateCharacterController();
	}
	
}
