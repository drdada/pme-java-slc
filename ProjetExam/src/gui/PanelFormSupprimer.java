package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import main.Projet;
import dal.AccessBDGen;
import dal.MyTableModel;

public class PanelFormSupprimer extends JPanel{
	private JButton supprimer,raff;
	private JComboBox fourn;
	private Object[] tableFourn,idFour;
	private JTable tableRes;
	private JTextField textNoInt;
	private JLabel labelNoInt;
	
	public PanelFormSupprimer(){
		
		remplirJcomboBox();
		supprimer = new JButton("Supprimer");
		raff = new JButton("Raffraichir");
		tableRes = new JTable();
		textNoInt = new JTextField();
		labelNoInt = new JLabel();
		
		
		MyListener myListener = new MyListener();
		raff.addActionListener(myListener);
		supprimer.addActionListener(myListener);
		
		this.add(fourn);
		this.add(raff);
		this.add(supprimer);
		this.add(labelNoInt);
		this.add(textNoInt);
		this.add(tableRes);
	}
	
	private void remplirJcomboBox(){
		String requestFournisseur="SELECT NomFourn FROM Fournisseur"; //Idem pou

		try{
			tableFourn = AccessBDGen.creerListe1Colonne(Projet.getConnexion(), requestFournisseur);
			fourn = new JComboBox(tableFourn);
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(raff)){
				String requestIdFour ="SELECT FournisseurId FROM Fournisseur WHERE NomFourn = '"+fourn.getSelectedItem()+"'";
				try{
					idFour = AccessBDGen.creerListe1Colonne(Projet.getConnexion(), requestIdFour);
					String request = "SELECT Intervention.* FROM Intervention WHERE FkFournisseuIntervenant = '"+idFour[0]+"' ";
					MyTableModel tab = AccessBDGen.creerTableModel(Projet.getConnexion(), request);
					tableRes.setModel(tab);
					PanelFormSupprimer.this.repaint();
					PanelFormSupprimer.this.validate();
				}catch (SQLException er){
					er.printStackTrace();
				}
			}
			if(e.getSource().equals(supprimer)){
				if(textNoInt.getText().length()==0)
					try{
						
						String request = "DELETE FROM Intervention WHERE NoInterv = '"+textNoInt.getText()+"'";
						int res = AccessBDGen.executerInstruction(Projet.getConnexion(), request);
						System.out.println(res);
					}catch (SQLException er){
						er.printStackTrace();
					}
			}

		}
	}
	
}
