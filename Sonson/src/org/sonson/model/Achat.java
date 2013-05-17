package org.sonson.model;

import java.sql.Date;
import org.sonson.main.AbstractApplication;

public class Achat extends AbstractApplication {

	private Integer idAchat;
	private Date date;
	private Integer idClient;
	private Integer idService;
	private Integer idProduit;

	public Achat(int idAchat, Date date, int idClient,
			int idService, int idProduit) {
		super();
		this.idAchat = idAchat;
		this.date = date;
		this.idClient = idClient;
		this.idService = idService;
		this.idProduit = idProduit;
	}

	
	//Getters et Setters
	public int getIdAchat() {
		return idAchat;
	}


	public void setIdAchat(int idAchat) {
		this.idAchat = idAchat;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
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
