package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AjoutGUI extends JPanel {
	private PanelFormAjout form;
	private JButton retour;
	private Container cont;
	private JLabel titre;
	public AjoutGUI(Container cont){
		this.cont = cont; //On r�cupere le conteneur parent

		this.setLayout(new BorderLayout()); //On d�fini le border layout
		
		form = new PanelFormAjout(); //On cr�e le jpanel panelFormAjout (on passe par un jpanel intermidiaire (ici) pour pouvoir avoir le bouton retour, et de ne pas etre bloqu� avec la limite de borderlayout)
		this.add(form,BorderLayout.CENTER); //On le met au centre de l'�cran
		
		titre = new JLabel("Ajout d'une nouvelle intervention");  
		this.add(titre,BorderLayout.NORTH); //On ajoute le titre au TOP
		
		MyListener ml = new MyListener(); //On cr�e le listener
		
		retour = new JButton("Retour");
		retour.addActionListener(ml); //On associe le bouton au listener
		this.add(retour, BorderLayout.SOUTH); //On ajoute le bouton au BOTOM
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(retour)){ //Si on a appuy� sur le bouton retour
				Accueil acc = new Accueil(); //On cr�e un nouvel objet accueil
				cont.removeAll(); //On supprime tout dans le container
				cont.add(acc); //On ajoute l'accueil
				cont.repaint(); //On redessine
				cont.validate(); //On raffraichis
			}
		}
	}
}
