package edu.mondragon.aperez.store.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import edu.mondragon.aperez.store.entities.Product;
import java.math.BigDecimal;
import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Long> {
    // Derived query method examples:

    // this will generate: select * from product where name = ?
    List<Product> findByName(String name);

    // this will generate: select * from product where name like ?
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameEndingWithIgnoreCase(String name);

    // Numbers

    // this will generate: select * from product where price = ?
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    // Null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    // Multiple conditions
    List<Product> findByNameAndPrice(String name, BigDecimal price);
    List<Product> findByDescriptionNullAndNameNull();

    // Sorting
    List<Product> findByNameOrderByPriceAsc(String name);

    // Limit (harcoded on method name)
    List<Product> findTop10ByNameOrderByPriceDesc(String name);
    List<Product> findFirst5ByNameLikeOrderByPrice(String name);

    // Find products whose price are in a given range and sort by name
    //List<Product> findByPriceBetweenOrderByName(BigDecimal min, BigDecimal max);
    // Simplify name using SQL or JPQL language
    @Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
    List<Product> findProducts(@Param("min") BigDecimal min,@Param("max") BigDecimal max);
}
