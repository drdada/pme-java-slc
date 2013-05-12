package org.sonson.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
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
	
	public ClientGUI(int id){
		this.id= id;
		int flag=0;
		this.arrayclient = sonson.getArrayclient();

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
			System.out.println("Element  non trouvé");
		}
		
		ajout();
	}

	private void declaration(){
		edition = new JLabel("Edition");
		editable = new JCheckBox();
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
		
		tfid = new JTextField();
		tfid.setEnabled(false);
		tfnom = new JTextField();
		tfnom.setEditable(false);
		tfprenom = new JTextField();
		tfprenom.setEditable(false);
		tfadresse = new JTextField();
		tfadresse.setEditable(false);
		tfcodep = new JTextField();
		tfcodep.setEditable(false);
		tfpays = new JTextField();
		tfpays.setEditable(false);
		tftelfixe = new JTextField();
		tftelfixe.setEditable(false);
		tftelportable = new JTextField();
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
	}
    private class CheckBoxListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			if(editable.isSelected()){
				tfnom.setEditable(true);
			}
			else{
				tfnom.setEditable(false);
			}
		}
    }
	
}
