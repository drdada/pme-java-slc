package org.sonson.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Achat;
import org.sonson.model.Produit;
import org.sonson.model.Service;


public class StatistiqueProduitGUI extends JPanel{

	private JTextField nbServiceP, nbProduitP, nbServiceV, nbProduitV;
	private JLabel textServiceP, textProduitP, textServiceV, textProduitV;
	private ArrayList<Produit> arrayProduit;
	private ArrayList<Service> arrayService;
	private ArrayList<Achat> arrayAchat;
	private int cptP,cptS;
	
	public StatistiqueProduitGUI() {
		//TODO Mise en forme
		this.setLayout(new GridLayout(8,3,8,8));
		
		arrayProduit = Sonson.getArrayProduit();
		arrayService = Sonson.getArrayService();
		arrayAchat = Sonson.getArrayAchat();
		
		textServiceP = new JLabel("Nombre de services proposés: ");
		textProduitP = new JLabel("Nombre de produits proposés: ");
		textProduitV = new JLabel("Nombre de produits vendus: ");
		textServiceV = new JLabel("Nombre de services vendus: ");
		
		calculProduit();
		
		nbServiceP = new JTextField(3);
		nbServiceP.setText(String.valueOf(arrayService.size()));
		nbServiceP.setEditable(false);
		nbProduitP = new JTextField(3);
		nbProduitP.setText(String.valueOf(arrayProduit.size()));
		nbProduitP.setEditable(false);
		nbProduitV = new JTextField(String.valueOf(cptP),3);
		nbProduitV.setEditable(false);
		nbServiceV = new JTextField(String.valueOf(cptS),3);
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

	private void calculProduit() {
		cptP=0;
		for (Achat a : arrayAchat) { // recherche de l'id du
			// produit selectionné
			if(a.getIdProduit()!=0){
				cptP++;
			}else{
				cptS++;
			}
			
		}
	}
}
