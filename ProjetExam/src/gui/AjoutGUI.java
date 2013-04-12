package gui;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AjoutGUI extends JPanel {
	private JComboBox fournisseurs;
	private JLabel lDateSignalement,lDescriptifbref,lSignaleur,lPreneurEnCharge,lEtatInterv,lSuiviViaFournisseur,lDateContact,lDatePrise,lDateRetour,lEtatRetour,lDateRemiseService,lTempsInterne,lResultat,lFkPcUnit,lFkTypeInterv,lFkFournisseurIntervenant;
	
	
	public AjoutGUI(){
		
		this.setLayout(new GridLayout(7,2,5,5));
		buildJlabel();
	}
	
	private void buildJlabel(){
		lDateSignalement = new JLabel("Date Signalement"); //On crée l'objet jlabel
		lDateSignalement.setToolTipText("Date du document signalant le probléme"); //On met un petit texte d'aide
		lDateSignalement.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		
	}
}
