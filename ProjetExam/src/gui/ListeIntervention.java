package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dal.*;
import main.*;


public class ListeIntervention extends JPanel{

	private JPanel liste;
	private JLabel titre;
	private JButton recherche,retour;
	private String requete;
	private Container cont;
	
	public ListeIntervention(Container cont){
		this.cont = cont;
		this.setLayout(new BorderLayout()); //On défini le layout (borderlayout)
		liste = new JPanel();
		liste.setLayout(new GridLayout());
		
		titre = new JLabel("Listes des installations");
		liste.add(titre);
		
		recherche = new JButton("Lister");
		liste.add(recherche);
		
		requete = "SELECT * FROM Intervention";
		
		MyListener myListener = new MyListener();
		recherche.addActionListener(myListener);
		this.add(liste,BorderLayout.CENTER);
		retour = new JButton("Retour");
		retour.addActionListener(myListener);
		this.add(retour,BorderLayout.SOUTH);
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(recherche)){
				try{
					MyTableModel table = AccessBDGen.creerTableModel(Projet.getConnexion(), requete);
					JTable tableR = new JTable(table);
					JScrollPane scrollTable = new JScrollPane(tableR);
					
					ListeIntervention.this.removeAll();
					ListeIntervention.this.setLayout(new BorderLayout());
					
					ListeIntervention.this.add(liste,BorderLayout.NORTH);
					ListeIntervention.this.add(scrollTable,BorderLayout.CENTER);
					ListeIntervention.this.repaint();
					ListeIntervention.this.validate();
					ListeIntervention.this.setVisible(true);
				}
				catch(SQLException er){
					JOptionPane.showMessageDialog(null, er.getMessage());
				}
			}
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
