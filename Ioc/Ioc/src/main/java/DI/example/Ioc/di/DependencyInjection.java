package DI.example.Ioc.di;

import org.springframework.stereotype.Component;

@Component
public class DependencyInjection {
    public void driveCar() {
    	System.out.print("He is driving a car");
    }
    public void stopCar() {
    	System.out.println("He stopped the car");
    }
}
