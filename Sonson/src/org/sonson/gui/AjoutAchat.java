package org.sonson.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import org.sonson.main.Sonson;
import org.sonson.model.Produit;
import org.sonson.model.Service;

public class AjoutAchat extends JFrame{
	private JLabel titre;
	private JButton envoi ;
	private int id;
	private ArrayList<Produit> arrayProduit;
	private ArrayList<Service> arrayService;
	private Sonson sonson;
	private Container cont;
	private JComboBox cbService, cbProduit;
	private ButtonGroup choixps;
	private JRadioButton rbProduit,rbService;

	
	public AjoutAchat(Integer id,Sonson ss){
		this.id=id;
		this.sonson=ss;
		cont = getContentPane();
		cont.setLayout(new GridLayout(3,3));
		this.setTitle("Ajout d'un produit/service");
		this.setSize(400, 400);
		
		arrayProduit=Sonson.getArrayProduit();
		arrayService=Sonson.getArrayService();
		
		titre= new JLabel("Ajouter un produit/service a l'utilisateur "+id+" ");
		envoi = new JButton("Ajout");
		rbProduit = new JRadioButton("Produit");
		rbService = new JRadioButton("Service");
		choixps = new ButtonGroup();
		choixps.add(rbProduit);
		choixps.add(rbService);
		
		buildJComboBox();
		
		this.add(titre);
		this.add(rbProduit);
		this.add(rbService);
		this.add(cbProduit);
		this.add(cbService);
		this.add(envoi);
		this.setVisible(true);
	}
	
	private void buildJComboBox(){
		cbService = new JComboBox();
		for(Service s : arrayService){
			cbService.addItem(s.getNom());
		}
		cbProduit = new JComboBox();
		for(Produit p : arrayProduit){
			cbProduit.addItem(p.getNom());
		}
	}
	private class EnvoiListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
}
