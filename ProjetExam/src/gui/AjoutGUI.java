package gui;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Projet;
import dal.AccessBDGen;

public class AjoutGUI extends JPanel {
	private JComboBox fournisseur,intervention,pc;
	private JLabel lDateSignalement,lDescriptifbref,lSignaleur,lPreneurEnCharge,lEtatInterv,lSuiviViaFournisseur,lDateContact,lDatePrise,lDateRetour,lEtatRetour,lDateRemiseService,lTempsInterne,lResultat,lFkPcUnit,lFkTypeInterv,lFkFournisseurIntervenant;
	
	
	public AjoutGUI(){
		
		this.setLayout(new GridLayout(7,2,5,5));
		buildJlabel();
		buildJcomboBox();
		
		this.add(fournisseur);
		this.add(intervention);
		this.add(pc);
	}
	
	private void buildJlabel(){
		lDateSignalement = new JLabel("Date Signalement"); //On crée l'objet jlabel
		lDateSignalement.setToolTipText("Date du document signalant le probléme"); //On met un petit texte d'aide
		lDateSignalement.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		
	}
	
	private void buildJcomboBox(){
		String requestIntervention ="SELECT LibelleTypeInt FROM TypeIntervention"; //Code SQL pour recuperer le libelle des type d'installation
		String requestPC="SELECT IdPcUnit FROM PcUnit"; //Idem pour le nom des PC
		String requestFournisseur="SELECT NomFourn FROM Fournisseur"; //Idem pou
		
		try{
			Object[] tableFourn = AccessBDGen.creerListe1Colonne(Projet.getConnexion(), requestFournisseur);
			Object[] tableIntervention = AccessBDGen.creerListe1Colonne(Projet.getConnexion(), requestIntervention);
			Object[] tablePC = AccessBDGen.creerListe1Colonne(Projet.getConnexion(), requestPC);
			
			fournisseur = new JComboBox(tableFourn);
			fournisseur.setMaximumRowCount(3);
			intervention = new JComboBox(tableIntervention);
			intervention.setMaximumRowCount(8);
			pc = new JComboBox(tablePC);
			pc.setMaximumRowCount(11);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
