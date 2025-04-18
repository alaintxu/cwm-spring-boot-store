package edu.mondragon.aperez.store.services;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import edu.mondragon.aperez.store.entities.Category;
import edu.mondragon.aperez.store.entities.Product;
import edu.mondragon.aperez.store.entities.User;
import edu.mondragon.aperez.store.repositories.CategoryRepository;
import edu.mondragon.aperez.store.repositories.ProductRepository;
import edu.mondragon.aperez.store.repositories.UserRepository;
import edu.mondragon.aperez.store.repositories.specifications.ProductSpec;
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

    @Transactional
    public void updateProductPrices() {
        // Method needs @Transactional as it is an update operation
        productRepository.updatePriceByCategory(BigDecimal.valueOf(99.99), (byte)1);
    }

    @Transactional
    public void fetchProducts() {
        var product = new Product();
        product.setName("Froga");

        var matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnorePaths("description", "id")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Product> example = Example.of(product, matcher);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchProductsByCriteria() {
        var products = productRepository.findProductsByCriteria("Froga", BigDecimal.valueOf(1), BigDecimal.valueOf(10));
        products.forEach(System.out::println);
    }

    public void fetchProductBySpecification(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        Specification<Product> spec = Specification.where(null);
        if (name != null && !name.isEmpty()) {
            spec = spec.and(ProductSpec.hasName(name));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpec.hasPriceLessThanOrEqualTo(maxPrice));
        }
        var products = productRepository.findAll(spec);
        products.forEach(System.out::println);
    }

    public void fetchSortedProducts() {
        var sort = Sort.by("name").and(
            Sort.by("price").descending()
        );

        productRepository.findAll(sort).forEach(System.out::println);
    }

    public void fetchPaginatedProducts(int pageNumber, int size){
        PageRequest pageRequest = PageRequest.of(pageNumber, size);
        Page<Product> page = productRepository.findAll(pageRequest);
        var products = page.getContent();
        products.forEach(System.out::println);

        var currentPageNumber = page.getNumber();
        var totalPages = page.getTotalPages();
        var totalElements = page.getTotalElements();
        var numberOfElements = page.getNumberOfElements();
        System.out.println("Page: " + currentPageNumber + "/" + totalPages);
        System.out.println("Total elements: " + totalElements);
        System.out.println("Number of elements: " + numberOfElements);
    }

    public void fetchPaginatedProductsAndSortedProducts(int i, int j, List<String> sortFields) {
        Sort sort = getSort(sortFields);
        PageRequest pageRequest = PageRequest.of(i, j, sort);
        Page<Product> page = productRepository.findAll(pageRequest);
        var products = page.getContent();

        products.forEach(System.out::println);

        var currentPageNumber = page.getNumber();
        var totalPages = page.getTotalPages();
        var totalElements = page.getTotalElements();
        var numberOfElements = page.getNumberOfElements();

        System.out.println("Page: " + currentPageNumber + "/" + totalPages);
        System.out.println("Total elements: " + totalElements);
        System.out.println("Number of elements: " + numberOfElements);
        System.out.println("Sort: " + page.getSort());
    }

    private Sort getSort(List<String> sortArray) {
        Sort sort = Sort.unsorted();
        for (String sortField : sortArray) {
            if (sortField.startsWith("-")) {
                sort = sort.and(Sort.by(sortField.substring(1)).descending());
            } else {
                sort = sort.and(Sort.by(sortField));
            }
        }
        return sort;
    }
}
