package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RechercheGUI extends JPanel {
	private JButton retour;
	private JLabel titre;
	private PanelTabRecherche rech;
	private Container cont;
	
	public RechercheGUI(Container cont){
		this.cont= cont;
		this.setLayout(new BorderLayout());
		retour = new JButton("Retour");
		titre = new JLabel("Recherche d'une intervention");
		rech = new PanelTabRecherche() ;
		
		MyListener my = new MyListener();
		retour.addActionListener(my);
		
		this.add(rech,BorderLayout.CENTER);
		this.add(retour,BorderLayout.SOUTH);
		this.add(titre,BorderLayout.NORTH);
		
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(retour)){
				Accueil acc = new Accueil();
				cont.removeAll();
				cont.add(acc);
				cont.repaint();
				cont.validate();
			}
		}
	}
}
