package org.sonson.gui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Produit;
import org.sonson.model.Service;

public class ModifierProduit extends JPanel{

	private int id;
	private ArrayList<Produit> arrayProduit;
	private JLabel titre,lid,lnom,ldesc,lprix;
	private JTextField tfid,nom,desc,prix;
	
	public ModifierProduit(int id) {
		this.id = id;
		arrayProduit=Sonson.getArrayProduit();
		
		titre = new JLabel("Modifier un Produit");
		lid = new JLabel("Id: ");
		lnom = new JLabel("Nom: ");
		ldesc = new JLabel("Description: ");
		lprix = new JLabel("Prix: ");
		
		tfid = new JTextField(3);
		tfid.setText(String.valueOf(id));
		nom = new JTextField(8);
		desc = new JTextField(25);
		prix = new JTextField(5);
		
		tfid.setEditable(false);
		prix.setEditable(false);
		
		getInfos();
		this.add(titre);
		this.add(lid);
		this.add(tfid);
		this.add(lnom);
		this.add(nom);
		this.add(ldesc);
		this.add(desc);
		this.add(lprix);
		this.add(prix);
	}
	
	private void getInfos(){
		for(Produit p :arrayProduit){
			if (p.getId()==id){
				nom.setText(p.getNom());
				desc.setText(p.getDescription());
				prix.setText(String.valueOf(p.getPrix()));
			}
		}
	}
}
