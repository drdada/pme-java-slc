package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Aide extends JPanel{
	private JLabel texte;
	private JButton retour;
	public Aide(){
		retour = new JButton("Retour");
		texte = new JLabel("<html><body><center>" +
				"Programme r�alis� par Mr Arnaud Booms et Mr Matteo D'Addamio</br>" +
				"Dans le cadre du cours de java de deuxieme TI" +
				"Henallux 2012-2013" +
				" </center></body></html>");
		this.add(texte);
		this.add(retour);
	}
}
