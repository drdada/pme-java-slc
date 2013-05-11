package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;

import com.sun.org.apache.xpath.internal.FoundIndex;

import main.Projet;

import dal.AccessBDGen;
import dal.MyTableModel;

public class PanelRechercheDate extends JPanel{
	private JTable table;
	private JLabel lDate,lLot;
	private JComboBox cblot;
	private JSpinner sDate;
	private Object[] tableLot;
	private JButton raffraichir;
	private JScrollPane js;
	
	public PanelRechercheDate(){
		table = new JTable();
		lDate = new JLabel("Date: ");
		lLot = new JLabel("Lot: ");
		Calendar calendarr = new GregorianCalendar(1970,Calendar.JANUARY,1);
		SpinnerDateModel modelDate = new SpinnerDateModel(new Date(), null, null, Calendar.DATE); //modele de data + initialisation
		sDate = new JSpinner(modelDate); //Création JSpinner
		sDate.setEditor(new JSpinner.DateEditor(sDate, "dd/MM/yyyy")); //Editeur jour/mois/annee
		sDate.setValue(calendarr.getTime());
		buildCBLot();
		raffraichir = new JButton("Raffraichir");
		MyListener my = new MyListener();
		raffraichir.addActionListener(my);
		
		js = new JScrollPane(table);
		
		
		this.add(lLot);
		this.add(cblot);
		this.add(lDate);
		this.add(sDate);
		this.add(raffraichir);
		add(js);
	}
	private void buildCBLot(){
		String requestLot="SELECT NoLot FROM LotConfiguration";
		try{
			tableLot=AccessBDGen.creerListe1Colonne(Projet.getConnexion(), requestLot);
			cblot = new JComboBox(tableLot);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String requestFourn="SELECT FkFournisseurLot FROM LotConfiguration WHERE LotConfiguration.NoLot = "+cblot.getSelectedItem()+"";
			System.out.println(requestFourn);
			String retourDateSignalement = new SimpleDateFormat("dd/MM/yyyy").format(sDate.getValue());
			try{
				Object[] fourn = AccessBDGen.creerListe1Colonne(Projet.getConnexion(), requestFourn);
				String request ="SELECT NoInterv,DateSignalement,FkFournisseuIntervenant FROM Intervention WHERE Intervention.DateSignalement > #"+retourDateSignalement+"# AND FkFournisseuIntervenant ='"+fourn[0]+"'";
				System.out.println(request);
				MyTableModel tab = AccessBDGen.creerTableModel(Projet.getConnexion(), request);
				table.setModel(tab);
				PanelRechercheDate.this.repaint();
				PanelRechercheDate.this.validate();
			}catch (SQLException er) {
				er.printStackTrace();
			}
		}
	}
}
