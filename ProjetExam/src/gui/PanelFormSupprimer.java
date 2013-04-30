package gui;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import main.Projet;
import dal.AccessBDGen;

public class PanelFormSupprimer extends JPanel{
	private JButton supprimer,raff;
	private JComboBox fourn;
	private Object[] tableFourn;
	
	public PanelFormSupprimer(){
		remplirJcomboBox();
		supprimer = new JButton("Supprimer");
		raff = new JButton("Raffraichir");
		
		
		this.add(fourn);
		this.add(raff);
		this.add(supprimer);
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
}
