package edu.mondragon.aperez.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import edu.mondragon.aperez.store.services.ProductService;


@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		ProductService productService = context.getBean(ProductService.class);
		//productService.stepOne();
		//productService.stepTwo();
		//productService.stepThree();
		//productService.stepFour();
		//productService.updateProductPrices();
		productService.fetchProducts();
	}

}
