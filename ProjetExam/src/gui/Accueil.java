package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Accueil extends JPanel{
	private JLabel texte;
	public Accueil(){
		texte = new JLabel("<html><body><center><h1>TITRE</h1><p>Texte ici</p></center></body></html>");
		this.add(texte); //ajoute le jlabel dans le panel
	}
}
