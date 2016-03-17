package ee.itcollege.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;

import static org.junit.Assert.*;

import ee.itcollege.hibernate.entity.Car;
import ee.itcollege.hibernate.entity.Driver;
import ee.itcollege.hibernate.entity.Make;
import ee.itcollege.hibernate.service.CarService;
import ee.itcollege.hibernate.service.MakeService;
import ee.itcollege.hibernate.service.UserInteractionService;

public class ApplicationTest {

	Injector injector;
	
	ArrayList<String> printed = new ArrayList<String>();
	
	UserInteractionService mockInteraction = new UserInteractionService() {
		
		public void print(Object o) {
			printed.add(o.toString());
		}
		
		public String getString() {
			return null;
		}
		
		public int getInt() {
			return 1;
		}
	};
	
	@Before
	public void setUp() throws Exception {
		
		injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				
				Driver mati = new Driver();
				mati.setFirstName("Mati");
				mati.setId(1l);
				
				Make make = new Make();	
				make.setName("Audi");
				make.setId(2l);
				
				Car car = new Car();
				car.setDriver(mati);
				car.setMake(make);
				
				List<Car> staticList = Arrays.asList(car);
				
				CarService mockCarService = Mockito.mock(CarService.class);
				Mockito.when(mockCarService.getCars()).thenReturn(staticList);
				
				bind(CarService.class).toInstance(mockCarService);
				
				bind(UserInteractionService.class).toInstance(mockInteraction);
				bind(MakeService.class).toInstance(Mockito.mock(MakeService.class));
				bind(EntityManager.class).toInstance(Mockito.mock(EntityManager.class));
			}
		});
	}

	@Test(timeout = 2000)
	public void testListingCars() {
		HibernateApplication app = injector.getInstance(HibernateApplication.class);
		app.start();
		
		String right = String.format("2 - Audi - driver: Mati");
		for (String line : printed) {
			System.out.println(line);
			if (line.equals(right)) {
				return;
			}
		}
		fail("Did not find the line: " + right);
	}

}
