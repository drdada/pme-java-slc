package org.sonson.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.sonson.main.Sonson;
import org.sonson.model.Achat;
import org.sonson.model.Produit;
import org.sonson.model.Service;


public class StatistiqueProduitGUI extends JPanel{

	private JTextField nbServiceP, nbProduitP, nbServiceV, nbProduitV,nbTotalP,nbTotalV;
	private JLabel textServiceP, textProduitP, textServiceV, textProduitV,textTotalP,textTotalV;
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
		
		textServiceP = new JLabel("Nombre de services proposés: ", SwingConstants.RIGHT);
		textProduitP = new JLabel("Nombre de produits proposés: ", SwingConstants.RIGHT);
		textProduitV = new JLabel("Nombre de produits vendus: ", SwingConstants.RIGHT);
		textServiceV = new JLabel("Nombre de services vendus: ", SwingConstants.RIGHT);
		textTotalV = new JLabel("Nombre d'achats (Service et Produit) vendus: ", SwingConstants.RIGHT);
		textTotalP = new JLabel("Nombre d'achats (Service et Produits) proposés", SwingConstants.RIGHT);
		
		calculProduit();
		
		nbServiceP = new JTextField(3);
		nbServiceP.setText(String.valueOf(arrayService.size()));
		nbServiceP.setEditable(false);
		nbProduitP = new JTextField(3);
		nbProduitP.setText(String.valueOf(arrayProduit.size()));
		nbProduitP.setEditable(false);
		int totalp = arrayProduit.size()+arrayService.size();
		nbTotalP = new JTextField(String.valueOf(totalp),3);
		nbTotalP.setEditable(false);
		
		nbProduitV = new JTextField(String.valueOf(cptP),3);
		nbProduitV.setEditable(false);
		nbServiceV = new JTextField(String.valueOf(cptS),3);
		nbServiceV.setEditable(false);
		int totalv = cptP+cptS;
		nbTotalV = new JTextField(String.valueOf(totalv),3);
		nbTotalV.setEditable(false);
		
		this.add(textProduitP);
		this.add(nbProduitP);
		this.add(textServiceP);
		this.add(nbServiceP);
		this.add(textTotalP);
		this.add(nbTotalP);
		this.add(textProduitV);
		this.add(nbProduitV);
		this.add(textServiceV);
		this.add(nbServiceV);
		this.add(textTotalV);
		this.add(nbTotalV);
		
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
