package edu.mondragon.aperez.store.repositories;

import java.math.BigDecimal;
import java.util.List;
import edu.mondragon.aperez.store.entities.Product;

public interface ProductCriteriaRepository {
    List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);
}
