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
		Object[][] data = new Object[arrayclient.size()][7];
		int i=0;
		for (Client object: arrayclient){
			data[i][0]=object.getId();
			data[i][1]=object.getNom();
			data[i][2]=object.getPrenom();
			data[i][3]=object.getAdresse();
			data[i][4]=object.getCodePostal();
			data[i][5]=object.getTelFixe();
			data[i][6]=object.getTelPortable();
		}
		JLabel test = new JLabel("Test");
		this.add(test);
		JTable table = new JTable(data);
		add(new JScrollPane(table));
		this.setVisible(true);
		}
	}
