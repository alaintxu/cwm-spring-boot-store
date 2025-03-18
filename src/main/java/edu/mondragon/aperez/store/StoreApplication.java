package edu.mondragon.aperez.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();
		//context.close();
		// HeavyResource heavyResource = context.getBean(HeavyResource.class);
		// System.out.println("HeavyResource bean retrieved");
		User erabiltzailea = new User(1L, "froga@adibidea.eus", "superstrongpassword", "FrogaJauna", "123456789");
		UserService userService = context.getBean(UserService.class);
		userService.registerUser(erabiltzailea);
		userService.registerUser(erabiltzailea);
	}

}
