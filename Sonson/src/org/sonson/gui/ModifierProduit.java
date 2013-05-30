package org.sonson.gui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.sonson.main.Sonson;
import org.sonson.model.Produit;


public class ModifierProduit extends JPanel{

	private int id;
	private ArrayList<Produit> arrayProduit;
	private JLabel titre,lid,lnom,ldesc,lprix,empty1;
	private JTextField tfid,nom,desc,prix;
	private JButton envoi;
	private Sonson ss;
	
	public ModifierProduit(int id,Sonson ss) {
		this.setLayout(new GridLayout(5,2,8,8));
		this.id = id;
		this.ss = ss;
		arrayProduit=Sonson.getArrayProduit();
		this.setLayout(new GridLayout(5, 5));
		
		titre = new JLabel("Modifier un Produit", SwingConstants.RIGHT);
		lid = new JLabel("Id: ", SwingConstants.RIGHT);
		lnom = new JLabel("Nom: ", SwingConstants.RIGHT);
		ldesc = new JLabel("Description: ", SwingConstants.RIGHT);
		lprix = new JLabel("Prix: ", SwingConstants.RIGHT);
		empty1 = new JLabel(" ");
		envoi= new JButton("Envoi");
		EnvoiListener ev = new EnvoiListener(ss);
		envoi.addActionListener(ev);
		
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
		this.add(envoi);
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

	private class EnvoiListener implements ActionListener {
		private Sonson ss;

		public EnvoiListener(Sonson sonson) {
			EnvoiListener.this.ss = sonson;
		}

		public void actionPerformed(ActionEvent e) {
			// Ecouteur
			if(e.getSource().equals(envoi)){
				Object[] options = {"Oui","Non"};
				int n= JOptionPane.showOptionDialog(null,"Voulez-vous vraiment modifier ce produit ?", "Vérification", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(n==0){
					ss.majProduit(nom.getText(), desc.getText(),id);
					ss.updateProduit();
					JOptionPane.showMessageDialog(null, "Produit bien modifié","OK", JOptionPane.INFORMATION_MESSAGE);

					ModifierProduit.this.removeAll();
					Inventaire inv = new Inventaire(ss);
					ModifierProduit.this.add(inv);
					ModifierProduit.this.repaint();
					ModifierProduit.this.validate();
				}
			}
		}
	}
}
