package client;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.Client;

@ManagedBean
@SessionScoped
public class CurrentUser {

	public Client current;	
	
}
