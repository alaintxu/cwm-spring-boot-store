package edu.mondragon.aperez.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.mondragon.aperez.store.entities.Address;
import edu.mondragon.aperez.store.entities.User;


@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StoreApplication.class, args);
		User user = User.builder()
			.name("John Doe")
			.password("pasahitza")
			.email("john.doe@froga.eus")
			.build();
		
		Address address = Address.builder()
			.street("Goiru 2")
			.city("Arrasate")
			.zip("20500")
			.state("Gipuzkoa")
			.build();

		user.addAddress(address);
		System.out.println(user);
	}

}
