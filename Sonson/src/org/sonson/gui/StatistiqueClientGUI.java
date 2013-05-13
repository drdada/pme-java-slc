package org.sonson.gui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Client;

public class StatistiqueClientGUI extends JPanel {

	private JLabel labTotClient;
	private JTextField textFieldTotClient;
	private ArrayList<Client> arrayClient;
	
	public StatistiqueClientGUI(){
	
		// On affiche les stats client
		this.statClient();
	}
	
	public void statClient(){
		labTotClient = new JLabel("Total de clients:");
		arrayClient = new ArrayList<Client>(Sonson.getArrayclient());
		textFieldTotClient = new JTextField(String.valueOf(arrayClient.size()));
		textFieldTotClient.setEditable(false);
		this.add(labTotClient);
		this.add(textFieldTotClient);
	}
}
