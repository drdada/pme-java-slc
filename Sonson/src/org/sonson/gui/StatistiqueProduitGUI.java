package org.sonson.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatistiqueProduitGUI extends JPanel{

	private JTextField nbServiceP, nbProduitP, nbServiceV, nbProduitV;
	private JLabel textServiceP, textProduitP, textServiceV, textProduitV;
	
	public void StatistiqueProduitGUI(){
		this.setLayout(new GridLayout(2,4,5,5));
		
		textServiceP = new JLabel("Nombre de services propos�s: ");
		textProduitP = new JLabel("Nombre de produits propos�s: ");
		textProduitV = new JLabel("Nombre de produits vendus: ");
		textServiceV = new JLabel("Nombre de services venuds: ");
		
		this.add(nbProduitP);
		this.add(nbServiceP);
		this.add(nbProduitV);
		this.add(nbServiceV);
		
	}
}
