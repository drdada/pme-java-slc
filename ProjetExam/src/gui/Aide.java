package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Aide extends JPanel{
	private JLabel texte;
	public Aide(){
		texte = new JLabel("<html><body><center>" +
				"Programme réalisé par Mr Arnaud Booms et Mr Matteo D'Addamio</br>" +
				"Dans le cadre du cours de java de deuxieme TI" +
				"Henallux 2012-2013" +
				" </center></body></html>");
	}
}
