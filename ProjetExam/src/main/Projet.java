package main;

import java.sql.Connection;

import gui.Fenetre;
/**
 * @author Matteo D'Addamio & Arnaud Booms
 * Henallux 2012-2013 2TIA
 */
public class Projet {
	private static Connection connexionDB ; 
	public Projet(){
		Fenetre f = new Fenetre();
	}
	
	public static void setConnexion(Connection c){ //Permet de definir l'objet connexion
		connexionDB =c;
	}
	
	public static Connection getConnexion(){ //Permet de retourner l'objec connexion
		return connexionDB;
	}
}
