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
		JLabel text = new JLabel("<html><body><h1>Texte D'aide ICI</h1>" +
				"</body></html>");
		this.add(text);
	}
}
