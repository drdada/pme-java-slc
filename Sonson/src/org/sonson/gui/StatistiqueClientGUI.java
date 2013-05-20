package org.sonson.gui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Achat;
import org.sonson.model.Client;

public class StatistiqueClientGUI extends JPanel {

	private JLabel labTotClient, lBestClient;
	private JTextField textFieldTotClient, tfBestClient;
	private ArrayList<Client> arrayClient;
	private ArrayList<Achat> arrayAchat;

	public StatistiqueClientGUI() {
		lBestClient = new JLabel("Nom du client le plus réccurent:");
		arrayAchat = Sonson.getArrayAchat();
		// On affiche les stats client
		this.statClient();

		this.add(labTotClient);
		this.add(textFieldTotClient);
	}

	public void statClient() {
		labTotClient = new JLabel("Total de clients:");
		arrayClient = Sonson.getArrayclient();
		textFieldTotClient = new JTextField(String.valueOf(arrayClient.size()),4);
		textFieldTotClient.setEditable(false);

	}
}
