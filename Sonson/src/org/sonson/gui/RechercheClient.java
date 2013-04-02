package org.sonson.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Client;

public class RechercheClient extends JPanel{
	private Sonson sonson;
	private JTable table;
	private JLabel text;
	private JTextField form;
	private ArrayList<Client> arrayclient;
	
	public RechercheClient(Sonson sonson){
		//TODO mettre les tailles des collones et organisation graphique
		//TODO Pouvoir selectionner une entree
		//TODO Pouvoir trouver le client parmi la liste (tout les champs)
		this.setLayout(new BorderLayout());
		arrayclient=sonson.getArrayclient();
		Object[][] data = new Object[arrayclient.size()][8];
		int i=0;
		for (Client object: arrayclient){
			data[i][0]=object.getId();
			data[i][1]=object.getNom();
			data[i][2]=object.getPrenom();
			data[i][3]=object.getAdresse();
			data[i][4]=object.getCodePostal();
			data[i][5]=object.getPays();
			data[i][6]=object.getTelFixe();
			data[i][7]=object.getTelPortable();
			i++;
		}

		form = new JTextField("Recherche");
		
		JLabel text = new JLabel("Recherche d'un client");
		this.add(form,BorderLayout.SOUTH);
		this.add(text,BorderLayout.NORTH);
		
		String  title[] = {"Id", "Nom", "Prenom", "Code Postal", "Adresse","Pays", "Telephone Fixe", "Telephone Portable"};
		
		JTable table = new JTable(data, title);
		table.setEnabled(false);
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		this.setVisible(true);
		}
	
	}
