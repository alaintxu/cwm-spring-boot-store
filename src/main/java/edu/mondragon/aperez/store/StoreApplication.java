package edu.mondragon.aperez.store;

import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		
		user.addTag("tag1");
		
		System.out.println(user);
	}

}
