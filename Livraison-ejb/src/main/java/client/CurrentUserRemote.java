package client;

import persistence.Client;

public interface CurrentUserRemote {
	public void set(Client user);
	public Client get();

}
