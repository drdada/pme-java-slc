package org.sonson.gui;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Inventaire extends JPanel{

	private ButtonGroup choixProduit;
	private JRadioButton service, produit;
	private JLabel texte;
	private JTextField nom, description, prix;
	
	public Inventaire(){
		this.setLayout(new GridLayout(0,2));
		
		texte = new JLabel("Type :");
		choixProduit = new ButtonGroup();
		service = new JRadioButton("Service");
		produit = new JRadioButton("Produit");
		nom = new JTextField("Nom du produit");
		
		choixProduit.add(produit);
		choixProduit.add(service);
		
		this.add(texte);
		this.add(produit);
		this.add(service);
		this.add(nom);
		
	}
	
}
