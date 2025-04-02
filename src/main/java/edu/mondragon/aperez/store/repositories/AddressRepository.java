package edu.mondragon.aperez.store.repositories;

import org.springframework.data.repository.CrudRepository;
import edu.mondragon.aperez.store.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {}
