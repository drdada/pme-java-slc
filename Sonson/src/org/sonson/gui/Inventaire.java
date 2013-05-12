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
	private JLabel texte,empty;
	private JTextField nom, description, prix;
	private JButton envoi;
	private Sonson ss;
	
	public Inventaire(Sonson ss){
		this.ss = ss;
		this.setLayout(new GridLayout(3,3));
		
		texte = new JLabel("Type :");
		choixProduit = new ButtonGroup();
		service = new JRadioButton("Service");
		produit = new JRadioButton("Produit");
		nom = new JTextField("Nom du produit");
		description = new JTextField("Description du produit");
		prix = new JTextField("Prix");
		envoi = new JButton("Enregistrer");
		empty= new JLabel("");
		
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
		this.add(empty);
		this.add(prix);
		this.add(envoi);
		
	}
	private class EnregListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO Verification des champs
			int flag=0;
			String erreur="";
			String nomb = nom.getText();
			String desc = description.getText();
			double prixb1 = 0;
			try{
				prixb1 = Double.parseDouble(prix.getText());
			}
			catch(NumberFormatException e1){
				flag=1;
				erreur+="prix, ";
			}
			if (nomb.length()==0){
				flag=1;
				erreur+="nom, ";
			}
			if (desc.length()==0){
				flag=1;
				erreur+="description, ";
			}
			if(flag==0){
				if (produit.isSelected())
				{
					//Si c'est un produit
					Object[] options = {"Oui","Non"};
					int n= JOptionPane.showOptionDialog(null,"Voulez-vous vraiment ajouter ce produit ?", "Vérification", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if(n==0){
						ss.addProduitBdd(nomb, desc, prixb1); //On insere dans la bdd
						ss.updateProduit(); //On recalcule l'arraylist
						JOptionPane.showMessageDialog(null, "Produit bien ajouté","Bravo!", JOptionPane.INFORMATION_MESSAGE);
						nom.setText("");
						description.setText("");
						prix.setText("");
					}
				}
				else
				{
					//Si c'est un service
					Object[] options = {"Oui","Non"};
					int n= JOptionPane.showOptionDialog(null,"Voulez-vous vraiment ajouter ce service ?", "Vérification", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if(n==0){
						ss.addServiceBdd(nomb, desc, prixb1); //On insere dans la bdd
						ss.updateService(); //On recalcule l'arraylist
						JOptionPane.showMessageDialog(null, "Service bien ajouté","Bravo!", JOptionPane.INFORMATION_MESSAGE);
						nom.setText("");
						description.setText("");
						prix.setText("");
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Oups, le/les champs "+erreur+"a/ont un soucis, veuillez vérifier!","Erreur", JOptionPane.ERROR_MESSAGE);
				erreur="";
				nom.setText("");
				description.setText("");
				prix.setText("");
			}
		}
	}
}
