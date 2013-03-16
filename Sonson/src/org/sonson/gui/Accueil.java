package org.sonson.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import org.sonson.main.Sonson;

public class Accueil extends JFrame {
	
	private Sonson sonson;
	private Container cont;
	private JButton credit;
	private JPanel pan1;
	private JLabel wlcm;
	private JMenuBar barre;
	private JMenu menuFichier, menuClient,menuInventaire,menuStats;
	private JMenuItem bAide, bQuitter, bRechercheClient, bAjoutclient, bAjout, bStatFinancier, bStatClient, bStatServ;
	
	public Accueil(Sonson ss){
		this.sonson = ss;
		//***
		//Fenetre
		this.setTitle("Projet PME - Matteo D. et Arnaud B.");
		// TODO Revoir les dimentions ?
		setBounds(50,50, 1000, 800);
		QuitListnerX quitx = new QuitListnerX();
		this.addWindowListener(quitx);
		
		wlcm = new JLabel("Bienvenue");
		
		credit = new JButton("Crédits");
		CreditsListener creditlist = new CreditsListener();
		credit.addActionListener(creditlist);
		
		//***
		//Menu
		barre = new JMenuBar();
		menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic('F');
		menuClient = new JMenu("Clients");
		menuClient.setMnemonic('C');
		menuInventaire =  new JMenu("Inventaire");
		menuInventaire.setMnemonic('I');
		menuStats = new JMenu("Statistiques");
		menuStats.setMnemonic('S');
		
		//Boutons dans le menu fichiers
		AideListner aideL = new AideListner();
		bAide = new JMenuItem("Aide");
		bAide.addActionListener(aideL);
		bQuitter = new JMenuItem("Quitter");
		QuitListner quit = new QuitListner();
		bQuitter.addActionListener(quit);
		bQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK));
		menuFichier.add(bAide);
		menuFichier.add(bQuitter);
		
		//Boutons dans le menu Client
		bRechercheClient = new JMenuItem("Recherche d'un client");
		bRechercheClient.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
		RechercheClientListener rClientListener = new RechercheClientListener();
		bRechercheClient.addActionListener(rClientListener);
		bAjoutclient = new JMenuItem("Ajouter un client");
		bAjoutclient.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		AjoutClientListener aClientListener = new AjoutClientListener();
		bAjoutclient.addActionListener(aClientListener);
		menuClient.add(bRechercheClient);
		menuClient.add(bAjoutclient);
		
		//Boutons dans le menu Inventaire
		bAjout = new JMenuItem("Ajouter un Produit/Service");
		bAjout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,InputEvent.CTRL_MASK));
		InventaireListener invl = new InventaireListener();
		bAjout.addActionListener(invl);
		menuInventaire.add(bAjout);
		
		//Boutons dans le menu Stat
		StatCListner statClistener = new StatCListner(ss);
		bStatClient = new JMenuItem("Statistiques des clients");
		bStatClient.addActionListener(statClistener);
		bStatFinancier = new JMenuItem("Statistiques financieres");
		bStatServ = new JMenuItem("Statistiques services et produits");
		menuStats.add(bStatServ);
		menuStats.add(bStatFinancier);
		menuStats.add(bStatClient);
		
		
		barre.add(menuFichier);
		barre.add(menuClient);
		barre.add(menuInventaire);
		barre.add(menuStats);
		
		
		pan1 = new JPanel();
		//Selection du layout
		pan1.setLayout(new FlowLayout());
		
		this.setJMenuBar(barre);
		//Ajout
		pan1.add(wlcm);
		pan1.add(credit);
		
		
		cont = getContentPane();
		cont.setLayout(new FlowLayout());
		cont.add(pan1);
		setVisible(true);
	}
	private class CreditsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null,"Projet \"Gestion simplifiée de PME\" écrit en Java\nPar Matteo D'Addamio et Arnaud Booms\nPour le cour de conduite de projet (Mr Renson)\nHenallux 2012-2013","Crédits", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private class QuitListnerX extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.out.println("EXIT");
			System.exit(0);
			}
	}
	private class QuitListner implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("EXIT");
			System.exit(0);
		}
	}
	private class RechercheClientListener implements ActionListener {
		public void actionPerformed (ActionEvent e){
			//Ecouteur de Recherche client
			pan1.removeAll();
			cont.repaint();
			RechercheClient rcl =  new RechercheClient(sonson);
			pan1.add(rcl);
			Accueil.this.setVisible(true);
		}
	}
	private class AjoutClientListener implements ActionListener {
		public void actionPerformed (ActionEvent e){
			//Ecouteur de l'ajout client
			pan1.removeAll();
			cont.repaint();
			AjoutClientGUI aj = new AjoutClientGUI();
			pan1.add(aj);
			Accueil.this.setVisible(true);
		}
	}
	
	private class AideListner implements ActionListener {
		public void actionPerformed (ActionEvent e){
			//Ecouteur de l'aide
			pan1.removeAll();
			cont.repaint();
			Aide aide = new Aide();
			pan1.add(aide);
			Accueil.this.setVisible(true);
		}
	}
	private class InventaireListener implements ActionListener {
		public void actionPerformed (ActionEvent e){
			//Ecouteur de l'aide
			pan1.removeAll();
			cont.repaint();
			Inventaire inv = new Inventaire();
			pan1.add(inv);
			Accueil.this.setVisible(true);
		}
	}
	
	/**
	 * WTF de mettre 50 classes dans une autre classe ^^ Non mais allo quoi ?
	 * Allo ? Tu me reçois ? Non mais allo.
	 * C'est comme enfilé un chat sans verrouillé ces pattes ! Non mais allo.
	 * @author 
	 *
	 */
	private class StatCListner implements ActionListener {
		Sonson ss;
		
		public StatCListner(Sonson ss) {
			this.ss = ss;
		}
		
		public void actionPerformed (ActionEvent e){
			//Ecouteur du boutons statistiques des CLIENTS
			pan1.removeAll();
			cont.repaint();
			StatistiqueClientGUI sc = new StatistiqueClientGUI(ss);
			pan1.add(sc);
			
			Accueil.this.setVisible(true);
		}
	}
}
