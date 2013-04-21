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
		this.cont = cont;

		this.setLayout(new BorderLayout());
		
		form = new PanelFormAjout();
		this.add(form,BorderLayout.CENTER);
		
		titre = new JLabel("Ajout d'une nouvelle intervention");
		this.add(titre,BorderLayout.NORTH);
		
		MyListener ml = new MyListener();
		
		retour = new JButton("Retour");
		retour.addActionListener(ml);
		this.add(retour, BorderLayout.SOUTH);
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
