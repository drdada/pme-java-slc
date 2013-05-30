package org.sonson.dal;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.sonson.main.Sonson;
import org.sonson.model.Achat;
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
	public void majClient(int idl,String noml, String prenoml, String codePostall, String adressel, String paysl, String telFixel, String telPortablel){
		String request="UPDATE client SET nom='"+noml+"', prenom='"+prenoml+"', codePostal='"+codePostall+"', adresse='"+adressel+"', pays='"+paysl+"',telFixe='"+telFixel+"', telPortable='"+telPortablel+"' WHERE id="+idl+" ";
		//System.out.println(request);
		try {
			Dal.getInstance().update(request);
				
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
	public void majProduit(String nom, String desc,int id){
		String request = "UPDATE produit SET nom='"+nom+"', description='"+desc+"' WHERE id="+id+"";
		try {
			Dal.getInstance().update(request);
				
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
	public void majService(String nom, String desc,int id){
		String request = "UPDATE service SET nom='"+nom+"', description='"+desc+"' WHERE id="+id+"";
		try {
			Dal.getInstance().update(request);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//ACHAT
	public void updateAchat() {
		try {
			ResultSet rs = Dal.getInstance().getResult("SELECT * FROM achat");
			while(rs.next()) {
				Achat a = new Achat(rs.getInt("id"),rs.getDate("date"),rs.getInt("client"),rs.getInt("service"),rs.getInt("produit"));
				sonson.setAchat(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addAchatProduit(int client,int produit) {
		try {
			Dal.getInstance().insert("INSERT INTO achat(client,produit) VALUES("+client+","+produit+")");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addAchatService(int client,int service){
		try {
			Dal.getInstance().insert("INSERT INTO achat(client,service) VALUES("+client+","+service+")");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String getLastDate(int id){
		String res;
		res="Jamais passé";
		try {
			ResultSet rs = Dal.getInstance().getResult("SELECT achat.date FROM achat WHERE achat.client="+id+" ORDER BY achat.date DESC LIMIT 1;");
			// Tu voulais lire un enregistrement, mais tu n'avais pas fait de next() pour te positionner dessus.
			rs.next();
			System.out.println("DEDANS ? WTF ? "+rs.getDate("date"));
			
			//res =rs.getString("date");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
}
