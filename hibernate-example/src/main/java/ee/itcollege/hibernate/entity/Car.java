
package ee.itcollege.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Make make;
    
    @ManyToOne
    private Driver driver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        String driver = "none";
        if (getDriver() != null) {
            driver = getDriver().getFirstName();
        }
        return String.format("%d - %s - driver: %s", getId(), getMake(), driver);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

}
