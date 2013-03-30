package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Fenetre extends JFrame{

	private Container cont;

	public Fenetre(){
		super("Projet Java 2013 - D'Addamio M. Booms A. - Henallux");
		this.setSize(500, 500); // donne une taille à la fenetre en x et y
		this.setLocationRelativeTo(null); // place la fenetre au centre de l'écran
		//cont.setLayout(new BorderLayout());
		QuitListnerX quitx = new QuitListnerX();
		this.addWindowListener(quitx);
		Connexion connexion = new Connexion();
		this.add(connexion, BorderLayout.CENTER);
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
