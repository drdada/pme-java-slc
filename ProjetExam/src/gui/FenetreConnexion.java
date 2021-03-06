package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
 * @author Matteo D'Addamio & Arnaud Booms
 * Henallux 2012-2013 2TIA
 */

public class FenetreConnexion extends JFrame{
	
	private Container contDB;
	public FenetreConnexion(){
		super("Connexion � la BDD"); // marque dans la barre des taches
		
		contDB = this.getContentPane(); // initialise le container de la fenetre DB
		
		this.parametres(); //apelle la fonct ion parametres qui regle les parametres de la fenetre
		
		Connexion fenConnexion = new Connexion(this); // On cr�e un objet Jpanel de la classe Connexion
		contDB.add(fenConnexion); // On ajoute ce jpanel dans le conteneur
		this.setVisible(true); // rendre fenetre visible
	}
	
	private void parametres(){
		this.setSize(400, 200); // donne la taille � la fenetre DB
		this.setLocationRelativeTo(null); // place la fenetre DB au centre de l'�cran
		this.setResizable(false); // emp�che redimensionnement de la fenetre DB
		contDB.setLayout(new BorderLayout()); // outil mise en page de la fenetre DB 
	}
}
