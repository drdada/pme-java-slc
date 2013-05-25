package org.sonson.gui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Service;

public class ModifierService extends JPanel {
	private int id;
	private ArrayList<Service> arrayService;
	private JLabel titre,lid,lnom,ldesc,lprix;
	private JTextField tfid,nom,desc,prix;
	
	public ModifierService(int id){
		this.id = id;
		arrayService=Sonson.getArrayService();
		
		titre = new JLabel("Modifier un service");
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
		for(Service s :arrayService){
			if (s.getId()==id){
				nom.setText(s.getNom());
				desc.setText(s.getDescription());
				prix.setText(String.valueOf(s.getPrix()));
			}
		}
	}
}
