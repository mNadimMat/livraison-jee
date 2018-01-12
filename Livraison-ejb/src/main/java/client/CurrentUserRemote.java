package client;

import javax.ejb.Remote;

import persistence.Client;
@Remote
public interface CurrentUserRemote {
	public void set(Client user);
	public Client get();

}
