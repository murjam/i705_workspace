package ee.itcollege.hibernate.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.google.inject.Inject;

import ee.itcollege.hibernate.entity.Car;

public class DatabaseCarService implements CarService {
	
	private EntityManager em;

	@Inject
	public DatabaseCarService(EntityManager em) {
		this.em = em;
	}

	public List<Car> getCars() {
		return em.createQuery("select c from Car c order by c.id", Car.class).getResultList();
	}

	public void save(Car car) {
		em.getTransaction().begin();
		
        em.persist(car.getDriver());
        em.persist(car);
        
        em.getTransaction().commit();
	}

}
