package ee.itcollege.hibernate.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import ee.itcollege.hibernate.HibernateApplication;
import ee.itcollege.hibernate.entity.Make;

public class DatabaseMakeService implements MakeService {
	
	private static final Logger LOG = LogManager.getLogger();
	
	private EntityManager em;

	@Inject
    public DatabaseMakeService(EntityManager em) {
		this.em = em;
	}

	public Make findMake(String name) {
    	LOG.printf(Level.WARN, "Finding a Make by name %s - printf", name);
    	LOG.debug("Finding a Make by name {}", name);
    	CriteriaBuilder cb = em.getCriteriaBuilder();
    	CriteriaQuery<Make> query = cb.createQuery(Make.class);
    	Root<Make> make = query.from(Make.class);
    	query.where(cb.equal(make.get("name"), name));
    	try {
    		return em.createQuery(query).getSingleResult();
    	}
    	catch (NoResultException e) {
    		return null;
    	}
    }

	public void save(Make make) {
		em.getTransaction().begin();
		em.persist(make);
		em.getTransaction().commit();
	}

	
	
}
