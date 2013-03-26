package gui;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Connexion extends JPanel {
private JLabel connexionLabel,log,pwd,test;
private JTextField login;
private JPasswordField pass;
private JButton ok,annuler;	

	public Connexion(){
		this.setLayout(new GridLayout(4,2));
		connexionLabel = new JLabel("Veuillez rentrer les informations de connexion à la base de données");
		log = new JLabel("Login");
		test = new JLabel("\n");
		pwd = new JLabel("Password");
		login = new JTextField("Login");
		pass = new JPasswordField();
		ok = new JButton("Ok");
		annuler = new JButton("Annuler");
		this.add(connexionLabel);
		this.add(test);
		this.add(log);
		this.add(login);
		this.add(pwd);
		this.add(pass);
		this.add(ok);
		this.add(annuler);
	}
	

}

