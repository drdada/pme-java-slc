package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import main.Projet;
import dal.AccessBDGen;

public class PanelFormAjout extends JPanel {
	private JComboBox fournisseur,intervention,pc;
	private JLabel lDateSignalement,lDescriptifbref,lSignaleur,lPreneurEnCharge,lEtatInterv,lSuiviViaFournisseur,lDateContact,lDatePrise,lDateRetour,lEtatRetour,lDateRemiseService,lTempsInterne,lResultat,lFkPcUnit,lFkTypeInterv,lFkFournisseurIntervenant,lNoInterv;
	private JTextField tfNoInterv,tfSignaleur,tfPreneurEnCharge,tfTempsInterne;
	private JRadioButton ok1,declasse1,suspens1,ok2,declasse2,suspens2,signale,encours,cloture,suivi,nonSuivi;
	private ButtonGroup bgEtatInterv,bgEtatRetour,bgResulstat,bgSuiviViaFournisseur;
	private JButton envoi;
	private JSpinner dateSignalement,dateContact,datePrise,dateRetour,dateRemiseService;
	private JTextArea desciptif;

	public PanelFormAjout(){
		this.setLayout(new GridLayout(15,2,5,5));
		buildJlabel();
		buildJcomboBox();
		buildJTextField();
		buildButtonGroup();
		buildDate();
		buildTextArea();
		setID();
		
		MyListener ml = new MyListener();
		envoi = new JButton("Envoi");
		envoi.addActionListener(ml);
		
		this.add(lNoInterv);
		this.add(tfNoInterv);
		this.add(lDateSignalement);
		this.add(dateSignalement);
		this.add(lDescriptifbref);
		this.add(desciptif);
		this.add(lSignaleur);
		this.add(tfSignaleur);
		this.add(lPreneurEnCharge);
		this.add(tfPreneurEnCharge);
		this.add(lEtatInterv);
		this.add(signale);this.add(encours);this.add(cloture);
		this.add(lSuiviViaFournisseur);
		this.add(suivi);this.add(nonSuivi);
		this.add(lDateContact);
		this.add(dateContact);
		this.add(lDatePrise);
		this.add(datePrise);
		this.add(lDateRetour);
		this.add(dateRetour);
		this.add(lEtatRetour);
		this.add(ok1);this.add(declasse1);this.add(suspens1);
		this.add(lDateRemiseService);
		this.add(dateRemiseService);
		this.add(lTempsInterne);
		this.add(tfTempsInterne);
		this.add(lResultat);
		this.add(ok2);this.add(declasse2);this.add(suspens2);
		this.add(lFkFournisseurIntervenant);
		this.add(fournisseur);
		this.add(lFkTypeInterv);
		this.add(intervention);
		this.add(lFkPcUnit);
		this.add(pc);
		this.add(envoi);
	}
	
	private void setID(){
		String requete = "SELECT TOP 1 NoInterv FROM Intervention ORDER BY NoInterv DESC"; //R�cupere la derniere entr�e de la table
		try{
			int dernierEntree = AccessBDGen.executerInstruction(Projet.getConnexion(), requete);
			dernierEntree++;
			//System.out.println(dernierEntree);
			tfNoInterv.setText(""+dernierEntree);//On met le champ tfNoINterv avec la valeur de l'id (dernier id + 1)
		}
		catch (SQLException er) { //Si la table est vide il renvoie une erreur
			//er.printStackTrace();
			int dernierEntree = 0; //C'est donc l'entr�e 0, la premiere entr�e de la table
			tfNoInterv.setText(""+dernierEntree); //On affiche le 0 (concat�nation moin ennuyante qu'une transformation int -> String)
			
		}
	}
	private void buildJTextField(){
		tfNoInterv = new JTextField();
		tfNoInterv.setEditable(false);
		
		tfPreneurEnCharge = new JTextField();
		
		tfSignaleur = new JTextField();
		
		tfTempsInterne = new JTextField(4);
	}
	private void buildTextArea(){
		desciptif = new JTextArea(2, 1);
	}
	
	private void buildButtonGroup(){
		ok1 = new JRadioButton("Ok", false);
		declasse1 = new JRadioButton("D�class�", false);
		suspens1 = new JRadioButton("En Suspens", false);
		
		ok2 = new JRadioButton("Ok", false);
		declasse2 = new JRadioButton("D�class�", false);
		suspens2 = new JRadioButton("En Suspens", false);
		
		signale = new JRadioButton("Signal�", false);
		encours = new JRadioButton("En Cours", false);
		cloture = new JRadioButton("Clotur�", false);
		
		suivi = new JRadioButton("Suivi",false);
		nonSuivi = new JRadioButton("Non Suivi", false);
		
		bgSuiviViaFournisseur = new ButtonGroup();
		bgSuiviViaFournisseur.add(suivi);
		bgSuiviViaFournisseur.add(nonSuivi);
		
		bgEtatInterv = new ButtonGroup();
		bgEtatInterv.add(signale);
		bgEtatInterv.add(encours);
		bgEtatInterv.add(cloture);
		
		bgEtatRetour = new ButtonGroup();
		bgEtatRetour.add(ok1);
		bgEtatRetour.add(declasse1);
		bgEtatRetour.add(suspens1);
		
		bgResulstat = new ButtonGroup();
		bgResulstat.add(ok2);
		bgResulstat.add(declasse2);
		bgResulstat.add(suspens2);
	}
	
	private void buildJlabel(){
		lDateContact = new JLabel("Date Signalement Fournisseur"); //On cr�e l'objet jlabel
		lDateContact.setToolTipText("Date de signalement au fournisseur"); //On met un petit texte d'aide
		lDateContact.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lDatePrise = new JLabel("Date Prise Mat�riel"); //On cr�e l'objet jlabel
		lDatePrise.setToolTipText("Date o� le mat�riel � �t� emport�"); //On met un petit texte d'aide
		lDatePrise.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lDateRemiseService = new JLabel("Date Remise En Service"); //On cr�e l'objet jlabel
		lDateRemiseService.setToolTipText("Date de la remise en service"); //On met un petit texte d'aide
		lDateRemiseService.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lDateRetour = new JLabel("Date Retour Fournisseur"); //On cr�e l'objet jlabel
		lDateRetour.setToolTipText("Date de retour de chez le fournisseur"); //On met un petit texte d'aide
		lDateRetour.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lDateSignalement = new JLabel("Date Du Signalement"); //On cr�e l'objet jlabel
		lDateSignalement.setToolTipText("Date du document signalant le probl�me"); //On met un petit texte d'aide
		lDateSignalement.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lDescriptifbref= new JLabel("Descriptif Probl�me"); //On cr�e l'objet jlabel
		lDescriptifbref.setToolTipText("Bref descriptif du probl�me"); //On met un petit texte d'aide
		lDescriptifbref.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lEtatInterv = new JLabel("Etat Intervention"); //On cr�e l'objet jlabel
		lEtatInterv.setToolTipText("Etat actuel de l'intervention"); //On met un petit texte d'aide
		lEtatInterv.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lEtatRetour = new JLabel("Etat Retour"); //On cr�e l'objet jlabel
		lEtatRetour.setToolTipText("Etat lors du retour"); //On met un petit texte d'aide
		lEtatRetour.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lFkFournisseurIntervenant = new JLabel("Fournisseur"); //On cr�e l'objet jlabel
		lFkFournisseurIntervenant.setToolTipText("R�f�rence vers le fournisseur"); //On met un petit texte d'aide
		lFkFournisseurIntervenant.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lFkPcUnit = new JLabel("PC"); //On cr�e l'objet jlabel
		lFkPcUnit.setToolTipText("R�f�rence vers le PC objet de l'intervention"); //On met un petit texte d'aide
		lFkPcUnit.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lFkTypeInterv = new JLabel("Type Intervention"); //On cr�e l'objet jlabel
		lFkTypeInterv.setToolTipText("R�f�rence vers le type de l'intervention"); //On met un petit texte d'aide
		lFkTypeInterv.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lNoInterv = new JLabel("Num�ro Intervention"); //On cr�e l'objet jlabel
		lNoInterv.setToolTipText("Num�ro incr�mentiel de l'intervention en cours"); //On met un petit texte d'aide
		lNoInterv.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lPreneurEnCharge = new JLabel("Administrateur"); //On cr�e l'objet jlabel
		lPreneurEnCharge.setToolTipText("Administrateur prenant en charge"); //On met un petit texte d'aide
		lPreneurEnCharge.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lResultat = new JLabel("R�sultat"); //On cr�e l'objet jlabel
		lResultat.setToolTipText("R�sultat de l'intervention"); //On met un petit texte d'aide
		lResultat.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lSignaleur = new JLabel("Signaleur Incident"); //On cr�e l'objet jlabel
		lSignaleur.setToolTipText("Nom de la personne signalante"); //On met un petit texte d'aide
		lSignaleur.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lSuiviViaFournisseur = new JLabel("Suivi Via Fournisseur"); //On cr�e l'objet jlabel
		lSuiviViaFournisseur.setToolTipText("Renvoy� ou non au fournisseur"); //On met un petit texte d'aide
		lSuiviViaFournisseur.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
		
		lTempsInterne = new JLabel("Temps Prest�"); //On cr�e l'objet jlabel
		lTempsInterne.setToolTipText("Temps Prest� en interne pour l'intervention"); //On met un petit texte d'aide
		lTempsInterne.setHorizontalAlignment(SwingConstants.RIGHT); //On aligne le jlabel a gauche
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
			intervention.setMaximumRowCount(3);
			pc = new JComboBox(tablePC);
			pc.setMaximumRowCount(3); 
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private void buildDate(){
		SpinnerDateModel modelDate = new SpinnerDateModel(new Date(), null, null, Calendar.DATE); //modele de data + initialisation
		dateSignalement = new JSpinner(modelDate); //Cr�ation JSpinner
		dateSignalement.setEditor(new JSpinner.DateEditor(dateSignalement, "dd/MM/yyyy")); //Editeur jour/mois/annee
		
		Calendar calendarr = new GregorianCalendar(1970,Calendar.JANUARY,1);
		SpinnerDateModel modelDate2 = new SpinnerDateModel(new Date(), null, null, Calendar.DATE); //modele de data + initialisation
		dateContact = new JSpinner(modelDate2);
		dateContact.setEditor(new JSpinner.DateEditor(dateContact, "dd/MM/yyyy"));
		dateContact.setValue(calendarr.getTime());
		
		SpinnerDateModel modelDate3 = new SpinnerDateModel(new Date(), null, null, Calendar.DATE); //modele de data + initialisation
		datePrise = new JSpinner(modelDate3);
		datePrise.setEditor(new JSpinner.DateEditor(datePrise, "dd/MM/yyyy"));
		datePrise.setValue(calendarr.getTime());
		
		SpinnerDateModel modelDate4 = new SpinnerDateModel(new Date(), null, null, Calendar.DATE); //modele de data + initialisation
		dateRetour = new JSpinner(modelDate4);
		dateRetour.setEditor(new JSpinner.DateEditor(dateRetour, "dd/MM/yyyy"));
		dateRetour.setValue(calendarr.getTime());
		
		SpinnerDateModel modelDate5 = new SpinnerDateModel(new Date(), null, null, Calendar.DATE); //modele de data + initialisation
		dateRemiseService = new JSpinner(modelDate5);
		dateRemiseService.setEditor(new JSpinner.DateEditor(dateRemiseService, "dd/MM/yyyy"));
		dateRemiseService.setValue(calendarr.getTime());
	}
	
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(envoi)){
				int flag=0;
				String erreurText=" ";
				//Si on a appuy� sur le bouton envoi
				if(desciptif.getText().length()==0){ //Si on ne remplis pas le champs descriptif
					desciptif.setText(" "); //On �crit un blanc dedans
				}
				if(tfSignaleur.getText().length()==0){
					tfSignaleur.setText(" ");
				}
				if(tfPreneurEnCharge.getText().length()==0){
					flag=1;
					erreurText+=" l'administrateur prenant en charge, ";
				}
				if(!signale.isSelected() && !encours.isSelected() && !cloture.isSelected()){
					flag=1;
					erreurText+=" l'�tat de l'intervention, ";
				}
				else{
					//On associe la r�ponse a un String
				}
				if(!suivi.isSelected() && !nonSuivi.isSelected()){
					flag=1;
					erreurText+=" suivi via le fournisseur, ";
				}
				else{
					//On associe la r�ponse a un int
				}
				String retourDateContact = new SimpleDateFormat("dd/MM/yyyy").format(dateContact.getValue());
				String retourDatePrise = new SimpleDateFormat("dd/MM/yyyy").format(datePrise.getValue());
//				if(retourDatePrise.equals("01/01/1970")){
//					retourDatePrise="null";
//				}
				String retourDateRetour = new SimpleDateFormat("dd/MM/yyyy").format(dateRetour.getValue());
				String retourDateRemise = new SimpleDateFormat("dd/MM/yyyy").format(dateRemiseService.getValue());
				if(retourDateRemise.equals("01/01/1970")){
					retourDateRemise="null";
				}
				//Probleme champ int � null
				int retourTempInterne;
				if(tfTempsInterne.getText().length()==0){
					//retourTempInterne=null;
				}else{
					String text =tfTempsInterne.getText();
					retourTempInterne= Integer.parseInt(text);
				}
				//TODO Verif Jbox
				
				
				if(flag==1){
					JOptionPane.showMessageDialog(null, "Oups, le/les champs "+erreurText+" a/ont un soucis, veuillez v�rifier!","Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Object[] options = {"Oui","Non"};
					int n= JOptionPane.showOptionDialog(null,"Voulez-vous vraiment ajouter cet utilisateur ?", "V�rification", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if(n==0){
						//TODO Ajout
						//TODO Reset
					}
				}
			}
		}
	}
}
