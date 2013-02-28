package org.sonson.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.sonson.main.Sonson;
import org.sonson.model.Client;

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
				Client c = new Client(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("codePostal"),rs.getString("adresse"),rs.getString("pays"),rs.getInt("telFixe"),rs.getInt("telPortable"));
				sonson.setClient(c);
				//System.out.println(rs.getString("id")+rs.getString("nom")+rs.getString("prenom")+rs.getString("codePostal")+rs.getString("adresse")+rs.getString("pays")+rs.getInt("telFixe")+rs.getInt("telPortable"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateProduits(){
		try {
			ResultSet rs = Dal.getInstance().getResult("SELECT * FROM produit");
			while(rs.next()) {
				System.out.println(rs.getString("nom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateServices(){
		try {
			ResultSet rs = Dal.getInstance().getResult("SELECT * FROM service");
			while(rs.next()) {
				System.out.println(rs.getString("nom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAchats(){
		try {
			ResultSet rs = Dal.getInstance().getResult("SELECT * FROM achat");
			while(rs.next()) {
				System.out.println(rs.getString("date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
