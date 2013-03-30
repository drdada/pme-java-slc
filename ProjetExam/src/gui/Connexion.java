package gui;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import dal.AccessBDGen;

public class Connexion extends JPanel {
private JLabel connexionLabel;
private JTextField login,url;
private JPasswordField pass;
private JButton ok;	
private Connection connexionDB ; 


	public Connexion(){
		//TODO redimentionner le panel
		this.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		this.setLayout(new GridLayout(4,1));
		

		
		connexionLabel = new JLabel("<html><body><center>Connexion<br>Veuillez rentrer les informations de connexion de la base de donnée</center></body></html>");
		url = new JTextField("Url");
		login = new JTextField("Login");
		pass = new JPasswordField();
		ok = new JButton("OK");
		
		
		
		this.add(connexionLabel);
		this.add(url);
		this.add(login);
		this.add(pass);
		this.add(ok);
	}
	
	private class EnvoiListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			String urll = url.getText();
			String logins = login.getText(); //Lit le contenu du champ login et le met dans la variable login
			String pw = new String (pass.getPassword()); //Lit (et transforme ) le mot de passe
			try{
				AccessBDGen.connecter(urll, logins, pw);
			}
			catch(SQLException ex)					//Si une erreur a la base de donnée se produit	
			{	JOptionPane.showMessageDialog(null, ex,	 
					"Erreur de connexion avec la base de donnée", JOptionPane.ERROR_MESSAGE);}
			}
		
	}

}

