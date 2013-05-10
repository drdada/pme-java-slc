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
		textNoInt = new JTextField("0",5);
		labelNoInt = new JLabel("Numéro Intervention : ");
		
		
		MyListener myListener = new MyListener();
		raff.addActionListener(myListener);
		supprimer.addActionListener(myListener);
		
		this.add(fourn);
		this.add(raff);
		this.add(labelNoInt);
		this.add(textNoInt);
		this.add(supprimer);
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

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(raff)) {
				String requestIdFour = "SELECT FournisseurId FROM Fournisseur WHERE NomFourn = '"
						+ fourn.getSelectedItem() + "'";// Requete suppression intervention
				try {
					idFour = AccessBDGen.creerListe1Colonne(
							Projet.getConnexion(), requestIdFour);// Envois de la requete a la db
					String request = "SELECT Intervention.* FROM Intervention WHERE FkFournisseuIntervenant = '"
							+ idFour[0] + "' ";// Requete suppression intervention
					MyTableModel tab = AccessBDGen.creerTableModel(
							Projet.getConnexion(), request);// Envois de la requete a la db
					tableRes.setModel(tab); // remplir la table avec resusltat de la requete
					PanelFormSupprimer.this.repaint();
					PanelFormSupprimer.this.validate();
				} catch (SQLException er) {
					er.printStackTrace();
				}
			}
			if (e.getSource().equals(supprimer)) {
				if (textNoInt.getText().length() != 0) {
					Object[] options = { "Oui", "Non" }; // Demande de confirmation de suppression
					int n = JOptionPane.showOptionDialog(null,
							"Voulez-vous vraiment supprimer cette intervention ?",
							"Vérification", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
					if (n == 0) {// Comfirmation de la suppression
						try {

							String request = "DELETE FROM Intervention WHERE NoInterv = "
									+ textNoInt.getText() + ""; // Requete suppression intervention
							// System.out.println(request);
							int res = AccessBDGen.executerInstruction(
									Projet.getConnexion(), request); // Envois de la requete a la db
							// System.out.println(res);
							if(res==0){ // Si la suppression ne s'est pas faite
								JOptionPane.showMessageDialog(null, 
										"L'éléments n'est pas présent dans la base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else{// Si la suppression a été faite
								JOptionPane.showMessageDialog(null, 
										"Vous avez supprimer l'intervention numéro"+textNoInt.getText()+".", "Ok", JOptionPane.INFORMATION_MESSAGE);
							}
							textNoInt.setText("0");// Remet la valeur par défaut du No d'intervention
						} catch (SQLException er) {
							er.printStackTrace();
						}
					}
					
				}

			}
		}

	}
}
