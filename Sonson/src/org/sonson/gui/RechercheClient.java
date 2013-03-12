package org.sonson.gui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.sonson.main.Sonson;
import org.sonson.model.Client;

public class RechercheClient extends JPanel{
	private Sonson sonson;
	private JTable table;
	private ArrayList<Client> arrayclient;
	
	public RechercheClient(Sonson sonson){
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
		
		JLabel test = new JLabel("Test");
		this.add(test);
		
		String  title[] = {"Id", "Nom", "Prenom", "Code Postal", "Adresse","Pays", "Telephone Fixe", "Telephone Portable"};
		
		
		JTable table = new JTable(data, title);
		add(new JScrollPane(table));
		this.setVisible(true);
		}
	
	}
