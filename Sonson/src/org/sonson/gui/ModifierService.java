package org.sonson.gui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.sonson.main.Sonson;
import org.sonson.model.Service;

public class ModifierService extends JPanel {
	private int id;
	private ArrayList<Service> arrayService;
	private JLabel titre,lid,lnom,ldesc,lprix,empty1,empty2;
	private JTextField tfid,nom,desc,prix;
	private Sonson ss;
	private JButton envoi;
	
	public ModifierService(int id,Sonson ss){
		this.ss=ss;
		this.setLayout(new GridLayout(8,2));
		this.id = id;
		arrayService=Sonson.getArrayService();
		titre = new JLabel("Modifier un service", SwingConstants.RIGHT);
		lid = new JLabel("Id: ", SwingConstants.RIGHT);
		lnom = new JLabel("Nom: ", SwingConstants.RIGHT);
		ldesc = new JLabel("Description: ", SwingConstants.RIGHT);
		lprix = new JLabel("Prix: ", SwingConstants.RIGHT);
		empty1 = new JLabel(" ");
		empty2 = new JLabel(" ");
		envoi = new JButton("Envoi");
		EnvoiListener ev = new EnvoiListener(ss);
		envoi.addActionListener(ev);
		
		
		tfid = new JTextField(3);
		tfid.setText(String.valueOf(id));
		nom = new JTextField(8);
		desc = new JTextField(25);
		prix = new JTextField(5);
		
		tfid.setEditable(false);
		prix.setEditable(false);
		
		getInfos();
		this.add(titre);
		this.add(empty1);
		this.add(lid);
		this.add(tfid);
		this.add(lnom);
		this.add(nom);
		this.add(ldesc);
		this.add(desc);
		this.add(lprix);
		this.add(prix);
		this.add(empty2);
		this.add(envoi);
	}
	
	private void getInfos(){
		for(Service s :arrayService){
			if (s.getId()==id){
				nom.setText(s.getNom());
				desc.setText(s.getDescription());
				prix.setText(String.valueOf(s.getPrix()));
			}
		}
	}
	private class EnvoiListener implements ActionListener {
		private Sonson ss;

		public EnvoiListener(Sonson sonson) {
			EnvoiListener.this.ss = sonson;
		}

		public void actionPerformed(ActionEvent e) {
			// Ecouteur
			if(e.getSource().equals(envoi)){
				Object[] options = {"Oui","Non"};
				int n= JOptionPane.showOptionDialog(null,"Voulez-vous vraiment modifier ce service ?", "Vérification", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(n==0){
					ss.majService(nom.getText(), desc.getText(),id);
					ss.updateService();
					JOptionPane.showMessageDialog(null, "Service bien modifié","OK", JOptionPane.INFORMATION_MESSAGE);
//					ModifierService.this.removeAll();
//					Inventaire inv = new Inventaire(ss);
//					ModifierService.this.add(inv);
//					ModifierService.this.repaint();
//					ModifierService.this.validate();
				}
			}
		}
	}
}
