package org.sonson.gui;

import java.awt.BorderLayout;
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

public class RechercheClient extends JPanel{
	private Sonson sonson;
	private JTable table;
	private JLabel text;
	private JTextField form;
	private ArrayList<Client> arrayclient;
	private JButton fiche;
	
	public RechercheClient(Sonson sonson){

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
		fiche = new JButton("Fiche Client");
		EnvoiListener envList = new EnvoiListener();
		JLabel text = new JLabel("Recherche d'un client");
		this.add(form,BorderLayout.SOUTH);
		this.add(text,BorderLayout.NORTH);
		
		String  title[] = {"Id", "Nom", "Prenom", "Code Postal", "Adresse","Pays", "Telephone Fixe", "Telephone Portable"};
		
		JTable table = new JTable(data, title);
		table.setEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		this.add(fiche,BorderLayout.SOUTH);
		fiche.addActionListener(envList);
		this.setVisible(true);
		}
	
	private class EnvoiListener implements ActionListener  {
		public void actionPerformed (ActionEvent e){
			//Ecouteur du bouton envoi

			System.out.println(table.getSelectedRow());
		}

	}
	}
