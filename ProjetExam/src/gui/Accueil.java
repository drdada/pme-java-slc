package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Projet;

public class Accueil extends JPanel{
	private JLabel texte;
	private static JLabel etat;
	public Accueil(){
		this.setLayout(new GridLayout(2,1));
		texte = new JLabel("<html><body><center><h1>Projet Java</h1><h2>Suivi de maintenance du mat�riel Informatique (S�rie 13)</h2><p>Voici le r�sultat de notre dur labeur</p></center></body></html>");
		etat = new JLabel();
		try {
			// si l'objet connexion est vide OU qu'il est ferm�
			if(Projet.getConnexion() == null || Projet.getConnexion().isClosed()){
				etat.setText("Non connect�");
				etat.setForeground(Color.red);
			}// sinon
			else{
				etat.setText("Connect�");
				etat.setForeground(Color.green);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		this.add(texte); //ajoute le jlabel dans le panel
		this.add(etat);
		etat.setHorizontalAlignment(SwingConstants.CENTER);
		texte.setHorizontalAlignment(SwingConstants.CENTER);


	}
	public static void modifierEtat(int i){
		if (i==1){
			etat.setForeground(Color.GREEN);
			etat.setText("Connect�");
		}
		else{
			etat.setForeground(Color.RED);
			etat.setText("Non connect�");
		}
	}
}
