package edu.mondragon.aperez.store;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StoreApplication.class, args);
		OrderService orderService = new OrderService(new StripePaymentService());
		orderService.placeOrder();
		OrderService orderService2 = new OrderService(new PayPalPaymentService());
		orderService2.placeOrder();
	}

}
