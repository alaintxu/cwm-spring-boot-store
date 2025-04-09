package edu.mondragon.aperez.store;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import edu.mondragon.aperez.store.services.ProductService;


@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		var productService = context.getBean(ProductService.class);
		productService.fetchPaginatedProductsAndSortedProducts(1, 5, List.of("price", "-name"));
	}
}
