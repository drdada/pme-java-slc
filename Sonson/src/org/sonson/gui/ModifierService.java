package org.sonson.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.sonson.main.Sonson;
import org.sonson.model.Service;

public class ModifierService extends JPanel {
	private int id;
	private ArrayList<Service> arrayService;
	private JLabel titre,lid,lnom,ldesc,lprix,empty1;
	private JTextField tfid,nom,desc,prix;
	
	public ModifierService(int id){
		this.setLayout(new GridLayout(5,2,8,8));
		this.id = id;
		arrayService=Sonson.getArrayService();
		
		titre = new JLabel("Modifier un service", SwingConstants.RIGHT);
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
		for(Service s :arrayService){
			if (s.getId()==id){
				nom.setText(s.getNom());
				desc.setText(s.getDescription());
				prix.setText(String.valueOf(s.getPrix()));
			}
		}
	}
}
