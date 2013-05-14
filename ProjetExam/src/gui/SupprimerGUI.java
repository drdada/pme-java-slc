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

public class SupprimerGUI extends JPanel {
	private JButton retour;
	private JLabel titre;
	private PanelFormSupprimer supp;
	private Container cont;
	
	public SupprimerGUI(Container cont){
		this.cont = cont;
		this.setLayout(new BorderLayout());
		supp= new PanelFormSupprimer();
		titre = new JLabel("Suppression");
		retour = new JButton("Retour");
		MyListener my = new MyListener();
		retour.addActionListener(my);

		
		this.add(supp,BorderLayout.CENTER);
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
