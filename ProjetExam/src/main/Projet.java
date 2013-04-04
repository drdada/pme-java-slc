package main;

import java.sql.Connection;

import gui.Fenetre;

public class Projet {
	private static Connection connexionDB ; 
	public Projet(){
		Fenetre f = new Fenetre();
	}
	
	public static void setConnexion(Connection c){
		connexionDB =c;
	}
}
