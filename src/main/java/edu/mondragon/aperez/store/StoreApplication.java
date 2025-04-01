package edu.mondragon.aperez.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.mondragon.aperez.store.entities.User;


@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StoreApplication.class, args);

		User.builder()
				.name("name")
				.email("email")
				.password("password")
				.build();
	}

}
