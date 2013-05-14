package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Projet;

/**
 * @author Matteo D'Addamio & Arnaud Booms
 * Henallux 2012-2013 2TIA
 */

public class Accueil extends JPanel{
	private JLabel texte;
	private static JLabel etat;
	public Accueil(){
		this.setLayout(new GridLayout(2,1));
		texte = new JLabel("<html><body><center><h1>Projet Java</h1><h2>Suivi de maintenance du matériel Informatique (Série 13)</h2><p>Voici le résultat de notre dur labeur</p></center></body></html>");
		etat = new JLabel();
		try {
			// si l'objet connexion est vide OU qu'il est fermé
			if(Projet.getConnexion() == null || Projet.getConnexion().isClosed()){
				etat.setText("Non connecté"); //On affiche le message qui indique un etat non connecté
				etat.setForeground(Color.red);
			}// sinon
			else{
				etat.setText("Connecté"); //On affiche le message qui indique un etat connecté
				etat.setForeground(Color.green);
			}
		} catch (SQLException e1) {
			e1.printStackTrace(); //On affiche le message d'erreur dans la console
		}
		
		this.add(texte); //ajoute le jlabel dans le panel
		this.add(etat); // on ajoute le jlabel
		etat.setHorizontalAlignment(SwingConstants.CENTER); //On centre le texte
		texte.setHorizontalAlignment(SwingConstants.CENTER);


	}
	public static void modifierEtat(int i){ //Méthode appellée par Connexion qui change directement le message quand on est sur la page d'accueil
		if (i==1){ // 1= Connecté
			etat.setForeground(Color.GREEN);
			etat.setText("Connecté");
		}
		else{
			etat.setForeground(Color.RED);
			etat.setText("Non connecté");
		}
	}
}
