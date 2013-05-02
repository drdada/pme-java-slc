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

	public Connexion(FenetreConnexion fenCon){
		
		this.fenCon = fenCon; //On récupere le JFRAME parent
		this.setLayout(new GridLayout(4,1)); //On défini le grid layout

		
//		connexionLabel = new JLabel("<html><body><br>Veuillez rentrer les informations de connexion de la BDD</body></html>");
		address = new JLabel("Nom de la base de données : ");
		url = new JTextField("ProjetExam");
		user = new JLabel("Utilisateur : ");
		login = new JTextField("Administrateur");
		mdp = new JLabel("Mot de passe : ");
		pass = new JPasswordField();
		ok = new JButton("OK");
		annuler = new JButton("Annuler");
		
		address.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne
		user.setHorizontalAlignment(SwingConstants.RIGHT);
		mdp.setHorizontalAlignment(SwingConstants.RIGHT);
				
		EnvoiListener envoilist = new EnvoiListener(); //On crée le listener
		ok.addActionListener(envoilist); //On lie le listener au bouton
		annuler.addActionListener(envoilist); // ici aussi
		
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
			if (e.getSource().equals(annuler)){ //Si on appuie sur annuler
				fenCon.dispose(); //Il ferme le popup (jframe)
			}
			if (e.getSource().equals(ok)){ //Si on appuie sur OK
				String urll = url.getText();
				String logins = login.getText(); //Lit le contenu du champ login et le met dans la variable login
				String pw = new String (pass.getPassword()); //Lit (et transforme ) le mot de passe
				try{
					connexionDB = AccessBDGen.connecter(urll, logins, pw); //On essaye de se conencter
					JOptionPane.showMessageDialog(null, 
							"Connexion établie", "Connexion DB", JOptionPane.INFORMATION_MESSAGE); // On affiche le message de bonne connexion
					main.Projet.setConnexion(connexionDB); //On envoi l'objet connexion a l'objet Projet pour s'en reservir plus tard
					fenCon.dispose(); //On ferme la fenetre
					Accueil.modifierEtat(1); //On modifie le texte "Non connecté" à " Connecté" dans l'acceuil
				}
				catch(SQLException ex)					//Si une erreur a la base de donnée se produit	
				{	JOptionPane.showMessageDialog(null, ex,	 
						"Erreur de connexion avec la base de donnée", JOptionPane.ERROR_MESSAGE);} // On affiche une boite d'erreur qui contient l'erreur retournée par le systeme
				}
			}
		
	}

}

