package org.sonson.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.dal.UpdateModel;
import org.sonson.main.Sonson;
import org.sonson.model.Client;

public class AjoutClientGUI extends JPanel {
	private Sonson ss;
	private JLabel emptylabel,texte,nomL,prenomL,adresseL,codePostalL,paysL,telFixeL,telPortableL;
	private JTextField nom,prenom,adresse,codePostal,pays,telFixe,telPortable;
	private JButton envoi;
	
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
		envoi.addActionListener(envlist);
		
		
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
	}
	



private class EnvoiListener implements ActionListener  {
	public void actionPerformed (ActionEvent e){
		//Ecouteur du bouton envoi
		
		ss.addClientBdd(nom.getText(), prenom.getText(), codePostal.getText(), adresse.getText(), pays.getText(), telFixe.getText(), telPortable.getText());
	}
}

}