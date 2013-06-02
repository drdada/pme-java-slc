package org.sonson.gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.sonson.main.Sonson;
import org.sonson.model.Achat;

public class TableauClientGUI extends JFrame{
	private int id;
	private ArrayList<Achat> arrayAchat;
	private JTable table;
	private JScrollPane jsp;
	
	
	public TableauClientGUI(int id){
	this.setTitle("Récapitulatif des achats de l'id client: "+id+"");
	this.setSize(750, 750);
	this.id = id;
	arrayAchat = Sonson.getArrayAchat();
	Object[][] data = new Object[10][4];
	int i=0;
	for (Achat object: arrayAchat){
		if(object.getIdClient()==id){
			data[i][0]=object.getIdAchat();
			data[i][1]=object.getDate();
			data[i][2]=object.getIdService();
			data[i][3]=object.getIdProduit();
			i++;
		}
	}
	String  title[] = {"Id de l'achat", "Date", "Service", "Produit"};
	
	table = new JTable(data, title);
	table.setEnabled(false);
	
	jsp = new JScrollPane(table);
	
	this.add(jsp);
	this.setVisible(true);
	}
}
