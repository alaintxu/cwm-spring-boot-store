package edu.mondragon.aperez.store.services;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import edu.mondragon.aperez.store.entities.Category;
import edu.mondragon.aperez.store.entities.Product;
import edu.mondragon.aperez.store.entities.User;
import edu.mondragon.aperez.store.repositories.CategoryRepository;
import edu.mondragon.aperez.store.repositories.ProductRepository;
import edu.mondragon.aperez.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    UserRepository userRepository;

    public void stepOne() {
        // Product.category needs `cascade = CascadeType.PERSIST` in @ManyToOne
        Product product = Product.builder()
                .name("Laptop")
                .description("High performance laptop")
                .price(BigDecimal.valueOf(1999.99))
                .build();
        Category category = Category.builder()
                .name("Electronics")
                .build();
        product.addCategory(category);
        productRepository.save(product);
    }

    @Transactional
    public void stepTwo() {
        // Method needs @Transactional
        Category category = categoryRepository.findById((byte) 1).orElseThrow();
        Product product = Product.builder()
                .name("Smartphone")
                .description("Latest model smartphone")
                .price(BigDecimal.valueOf(800.00))
                .category(category)
                .build();
        productRepository.save(product);
    }

    public void stepThree() {
        User user = userRepository.findById(1L).orElseThrow();
        Iterable<Product> products = productRepository.findAll();
        products.forEach(user::addProductToWishlist);
        userRepository.save(user);
    }

    public void stepFour() {
        // Wishlist table (db) foreign keys need cascade on delete
        productRepository.deleteById(1L);
    }
}
