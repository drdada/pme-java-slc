package gui;


import java.awt.Container;
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
import javax.swing.SwingConstants;

import dal.AccessBDGen;

public class Connexion extends JPanel {
private JLabel connexionLabel,user,mdp,address;
private JTextField login,url;
private JPasswordField pass;
private JButton ok,annuler;	
private Connection connexionDB ; 
private FenetreConnexion fenCon;
private Container cont;

	public Connexion(FenetreConnexion fenCon){
		
		this.fenCon = fenCon;
		//TODO redimentionner le panel
		this.setLayout(new GridLayout(4,1));
		cont = Fenetre.getCont();

		
//		connexionLabel = new JLabel("<html><body><br>Veuillez rentrer les informations de connexion de la BDD</body></html>");
		address = new JLabel("Nom de la base de données : ");
		url = new JTextField("URL");
		user = new JLabel("Utilisateur : ");
		login = new JTextField("Administrateur");
		mdp = new JLabel("Mot de passe : ");
		pass = new JPasswordField();
		ok = new JButton("OK");
		annuler = new JButton("Annuler");
		
		address.setHorizontalAlignment(SwingConstants.RIGHT);
		user.setHorizontalAlignment(SwingConstants.RIGHT);
		mdp.setHorizontalAlignment(SwingConstants.RIGHT);
				
		EnvoiListener envoilist = new EnvoiListener();
		ok.addActionListener(envoilist);
		annuler.addActionListener(envoilist);
		
//		this.add(connexionLabel);
		this.add(address);
		this.add(url);
		this.add(user);
		this.add(login);
		this.add(mdp);
		this.add(pass);
		this.add(ok);
		this.add(annuler);
	}
	
	private class EnvoiListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if (e.getSource().equals(annuler)){
				fenCon.dispose();
			}
			if (e.getSource().equals(ok)){
				String urll = url.getText();
				String logins = login.getText(); //Lit le contenu du champ login et le met dans la variable login
				String pw = new String (pass.getPassword()); //Lit (et transforme ) le mot de passe
				try{
					connexionDB = AccessBDGen.connecter(urll, logins, pw);
					JOptionPane.showMessageDialog(null, 
							"Connexion établie", "Connexion DB", JOptionPane.INFORMATION_MESSAGE); // On affiche le message de bonne connexion
					main.Projet.setConnexion(connexionDB);
					fenCon.dispose();
					cont.repaint();
					cont.validate();
				}
				catch(SQLException ex)					//Si une erreur a la base de donnée se produit	
				{	JOptionPane.showMessageDialog(null, ex,	 
						"Erreur de connexion avec la base de donnée", JOptionPane.ERROR_MESSAGE);} // On affiche une boite d'erreur qui contient l'erreur retournée par le systeme
				}
			}
		
	}

}

