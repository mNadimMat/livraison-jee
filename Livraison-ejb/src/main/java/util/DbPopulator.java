package util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import persistence.Client;
import persistence.Facteur;
import services.ClientServiceLocal;
import services.ColisServiceRemote;

@Singleton
@Startup
public class DbPopulator {
	@EJB
	ClientServiceLocal cs;
	@EJB
	ColisServiceRemote colS;
	
	
	@PostConstruct
	public void populate(){
		cs.ajouter(new Client("Toukebri", "Houssem", "houssem.toukebri@gmail.com", "xxx"));
		cs.ajouter(new Facteur("Matoussi", "Nadim", "matoussinadim", "xx","5544","12345678"));
	}

}
