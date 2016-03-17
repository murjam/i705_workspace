package ee.itcollege.hibernate.service;

import java.util.List;

import ee.itcollege.hibernate.entity.Car;

public interface CarService {

	public List<Car> getCars();
	
	public void save(Car car);
	
}
