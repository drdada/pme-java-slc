package org.sonson.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Client;
import org.sonson.model.Produit;
import org.sonson.model.Service;

public class ListInventaireGUI extends JPanel{

	private JLabel titre,lidp,lids;
	private JTextField idp,ids;
	private JTable tableService, tableProduit;
	private ArrayList<Produit> arrayProduit;
	private ArrayList<Service> arrayService;
	private JButton envoi;
	
	public ListInventaireGUI(){
		titre = new JLabel("Modification d'un produit/service");
		lidp= new JLabel("Id du produit à modifier");
		lids = new JLabel("Id du service à modifier");
		idp = new JTextField(3);
		ids = new JTextField(3);
		envoi = new JButton("Envoi");
		
		EnvoiListener ev = new EnvoiListener();
		envoi.addActionListener(ev);
		
		arrayProduit = new ArrayList<Produit>(Sonson.getArrayProduit());
		arrayService = new ArrayList<Service>(Sonson.getArrayService());
		Object[][] data = new Object[arrayProduit.size()][4];
		int i=0;
		for (Produit object: arrayProduit){
			data[i][0]=object.getId();
			data[i][1]=object.getNom();
			data[i][2]=object.getDescription();
			data[i][3]=object.getPrix();
			i++;
		}
		String  title[] = {"Id", "Nom", "Description", "Prix"};
		
		tableProduit = new JTable(data, title);
		tableProduit.setEnabled(false);
		JScrollPane jsp = new JScrollPane(tableProduit);
		
		
		Object[][] data2 = new Object[arrayService.size()][4];
		int h=0;
		for (Service object: arrayService){
			data2[h][0]=object.getId();
			data2[h][1]=object.getNom();
			data2[h][2]=object.getDescription();
			data2[h][3]=object.getPrix();
			h++;
		}
		String  title2[] = {"Id", "Nom", "Description", "Prix"};
		
		tableService = new JTable(data2, title2);
		tableService.setEnabled(false);
		JScrollPane jss = new JScrollPane(tableService);
		
		
		this.add(jsp);
		jsp.setPreferredSize(new Dimension(300, 500));

		
		this.add(jss);
		jss.setPreferredSize(new Dimension(300,500));
		this.add(lidp);
		this.add(idp);
		this.add(lids);
		this.add(ids);
		this.add(envoi);
	}
	private class EnvoiListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(){
				//TODO verification
			}
			else{
				//TODO modification
			}
			
		}
	}
}
