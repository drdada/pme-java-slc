package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.Projet;

import dal.AccessBDGen;
import dal.MyTableModel;

public class PanelRechercheTemps extends JPanel {
	private JButton rechercher;
	private JTable tableRes;
	private JLabel lTemps,lType;
	private JComboBox cbType;
	private JTextField tfTemps;
	private JScrollPane js;
	
	
	public PanelRechercheTemps(){
	
		rechercher = new JButton("Rechercher");
		lTemps = new JLabel("Temps: ");
		lType = new JLabel("Type d'intervention: ");
		tfTemps = new JTextField();
		MyListener ml = new MyListener();
		rechercher.addActionListener(ml);
		tableRes = new JTable();
		buildJcomboBox();

		
		
		this.add(lTemps);
		this.add(tfTemps);
		this.add(lType);
		this.add(cbType);
		this.add(rechercher);
		
	}
	
	private void buildJcomboBox(){
		String request = "SELECT LibelleTypeInt FROM TypeIntervention";
		try{ 
			Object[] res = AccessBDGen.creerListe1Colonne(Projet.getConnexion(), request);
			cbType = new JComboBox(res);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String request = "SELECT Intervention.* FROM Intervention";
			try{
			MyTableModel tab = AccessBDGen.creerTableModel(Projet.getConnexion(), request);
			tableRes.setModel(tab);
			js = new JScrollPane(tableRes);
			add(tableRes);
			}catch (SQLException er) {
				er.printStackTrace();
			}
		}
	}
}
