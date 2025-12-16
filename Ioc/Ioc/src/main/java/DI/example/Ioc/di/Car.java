package DI.example.Ioc.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	private DependencyInjection di;
	@Autowired
	public Car() {}
	
	
	public Car(DependencyInjection di) {
		this.di = di;
	}
	
	public void drive() {
		di.driveCar();
	}
	
	public void stop() {
		di.stopCar();
	}

}
