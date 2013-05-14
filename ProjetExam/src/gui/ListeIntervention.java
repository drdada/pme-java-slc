package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dal.*;
import main.*;

/**
 * @author Matteo D'Addamio & Arnaud Booms
 * Henallux 2012-2013 2TIA
 */

public class ListeIntervention extends JPanel{

	private JLabel titre;
	private JButton retour;
	private String requete;
	private Container cont;
	
	public ListeIntervention(Container cont){
		this.cont = cont;
		this.setLayout(new BorderLayout()); //On d�fini le layout (borderlayout)
		
		titre = new JLabel("Listes des interventions"); //On affiche le titre
		this.add(titre,BorderLayout.NORTH); //On ajoute le titre au dessus (borderlayout)
		
		requete = "SELECT * FROM Intervention"; //On �crit la requete SQL

		try{
            MyTableModel table = AccessBDGen.creerTableModel(Projet.getConnexion(), requete); //on envoie la requete 
            JTable tableR = new JTable(table); //On cr�e le tableau
            JScrollPane scrollTable = new JScrollPane(tableR); //On met le tableau dans un jscrollpane
        
            this.add(scrollTable,BorderLayout.CENTER); //on ajoute le scrollpane au centre
		}
		catch(SQLException er){
			er.printStackTrace(); //On affiche l'erreur eventuelle a la console
		}
		
		
		MyListener myListener = new MyListener(); //On cr�e l'objet listener
		retour = new JButton("Retour"); //On cr�e le bouton
		retour.addActionListener(myListener); //ON lie le bouton et le listener
		this.add(retour,BorderLayout.SOUTH); //On ajoute le bonton en bas
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(retour)){
				Accueil acc = new Accueil();
				cont.removeAll();
				cont.add(acc);
				cont.repaint();
				cont.validate();
			}
		}
	}
		
}
