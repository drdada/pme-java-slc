package org.sonson.model;

import java.util.GregorianCalendar;

import org.sonson.main.AbstractApplication;

public class Achat extends AbstractApplication {

	private int id;
	private GregorianCalendar date;
	//A Verifier...
	
	public Achat(int id, GregorianCalendar date) {
		super();
		this.id = id;
		this.date = date;
	}
	// Bonjour :-)
	//Getters et Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	
	
	
}
