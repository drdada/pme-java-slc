package gui;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Fenetre extends JFrame{

private Container cont;
	public Fenetre(){
		super("Projet Java 2013 - D'Addamio M. Booms A. - Henallux");
		setBounds(50,50, 1000, 800);
		QuitListnerX quitx = new QuitListnerX();
		this.addWindowListener(quitx);
		Connexion connexion = new Connexion();
		this.add(connexion);
		cont = getContentPane();
		setVisible(true);
	}
	private class QuitListnerX extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.out.println("EXIT");
			System.exit(0);
			}
	}
}
