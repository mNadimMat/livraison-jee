package client;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

import persistence.Client;

@Stateful
@SessionScoped
public class CurrentUser implements CurrentUserLocal,CurrentUserRemote {

	private Client client;
	@Override
	public void set(Client user) {
		this.client = user;
		
	}

	@Override
	public Client get() {
		return this.client;
	}
	
	public CurrentUser() {
		// TODO Auto-generated constructor stub
	}

}
