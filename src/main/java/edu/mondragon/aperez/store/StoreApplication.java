package edu.mondragon.aperez.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();
		NotificationManager notificationManager = context.getBean(NotificationManager.class);
		notificationManager.sendNotification("Nire mezua");
	}

}
