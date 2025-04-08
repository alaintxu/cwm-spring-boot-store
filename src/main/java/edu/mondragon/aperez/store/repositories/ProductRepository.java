package edu.mondragon.aperez.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import edu.mondragon.aperez.store.dtos.ProductSummaryDTO;
import edu.mondragon.aperez.store.entities.Category;
import edu.mondragon.aperez.store.entities.Product;
import java.math.BigDecimal;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long>, ProductCriteriaRepository {
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
    //@Query("select p from Product p join p.category where p.price between :min and :max order by p.name")
    //List<Product> findProducts(@Param("min") BigDecimal min,@Param("max") BigDecimal max);
    @Procedure("findProductsByPrice")
    List<Product> findProducts(BigDecimal min,BigDecimal max);

    @Query("select count(*) from Product p where p.price between :min and :max")
    long countProducts(@Param("min") BigDecimal min,@Param("max") BigDecimal max);

    @Modifying  // tell hibernate that DB will be modified
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);

    // Projections (just get small part of the entity)
    //List<ProductSummary> findByCategory(Category category);
    //List<ProductSummaryDTO> findByCategory(Category category);
    //@Query("select p.id, p.name from Product p where p.category = :category")
    //List<ProductSummary> findByCategory(@Param("category") Category category);


    @Query("select new edu.mondragon.aperez.store.dtos.ProductSummaryDTO(p.id, p.name) from Product p where p.category = :category")
    List<ProductSummaryDTO> findByCategory(@Param("category") Category category);

}
