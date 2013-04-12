package org.sonson.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.sonson.main.Sonson;

public class Inventaire extends JPanel{

	private ButtonGroup choixProduit;
	private JRadioButton service, produit;
	private JLabel texte;
	private JTextField nom, description, prix;
	private JButton envoi;
	private Sonson ss;
	
	public Inventaire(Sonson ss){
		this.ss = ss;
		this.setLayout(new GridLayout(5,2,5,5));
		
		texte = new JLabel("Type :");
		choixProduit = new ButtonGroup();
		service = new JRadioButton("Service");
		produit = new JRadioButton("Produit");
		nom = new JTextField("Nom du produit");
		description = new JTextField("Description du produit");
		prix = new JTextField("Prix");
		envoi = new JButton("Enregistrer");
		
		produit.setSelected(true); //Selectionne le choix "produit" par défaut
		choixProduit.add(produit);
		choixProduit.add(service);
		
		EnregListener enrl = new EnregListener();
		envoi.addActionListener(enrl);
		
		this.add(texte);
		this.add(produit);
		this.add(service);
		this.add(nom);
		this.add(description);
		this.add(prix);
		this.add(envoi);
		
	}
	private class EnregListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO Verification des champs
			String nomb = nom.getText();
			String desc = description.getText();
			double prixb = Double.parseDouble(prix.getText());
			if (produit.isSelected())
			{
				//Si c'est un produit
				ss.addProduitBdd(nomb, desc, prixb);
			}
			else
			{

			}
		}
	}
}
