package org.sonson.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.sonson.main.Sonson;
import org.sonson.model.Produit;
import org.sonson.model.Service;

public class ModifierProduit extends JPanel{

	private int id;
	private ArrayList<Produit> arrayProduit;
	private JLabel titre,lid,lnom,ldesc,lprix,empty1;
	private JTextField tfid,nom,desc,prix;
	
	public ModifierProduit(int id) {
		this.setLayout(new GridLayout(5,2,8,8));
		this.id = id;
		arrayProduit=Sonson.getArrayProduit();
		
		titre = new JLabel("Modifier un Produit", SwingConstants.RIGHT);
		lid = new JLabel("Id: ", SwingConstants.RIGHT);
		lnom = new JLabel("Nom: ", SwingConstants.RIGHT);
		ldesc = new JLabel("Description: ", SwingConstants.RIGHT);
		lprix = new JLabel("Prix: ", SwingConstants.RIGHT);
		empty1 = new JLabel(" ");
		
		tfid = new JTextField(3);
		tfid.setText(String.valueOf(id));
		nom = new JTextField(8);
		desc = new JTextField(25);
		prix = new JTextField(5);
		
		tfid.setEditable(false);
		prix.setEditable(false);
		
		getInfos();
		this.add(titre);
		this.add(empty1);
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
