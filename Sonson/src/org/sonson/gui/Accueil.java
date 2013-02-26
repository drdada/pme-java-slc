package org.sonson.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Accueil extends JFrame {
	
	private Container cont;
	private JButton credit;
	private JPanel pan1;
	private JLabel wlcm;

	public Accueil(){
		
		super("Projet PME - Matteo D. et Arnaud B.");
		//Revoir les dimentions ?
		setBounds(50,50, 1000, 800);
		addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent e){System.exit(0);}});
		
		wlcm = new JLabel("Bienvenue");
		credit = new JButton("Crédits");
		
		pan1 = new JPanel();
		//Selection du layout
		pan1.setLayout(new FlowLayout());
		pan1.add(wlcm);
		pan1.add(credit);
		
		CreditsListener creditlist = new CreditsListener();
		credit.addActionListener(creditlist);
		
		cont = getContentPane();
		cont.add(pan1);
		setVisible(true);
	}
	private class CreditsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null,"Projet \"Gestion simplifiée de PME\" écrit en Java\nPar Matteo D'Addamio et Arnaud Booms\nPour le cour de conduite de projet (Mr Renson)\nHenallux 2012-2013","Crédits", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
