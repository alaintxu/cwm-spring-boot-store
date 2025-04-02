package edu.mondragon.aperez.store.repositories;

import org.springframework.data.repository.CrudRepository;
import edu.mondragon.aperez.store.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {}
