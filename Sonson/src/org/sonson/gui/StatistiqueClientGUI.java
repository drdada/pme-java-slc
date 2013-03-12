package org.sonson.gui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.main.StatistiqueClient;
import org.sonson.model.Client;

public class StatistiqueClientGUI extends JPanel {

	private JLabel labTotClient;
	private JTextField textFieldTotClient;
	private Sonson ss;
	public StatistiqueClientGUI(Sonson ss){
		this.ss = ss;
	}
	public StatistiqueClientGUI(){
		labTotClient = new JLabel("Total de clients:");
		StatistiqueClient sc = new StatistiqueClient(ss);
		textFieldTotClient = new JTextField();
		textFieldTotClient.setEditable(false);
		textFieldTotClient.setText(sc.calculClientTotal());
		this.add(labTotClient);
		this.add(textFieldTotClient);
	}
}
