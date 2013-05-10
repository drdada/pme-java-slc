package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private Object[] idType;
	
	
	public PanelRechercheTemps(){
	
		rechercher = new JButton("Rechercher");
		lTemps = new JLabel("Temps: ");
		lType = new JLabel("Type d'intervention: ");
		tfTemps = new JTextField("0",5);
		MyListener ml = new MyListener();
		rechercher.addActionListener(ml);
		tableRes = new JTable();
		buildJcomboBox();

		js = new JScrollPane(tableRes);
		
		
		this.add(lTemps);
		this.add(tfTemps);
		this.add(lType);
		this.add(cbType);
		this.add(rechercher);
		add(js);
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
			if(tfTemps.getText().length()==0){
				JOptionPane.showMessageDialog(null, "Temps incorrect","Erreur", JOptionPane.ERROR_MESSAGE);

			}else{
				String requestTyInt ="SELECT CodeTypeInt FROM TypeIntervention WHERE LibelleTypeInt = '"+cbType.getSelectedItem()+"'";
				try{
				idType = AccessBDGen.creerListe1Colonne(Projet.getConnexion(), requestTyInt);
				String request = "SELECT Intervention.* FROM Intervention WHERE Intervention.TempsInterne > "+tfTemps.getText()+" AND Intervention.FkTypeInterv = '"+idType[0]+"'";
				MyTableModel tab = AccessBDGen.creerTableModel(Projet.getConnexion(), request);
				tableRes.setModel(tab);
				PanelRechercheTemps.this.validate();
				PanelRechercheTemps.this.repaint();
				}catch (SQLException er) {
					er.printStackTrace();
				}
			}
		}
	}
}
