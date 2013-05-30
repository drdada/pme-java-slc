package org.sonson.gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.sonson.main.Sonson;
import org.sonson.model.Achat;
import org.sonson.model.Client;

public class StatistiqueClientGUI extends JPanel {

	private JLabel labTotClient, lBestClient;
	private JTextField textFieldTotClient, tfBestClient;
	private ArrayList<Client> arrayClient;
	private ArrayList<Achat> arrayAchat;
	private String nomMax;

	public StatistiqueClientGUI() {

		this.setLayout(new GridLayout(2,1,8,8));
		lBestClient = new JLabel("Nom du meilleur client:", SwingConstants.RIGHT);
		arrayAchat = Sonson.getArrayAchat();
		tfBestClient = new JTextField();
		tfBestClient.setEditable(false);
		// On affiche les stats client
		this.statClient();
		this.meilleurClient();
		
		tfBestClient.setText(nomMax);
		this.add(labTotClient);
		this.add(textFieldTotClient);
		this.add(lBestClient);
		this.add(tfBestClient);
	}

	private void statClient() {
		labTotClient = new JLabel("Total de clients:", SwingConstants.RIGHT);
		arrayClient = Sonson.getArrayclient();
		textFieldTotClient = new JTextField(String.valueOf(arrayClient.size()),4);
		textFieldTotClient.setEditable(false);

	}
	
	private void meilleurClient(){
		int tmp=0,max=0;
		for(Client c : arrayClient){
			for(Achat a : arrayAchat){
				if(a.getIdClient()==c.getId()){
				tmp++;	
				}
			}
			if(tmp>max){
				max=tmp;
				nomMax=c.getNom();
				nomMax+=" "+c.getPrenom();
			}
			tmp=0;
		}
	}
}
