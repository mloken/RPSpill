package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		initUI();
//		new CreateCharacterController();
	}
	
	public final void initUI() {

	       JPanel panel = new JPanel();
	       getContentPane().add(panel);

	       panel.setLayout(null);

	       JButton playButton = new JButton("Play");
	       playButton.setBounds(250, 60, 300, 100);
	       playButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent event) {
	               try {
					new CreateCharacterController();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	       });
	       panel.add(playButton);
	       
	       JButton quitButton = new JButton("Quit");
	       quitButton.setBounds(250, 200, 300, 100);
	       quitButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent event) {
	               System.exit(0);
	          }
	       });
	       panel.add(quitButton);

	       setTitle("Main Menu");
	       setSize(800, 600);
	       setLocationRelativeTo(null);
	       setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }
	
}
