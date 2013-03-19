package gui;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Connexion extends JPanel {
private JLabel connexionLabel;
private JTextField login;
private JPasswordField pass;
private JButton ok;	

	public Connexion(){
		this.setLayout(new GridLayout(4,1));
		connexionLabel = new JLabel("Connexion\nVeuillez rentrer les informations de connexion de la base de donnée");
		login = new JTextField("Login");
		pass = new JPasswordField();
		ok = new JButton("OK");
		this.add(connexionLabel);
		this.add(login);
		this.add(pass);
		this.add(ok);
	}
	

}

