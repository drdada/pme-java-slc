package org.sonson.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import org.sonson.main.Sonson;
import org.sonson.model.Achat;
import org.sonson.model.Produit;
import org.sonson.model.Service;

public class AjoutAchat extends JFrame{
	private JLabel titre;
	private JButton envoi ;
	private int idClient;
	private ArrayList<Produit> arrayProduit;
	private ArrayList<Service> arrayService;
	private ArrayList<Achat> arrayAchat;
	private Sonson sonson;
	private Container cont;
	private JComboBox cbService, cbProduit;
	private ButtonGroup choixps;
	private JRadioButton rbProduit,rbService;

	
	public AjoutAchat(Integer id,Sonson ss){
		this.idClient=id;
		this.sonson=ss;
		cont = getContentPane();
		cont.setLayout(new GridLayout(3,3));
		this.setTitle("Ajout d'un produit/service");
		this.setSize(400, 400);
		
		EnvoiListener ev= new EnvoiListener();
		
		arrayProduit=Sonson.getArrayProduit();
		arrayService=Sonson.getArrayService();
		arrayAchat=Sonson.getArrayAchat();
		
		titre= new JLabel("Ajouter un produit/service a l'utilisateur "+id+" ");
		envoi = new JButton("Ajout");
		envoi.addActionListener(ev);
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
		int id;

		public void actionPerformed(ActionEvent e) {
			if (rbProduit.isSelected() || rbService.isSelected()) {
				if (rbProduit.isSelected()) { // si on a selectionner produit

					for (Produit p : arrayProduit) { // recherche de l'id du
														// produit selectionné
						if (p.getNom() == cbProduit.getSelectedItem()) {
							id = p.getId();
						}
					}
					sonson.addAchatProduitBdd(idClient, id);
					sonson.updateAchat();

				} else { // si on a selectionner service

					for (Service s : arrayService) {
						if (s.getNom() == cbService.getSelectedItem()) {
							id = s.getId();
						}
					}
					sonson.addAchatServiceBdd(idClient, id);
					sonson.updateAchat();
				}
				JOptionPane.showMessageDialog(null, "Achat effectué","Ah oui!", JOptionPane.INFORMATION_MESSAGE);
				AjoutAchat.this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "Il faut choisir entre produit et service...","Ah non!", JOptionPane.ERROR_MESSAGE);

			}
		}
	}
}
