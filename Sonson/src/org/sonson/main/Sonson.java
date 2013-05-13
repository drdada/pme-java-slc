package org.sonson.main;

import java.util.ArrayList;

import org.sonson.dal.Dal;
import org.sonson.dal.UpdateModel;
import org.sonson.gui.Accueil;
import org.sonson.model.Client;
import org.sonson.model.Produit;
import org.sonson.model.Service;

/**
 * Controller class for this application Sonson
 * @author Matteo D'Addamio & Arnaud Booms (Henallux 2012 2013)
 *
 */
public class Sonson extends AbstractApplication {
	private Dal dal; 
	private static ArrayList<Client> arrayclient;
	private static ArrayList<Produit> arrayproduit;
	private static ArrayList<Service> arrayService;
	private UpdateModel um;
	
	public Sonson() {
		arrayclient = new ArrayList<Client>();
		arrayproduit = new ArrayList<Produit>();
		arrayService = new ArrayList<Service>();
	}

	
	public void launch() {
		logger.info("Launch Sonson Application");
		
		logger.info("Initialisation couche DAL");
		this.dal = Dal.getInstance();
		um = new UpdateModel(this);
		um.updateClients();
		um.updateProduits();
		um.updateService();
//		um.updateAchats();
		Accueil accueil = new Accueil(this);
	}
	// PARTIE CLIENTS
	public void updateClients(){
		um.updateClients();
	}
	
	public void setClient(Client c){
		int flag=0,savecl = 0;
		//boucle de recherche sur l'id du client
		for (Client cl : arrayclient){
			if (cl.getId() == (c.getId())){
					flag=1;
					savecl=arrayclient.indexOf(cl);
				}
			}
		if(flag == 1){
			//Le client existe donc on le modifie
			arrayclient.remove(savecl);
			arrayclient.add(savecl, c);
		}else{
			//Le client n'exite pas encore, donc on le rajoute
			arrayclient.add(c);
		}
	}
	public void addClientBdd(String noml, String prenoml, String codePostall, String adressel, String paysl, String telFixel, String telPortablel)
	{
		um.addClient(noml, prenoml, codePostall, adressel, paysl, telFixel, telPortablel);
	}
	
	public static ArrayList<Client> getArrayclient() {
		return arrayclient;
	}
	
	//PARTIE PRODUIT
	public static void setProduit(Produit p){
		int flag=0,savecl = 0;

		for (Produit pr : arrayproduit){
			if (pr.getId() == (p.getId())){
					flag=1;
					savecl=arrayproduit.indexOf(pr);
				}
			}
		if(flag == 1){
			//Le produit existe donc on le modifie
			arrayproduit.remove(savecl);
			arrayproduit.add(savecl, p);
		}else{
			//Le produit n'exite pas encore, donc on le rajoute
			arrayproduit.add(p);
		}
	}
	
	public void addProduitBdd(String noml,String descriptionl,double prixl){
		um.addProduit(noml, descriptionl, prixl);
	}
	public void updateProduit(){
		um.updateProduits();
	}
	public static ArrayList<Produit> getArrayProduit(){
		return arrayproduit;
	}
	
	
	//PARTIE SERVICE
	public void setService(Service s){
		int flag=0,savecl = 0;

		for (Service sr : arrayService){
			if (sr.getId() == (s.getId())){
					flag=1;
					savecl=arrayService.indexOf(sr);
				}
			}
		if(flag == 1){
			//Le produit existe donc on le modifie
			arrayService.remove(savecl);
			arrayService.add(savecl, s);
		}else{
			//Le produit n'exite pas encore, donc on le rajoute
			arrayService.add(s);
		}
	}
	
	public void addServiceBdd(String noml,String descriptionl,double prixl){
		um.addService(noml, descriptionl, prixl);
	}
	public void updateService(){
		um.updateService();
	}
	
	public static ArrayList<Service> getArrayService(){
		return arrayService;
	}
	
}
