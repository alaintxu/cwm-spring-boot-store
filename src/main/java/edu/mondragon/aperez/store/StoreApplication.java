package edu.mondragon.aperez.store;

import java.math.BigDecimal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import edu.mondragon.aperez.store.services.ProductService;


@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		var productService = context.getBean(ProductService.class);
		productService.fetchProductBySpecification("Froga", BigDecimal.valueOf(1), BigDecimal.valueOf(10));
		
	}

}
