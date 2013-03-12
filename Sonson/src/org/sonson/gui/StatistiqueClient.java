package org.sonson.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatistiqueClient extends JPanel {

	private JLabel labTotClient;
	private JTextField textFieldTotClient;
	public StatistiqueClient(){
		//org.sonson.main.StatistiqueClient stat = new org.sonson.main.StatistiqueClient(sonson);
		labTotClient = new JLabel("Total de clients:");
		textFieldTotClient = new JTextField();
		textFieldTotClient.setEditable(false);
		//textFieldTotClient.setText(stat.calculClientTotal());
		this.add(labTotClient);
		this.add(textFieldTotClient);
	}
}
