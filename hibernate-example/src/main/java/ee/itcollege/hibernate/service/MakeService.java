package ee.itcollege.hibernate.service;

import ee.itcollege.hibernate.entity.Make;

public interface MakeService {

	public Make findMake(String name);
	
	public void save(Make make);
	
}
