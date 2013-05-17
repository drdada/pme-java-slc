package org.sonson.gui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Achat;
import org.sonson.model.Produit;
import org.sonson.model.Service;

public class StatistiquesFinancesGUI extends JPanel{
	
	private JTextField chiffreTotal,chiffreProduit,chiffreService;
	private JLabel textTotal,textProduit,textService;
	private ArrayList<Produit> arrayProduit;
	private ArrayList<Service> arrayService;
	private double sumP,sumS;
	
	public StatistiquesFinancesGUI(){
		
		textTotal = new JLabel("Chiffre d'affaire total : ");
		textProduit = new JLabel("Chiffre d'affaire pour les produits : ");
		textService = new JLabel("Chiffre d'affaire pour les services : ");
		arrayProduit = Sonson.getArrayProduit();
		arrayService = Sonson.getArrayService();
		calcul();
		chiffreProduit = new JTextField();
		chiffreTotal = new JTextField();
		chiffreService = new JTextField();
		chiffreProduit.setEditable(false);
		chiffreTotal.setEditable(false);
		chiffreService.setEditable(false);
		
		this.add(textProduit);
		this.add(chiffreProduit);
		this.add(textService);
		this.add(chiffreService);
		this.add(textTotal);
		this.add(chiffreTotal);
	}
	
	private void calcul(){
//		sumP=0;
//		sumS=0;
//		for (Produit p : arrayProduit) { // recherche de l'id du
//			// produit selectionné
//			sumP+=p.getPrix();
//		}
//		for (Service s : arrayService){
//			sumS+=s.getPrix();
//		}
	}

}
