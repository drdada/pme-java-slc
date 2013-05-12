package org.sonson.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Client;

public class ClientGUI extends JPanel{
	private int id;
	private ArrayList<Client> arrayclient;
	private JLabel lid,lnom,lprenom,laddresse,lcodep,lpays,ltelfixe,ltelportable,edition;
	private JTextField tfid,tfnom,tfprenom,tfadresse,tfcodep,tfpays,tftelfixe,tftelportable;
	private Sonson sonson;
	private JCheckBox editable;
	private JButton enreg,ajout,retour;
	private JPanel pan;
	
	
	public ClientGUI(int id,JPanel pan){
		this.id= id;
		int flag=0;
		this.arrayclient = sonson.getArrayclient();
		this.pan = pan;
		
		this.setPreferredSize(new Dimension(800, 200));

		declaration();
		
		//System.out.println(sonson.getArrayclient());
		for (Client cl : arrayclient){
			if(cl.getId()==id){
				tfid.setText(String.valueOf(cl.getId()));
				tfnom.setText(cl.getNom());
				tfprenom.setText(cl.getPrenom());
				tfadresse.setText(cl.getAdresse());
				tfcodep.setText(cl.getCodePostal());
				tfpays.setText(cl.getPays());
				tftelfixe.setText(cl.getTelFixe());
				tftelportable.setText(cl.getTelPortable());
				flag=1;
			}
		}
		if(flag==0){
			//TODO boite d'erreur et redirection
			JOptionPane.showMessageDialog(null, "Oups,id non trouvé, veuillez vérifier!","Erreur", JOptionPane.ERROR_MESSAGE); //On affiche un seul message d'erreur
			pan.removeAll();
			RechercheClient rc = new RechercheClient(sonson, pan);
			pan.add(rc);
			pan.repaint();
			pan.validate();
			//System.out.println("Element  non trouvé");
		}
		else{
			ajout();
		}
		
		
	}

	private void declaration(){
		edition = new JLabel("Mode Edition");
		editable = new JCheckBox();
		
		EnvoiListener ev = new EnvoiListener();
		
		enreg = new JButton("Enrengistrer les modifications");
		ajout = new JButton("Ajouter un Produit/Service");
		retour = new JButton("Retour");
		
		enreg.addActionListener(ev);
		ajout.addActionListener(ev);
		retour.addActionListener(ev);
		
		CheckBoxListener chl = new CheckBoxListener();
		editable.addItemListener(chl);
		lid=new JLabel("L'id: ");
		lnom = new JLabel("Le nom: ");
		lprenom = new JLabel("Le prénom :");
		laddresse = new  JLabel("L'adresse: ");
		lcodep = new JLabel("Le code postal: ");
		lpays = new JLabel("Le pays: ");
		ltelfixe = new JLabel("Telephone fixe: ");
		ltelportable = new JLabel("GSM :");
		
		tfid = new JTextField(2);
		tfid.setEnabled(false);
		tfnom = new JTextField(5);
		tfnom.setEditable(false);
		tfprenom = new JTextField(5);
		tfprenom.setEditable(false);
		tfadresse = new JTextField(10);
		tfadresse.setEditable(false);
		tfcodep = new JTextField(5);
		tfcodep.setEditable(false);
		tfpays = new JTextField(8);
		tfpays.setEditable(false);
		tftelfixe = new JTextField(8);
		tftelfixe.setEditable(false);
		tftelportable = new JTextField(8);
		tftelportable.setEditable(false);
		
	}
	
	private void ajout(){
		this.add(edition);
		this.add(editable);
		this.add(lid);
		this.add(tfid);
		this.add(lnom);
		this.add(tfnom);
		this.add(lprenom);
		this.add(tfprenom);
		this.add(laddresse);
		this.add(tfadresse);
		this.add(lcodep);
		this.add(tfcodep);
		this.add(lpays);
		this.add(tfpays);
		this.add(ltelfixe);
		this.add(tftelfixe);
		this.add(ltelportable);
		this.add(tftelportable);
		this.add(enreg);
		this.add(ajout);
		this.add(retour);
	}
    private class CheckBoxListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			if(editable.isSelected()){
				tfnom.setEditable(true);
				tfprenom.setEditable(true);
				tfadresse.setEditable(true);
				tfcodep.setEditable(true);
				tfpays.setEditable(true);
				tftelfixe.setEditable(true);
				tftelportable.setEditable(true);
			}
			else{
				tfnom.setEditable(false);
				tfprenom.setEditable(false);
				tfadresse.setEditable(false);
				tfcodep.setEditable(false);
				tfpays.setEditable(false);
				tftelfixe.setEditable(false);
				tftelportable.setEditable(false);
			}
		}
    }
    private class EnvoiListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Ecouteur
			if(e.getSource().equals(enreg)){
				//Si on modifie les infos
				
			}
			else if(e.getSource().equals(ajout)){
				//si on ajoute un nouveau produit/service
				
			}
			else{
				//Si on appuie sur retour
				pan.removeAll();
				RechercheClient rc = new RechercheClient(sonson, pan);
				pan.add(rc);
				pan.repaint();
				pan.validate();
			}

		}

	}
}
