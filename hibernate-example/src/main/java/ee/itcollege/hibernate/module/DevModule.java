package ee.itcollege.hibernate.module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import ee.itcollege.hibernate.service.CarService;
import ee.itcollege.hibernate.service.ConsoleService;
import ee.itcollege.hibernate.service.DatabaseCarService;
import ee.itcollege.hibernate.service.DatabaseMakeService;
import ee.itcollege.hibernate.service.MakeService;
import ee.itcollege.hibernate.service.UserInteractionService;

public class DevModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(UserInteractionService.class).to(ConsoleService.class);
		bind(CarService.class).to(DatabaseCarService.class);
		bind(MakeService.class).to(DatabaseMakeService.class);
		//bind(HibernateApplication.class).to(HibernateApplication.class);
	}
	
	@Provides
	@Singleton
	public EntityManager createEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test1");
        return entityManagerFactory.createEntityManager();
	}

}
