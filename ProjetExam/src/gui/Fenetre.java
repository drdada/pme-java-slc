package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


import main.Projet;


public class Fenetre extends JFrame{

	private Container cont;
	private JMenuBar barre;
	private JMenu fichier,intervention,liste,bdd,aide;
	private JMenuItem quitter,ajout,suppression,listel,recherche,connexion,deconnexion,aidea;

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
		ajout.addActionListener(barreListener);
		suppression.addActionListener(barreListener);
		intervention.add(ajout);
		intervention.add(suppression);
		
		//Jmenu Liste
		liste = new JMenu("Recherche");
		listel = new JMenuItem("Liste des interventions");
		listel.addActionListener(barreListener);
		recherche = new JMenuItem("Recherche");
		recherche.addActionListener(barreListener);
		liste.add(listel);
		liste.add(recherche);
		
		//Jmenu BDD
		bdd = new JMenu("Base de données");
		connexion = new JMenuItem("Connexion");
		deconnexion = new JMenuItem("Deconnexion");
		bdd.add(connexion);
		bdd.add(deconnexion);
		connexion.addActionListener(barreListener);
		deconnexion.addActionListener(barreListener);
		
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
	public Container getCont(){
		return cont;
	}
	
	private class QuitListnerX extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			try{ //On déconnecte de la BDD avant de quitter
				if(Projet.getConnexion() != null && Projet.getConnexion().isClosed() == false){
					Projet.getConnexion().close();
				}
			System.exit(0); //On ferme le programme
			}
			catch(SQLException er){
				System.out.println("Erreur de déconnexion");
			}
			}
	}
	private class BarreListener implements ActionListener {
		public void actionPerformed (ActionEvent e){
			if (e.getSource().equals(quitter)){ //Si on appuie sur le bouton quitter
				try{ //On déconnecte de la BDD avant de quitter
					if(Projet.getConnexion() != null && Projet.getConnexion().isClosed() == false){
						Projet.getConnexion().close();
					}
					System.exit(0); //On ferme le programme
				}
				catch(SQLException er){
					System.out.println("Erreur de déconnexion");
				}
			}
			if (e.getSource().equals(ajout)){
				try {
					// si l'objet connexion est vide OU qu'il est fermé
					if(Projet.getConnexion() == null || Projet.getConnexion().isClosed()){
						JOptionPane.showMessageDialog(null, "Vous n'êtes pas connecté à une Base de donnée!\n" +
								"Veuillez-vous connecter.", "Attention", JOptionPane.WARNING_MESSAGE);
						new FenetreConnexion(); // On lance la fenetre de connexion
					}// sinon
					else{
						AjoutGUI ajoutGUI = new AjoutGUI();
						cont.removeAll();
						cont.add(ajoutGUI);
						cont.repaint();
						cont.validate();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (e.getSource().equals(listel)){
				try {
					// si l'objet connexion est vide OU qu'il est fermé
					if(Projet.getConnexion() == null || Projet.getConnexion().isClosed()){
						JOptionPane.showMessageDialog(null, "Vous n'êtes pas connecté à une Base de donnée!\n" +
								"Veuillez-vous connecter.", "Attention", JOptionPane.WARNING_MESSAGE);
						new FenetreConnexion(); // On lance la fenetre de connexion
					}// sinon
					else{
						ListeIntervention lI = new ListeIntervention(cont);
						cont.removeAll();
						cont.add(lI);
						cont.repaint();
						cont.validate();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (e.getSource().equals(aidea)){ 
				Aide aidex = new Aide(cont);
				cont.removeAll();
				cont.add(aidex);
				cont.repaint();
				cont.validate();
			}
			if (e.getSource().equals(connexion)){
				try{
					if (Projet.getConnexion()== null || Projet.getConnexion().isClosed()){ // SI l'objet connexion est vide OU qu'il est fermé (cad pas connecté)
						new FenetreConnexion(); //On lance la fenetre de connexion
						
					}
					else{ // sinon l'objet connexion est ouvert , on ne va pas connecter quelque chose qui est déja connecté...
						JOptionPane.showMessageDialog(null, "Vous êtes déjà connecté !","Attention", JOptionPane.WARNING_MESSAGE); //Message d'erreur
					}
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (e.getSource().equals(deconnexion)){
				try {
					if(Projet.getConnexion() != null && Projet.getConnexion().isClosed() == false){
						Projet.getConnexion().close(); // on ferme la connection à la BDD
						//On redirige la personne vers la page d'accueil

						
						JOptionPane.showMessageDialog(null, "Vous êtes maintenant déconnecté !",
								"Success", JOptionPane.INFORMATION_MESSAGE); // message de déconnexion réussie
						Accueil.modifierEtat(2);
					}
					else JOptionPane.showMessageDialog(null, "Vous n'êtes pas connecté !",
							"Attention", JOptionPane.WARNING_MESSAGE); // Message d'erreur, on n'a pas pu se déconnecter
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
