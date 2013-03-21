package marcus;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.JDBC;

public class LoginGUI {

	    private JFrame frame;
	    private JPanel panel;
	    private JButton quitButton, loginButton;
	    private JTextField usernameField;
	    private JPasswordField passwordField;
	    private JLabel usernameLabel, passwordLabel;

	    public LoginGUI(){
	        frame = new JFrame();
	        frame.setSize(800,600);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        panel = new JPanel();
	        panel.setLayout(new GridLayout(0,2));
	        
	        //Quit-knapp
	        quitButton = new JButton("Quit");
	        quitButton.addActionListener(new ActionListener(){

	            public void actionPerformed(ActionEvent e){
	            	System.exit(0);
	            }
	        });
	        quitButton.setFont(new Font("sansserif", Font.BOLD, 32));
	        
	        //Log in-knapp
	        loginButton = new JButton("Log in");
	        loginButton.addActionListener(new ActionListener(){

	            public void actionPerformed(ActionEvent e){
	            	
	            	
	    			String user = usernameField.getText();
	    			String password = passwordField.getText();
	    			boolean a = (JDBC.logIn(user, password));
	    			if (!a) {
	    				System.out.println("Wrong username or password.");
	    			}
	    			else{
	    				System.out.println("Correct");
	    				new CharacterSelectionGUI();
	    				frame.setVisible(false);
	    			}
	            	
//	                JOptionPane.showMessageDialog(null, "" + usernameField.getText() + " logged in");
	            }
	        });
	        loginButton.setFont(new Font("sansserif", Font.BOLD, 32));
	        
	        
	        usernameField = new JTextField(12);
	        usernameField.setFont(new Font("sansserif", Font.BOLD, 32));
	        passwordField = new JPasswordField(12);
	        passwordField.setFont(new Font("sansserif", Font.BOLD, 32));
	        
	        usernameLabel = new JLabel("Enter username: ");
	        usernameLabel.setFont(new Font("sansserif", Font.BOLD, 32));
	        passwordLabel = new JLabel("Enter password: ");
	        passwordLabel.setFont(new Font("sansserif", Font.BOLD, 32));
	        
	        panel.add(usernameLabel);
	        panel.add(usernameField);
	        panel.add(passwordLabel);
	        panel.add(passwordField);
	        panel.add(quitButton);
	        panel.add(loginButton);
	        passwordField.setLocation(400, 200);
	        frame.add(panel);
	        frame.setVisible(true);
	        
	    }
	    
	    public static void main(String args[]){
	    	new LoginGUI();
	    }
}
