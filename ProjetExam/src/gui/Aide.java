package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Matteo D'Addamio & Arnaud Booms
 * Henallux 2012-2013 2TIA
 */

public class Aide extends JPanel{
	private JLabel texte;
	private JButton retour;
	private Container cont;
	public Aide(Container cont){
		this.setLayout(new BorderLayout()); //On défini le gestionnaire de tracé
		this.cont = cont; //On obtient le container
		RetourListener retourL = new RetourListener(); //Création de l'objet retourL (Listener)
		retour = new JButton("Retour"); //Création de l'objet jbutton retour
		texte = new JLabel("<html><body><center>" +
				"Programme réalisé par M. Arnaud Booms et M. Matteo D'Addamio<br>" +
				"Dans le cadre du cours de java de deuxieme TI<br>" +
				"Henallux 2012-2013<br>" +
				" </center></body></html>"); //On crée le jlabel
		texte.setHorizontalAlignment(SwingConstants.CENTER); //On centre le jlabel
		this.add(texte,BorderLayout.CENTER); //On ajoute le texte au centre du jpanel
		this.add(retour,BorderLayout.SOUTH); //On ajoute le bouton retour dans le fond du jpanel
		retour.addActionListener(retourL); //On défini l'objet listener (action qui serra exécutée quand on clique)
	}
	private class RetourListener implements ActionListener {
		public void actionPerformed (ActionEvent e){
			Accueil acc = new Accueil(); //On crée l'objet accueil
			cont.removeAll(); //On supprime tout dans le container
			cont.add(acc); //On ajoute le jpanel accueil dans le container
			cont.repaint(); //On raffraichis
			cont.validate(); //Ici aussi sinon obligé de redimentionner pour voir les modifications
		}
	}
}
