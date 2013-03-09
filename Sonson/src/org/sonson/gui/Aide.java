package org.sonson.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Aide {
	public Aide(){
		//TODO Aide
		String message ="Aide\n" +
				"Mettre l'aide ici";
		JOptionPane.showMessageDialog(null, message,"Aide",JOptionPane.INFORMATION_MESSAGE);
	}
}
