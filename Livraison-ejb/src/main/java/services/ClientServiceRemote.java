package services;

import javax.ejb.Remote;

import exceptions.AuthenticationException;
import persistence.Client;

@Remote
public interface ClientServiceRemote {
	public void ajouter(Client c);
	public Client getByEmail(String email);
	public Client login(String email,String password) throws AuthenticationException;
	public void signUp(Client c) throws AuthenticationException;

}
