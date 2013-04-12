package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Aide extends JPanel{
	private JLabel texte;
	private JButton retour;
	private Container cont;
	public Aide(Container cont){
		this.setLayout(new BorderLayout());
		this.cont = cont;
		RetourListener retourL = new RetourListener();
		retour = new JButton("Retour");
		texte = new JLabel("<html><body><center>" +
				"Programme réalisé par Mr Arnaud Booms et Mr Matteo D'Addamio<br>" +
				"Dans le cadre du cours de java de deuxieme TI<br>" +
				"Henallux 2012-2013<br>" +
				" </center></body></html>");
		this.add(texte,BorderLayout.CENTER);
		this.add(retour,BorderLayout.SOUTH);
		retour.addActionListener(retourL);
	}
	private class RetourListener implements ActionListener {
		public void actionPerformed (ActionEvent e){
			Accueil acc = new Accueil();
			cont.removeAll();
			cont.add(acc);
			cont.setVisible(true);
			cont.repaint();
		}
	}
}
