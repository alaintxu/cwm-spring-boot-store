package edu.mondragon.aperez.store;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.mondragon.aperez.store.entities.Profile;
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

		Profile profile = Profile.builder()
			.bio("This is a bio")
			.phoneNumber("123456789")
			.dateOfBirth(new java.util.Date())
			.loyaltyPoints(100)
			.user(user)
			.build();

		user.setProfile(profile);
		profile.setUser(user);
		
		System.out.println(user);
	}

}
