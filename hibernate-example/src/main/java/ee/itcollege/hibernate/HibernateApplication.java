package ee.itcollege.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import ee.itcollege.hibernate.entity.Car;
import ee.itcollege.hibernate.entity.Driver;
import ee.itcollege.hibernate.entity.Make;
import ee.itcollege.hibernate.module.DevModule;
import ee.itcollege.hibernate.service.CarService;
import ee.itcollege.hibernate.service.MakeService;
import ee.itcollege.hibernate.service.UserInteractionService;

public class HibernateApplication {
    
	
	private static final Logger LOG = LogManager.getLogger(HibernateApplication.class);
	
    private EntityManager em;
    private CarService carService;
    private MakeService makeService;
    private UserInteractionService interaction;
    
    
    @Inject
    public HibernateApplication(EntityManager em, CarService carService,
    		MakeService makeService,
    		UserInteractionService interaction) {
		this.em = em;
		this.makeService = makeService;
		this.carService = carService;
		this.interaction = interaction;
	}

	public void listDrivers() {
    	UserLog.log("User listed drivers");
        List<Driver> drivers = em.createQuery("select d from Driver d", Driver.class).getResultList();
        for (Driver driver : drivers) {
        	interaction.print(driver);
        }
        interaction.print("\n");
    }
    
    public void listCars() {
    	UserLog.log("User listed cars");
        List<Car> list = carService.getCars();
        
        for (Car car : list) {
        	interaction.print(car);
        }
        interaction.print("\n");
    }
    

    

	private void findByMake() {
		interaction.print("Insert the make");
		String makeName = interaction.getString();
		Make make = makeService.findMake(makeName);
		if (make == null) {
			interaction.print("Could not find that make!");
			return;
		}
		
		em.refresh(make);
		
		List<Car> cars = make.getCars();
		for (Car car : cars) {
			interaction.print(car);
		}
	}
    
    public void addCar() {
        interaction.print("What is the make of the car?");
        String makeName = interaction.getString();
        
        Make make = makeService.findMake(makeName);
        if (null == make) {
        	make = new Make();
        	make.setName(makeName);
        	makeService.save(make);
        }
        
        Car car = new Car();
        car.setMake(make);
        
        interaction.print("What is the name of the driver?");
        String driverName = interaction.getString();
        
        Driver driver = new Driver();
        driver.setFirstName(driverName);
        car.setDriver(driver);
    }
    
    public void start() {
    	
        
        while (true) {
            interaction.print("\nPlease choose:");
            interaction.print("1 - list cars");
            interaction.print("2 - list drivers");
            interaction.print("3 - add car and driver");
            interaction.print("4 - find cars by make");
            interaction.print("5 - any other number to exit");
            
            int selection = interaction.getInt();
            
           // em.getTransaction().begin();
            
            switch (selection) {
                case 1: listCars(); break;
                case 2: listDrivers(); break;
                case 3: addCar(); break;
                case 4: findByMake(); break;
                default: em.close(); return;
            }            
           
            //em.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
    	
    	Injector injector = Guice.createInjector(new DevModule());
    	HibernateApplication application = injector.getInstance(HibernateApplication.class);
        application.start();
        
    }


}
