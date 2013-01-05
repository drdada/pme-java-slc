package org.sonson.model;

public class Client {

	private int id;
	private String nom;
	private String prenom;
	private String codePostal;
	private String adresse;
	private String pays;
	private int telFixe;
	private int telPortable;
	
	public Client(int id, String nom, String prenom, String codePostal,
			String adresse, String pays, int telFixe, int telPortable) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.codePostal = codePostal;
		this.adresse = adresse;
		this.pays = pays;
		this.telFixe = telFixe;
		this.telPortable = telPortable;
	}
	
	
}
