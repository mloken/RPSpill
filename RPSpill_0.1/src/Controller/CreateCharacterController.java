package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class CreateCharacterController extends AbstractController{

	JFrame frame;
	
	public CreateCharacterController() throws IOException{
//		System.out.print("Choose name: ");
//		String inn = this.waitForInput();
//		System.out.println("" + inn + " is a great name!");
		frame = new JFrame();
		initUI();
	}
	
	public final void initUI() {

	       JPanel panel = new JPanel();
	       frame.getContentPane().add(panel);

	       panel.setLayout(null);

	       JButton playButton = new JButton("GOGO");
	       playButton.setBounds(360, 60, 80, 30);
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
	       quitButton.setBounds(360, 100, 80, 30);
	       quitButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent event) {
	               System.exit(0);
	          }
	       });
	       panel.add(quitButton);

	       frame.setTitle("Main Menu");
	       frame.setSize(800, 600);
	       frame.setLocationRelativeTo(null);
	       frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	    }
}
