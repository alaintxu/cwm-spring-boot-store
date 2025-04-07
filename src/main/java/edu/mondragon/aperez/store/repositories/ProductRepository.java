package edu.mondragon.aperez.store.repositories;

import org.springframework.data.repository.CrudRepository;
import edu.mondragon.aperez.store.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {}
