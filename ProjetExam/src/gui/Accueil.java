package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Projet;

public class Accueil extends JPanel{
	private JLabel texte,connecter,deconnecter;
	public Accueil(){
		this.setLayout(new GridLayout(2,1));
		texte = new JLabel("<html><body><center><h1>Projet Java</h1><h2>Suivi de maintenance du matériel Informatique (Série 13)</h2><p>Voici le résultat de notre dur labeur</p></center></body></html>");
		connecter = new JLabel("Vous etes connecter à la DB.");
		deconnecter = new JLabel("Vous n'etes pas connecter à la DB !!!");
		this.add(texte); //ajoute le jlabel dans le panel
		texte.setHorizontalAlignment(SwingConstants.CENTER);

		try {
			// si l'objet connexion est vide OU qu'il est fermé
			if(Projet.getConnexion() == null || Projet.getConnexion().isClosed()){
				deconnecter.setHorizontalAlignment(SwingConstants.CENTER);
				this.add(deconnecter);
			}// sinon
			else{
				connecter.setHorizontalAlignment(SwingConstants.CENTER);
				this.add(connecter);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
