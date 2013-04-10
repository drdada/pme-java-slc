package org.sonson.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.dal.UpdateModel;
import org.sonson.main.Sonson;
import org.sonson.model.Client;

public class AjoutClientGUI extends JPanel {
	private Sonson ss;
	private JLabel emptylabel,texte,nomL,prenomL,adresseL,codePostalL,paysL,telFixeL,telPortableL;
	private JTextField nom,prenom,adresse,codePostal,pays,telFixe,telPortable;
	private JButton envoi,reinitialiser;
	
	public AjoutClientGUI(Sonson ss){
		this.ss = ss;
		this.setLayout(new GridLayout(0,2));
		emptylabel = new JLabel(" ");
		texte = new JLabel("Ajout d'un nouveau client, entrez les informations");
		nomL = new JLabel("Nom:");
		nom = new JTextField();
		prenomL = new JLabel("Prénom:");
		prenom = new JTextField();
		adresseL = new JLabel("Adresse:");
		adresse = new JTextField();
		codePostalL = new JLabel("Code Postal:");
		codePostal = new JTextField();
		paysL = new JLabel("Pays:");
		pays = new JTextField();
		telFixeL = new JLabel("Telephone fixe:");
		telFixe = new JTextField();
		telPortableL = new JLabel("Telephone portable:");
		telPortable = new JTextField();
		EnvoiListener envlist = new EnvoiListener();
		envoi = new JButton("Envoi");
		reinitialiser = new JButton("Reset");
		envoi.addActionListener(envlist);
		reinitialiser.addActionListener(envlist);
		
		
		//TODO mettre le titre et arranger les menus
		this.add(texte);
		this.add(emptylabel);
		this.add(nomL);
		this.add(nom);
		this.add(prenomL);
		this.add(prenom);
		this.add(adresseL);
		this.add(adresse);
		this.add(codePostalL);
		this.add(codePostal);
		this.add(paysL);
		this.add(pays);
		this.add(telFixeL);
		this.add(telFixe);
		this.add(telPortableL);
		this.add(telPortable);
		this.add(envoi);
		this.add(reinitialiser);
	}
	



private class EnvoiListener implements ActionListener  {
	private String alphanum="([a-zA-Z0-9 ]*)";
	private String alpha="([a-zA-Z ]*)";
	private String num="([0-9 ]*)";
	private int flag;
	
	public void actionPerformed (ActionEvent e){
		//Ecouteur du bouton envoi
		if(e.getSource().equals(envoi)){ //Si on appuie sur envoi
			flag=0;
			//Vérification
				if(!nom.getText().matches(alpha) || nom.getText().length()==0){ //Si le champ ne rentre pas dans le regex ou si il est vide
					flag=1;
					JOptionPane.showMessageDialog(null, "Oups, le champs Nom a un soucis, veuillez vérifier!","Erreur", JOptionPane.ERROR_MESSAGE); //On affiche un message d'erreur	
				}
				if(!prenom.getText().matches(alpha) || prenom.getText().length()==0){
					flag=1;
					JOptionPane.showMessageDialog(null, "Oups, le champs Prenom a un soucis, veuillez vérifier!","Erreur", JOptionPane.ERROR_MESSAGE); //On affiche un message d'erreur	
				}
				if(codePostal.getText().length()==0){
					flag=1;
					JOptionPane.showMessageDialog(null, "Oups, le champs Code Postal a un soucis, veuillez vérifier!","Erreur", JOptionPane.ERROR_MESSAGE); //On affiche un message d'erreur	
				}
				if(!adresse.getText().matches(alpha)|| adresse.getText().length()==0){
					flag=1;
					JOptionPane.showMessageDialog(null, "Oups, le champs Adresse a un soucis, veuillez vérifier!","Erreur", JOptionPane.ERROR_MESSAGE); //On affiche un message d'erreur	
				}
				if(!pays.getText().matches(alpha)|| pays.getText().length()==0){
					flag=1;
					JOptionPane.showMessageDialog(null, "Oups, le champs Pays a un soucis, veuillez vérifier!","Erreur", JOptionPane.ERROR_MESSAGE); //On affiche un message d'erreur	
				}
				if(!telFixe.getText().matches(num)|| telFixe.getText().length()==0){
					flag=1;
					JOptionPane.showMessageDialog(null, "Oups, le champs Telephone fixe a un soucis, veuillez vérifier!","Erreur", JOptionPane.ERROR_MESSAGE); //On affiche un message d'erreur	
				}
				if(!telPortable.getText().matches(num)|| telPortable.getText().length()==0){
					flag=1;
					JOptionPane.showMessageDialog(null, "Oups, le champs Telephone Portable a un soucis, veuillez vérifier!","Erreur", JOptionPane.ERROR_MESSAGE); //On affiche un message d'erreur	
				}
				
				if (flag==0){
					//TODO Confirmation a faire ici
					ss.addClientBdd(nom.getText(), prenom.getText(), codePostal.getText(), adresse.getText(), pays.getText(), telFixe.getText(), telPortable.getText()); // On l'envoie a la BDD
					//System.out.println("BDD!");
				}
			}
		if(e.getSource().equals(reinitialiser)){ //Si on appuie sur reset
			nom.setText(""); //On reset tout les champs
			prenom.setText("");
			adresse.setText("");
			codePostal.setText("");
			pays.setText("");
			telFixe.setText("");
			telPortable.setText("");
		}
		
	}
}

}