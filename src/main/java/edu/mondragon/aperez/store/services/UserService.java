package edu.mondragon.aperez.store.services;

import org.springframework.stereotype.Service;
import edu.mondragon.aperez.store.entities.Address;
import edu.mondragon.aperez.store.entities.User;
import edu.mondragon.aperez.store.repositories.AddressRepository;
import edu.mondragon.aperez.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;

    @Transactional
    public void showEntityStates() {
        User user = User.builder().name("John Doe").email("john.doe@adibidea.eus")
                .password("pasahitza").build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    @Transactional
    public void showRelatedEntities() {
        Address address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getCity());
        System.out.println(address.getUser().getName());
        
    }
}
