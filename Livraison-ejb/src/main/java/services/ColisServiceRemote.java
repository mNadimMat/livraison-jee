package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Colis;

@Remote
public interface ColisServiceRemote {
	List<Colis> getAll();
	public void add(Colis c);

}
