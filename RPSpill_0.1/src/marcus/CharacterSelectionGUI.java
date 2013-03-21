package marcus;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CharacterSelectionGUI {

	private JFrame frame;
    private JPanel panel;
    
    public CharacterSelectionGUI(){
    	frame = new JFrame();
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        
        frame.add(panel);
        frame.setVisible(true);
    }
	
}
