package org.sonson.gui;

import javax.swing.*;

public class StatistiquesFinancesGUI extends JPanel{
	
	private JTextField chiffreTotal,chiffreProduit,chiffreService;
	private JLabel textTotal,textProduit,textService;
	
	public void StatistiquesFinancesGUI(){
		this.setLayout(null);
		
		textTotal = new JLabel("Chiffre d'affaire total : ");
		textProduit = new JLabel("Chiffre d'affaire pour les produits : ");
		textService = new JLabel("Chiffre d'affaire pour les services : ");
		
		this.add(textProduit);
		this.add(chiffreProduit);
		this.add(textService);
		this.add(chiffreService);
		this.add(textTotal);
		this.add(chiffreTotal);
	}

}
