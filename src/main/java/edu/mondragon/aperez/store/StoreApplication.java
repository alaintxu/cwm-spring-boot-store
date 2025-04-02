package edu.mondragon.aperez.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
// import edu.mondragon.aperez.store.entities.User;
//import edu.mondragon.aperez.store.repositories.AddressRepository;
// import edu.mondragon.aperez.store.repositories.UserRepository;
import edu.mondragon.aperez.store.services.UserService;


@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		// UserRepository userRepository = context.getBean(UserRepository.class);
		//AddressRepository addressRepository = (AddressRepository) context.getBean("AddressRepository");

		// User user = User.builder()
		// 	.name("John Doe")
		// 	.email("john.doe@adibidea.eus")
		// 	.password("pasahitza")
		// 	.build();
		//userRepository.save(user);

		// User user = userRepository.findById(1L).orElseThrow();
		// System.out.println(user.getName());

		// userRepository.findAll().forEach(user -> {
		// 	System.out.println(user.getName());
		// });

		// userRepository.deleteById(1L);

		UserService userService = context.getBean(UserService.class);
		userService.showEntityStates();
	}

}
