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
		
		OrderService orderService2 = context.getBean(OrderService.class);
		orderService2.placeOrder();

		HeavyResource heavyResource = context.getBean(HeavyResource.class);
		System.out.println("HeavyResource bean retrieved");
	}

}
