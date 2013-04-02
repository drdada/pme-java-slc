package org.sonson.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class StatistiqueProduitGUI extends JPanel{

	private JTextField nbServiceP, nbProduitP, nbServiceV, nbProduitV;
	private JLabel textServiceP, textProduitP, textServiceV, textProduitV;
	
	public StatistiqueProduitGUI() {
		//TODO Mise en forme
		this.setLayout(new GridLayout(8,3,8,8));
		
		textServiceP = new JLabel("Nombre de services proposés: ");
		textProduitP = new JLabel("Nombre de produits proposés: ");
		textProduitV = new JLabel("Nombre de produits vendus: ");
		textServiceV = new JLabel("Nombre de services venuds: ");
		
		nbServiceP = new JTextField();
		nbServiceP.setEditable(false);
		nbProduitP = new JTextField();
		nbProduitP.setEditable(false);
		nbProduitV = new JTextField();
		nbProduitV.setEditable(false);
		nbServiceV = new JTextField();
		nbServiceV.setEditable(false);
		
		this.add(textProduitP);
		this.add(nbProduitP);
		this.add(textServiceP);
		this.add(nbServiceP);
		this.add(textProduitV);
		this.add(nbProduitV);
		this.add(textServiceV);
		this.add(nbServiceV);
		
	}
}
