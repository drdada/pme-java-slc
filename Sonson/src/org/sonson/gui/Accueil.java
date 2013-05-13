package org.sonson.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import org.sonson.main.Sonson;

public class Accueil extends JFrame {
	
	private Sonson sonson;
	private Container cont;
	private JPanel pan1;
	private JLabel wlcm;
	private JMenuBar barre;
	private JMenu menuFichier, menuClient,menuInventaire,menuStats, menuAide;
	private JMenuItem bAide, bQuitter, bRechercheClient, bAjoutclient, bAjout, bStatFinancier, bStatClient, bStatServ, bCredit, bListInv;
	
	public Accueil(Sonson ss){
		this.sonson = ss;
		//***
		//Fenetre
		this.setTitle("Projet PME - Matteo D. et Arnaud B.");
		// TODO Revoir les dimentions ?
		setBounds(50,50, 1000, 800);
		this.setMinimumSize(new Dimension(1000, 800));
		
		QuitListnerX quitx = new QuitListnerX();
		this.addWindowListener(quitx);
		
		wlcm = new JLabel("<html><body><center><h1>Projet Y</h1><h2>Explication ici</h2><p>Coucou</p></center></body></html>");
		wlcm.setHorizontalAlignment(SwingConstants.CENTER);
		wlcm.setVerticalAlignment(SwingConstants.CENTER);
		
		BaListener baListener = new BaListener(sonson);
		
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
		menuAide = new JMenu("?");
		
		//Boutons dans le menu fichiers
		bQuitter = new JMenuItem("Quitter");
		bQuitter.addActionListener(baListener);
		bQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK));
		menuFichier.add(bQuitter);
		
		//Boutons dans le menu Client
		bRechercheClient = new JMenuItem("Recherche d'un client");
		bRechercheClient.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
		bRechercheClient.addActionListener(baListener);
		bAjoutclient = new JMenuItem("Ajouter un client");
		bAjoutclient.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		bAjoutclient.addActionListener(baListener);
		menuClient.add(bRechercheClient);
		menuClient.add(bAjoutclient);
		
		//Boutons dans le menu Inventaire
		bAjout = new JMenuItem("Ajouter un Produit/Service");
		bAjout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,InputEvent.CTRL_MASK));
		bAjout.addActionListener(baListener);
		bListInv = new JMenuItem("Modifier un Produit/Service");
		bListInv.addActionListener(baListener);
		menuInventaire.add(bAjout);
		menuInventaire.add(bListInv);
		
		//Boutons dans le menu Stat
		bStatClient = new JMenuItem("Statistiques des clients");
		bStatClient.addActionListener(baListener);
		
		bStatFinancier = new JMenuItem("Statistiques financieres");
		bStatFinancier.addActionListener(baListener);
		
		bStatServ = new JMenuItem("Statistiques services et produits");
		bStatServ.addActionListener(baListener);
		
		menuStats.add(bStatServ);
		menuStats.add(bStatFinancier);
		menuStats.add(bStatClient);
		
		
		//Boutons dans le menu aide
		bAide = new JMenuItem("Aide");
		bAide.addActionListener(baListener);
		bAide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		bCredit = new JMenuItem("Crédits");
		bCredit.addActionListener(baListener);
		menuAide.add(bAide);
		menuAide.add(bCredit);
		
	
		
		barre.add(menuFichier);
		barre.add(menuClient);
		barre.add(menuInventaire);
		barre.add(menuStats);
		barre.add(menuAide);

		
		pan1 = new JPanel();
		//Selection du layout
		pan1.setLayout(new FlowLayout());
		pan1.setMinimumSize(new Dimension(1000, 800));
		pan1.setPreferredSize(new Dimension(1000, 800));
		pan1.setBackground(Color.red);
		
		
		this.setJMenuBar(barre);
		//Ajout
		pan1.add(wlcm);
		
		
		cont = getContentPane();
		cont.setSize(1000, 800);
		cont.setMinimumSize(new Dimension(1000, 800));
		cont.setPreferredSize(new Dimension(1000, 800));
		cont.setBackground(Color.green);
		cont.setLayout(new FlowLayout());
		cont.add(pan1);
		setVisible(true);
	}
	
	private class QuitListnerX extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.out.println("EXIT");
			System.exit(0);
			}
	}
	
	private class BaListener implements ActionListener{
		Sonson ss;
		
		public BaListener(Sonson ss) {
			this.ss = ss;
		}
		public void actionPerformed(ActionEvent e){
				if (e.getSource().equals(bQuitter)){ //Si on appuie sur le bouton quitter
					System.out.println("EXIT");
					System.exit(0);
				}
				if(e.getSource().equals(bAjoutclient)){
					pan1.removeAll();
					cont.repaint();
					AjoutClientGUI aj = new AjoutClientGUI(ss);
					pan1.add(aj);
					Accueil.this.setVisible(true);
				}
				if(e.getSource().equals(bRechercheClient)){
					pan1.removeAll();
					cont.repaint();
					RechercheClient rcl =  new RechercheClient(sonson,pan1);
					pan1.add(rcl);
					Accueil.this.setVisible(true);
				}
				if(e.getSource().equals(bListInv)){
					pan1.removeAll();
					cont.repaint();
					ListInventaireGUI lv = new ListInventaireGUI();
					pan1.add(lv);
					Accueil.this.setVisible(true);
				}
				if(e.getSource().equals(bAjout)){
					pan1.removeAll();
					cont.repaint();
					Inventaire inv = new Inventaire(ss);
					pan1.add(inv);
					Accueil.this.setVisible(true);
				}
				if(e.getSource().equals(bStatClient)){
					pan1.removeAll();
					cont.repaint();
					StatistiqueClientGUI sc = new StatistiqueClientGUI(ss);
					pan1.add(sc);
					
					Accueil.this.setVisible(true);
				}
				if(e.getSource().equals(bStatFinancier)){
					pan1.removeAll();
					cont.repaint();
					StatistiquesFinancesGUI sf= new StatistiquesFinancesGUI();
					pan1.add(sf);
					Accueil.this.setVisible(true);
				}
				if(e.getSource().equals(bStatServ)){
					pan1.removeAll();
					cont.repaint();
					StatistiqueProduitGUI sp = new StatistiqueProduitGUI();
					pan1.add(sp);
					Accueil.this.setVisible(true);
				}
				if(e.getSource().equals(bAide)){
					pan1.removeAll();
					cont.repaint();
					Aide aide = new Aide();
					//pan1.add(aide);
					//Accueil.this.setVisible(true);
				}
				if(e.getSource().equals(bCredit)){
					pan1.removeAll();
					cont.repaint();
					CreditGUI cgui = new CreditGUI();
					pan1.add(cgui);
					Accueil.this.setVisible(true);
				}
			}
	}	
}
