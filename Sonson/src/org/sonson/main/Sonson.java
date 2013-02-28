package org.sonson.main;

import java.util.ArrayList;

import org.sonson.dal.Dal;
import org.sonson.dal.UpdateModel;
import org.sonson.model.Client;

/**
 * Controller class for this application Sonson
 * @author Matteo D'Addamio & Arnaud Booms (Henallux 2012 2013)
 *
 */
public class Sonson extends AbstractApplication {
	private Dal dal; 
	private ArrayList<Client> arrayclient;
	
	public Sonson() {
		arrayclient = new ArrayList<Client>();
	}

	
	public void launch() {
		logger.info("Launch Sonson Application");
		
		logger.info("Initialisation couche DAL");
		this.dal = Dal.getInstance();
		UpdateModel um = new UpdateModel(this);
		um.updateClients();
		um.updateProduits();
		um.updateServices();
		um.updateAchats();
	}
	
	public void setClient(Client c){
		int flag=0;
		//boucle de recherche sur l'id du client
		for (Client cl : arrayclient){
			if (cl.getId() == (c.getId())){
					flag=1;
				}
			}
		if(flag == 1){
			//Le client existe donc on le modifie
		}else{
			//Le client n'exite pas encore, donc on le rajoute
			arrayclient.add(c);
		}
		}
}
