package org.sonson.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Aide extends JPanel{
	private JLabel text;
	public Aide(){
		//TODO Aide
		JLabel text = new JLabel("Texte D'aide ICI");
		this.add(text);
	}
}
