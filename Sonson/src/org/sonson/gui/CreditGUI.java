package org.sonson.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CreditGUI extends JPanel{

	private JLabel texte;
	public CreditGUI(){
		this.setLayout(new BorderLayout());
		texte = new JLabel("<html><body><center>Projet Gestion simplifiée de PME écrit en Java Par Matteo D'Addamio et Arnaud Booms Pour le cour de conduite de projet (Mr Renson) Henallux 2012-2013</center></body></html>");
		//texte.setHorizontalAlignment(SwingConstants.CENTER); //On centre le jlabel
		this.add(texte,BorderLayout.CENTER);
	}
}
