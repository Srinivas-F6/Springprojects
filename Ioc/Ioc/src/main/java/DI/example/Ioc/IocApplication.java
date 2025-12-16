package DI.example.Ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import DI.example.Ioc.di.DependencyInjection;


@SpringBootApplication
public class IocApplication implements CommandLineRunner {

    @Autowired
    private DependencyInjection di; // injected by Spring

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);
    }

    @Override
    public void run(String... args) {
    	System.out.print("Hello");
        di.driveCar();
        di.stopCar();
    }
}

