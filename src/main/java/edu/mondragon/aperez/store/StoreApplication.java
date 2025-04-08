package edu.mondragon.aperez.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import edu.mondragon.aperez.store.services.ProfileService;


@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		var profileService = context.getBean(ProfileService.class);
		profileService.printLoyalProfiles();
		
	}

}
