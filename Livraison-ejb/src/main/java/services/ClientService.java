package services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import client.CurrentUserLocal;
import exceptions.AuthenticationException;
import persistence.Client;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
@LocalBean
public class ClientService implements ClientServiceRemote,ClientServiceLocal {
	@PersistenceContext
	EntityManager em;
	
	@EJB
	CurrentUserLocal cu;
	
	public ClientService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouter(Client c) {
		em.persist(c);

	}

	@Override
	public Client getByEmail(String email) {
		try{
			return em.createQuery("FROM Client c WHERE c.mail = :m",Client.class)
					.setParameter("m", email)
					.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}

	@Override
	public void login(String email, String password) throws AuthenticationException {
		Client c = getByEmail(email);
		if (c == null)
			throw new AuthenticationException("Compte non trouvé");
		if (!c.getPwd().equals(password)){
			throw new AuthenticationException("Mot de passe incorrect");
		}
		
		cu.set(c);
		
		
	}

	@Override
	public void signUp(Client client) throws AuthenticationException{
		Client c = getByEmail(client.getMail());
		if (c != null)
			throw new AuthenticationException("Il existe un autre compte avec cet email");
		else{
			em.persist(client);
		}
		
	}

}
