package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Colis;

/**
 * Session Bean implementation class ColisService
 */
@Stateless
@LocalBean
public class ColisService implements ColisServiceRemote {

    @PersistenceContext
    EntityManager em;

	@Override
	public List<Colis> getAll() {
		return em.createQuery("FROM Colis c ",Colis.class).getResultList();
	}

	@Override
	public void add(Colis c) {
		em.persist(c);
		
	}

}
