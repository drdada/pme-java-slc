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

	
	public void ajouterClient(){
	//TODO ajouter un client	
	}
	
	public void modifierClient(){
		//TODO modifier un client
	}
	
	
	//Getters et Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(int telFixe) {
		this.telFixe = telFixe;
	}

	public int getTelPortable() {
		return telPortable;
	}

	public void setTelPortable(int telPortable) {
		this.telPortable = telPortable;
	}
	
	
}
