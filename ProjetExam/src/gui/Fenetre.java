package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Fenetre extends JFrame{

	private Container cont;
	private JMenuBar barre;
	private JMenu fichier,intervention,liste,bdd,aide;
	private JMenuItem quitter,ajout,suppression,listel,connexion,deconnexion,aidea;

	public Fenetre(){
		this.parametres(); // Parametres de la fenetres

		QuitListnerX quitx = new QuitListnerX();
		this.addWindowListener(quitx);
		
		this.barre();
	

		Accueil accueil = new Accueil();
		this.add(accueil, BorderLayout.CENTER);
		
		cont = getContentPane();
		setVisible(true);
	}
	
	private void parametres(){
		this.setTitle("Projet Java 2013 - D'Addamio M. Booms A. - Henallux"); //Met le titre de la fenetre
		this.setSize(800, 600); // donne une taille à la fenetre en x et y
		this.setLocationRelativeTo(null); // place la fenetre au centre de l'écran
	}
	
	private void barre(){
		
		barre = new JMenuBar();
		BarreListener barreListener = new BarreListener(); //On crée l'objet BarreListener qui va ecouter les boutons de la barre
		
		
		//Jmenu Fichier
		fichier = new JMenu("Fichier"); //On crée le jmenu fichier
		quitter = new JMenuItem("Quitter"); //On crée le jmenuitem Quitter
		fichier.add(quitter); //On insere le bouton quitter dans le menu fichier
		quitter.addActionListener(barreListener); //On ajoute l'action au bouton
		
		//Jmenu Intervention
		intervention = new JMenu("Intervention");
		ajout = new JMenuItem("Ajouter une intervention");
		suppression= new JMenuItem("Supprimer une intervention");
		intervention.add(ajout);
		intervention.add(suppression);
		
		//Jmenu Liste
		liste = new JMenu("Recherche");
		listel = new JMenuItem("Liste des interventions");
		liste.add(listel);
		
		//Jmenu BDD
		bdd = new JMenu("Base de données");
		connexion = new JMenuItem("Connexion");
		deconnexion = new JMenuItem("Deconnexion");
		bdd.add(connexion);
		bdd.add(deconnexion);
		connexion.addActionListener(barreListener);
		
		//Jmenu aide
		aide = new JMenu("Aide");
		aidea = new JMenuItem("Credits");
		aide.add(aidea);
		aidea.addActionListener(barreListener);

		//JMENU
		barre.add(fichier); //On ajoute le menu fichier dans la barre
		barre.add(intervention);
		barre.add(liste);
		barre.add(bdd);
		barre.add(aide);
		this.setJMenuBar(barre);
	}
	
	private class QuitListnerX extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			//TODO Deconnexion
			System.exit(0);
			}
	}
	private class BarreListener implements ActionListener {
		public void actionPerformed (ActionEvent e){
			if (e.getSource().equals(quitter)){ //Si on appuie sur le bouton quitter
				//TODO Deconnexion
				System.exit(0); //On ferme le programme
			}
			if (e.getSource().equals(aidea)){
				Aide aide = new Aide();
				cont.removeAll();
				cont.repaint();
				cont.add(aide);
			}
		}
	}
}
