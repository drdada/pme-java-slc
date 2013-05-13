package org.sonson.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.sonson.main.Sonson;
import org.sonson.model.Client;

public class RechercheClient extends JPanel{
	private Sonson sonson;
	private JTable table;
	private JLabel text;
	private JTextField form;
	private ArrayList<Client> arrayclient;
	private JButton fiche;
	private JPanel pan;
	
	
	public RechercheClient(Sonson sonson,JPanel pan){

		//this.setLayout(new GridLayout(4, 0));
		
		//this.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.setBackground(Color.orange);
		this.pan=pan;
		this.sonson=sonson;
		form = new JTextField("Id du client",7);
		fiche = new JButton("Fiche Client");
		EnvoiListener envList = new EnvoiListener();
		fiche.addActionListener(envList);
		

		JLabel text = new JLabel("Recherche d'un client");

	//	this.add(form,BorderLayout.SOUTH);
		this.add(text);
		
		arrayclient=sonson.getArrayclient();
		Object[][] data = new Object[arrayclient.size()][8];
		int i=0;
		for (Client object: arrayclient){
			data[i][0]=object.getId();
			data[i][1]=object.getNom();
			data[i][2]=object.getPrenom();
			data[i][3]=object.getAdresse();
			data[i][4]=object.getCodePostal();
			data[i][5]=object.getPays();
			data[i][6]=object.getTelFixe();
			data[i][7]=object.getTelPortable();
			i++;
		}
		String  title[] = {"Id", "Nom", "Prenom", "Code Postal", "Adresse","Pays", "Telephone Fixe", "Telephone Portable"};
		
		JTable table = new JTable(data, title);
		
		//table.setPreferredSize(new Dimension(800, 200));
		table.setEnabled(false);
		JScrollPane jst = new JScrollPane(table);
		this.add(jst);
		this.add(form);
		this.add(fiche);
		/*

		this.add(new JScrollPane(table),BorderLayout.CENTER);
		this.add(fiche,BorderLayout.SOUTH);
		this.add(table);
		
		fiche.addActionListener(envList);
		*/
		
		this.setVisible(true);
		
		}
	
	private class EnvoiListener implements ActionListener {
		private String num = "([0-9 ]*)";
		private int id;

		public void actionPerformed(ActionEvent e) {
			// Ecouteur du bouton envoi
			if (!form.getText().matches(num) || form.getText().length() == 0) {
				// erreur
				JOptionPane.showMessageDialog(null,
						"Oups,id non correct, veuillez vérifier!", "Erreur",
						JOptionPane.ERROR_MESSAGE); // On affiche un seul
													// message d'erreur
			} else {
				// OK
				id = Integer.parseInt(form.getText());
				// System.out.println(id);
				pan.removeAll();
				ClientGUI cligui = new ClientGUI(id, pan,sonson);
				pan.add(cligui);
				pan.repaint();
				pan.validate();

			}

		}

	}
	}
