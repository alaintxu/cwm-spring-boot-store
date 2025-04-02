package edu.mondragon.aperez.store;

import edu.mondragon.aperez.store.entities.Category;
import edu.mondragon.aperez.store.entities.Product;
import edu.mondragon.aperez.store.entities.User;
import java.math.BigDecimal;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StoreApplication.class, args);
		User user = User.builder()
			.name("John Doe")
			.password("pasahitza")
			.email("john.doe@froga.eus")
			.build();

		// Profile profile = Profile.builder()
		// 	.bio("This is a bio")
		// 	.phoneNumber("123456789")
		// 	.dateOfBirth(new java.util.Date())
		// 	.loyaltyPoints(100)
		// 	.user(user)
		// 	.build();

		// user.setProfile(profile);
		// profile.setUser(user);
		
		// System.out.println(user);
		Product product = Product.builder()
			.name("Laptop")
			.price(BigDecimal.valueOf(999.99))
			.build();
		Category category = Category.builder()
			.name("Electronics")
			.build();

		product.addCategory(category);
		user.getWishlist().add(product);

		System.out.println(user);
	}

}
