package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 * @author Matteo D'Addamio & Arnaud Booms
 * Henallux 2012-2013 2TIA
 */
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
