package services;

import javax.ejb.Local;
import javax.ejb.Remote;

import persistence.Client;

@Local
public interface ClientServiceLocal {
	public void ajouter(Client c);
	public Client getByEmail(String email);

}
