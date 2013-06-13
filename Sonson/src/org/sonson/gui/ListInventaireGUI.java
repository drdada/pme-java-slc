package org.sonson.gui;

import java.awt.BorderLayout;
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
import org.sonson.model.Produit;
import org.sonson.model.Service;

public class ListInventaireGUI extends JPanel{

	private JLabel titre,lidp,lids;
	private JTextField idp,ids;
	private JTable tableService, tableProduit;
	private ArrayList<Produit> arrayProduit;
	private ArrayList<Service> arrayService;
	private JButton envoi;
	private Sonson ss;
	
	public ListInventaireGUI(Sonson ss){
		this.setLayout(new BorderLayout());
		this.ss=ss;
		titre = new JLabel("Modification d'un produit/service");
		lidp= new JLabel("Id du produit � modifier");
		lids = new JLabel("Id du service � modifier");
		idp = new JTextField(3);
		ids = new JTextField(3);
		envoi = new JButton("Envoi");
		
		EnvoiListener ev = new EnvoiListener();
		envoi.addActionListener(ev);
		
		arrayProduit = new ArrayList<Produit>(Sonson.getArrayProduit());
		arrayService = new ArrayList<Service>(Sonson.getArrayService());
		Object[][] data = new Object[arrayProduit.size()][4];
		int i=0;
		for (Produit object: arrayProduit){
			data[i][0]=object.getId();
			data[i][1]=object.getNom();
			data[i][2]=object.getDescription();
			data[i][3]=object.getPrix();
			i++;
		}
		String  title[] = {"Id du produit", "Nom", "Description", "Prix"};
		
		tableProduit = new JTable(data, title);
		tableProduit.setEnabled(false);
		JScrollPane jsp = new JScrollPane(tableProduit);
		
		
		Object[][] data2 = new Object[arrayService.size()][4];
		int h=0;
		for (Service object: arrayService){
			data2[h][0]=object.getId();
			data2[h][1]=object.getNom();
			data2[h][2]=object.getDescription();
			data2[h][3]=object.getPrix();
			h++;
		}
		String  title2[] = {"Id du service", "Nom", "Description", "Prix"};
		
		tableService = new JTable(data2, title2);
		tableService.setEnabled(false);
		JScrollPane jss = new JScrollPane(tableService);
		
		JPanel mid = new JPanel();
		JPanel mid1 = new JPanel();
		JPanel mid2 = new JPanel();
		JPanel mid12 = new JPanel();
		JPanel mid22 = new JPanel();
		
		mid1.setLayout(new BorderLayout());
		mid1.add(jsp,BorderLayout.CENTER);
		mid1.add(mid12,BorderLayout.SOUTH);
		//jsp.setPreferredSize(new Dimension(200, 300));
		mid12.add(lidp);
		mid12.add(idp);
		
		
		mid2.setLayout(new BorderLayout());
		mid2.add(jss,BorderLayout.CENTER);
		mid2.add(mid22,BorderLayout.SOUTH);
		//this.setPreferredSize(new Dimension(600,600));
		mid22.add(lids);
		mid22.add(ids);
		mid.add(mid1);
		mid.add(mid2);
		this.add(mid,BorderLayout.CENTER);
		this.add(envoi,BorderLayout.SOUTH);
	}
	private class EnvoiListener implements ActionListener {
		String id;
		int type;
		String num="([0-9 ]*)";
		public void actionPerformed(ActionEvent e) {
			if((idp.getText().length()==0 && ids.getText().length()==0)||(idp.getText().length()!=0 && ids.getText().length()!=0)){ //champs vide
				JOptionPane.showMessageDialog(null, "Il faut rentrer un ID","Ah non!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				if(idp.getText().length()!=0){
					//on a rentr� un produit
					id=idp.getText();
					type=1;
				}
				else{
					//on a rentr� un service
					id=ids.getText();
					type=0;
				}
				
				if(!id.matches(num)){
					//on a rentr� autre chose qu'un int
					JOptionPane.showMessageDialog(null, "Il faut rentrer un ID, donc un nombre...","Ah non!", JOptionPane.ERROR_MESSAGE);

				}
				else{
					//On a rentr� un int
					if(type==1){//si c'est un produit
						ListInventaireGUI.this.removeAll();
						ModifierProduit mod = new ModifierProduit(Integer.valueOf(id),ss);
						ListInventaireGUI.this.add(mod);
						ListInventaireGUI.this.repaint();
						ListInventaireGUI.this.validate();
					}
					else{
						ListInventaireGUI.this.removeAll();
						ModifierService mov = new ModifierService(Integer.valueOf(id),ss);
						ListInventaireGUI.this.add(mov);
						ListInventaireGUI.this.repaint();
						ListInventaireGUI.this.validate();
					}
				}
				
			}
			
		}
	}
}
