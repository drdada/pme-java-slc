package org.sonson.model;

import java.util.GregorianCalendar;

import org.sonson.main.AbstractApplication;

public class Achat extends AbstractApplication {

	private int idAchat;
	private GregorianCalendar date;
	private int idClient;
	private int idService;
	private int idProduit;

	public Achat(int idAchat, GregorianCalendar date, int idClient,
			int idService, int idProduit) {
		super();
		this.idAchat = idAchat;
		this.date = date;
		this.idClient = idClient;
		this.idService = idService;
		this.idProduit = idProduit;
	}
	

	public void ajouterAchat(){
		//TODO ajouter un achat a la bdd ?
	}

	
	//Getters et Setters
	public int getIdAchat() {
		return idAchat;
	}


	public void setIdAchat(int idAchat) {
		this.idAchat = idAchat;
	}


	public GregorianCalendar getDate() {
		return date;
	}


	public void setDate(GregorianCalendar date) {
		this.date = date;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public int getIdService() {
		return idService;
	}


	public void setIdService(int idService) {
		this.idService = idService;
	}


	public int getIdProduit() {
		return idProduit;
	}


	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	
}
