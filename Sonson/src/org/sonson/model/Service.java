package org.sonson.model;

import org.sonson.main.AbstractApplication;

public class Service extends AbstractApplication {

	private int id;
	private String nom;
	private String description;
	private double prix;
	
	public Service(int id, String nom, String description, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}
	
}
