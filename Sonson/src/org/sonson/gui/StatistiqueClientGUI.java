package org.sonson.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.main.StatistiqueClient;

public class StatistiqueClientGUI extends JPanel {

	private JLabel labTotClient;
	private JTextField textFieldTotClient;
	public StatistiqueClientGUI(){
		labTotClient = new JLabel("Total de clients:");
		textFieldTotClient = new JTextField();
		textFieldTotClient.setEditable(false);
		//textFieldTotClient.setText(StatistiqueClient.c);
		this.add(labTotClient);
		this.add(textFieldTotClient);
	}
}
