package org.sonson.main;

import java.util.ArrayList;

import org.sonson.model.Client;

public class StatistiqueClient {
	private Sonson ss;
	private ArrayList<Client> arrayclient;
	public StatistiqueClient(Sonson ss){
		this.ss = ss;
	}
	public String calculClientTotal(){
		//TODO transformer int en string
		int tot;
		tot= arrayclient.size();
		return tot;
	}
}
