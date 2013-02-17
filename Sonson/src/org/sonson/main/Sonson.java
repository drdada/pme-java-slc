package org.sonson.main;

import org.sonson.dal.Dal;

/**
 * Controller class for this application Sonson
 * @author Matteo D'Addamio & Arnaud Booms (Henallux 2012 2013)
 *
 */
public class Sonson extends AbstractApplication {
	private Dal dal;
	
	public Sonson() {
		
	}

	
	public void launch() {
		logger.info("Launch Sonson Application");
		
		logger.info("Initialisation couche DAL");
		this.dal = Dal.getInstance();
	}
}
