package org.sonson.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.sonson.main.Sonson;
import org.sonson.model.Client;
import org.sonson.model.Produit;
import org.sonson.model.Service;

public class UpdateModel {
	Sonson sonson;
	
	public UpdateModel(Sonson ss) {
		this.sonson = ss;
	}
	
	/**
	 * Met à jour tous les clients dans le model
	 */
	public void updateClients() {
		try {
			ResultSet rs = Dal.getInstance().getResult("SELECT * FROM client");
			while(rs.next()) {
				Client c = new Client(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("codePostal"),rs.getString("adresse"),rs.getString("pays"),rs.getString("telFixe"),rs.getString("telPortable"));
				sonson.setClient(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addClient(String noml, String prenoml, String codePostall, String adressel, String paysl, String telFixel, String telPortablel) {
		try {
			Dal.getInstance().insert("INSERT INTO client(nom,prenom,codePostal,adresse,pays,telFixe,telPortable) VALUES('"+noml+"','"+prenoml+"','"+codePostall+"','"+adressel+"','"+paysl+"','"+telFixel+"','"+telPortablel+"')");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Produit
	public void updateProduits() {
		try {
			ResultSet rs = Dal.getInstance().getResult("SELECT * FROM produit");
			while(rs.next()) {
				Produit p = new Produit(rs.getInt("id"),rs.getString("nom"),rs.getString("description"),rs.getDouble("prix"));
				sonson.setProduit(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addProduit(String noml, String descriptionl, double prixl) {
		try {
			Dal.getInstance().insert("INSERT INTO produit(nom,description,prix) VALUES('"+noml+"','"+descriptionl+"',"+prixl+")");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Service
	public void updateService() {
		try {
			ResultSet rs = Dal.getInstance().getResult("SELECT * FROM service");
			while(rs.next()) {
				Service s = new Service(rs.getInt("id"),rs.getString("nom"),rs.getString("description"),rs.getDouble("prix"));
				sonson.setService(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addService(String noml, String descriptionl, double prixl) {
		try {
			Dal.getInstance().insert("INSERT INTO service(nom,description,prix) VALUES('"+noml+"','"+descriptionl+"',"+prixl+")");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
