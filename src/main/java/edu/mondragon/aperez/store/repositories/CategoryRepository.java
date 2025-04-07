package edu.mondragon.aperez.store.repositories;

import org.springframework.data.repository.CrudRepository;
import edu.mondragon.aperez.store.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Byte> {}