package org.sonson.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreditGUI extends JPanel{

	private JLabel texte;
	public CreditGUI(){
		texte = new JLabel("<html><body>Projet Gestion simplifi�e de PME �crit en Java Par Matteo D'Addamio et Arnaud Booms Pour le cour de conduite de projet (Mr Renson) Henallux 2012-2013</body></html>");
		this.add(texte);
	}
}
