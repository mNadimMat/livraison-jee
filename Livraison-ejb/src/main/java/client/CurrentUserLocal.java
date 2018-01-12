package client;

import javax.ejb.Local;

import persistence.Client;
@Local
public interface CurrentUserLocal {
	public void set(Client user);
	public Client get();

}
