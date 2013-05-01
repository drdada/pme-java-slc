package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelTabRecherche extends JPanel {
	private JTabbedPane tab;
	private PanelRechercheDate panDate;
	private PanelRechercheTemps panTemps;
	
	
	public PanelTabRecherche(){
		
		this.setLayout(new BorderLayout());
		
		panDate = new PanelRechercheDate();
		panTemps = new PanelRechercheTemps();
		tab = new JTabbedPane();
		tab.insertTab("Par date", null, panDate, "Liste par date", 0);
		tab.insertTab("Par temps", null, panTemps, "Liste par temps", 1);
		
		this.add(tab,BorderLayout.CENTER);
	}
}
