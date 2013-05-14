package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Matteo D'Addamio & Arnaud Booms
 * Henallux 2012-2013 2TIA
 */

public class AjoutGUI extends JPanel {
	private PanelFormAjout form;
	private JButton retour;
	private Container cont;
	private JLabel titre;
	public AjoutGUI(Container cont){
		this.cont = cont; //On récupere le conteneur parent

		this.setLayout(new BorderLayout()); //On défini le border layout
		
		form = new PanelFormAjout(); //On crée le jpanel panelFormAjout (on passe par un jpanel intermidiaire (ici) pour pouvoir avoir le bouton retour, et de ne pas etre bloqué avec la limite de borderlayout)
		this.add(form,BorderLayout.CENTER); //On le met au centre de l'écran
		
		titre = new JLabel("Ajout d'une nouvelle intervention");  
		this.add(titre,BorderLayout.NORTH); //On ajoute le titre au TOP
		
		MyListener ml = new MyListener(); //On crée le listener
		
		retour = new JButton("Retour");
		retour.addActionListener(ml); //On associe le bouton au listener
		this.add(retour, BorderLayout.SOUTH); //On ajoute le bouton au BOTOM
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(retour)){ //Si on a appuyé sur le bouton retour
				Accueil acc = new Accueil(); //On crée un nouvel objet accueil
				cont.removeAll(); //On supprime tout dans le container
				cont.add(acc); //On ajoute l'accueil
				cont.repaint(); //On redessine
				cont.validate(); //On raffraichis
			}
		}
	}
}
