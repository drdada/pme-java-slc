package org.sonson.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Produit;
import org.sonson.model.Service;


public class StatistiqueProduitGUI extends JPanel{

	private JTextField nbServiceP, nbProduitP, nbServiceV, nbProduitV;
	private JLabel textServiceP, textProduitP, textServiceV, textProduitV;
	private ArrayList<Produit> arrayProduit;
	private ArrayList<Service> arrayService;
	
	public StatistiqueProduitGUI() {
		//TODO Mise en forme
		this.setLayout(new GridLayout(8,3,8,8));
		
		arrayProduit = new ArrayList<Produit>(Sonson.getArrayProduit());
		arrayService = new ArrayList<Service>(Sonson.getArrayService());
		
		
		textServiceP = new JLabel("Nombre de services proposés: ");
		textProduitP = new JLabel("Nombre de produits proposés: ");
		textProduitV = new JLabel("Nombre de produits vendus: ");
		textServiceV = new JLabel("Nombre de services venuds: ");
		
		nbServiceP = new JTextField(3);
		nbServiceP.setText(String.valueOf(arrayService.size()));
		nbServiceP.setEditable(false);
		nbProduitP = new JTextField(3);
		nbProduitP.setText(String.valueOf(arrayProduit.size()));
		nbProduitP.setEditable(false);
		nbProduitV = new JTextField(3);
		nbProduitV.setEditable(false);
		nbServiceV = new JTextField(3);
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
