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

public class StatistiquesFinancesGUI extends JPanel{
	
	private JTextField chiffreTotal,chiffreProduit,chiffreService;
	private JLabel textTotal,textProduit,textService;
	private ArrayList<Produit> arrayProduit;
	private ArrayList<Service> arrayService;
	private ArrayList<Achat> arrayAchat;
	private double sumP,sumS,sumT;
	
	public StatistiquesFinancesGUI(){

		this.setLayout(new GridLayout(3,1,8,8));
		textTotal = new JLabel("Chiffre d'affaire total (Euro) : ", SwingConstants.RIGHT);
		textProduit = new JLabel("Chiffre d'affaire pour les produits (Euro) : ", SwingConstants.RIGHT);
		textService = new JLabel("Chiffre d'affaire pour les services (Euro) : ", SwingConstants.RIGHT);

		arrayProduit = Sonson.getArrayProduit();
		arrayService = Sonson.getArrayService();
		arrayAchat = Sonson.getArrayAchat();
		calcul();
		sumT=sumP+sumS;
		chiffreProduit = new JTextField(String.valueOf(sumP));
		chiffreTotal = new JTextField(String.valueOf(sumT));
		chiffreService = new JTextField(String.valueOf(sumS));
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
		 sumP=0;
		 sumS=0;
		 for(Achat a : arrayAchat){ //On parcourt tout les achats
			 if(a.getIdProduit()!=0){
				 //c'est un produit
				 for(Produit p : arrayProduit){ //On retrouve l'id correspondant
					 if(p.getId()==a.getIdProduit()){
						 sumP+=p.getPrix();
					 }
				 }
			 }
			 else{
				 //c'est un service
				 for(Service s : arrayService){
					 if(s.getId()==a.getIdService()){
						 sumS+=s.getPrix();
					 }
				 }
			 }
		 }

	}

}
