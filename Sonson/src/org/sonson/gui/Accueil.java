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

public class Accueil extends JFrame {
	
	private Container cont;
	private JButton credit;
	private JPanel pan1;
	private JLabel wlcm;
	private JMenuBar barre;
	private JMenu menuFichier, menuClient,menuInventaire,menuStats;
	private JMenuItem bAide, bQuitter, bRechercheClient, bAjoutclient, bAjout, bStatFinancier, bStatClient, bStatServ;

	public Accueil(){
		
		//***
		//Fenetre
		super("Projet PME - Matteo D. et Arnaud B.");
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
		bAide = new JMenuItem("Aide");
		bQuitter = new JMenuItem("Quitter");
		QuitListner quit = new QuitListner();
		bQuitter.addActionListener(quit);
		bQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK));
		menuFichier.add(bAide);
		menuFichier.add(bQuitter);
		
		//Boutons dans le menu Client
		bRechercheClient = new JMenuItem("Recherche d'un client");
		bRechercheClient.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
		bAjoutclient = new JMenuItem("Ajouter un client");
		bAjoutclient.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		menuClient.add(bRechercheClient);
		menuClient.add(bAjoutclient);
		
		//Boutons dans le menu Inventaire
		bAjout = new JMenuItem("Ajouter un Produit/Service");
		bAjout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,InputEvent.CTRL_MASK));
		menuInventaire.add(bAjout);
		
		//Boutons dans le menu Stat
		bStatClient = new JMenuItem("Statistiques des clients");
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
		//Ajout
		pan1.add(barre);
		pan1.add(wlcm);
		pan1.add(credit);
		
		
		cont = getContentPane();
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
			//System.out.println("EXIT");
			System.exit(0);
			}
	}
	private class QuitListner implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//System.out.println("EXIT");
			System.exit(0);
		}
	}
}
